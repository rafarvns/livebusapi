package br.com.rag.apilivebus.api.point;

import br.com.rag.apilivebus.utils.CtrlUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(PointCtrl.PATH)
public class PointCtrl {

    static final String PATH = "/api/point";
    private PointService pointService;

    @Autowired
    public PointCtrl(PointServiceImpl service) {
        this.pointService = service;
    }

    @GetMapping
    public ResponseEntity getName(){
        return CtrlUtils.sendOk("teste");
    }

}
