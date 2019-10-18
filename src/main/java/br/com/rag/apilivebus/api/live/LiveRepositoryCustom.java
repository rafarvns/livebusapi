package br.com.rag.apilivebus.api.live;

import br.com.rag.apilivebus.api.user.User;

import java.util.List;

public interface LiveRepositoryCustom {

    List<User> findLiveBus();

    void mocka();
}
