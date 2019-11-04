package br.com.rag.apilivebus.api.live;

import br.com.rag.apilivebus.abstraction.QueryDslSupport;
import br.com.rag.apilivebus.api.line.QLine;

import br.com.rag.apilivebus.api.live.dto.LiveSummaryDTO;
import br.com.rag.apilivebus.api.live.dto.QLiveSummaryDTO;
import br.com.rag.apilivebus.api.user.QUser;
import br.com.rag.apilivebus.api.user.User;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class LiveRepositoryImpl extends QueryDslSupport implements LiveRepositoryCustom {

    private EntityManager em;

    public LiveRepositoryImpl() {
        super(Live.class);
    }

    @Override
    public List<Live> findAllLiveBuses() {

        //inicia uma lista que armazenerá os possíveis ônibus
        List<Live> lstLive = new ArrayList<>();

        //pega uma lista de usuários que estejam dentro da área da linha informada
        List<User> lstUsersBoarding = getAllBoardingUsers();

        //inicia uma lista de usuários que armazenará um grupo de usuários que estarão nos possíveis ônibus
        List<User> jumpUsers = new ArrayList<>();
        int numberOfJump = 0;
        int indexUser = 0;

        //for que percorre toda a lista de usuários que estejam dentro da área da linha informada
        for (User u : lstUsersBoarding) {

            //for a seguir para otimizar a busca, onde faz pular para o próximo usuário caso o mesmo esteja dentro do grupo da última
            boolean isRepeat = false;
            for (int i = indexUser; i < numberOfJump; i++) {
                if (u.getId().equals(jumpUsers.get(i).getId())) {
                    isRepeat = true;
                    break;
                }
            }
            if (isRepeat && numberOfJump != 0) continue;

            //busca uma lista de usuários próximos num raio de 10 metros a partir da posição do usuário que está sendo verificado
            List<User> nearbyUsers = getNearbyUsers(u, BigDecimal.valueOf(10).divide(BigDecimal.valueOf(1000)));

            //se vir uma lista vazia, pula para o próximo usuário
            if (nearbyUsers.isEmpty()) continue;

            //adiciona os usuários que foram buscados à lista de usuários que irão ser ignorados no início deste bloco durante as próximas execuções
            jumpUsers.addAll(nearbyUsers);
            indexUser += numberOfJump;
            numberOfJump += nearbyUsers.size();

            //por fim, caso o grupo de usuário seja maio que 5, cria-se um novo possível ônibus
            if (nearbyUsers.size() >= 5) lstLive.add(new Live(
                    nearbyUsers.get(0).getLatitude(),
                    nearbyUsers.get(0).getLongitude(),
                    Long.valueOf(nearbyUsers.size()),
                    nearbyUsers.get(0).getConfirmedLine()
            ));

        }
        return lstLive;
    }

    @Override
    public List<LiveSummaryDTO> findLiveBusByLine(Long number) {
        QLive live = QLive.live;
        QLine line = QLine.line;

        return getQuerydsl().createQuery()
                .select(LiveSummaryDTO.constructor(live))
                .from(live)
                .innerJoin(live.line, line)
                .on(line.number.eq(number))
                .fetch();
    }

    private List<User> getNearbyUsers(User user, BigDecimal raio) {
        EntityManager em = getEntityManager();
        String str = "select *, (6371 * acos(cos(radians(" + user.getLatitude() + ")) * cos(radians(latitude)) * " +
                "cos(radians(" + user.getLongitude() + ") - radians(longitude)) + sin(radians(" + user.getLatitude() + ")) * " +
                "sin(radians(latitude)))) as distance from user having distance <= " + raio + " and distance > 0";
        TypedQuery<User> query = (TypedQuery<User>) em.createNativeQuery(str, User.class);
        return query.getResultList();
    }

    private List<User> getAllBoardingUsers() {
        QUser user = QUser.user;
        QLine line = QLine.line;
        return getQuerydsl().createQuery()
                .select(user)
                .from(user)
                .innerJoin(user.confirmedLine, line)
                .where(user.isConnected.eq(true).and(user.isTraveling.eq(true)))
                .fetch();
    }

}
