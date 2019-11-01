package br.com.rag.apilivebus.api.point;

import br.com.rag.apilivebus.abstraction.IBaseService;
import br.com.rag.apilivebus.api.point.dto.PointsWithoutLinesDTO;

import java.util.List;

public interface PointService extends IBaseService<Point> {

    List<Point> getAll();

    List<PointsWithoutLinesDTO> getByLine(Long number);

}
