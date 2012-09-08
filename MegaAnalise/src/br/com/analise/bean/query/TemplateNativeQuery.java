package br.com.analise.bean.query;

import java.io.Serializable;
import java.util.List;

import br.com.analise.handler.services.Query;
import br.com.analise.handler.services.QueryNativeService;

@QueryNativeService
public interface TemplateNativeQuery extends Serializable{

	 @Query("select dez, idsorteio from (select dezena1 dez,idsorteio   from sorteio  union select dezena2 dez,idsorteio  from sorteio " +
	 		"union select dezena3 dez,idsorteio  from sorteio union select dezena4 dez,idsorteio  from sorteio " +
	 		"union select dezena5 dez,idsorteio  from sorteio union select dezena6 dez,idsorteio  from sorteio )order by 1")
	   public List<Object[]> getAllSorteios();
	
}
