package br.com.rag.apilivebus.api.point;

import br.com.rag.apilivebus.abstraction.AbstractService;
import br.com.rag.apilivebus.api.point.dto.PointsWithoutLinesDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PointServiceImpl extends AbstractService<Point> implements PointService {

    private PointRepository pointRepository;
    @Autowired
    public PointServiceImpl(PointRepository repository) {
        super(repository);
        this.pointRepository = repository;
    }

    @Override
    public List<Point> getAll() {
        return pointRepository.findAll();
    }

    @Override
    public List<PointsWithoutLinesDTO> getByLine(Long number) {
        return pointRepository.findByLine(number);
    }
}
