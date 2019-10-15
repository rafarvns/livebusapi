package br.com.rag.apilivebus.api.travelhistory;

import br.com.rag.apilivebus.abstraction.AbstractService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TravelHistoryServiceImpl extends AbstractService<TravelHistory> implements TravelHistoryService {

    private TravelHistoryRepository travelhistoryRepository;
    @Autowired
    public TravelHistoryServiceImpl(TravelHistoryRepository repository) {
        super(repository);
        this.travelhistoryRepository = repository;
    }

}
