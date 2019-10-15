package br.com.rag.apilivebus.api.route;

import br.com.rag.apilivebus.abstraction.QueryDslSupport;

public class RouteRepositoryImpl extends QueryDslSupport implements RouteRepositoryCustom {

    public RouteRepositoryImpl() {
        super(Route.class);
    }

}
