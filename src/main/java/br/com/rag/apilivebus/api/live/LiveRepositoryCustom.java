package br.com.rag.apilivebus.api.live;

import br.com.rag.apilivebus.api.live.dto.LiveSummaryDTO;
import br.com.rag.apilivebus.api.user.User;

import java.util.List;

public interface LiveRepositoryCustom {

    List<Live> findAllLiveBuses();

    List<LiveSummaryDTO> findLiveBusByLine(Long number);
}
