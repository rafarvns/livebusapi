package br.com.rag.apilivebus.api.routedraw;

import br.com.rag.apilivebus.abstraction.IBaseService;

import java.util.List;

public interface RouteDrawService extends IBaseService<RouteDraw> {

    List<RouteDraw> getAll();

    List<RouteDraw> getAllRouteDrawByLine(Long number);

}
