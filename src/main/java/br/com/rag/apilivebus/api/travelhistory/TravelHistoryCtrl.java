package br.com.rag.apilivebus.api.travelhistory;

import br.com.rag.apilivebus.utils.CtrlUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(TravelHistoryCtrl.PATH)
public class TravelHistoryCtrl {

    static final String PATH = "/api/travelhistory";
    private TravelHistoryService travelhistoryService;

    @Autowired
    public TravelHistoryCtrl(TravelHistoryServiceImpl service) {
        this.travelhistoryService = service;
    }

}
