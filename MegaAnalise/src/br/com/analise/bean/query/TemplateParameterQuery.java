package br.com.analise.bean.query;

import java.io.Serializable;
import java.util.List;

import br.com.analise.handler.services.Query;
import br.com.analise.handler.services.QueryParameterService;

@QueryParameterService
public interface TemplateParameterQuery extends Serializable{

	
	@Query(value="select  sorteio from Numerosorteado where sorteio")
	public List<Object> getNumeroPorSorteio();	
	
}
