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
	 
	 @Query("select t.dezena1 dez,t.idSorteio   from Sorteio t  " +
	 		"union select t.dezena2 dez,idSorteio  from Sorteio t " +
	 		"union select t.dezena3 dez,idSorteio  from Sorteio t" +
	 		"union select t.dezena4 dez,idSorteio  from Sorteio t" +
	 		"union select t.dezena5 dez,idSorteio  from Sorteio t" +
	 		"union select t.dezena6 dez,idSorteio  from Sorteio t ")
	   public List<Sorteio> getAllSorteiosG();
	


}
