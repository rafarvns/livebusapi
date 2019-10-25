package br.com.rag.apilivebus.api.routedraw;

import br.com.rag.apilivebus.abstraction.AbstractService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RouteDrawServiceImpl extends AbstractService<RouteDraw> implements RouteDrawService {

    private RouteDrawRepository routeDrawRepository;
    @Autowired
    public RouteDrawServiceImpl(RouteDrawRepository repository) {
        super(repository);
        this.routeDrawRepository = repository;
    }

}
