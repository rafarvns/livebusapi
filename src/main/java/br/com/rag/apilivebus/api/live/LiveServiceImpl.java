package br.com.rag.apilivebus.api.live;

import br.com.rag.apilivebus.abstraction.AbstractService;
import br.com.rag.apilivebus.api.live.dto.LiveSummaryDTO;
import br.com.rag.apilivebus.api.user.User;
import com.querydsl.core.types.dsl.SetPath;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Component
@EnableScheduling
@Service
public class LiveServiceImpl extends AbstractService<Live> implements LiveService {

    final int timeOfAutoFindBuses = 1000;

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
        if (!lstAllLiveBuses.isEmpty()) {
            updateLivePositions(lstAllLiveBuses);
        } else {
            liveRepository.deleteAll();
        }
        ;
    }

    private void updateLivePositions(List<Live> lstAllLiveBuses) {
        List<Live> allLives = liveRepository.findAll();
        Set<Long> lstLongForRemove = new HashSet<>();
        if (lstAllLiveBuses.size() > allLives.size()) {

            int i = 0;
            for (Live live : lstAllLiveBuses) {
                if (i < allLives.size()) {
                    live.setId(allLives.get(i).getId());
                    liveRepository.save(live);
                } else {
                    liveRepository.save(lstAllLiveBuses.get(i));
                }
                i++;
            }

        } else if (lstAllLiveBuses.size() < allLives.size()) {
            int i = 0;
            for (Live live : allLives) {
                if (i < lstAllLiveBuses.size()) {
                    lstAllLiveBuses.get(i).setId(live.getId());
                    liveRepository.save(lstAllLiveBuses.get(i));
                } else {
                    lstLongForRemove.add(live.getId());
                }
                i++;
            }
        } else {
            int i = 0;
            for (Live live : lstAllLiveBuses) {
                live.setId(allLives.get(i).getId());
                liveRepository.save(live);
                i++;
            }
        }
        if (lstLongForRemove.size() > 0) {
            for (Long id : lstLongForRemove) {
                liveRepository.deleteById(id);
            }
        }
    }
}
