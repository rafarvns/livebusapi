package br.com.rag.apilivebus.api.user;

import br.com.rag.apilivebus.abstraction.AbstractService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl extends AbstractService<User> implements UserService {

    private UserRepository userRepository;
    @Autowired
    public UserServiceImpl(UserRepository repository) {
        super(repository);
        this.userRepository = repository;
    }

}
