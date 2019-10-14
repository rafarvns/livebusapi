package br.com.rag.apilivebus.api.line;

import br.com.rag.apilivebus.abstraction.QueryDslSupport;

public class LineRepositoryImpl extends QueryDslSupport implements LineRepositoryCustom {

    public LineRepositoryImpl() {
        super(Line.class);
    }

}
