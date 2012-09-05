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
	 
	 @Query("select t.dezena1 from Sorteio t group by t.dezena1 union Select t2.dezena2 from Sorteio t2 group by t2.dezena2")
	   public List<Sorteio> getAllSorteiosG();
	
}
