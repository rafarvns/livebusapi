package br.com.rag.apilivebus.api.user;

import br.com.rag.apilivebus.utils.CtrlUtils;
import br.com.rag.apilivebus.utils.exceptions.NegocioException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;

@RestController
@RequestMapping(UserCtrl.PATH)
public class UserCtrl {

    static final String PATH = "/api/user";
    private UserService userService;

    @Autowired
    public UserCtrl(UserServiceImpl service) {
        this.userService = service;
    }

    @PostMapping("updateUserPosition/{id}/{latitude}/{longitude}")
    public ResponseEntity updateUserPosition(
            @PathVariable Long id,
            @PathVariable BigDecimal latitude,
            @PathVariable BigDecimal longitude
    ) {
        try {
            return CtrlUtils.sendOk(userService.updateUserPosition(id, latitude, longitude));
        } catch (NegocioException nEx) {
            return CtrlUtils.sendBadRequest(nEx.getMessage());
        }

    }

//    @Valid @RequestBody ItemPlanoAquisicao itemPlanoAquisicao, BindingResult result) {
//        if (result.hasErrors()) return CtrlUtils.sendBadRequest(result);
//        try {
//            return CtrlUtils.sendOk(itemPlanoAquisicaoService.insert(itemPlanoAquisicao));
//        } catch (NegocioException e) {
//            return CtrlUtils.sendBadRequest(e.getMessage());
//        }

}
