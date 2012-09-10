package br.com.analise.bean.query;

import java.io.Serializable;
import java.util.List;

import br.com.analise.handler.services.Query;
import br.com.analise.handler.services.QueryNativeService;

@QueryNativeService
public interface TemplateNativeQuery extends Serializable{

	 @Query("select  s.dezena1 dez,  s.idsorteio   from sorteio s union select s.dezena1 dez,  s.idsorteio   from sorteio s" +
	 		"	 	union select s.dezena1 dez,  s.idsorteio   from sorteio s union select s.dezena1 dez,  s.idsorteio   from sorteio s" +
	 		"	 	union select s.dezena1 dez,  s.idsorteio   from sorteio s union select s.dezena1 dez,  s.idsorteio   from sorteio s order by 1")
	   public List<Object[]> getAllSorteios();
	
}
