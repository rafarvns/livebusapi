package br.com.rag.apilivebus.api.live;

import br.com.rag.apilivebus.abstraction.IBaseService;
import br.com.rag.apilivebus.api.live.dto.LiveSummaryDTO;
import br.com.rag.apilivebus.api.user.User;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.util.List;

public interface LiveService extends IBaseService<Live> {

    List<LiveSummaryDTO> getLiveBusByLine(Long number);

    void autoFindLiveBuses();

}
