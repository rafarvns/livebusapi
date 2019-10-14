package br.com.rag.apilivebus.api.point;

import br.com.rag.apilivebus.abstraction.AbstractService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PointServiceImpl extends AbstractService<Point> implements PointService {

    private PointRepository pointRepository;
    @Autowired
    public PointServiceImpl(PointRepository repository) {
        super(repository);
        this.pointRepository = repository;
    }

}
