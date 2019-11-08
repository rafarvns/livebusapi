package br.com.rag.apilivebus.api.live;

import br.com.rag.apilivebus.abstraction.AbstractService;
import br.com.rag.apilivebus.api.live.dto.LiveSummaryDTO;
import br.com.rag.apilivebus.api.user.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Component
@EnableScheduling
@Service
public class LiveServiceImpl extends AbstractService<Live> implements LiveService {

    final int timeOfAutoFindBuses = 1500;

    private LiveRepository liveRepository;
    @Autowired
    public LiveServiceImpl(LiveRepository repository) {
        super(repository);
        this.liveRepository = repository;
    }

    @Override
    public List<LiveSummaryDTO> getLiveBusByLine(Long number) {
        return liveRepository.findLiveBusByLine(number);
    }

    @Scheduled(fixedDelay = timeOfAutoFindBuses)
    @Override
    public void autoFindLiveBuses() {
        List<Live> lstAllLiveBuses = liveRepository.findAllLiveBuses();
        liveRepository.deleteAll();
        if(!lstAllLiveBuses.isEmpty()) updateLivePositions(lstAllLiveBuses);
    }

    private void updateLivePositions(List<Live> lstAllLiveBuses) {
        liveRepository.saveAll(lstAllLiveBuses);
    }
}
