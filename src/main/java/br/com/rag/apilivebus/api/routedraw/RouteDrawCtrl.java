package br.com.rag.apilivebus.api.routedraw;

import br.com.rag.apilivebus.utils.CtrlUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
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

    @GetMapping
    public ResponseEntity getAllRoutesDraw(){
        return CtrlUtils.sendOk(routeDrawService.getAll());
    }

}
