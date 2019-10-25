package br.com.rag.apilivebus.api.routedraw;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(RouteDrawCtrl.PATH)
public class RouteDrawCtrl {

    static final String PATH = "/api/routedraw";
    private RouteDrawService routeDrawService;

    @Autowired
    public RouteDrawCtrl(RouteDrawServiceImpl service) {
        this.routeDrawService = service;
    }

}
