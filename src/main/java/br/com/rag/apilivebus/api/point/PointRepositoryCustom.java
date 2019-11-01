package br.com.rag.apilivebus.api.point;

import br.com.rag.apilivebus.api.point.dto.PointsWithoutLinesDTO;

import java.util.List;

public interface PointRepositoryCustom {
    List<PointsWithoutLinesDTO> findByLine(Long number);
}
