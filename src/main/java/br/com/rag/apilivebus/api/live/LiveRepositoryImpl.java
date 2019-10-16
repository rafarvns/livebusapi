package br.com.rag.apilivebus.api.live;

import br.com.rag.apilivebus.abstraction.QueryDslSupport;
import br.com.rag.apilivebus.api.line.Line;
import br.com.rag.apilivebus.api.live.Live;
import br.com.rag.apilivebus.api.point.Point;
import br.com.rag.apilivebus.api.user.QUser;
import br.com.rag.apilivebus.api.user.User;
import org.springframework.beans.factory.annotation.Autowired;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class LiveRepositoryImpl extends QueryDslSupport implements LiveRepositoryCustom {

    private EntityManager em;

    public LiveRepositoryImpl() {
        super(Live.class);
    }

    @Override
    public List<Live> findLiveBus() {

        List<Live> lstLive = new ArrayList<>();
        QUser user = QUser.user;

        List<User> lstUsersBoarding = getQuerydsl().createQuery()
                .select(user)
                .from(user)
                .where(user.isConnected.eq(true)
                        .and(user.isTraveling.eq(true)))
                .fetch();

        for(User u : lstUsersBoarding){
            EntityManager em = getEntityManager();
            String str = "select *, (6371 * acos(cos(radians("+u.getLatitude()+")) * cos(radians(latitude)) * cos(radians("+u.getLongitude()+") - radians(longitude)) + sin(radians("+u.getLatitude()+")) * sin(radians(latitude)))) as distance from user having distance <= 1";
            Query query = em.createQuery(
                    str
            );
            return null;
        }
        return null;
    }

    @Transactional
    public void mocka() {
        EntityManager e = getEntityManager();
        Point p1 = new Point();
        p1.setId(1L);
        Point p2 = new Point();
        p2.setId(1L);
        Line l1 = new Line();
        l1.setId(1L);
        Line l2 = new Line();
        l2.setId(1L);
        e.persist(new User(true, new Date(), "asdf1", new BigDecimal(-10.5), new BigDecimal(-10), true, p1, p2, l1, l2));
        e.persist(new User(true, new Date(), "asdf2", new BigDecimal(-10.54), new BigDecimal(-10), true, p1, p2, l1, l2));
        e.persist(new User(true, new Date(), "asdf3", new BigDecimal(-10.53), new BigDecimal(-10), true, p1, p2, l1, l2));
        e.persist(new User(true, new Date(), "asdf4", new BigDecimal(-20.5), new BigDecimal(-10), true, p1, p2, l1, l2));
        e.persist(new User(true, new Date(), "asdf5", new BigDecimal(-30.5), new BigDecimal(-10), true, p1, p2, l1, l2));
    }
}
