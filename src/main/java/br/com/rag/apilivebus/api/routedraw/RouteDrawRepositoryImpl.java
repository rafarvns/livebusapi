package br.com.rag.apilivebus.api.routedraw;

import br.com.rag.apilivebus.abstraction.QueryDslSupport;

public class RouteDrawRepositoryImpl extends QueryDslSupport implements RouteDrawRepositoryCustom {

    public RouteDrawRepositoryImpl() {
        super(RouteDraw.class);
    }

}
