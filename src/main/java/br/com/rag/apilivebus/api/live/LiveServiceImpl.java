package br.com.rag.apilivebus.api.live;

import br.com.rag.apilivebus.abstraction.AbstractService;
import br.com.rag.apilivebus.api.live.Live;
import br.com.rag.apilivebus.api.user.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LiveServiceImpl extends AbstractService<User> implements LiveService {

    private LiveRepository liveRepository;
    @Autowired
    public LiveServiceImpl(LiveRepository repository) {
        super(repository);
        this.liveRepository = repository;
    }

    @Override
    public List<User> getLiveBus() {
        //liveRepository.mocka();
        return liveRepository.findLiveBus();
    }
}
