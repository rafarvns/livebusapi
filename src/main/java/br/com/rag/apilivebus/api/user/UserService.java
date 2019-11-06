package br.com.rag.apilivebus.api.user;

import br.com.rag.apilivebus.abstraction.IBaseService;

import java.math.BigDecimal;

public interface UserService extends IBaseService<User> {

    Long updateUserPosition(Long id, BigDecimal latitude, BigDecimal longitude);
}
