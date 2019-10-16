package br.com.rag.apilivebus.api.live;

import br.com.rag.apilivebus.abstraction.AbstractService;
import br.com.rag.apilivebus.api.live.Live;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LiveServiceImpl extends AbstractService<Live> implements LiveService {

    private LiveRepository liveRepository;
    @Autowired
    public LiveServiceImpl(LiveRepository repository) {
        super(repository);
        this.liveRepository = repository;
    }

    @Override
    public List<Live> getLiveBus() {
        //liveRepository.mocka();
        return liveRepository.findLiveBus();
    }
}
