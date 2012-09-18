package br.com.analise.algorithm;

import java.util.List;

import javax.inject.Inject;

import br.com.analise.bean.query.TemplateNativeQuery;
import br.com.analise.bean.query.TemplateQuery;

public class CombAnalise {

	@Inject
	TemplateNativeQuery templateNativeQuery;
	
	public void verificaCombinacoes(){
		
		List<Object>  teste = templateNativeQuery.getCountSorteios();
		
		for(Object e : teste ){
			
			
			
		}
		
	}
	
}
