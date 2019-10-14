package br.com.rag.apilivebus.api.point;

import br.com.rag.apilivebus.abstraction.QueryDslSupport;

public class PointRepositoryImpl extends QueryDslSupport implements PointRepositoryCustom {

    public PointRepositoryImpl() {
        super(Point.class);
    }

}
