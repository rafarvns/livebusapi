package br.com.rag.apilivebus.api.live;

import br.com.rag.apilivebus.abstraction.IBaseService;
import br.com.rag.apilivebus.api.live.Live;

import java.util.List;

public interface LiveService extends IBaseService<Live> {

    List<Live> getLiveBus();

}
