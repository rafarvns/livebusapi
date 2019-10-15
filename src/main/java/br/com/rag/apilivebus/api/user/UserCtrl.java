package br.com.rag.apilivebus.api.user;

import br.com.rag.apilivebus.utils.CtrlUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(UserCtrl.PATH)
public class UserCtrl {

    static final String PATH = "/api/user";
    private UserService userService;

    @Autowired
    public UserCtrl(UserServiceImpl service) {
        this.userService = service;
    }

}
