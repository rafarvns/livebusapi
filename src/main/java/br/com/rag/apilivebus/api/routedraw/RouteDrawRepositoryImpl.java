package br.com.rag.apilivebus.api.routedraw;

import br.com.rag.apilivebus.abstraction.QueryDslSupport;
import br.com.rag.apilivebus.api.line.QLine;

import java.util.List;

public class RouteDrawRepositoryImpl extends QueryDslSupport implements RouteDrawRepositoryCustom {

    public RouteDrawRepositoryImpl() {
        super(RouteDraw.class);
    }

    @Override
    public List<RouteDraw> findAllRouteDrawByLine(Long number) {
        QRouteDraw routeDraw = QRouteDraw.routeDraw;
        QLine line = QLine.line;
        return getQuerydsl().createQuery()
                .select(routeDraw)
                .from(routeDraw)
                .innerJoin(routeDraw.line, line)
                .on(line.number.eq(number))
                .fetch();
    }
}
