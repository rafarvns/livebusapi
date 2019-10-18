package br.com.rag.apilivebus.api.live;

import br.com.rag.apilivebus.abstraction.IBaseRepository;
import br.com.rag.apilivebus.api.live.Live;
import br.com.rag.apilivebus.api.user.User;

public interface LiveRepository extends IBaseRepository<User>, LiveRepositoryCustom {
}
