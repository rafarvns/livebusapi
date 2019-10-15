package br.com.rag.apilivebus.api.route;

import br.com.rag.apilivebus.abstraction.AbstractService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RouteServiceImpl extends AbstractService<Route> implements RouteService {

    private RouteRepository routeRepository;
    @Autowired
    public RouteServiceImpl(RouteRepository repository) {
        super(repository);
        this.routeRepository = repository;
    }

}
