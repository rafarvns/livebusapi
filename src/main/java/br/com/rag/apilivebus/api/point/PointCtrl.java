package br.com.rag.apilivebus.api.point;

import br.com.rag.apilivebus.utils.CtrlUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
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
    public ResponseEntity getAllPoints(){
        return CtrlUtils.sendOk(pointService.getAll());
    }

    @GetMapping("byLine/{number}")
    public ResponseEntity getByLine(@PathVariable Long number){
        return CtrlUtils.sendOk(pointService.getByLine(number));
    }

}
