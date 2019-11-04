package br.com.rag.apilivebus.api.line;

import br.com.rag.apilivebus.abstraction.IBaseService;

import java.util.List;

public interface LineService extends IBaseService<Line> {

    List<Line> getAll();

}
