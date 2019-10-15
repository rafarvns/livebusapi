package br.com.rag.apilivebus.api.route;

import br.com.rag.apilivebus.utils.CtrlUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(RouteCtrl.PATH)
public class RouteCtrl {

    static final String PATH = "/api/route";
    private RouteService routeService;

    @Autowired
    public RouteCtrl(RouteServiceImpl service) {
        this.routeService = service;
    }

}
