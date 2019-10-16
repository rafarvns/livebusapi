package br.com.rag.apilivebus.api.live;

import br.com.rag.apilivebus.api.live.LiveService;
import br.com.rag.apilivebus.api.live.LiveServiceImpl;
import br.com.rag.apilivebus.utils.CtrlUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(LiveCtrl.PATH)
public class LiveCtrl {

    static final String PATH = "/api/live";
    private LiveService liveService;

    @Autowired
    public LiveCtrl(LiveServiceImpl service) {
        this.liveService = service;
    }

    @GetMapping("getLiveBus")
    public ResponseEntity getLiveBus(){
        return CtrlUtils.sendOk(liveService.getLiveBus());
    }

}
