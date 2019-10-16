package br.com.rag.apilivebus.api.live;

import br.com.rag.apilivebus.abstraction.QueryDslSupport;
import br.com.rag.apilivebus.api.live.Live;
import br.com.rag.apilivebus.api.user.QUser;
import br.com.rag.apilivebus.api.user.User;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class LiveRepositoryImpl extends QueryDslSupport implements LiveRepositoryCustom {

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
            List<User> passengers = getQuerydsl()
        }

    }
}
