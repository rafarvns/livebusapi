package br.com.rag.apilivebus.api.line;

import br.com.rag.apilivebus.abstraction.AbstractService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LineServiceImpl extends AbstractService<Line> implements LineService {

    private LineRepository lineRepository;
    @Autowired
    public LineServiceImpl(LineRepository repository) {
        super(repository);
        this.lineRepository = repository;
    }

}
