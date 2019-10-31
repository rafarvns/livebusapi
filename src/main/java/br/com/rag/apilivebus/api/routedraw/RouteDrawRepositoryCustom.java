package br.com.rag.apilivebus.api.routedraw;

import java.util.List;

public interface RouteDrawRepositoryCustom {
    List<RouteDraw> findAllRouteDrawByLine(Long number);
}
