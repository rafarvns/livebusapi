package br.com.rag.apilivebus.api.user;

import br.com.rag.apilivebus.abstraction.QueryDslSupport;

public class UserRepositoryImpl extends QueryDslSupport implements UserRepositoryCustom {

    public UserRepositoryImpl() {
        super(User.class);
    }

}
