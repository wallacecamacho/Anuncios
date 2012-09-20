package br.com.analise.bean.query;

import java.io.Serializable;
import java.util.List;

import br.com.analise.handler.services.Query;
import br.com.analise.handler.services.QueryService;
import br.com.analise.model.Sorteio;


@QueryService
public interface TemplateQuery extends Serializable{

	
	
	 @Query("select t from Sorteio t")
	   public List<Sorteio> getAllSorteios();
	 

}
