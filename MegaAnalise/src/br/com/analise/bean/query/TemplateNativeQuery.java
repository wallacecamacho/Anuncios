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

	@Query("select  n.numeroSorteado, count(n.numeroSorteado)  from  NumeroSorteado n group by  n.numeroSorteado")
	public List<Object[]> getCountNumeroSorteios();
	
	
	@Query("select  sorteio from analise.numerosorteado group by sorteio")
	public List<Object> getCountSorteios();
	
	@Query(value="select  sorteio from Numerosorteado where sorteio")
	public List<Object> getNumeroPorSorteio();	

}
