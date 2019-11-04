package br.com.rag.apilivebus.api.point;

import br.com.rag.apilivebus.abstraction.QueryDslSupport;
import br.com.rag.apilivebus.api.line.QLine;
import br.com.rag.apilivebus.api.point.dto.PointsWithoutLinesDTO;

import java.util.List;

public class PointRepositoryImpl extends QueryDslSupport implements PointRepositoryCustom {

    public PointRepositoryImpl() {
        super(Point.class);
    }

    @Override
    public List<Point> findByLine(Long number) {
        QPoint point = QPoint.point;
        QLine line = QLine.line;

        return getQuerydsl().createQuery()
                .select(point)
                .from(point, line)
                .innerJoin(point.lines, line)
                .on(line.number.eq(number))
                .fetch();
    }
}
