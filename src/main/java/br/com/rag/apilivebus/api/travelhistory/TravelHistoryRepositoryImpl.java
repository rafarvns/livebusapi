package br.com.rag.apilivebus.api.travelhistory;

import br.com.rag.apilivebus.abstraction.QueryDslSupport;

public class TravelHistoryRepositoryImpl extends QueryDslSupport implements TravelHistoryRepositoryCustom {

    public TravelHistoryRepositoryImpl() {
        super(TravelHistory.class);
    }

}
