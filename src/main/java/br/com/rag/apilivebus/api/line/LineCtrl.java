package br.com.rag.apilivebus.api.line;

import br.com.rag.apilivebus.utils.CtrlUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(LineCtrl.PATH)
public class LineCtrl {

    static final String PATH = "/api/line";
    private LineService lineService;

    @Autowired
    public LineCtrl(LineServiceImpl service) {
        this.lineService = service;
    }

    @GetMapping
    public ResponseEntity getName(){
        return CtrlUtils.sendOk(lineService.getAll());
    }

}
