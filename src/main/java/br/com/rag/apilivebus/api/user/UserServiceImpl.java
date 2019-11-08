package br.com.rag.apilivebus.api.user;

import br.com.rag.apilivebus.abstraction.AbstractService;
import br.com.rag.apilivebus.api.line.Line;
import br.com.rag.apilivebus.api.point.Point;
import br.com.rag.apilivebus.utils.exceptions.DefaultMessages;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.math.BigDecimal;
import java.util.Date;

@Service
public class UserServiceImpl extends AbstractService<User> implements UserService {

    private UserRepository userRepository;

    @Autowired
    public UserServiceImpl(UserRepository repository) {
        super(repository);
        this.userRepository = repository;
    }

    @Override
    public Long updateUserPosition(Long id, BigDecimal latitude, BigDecimal longitude) {
        User user = userRepository.findUserById(id);
        if (user != null) {
            user.setLastConnect(new Date());
            user.setLatitude(latitude);
            user.setLongitude(longitude);
            userRepository.save(user);
            return id;
        }
        user = new User(true, new Date(), "newUser", latitude, longitude,
                true, null, null, new Line(1L, null, null, null),
                new Line(1L, null, null, null));
        return userRepository.saveAndFlush(user).getId();
    }
}
