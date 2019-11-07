package br.com.rag.apilivebus.api.user;

import br.com.rag.apilivebus.abstraction.QueryDslSupport;

public class UserRepositoryImpl extends QueryDslSupport implements UserRepositoryCustom {

    public UserRepositoryImpl() {
        super(User.class);
    }

    @Override
    public User findUserById(Long id) {
        QUser user = QUser.user;
        return getQuerydsl().createQuery()
                .select(user)
                .from(user)
                .where(user.id.eq(id))
                .fetchOne();
    }
}
