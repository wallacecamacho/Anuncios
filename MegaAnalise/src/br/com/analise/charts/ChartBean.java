package br.com.analise.charts;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;

import org.primefaces.model.chart.CartesianChartModel;
import org.primefaces.model.chart.ChartSeries;

import br.com.analise.algorithm.CombAnalise;
import br.com.analise.bean.query.TemplateNativeQuery;

@Named("chartBean")
@RequestScoped
public class ChartBean {

	
	@Inject
	TemplateNativeQuery templateNativeQuery;
	
    private CartesianChartModel categoryModel;  
    

    public ChartBean() {  
        
    }  
  
    public CartesianChartModel getCategoryModel() {  
        return categoryModel;  
    }  
    
    @PostConstruct
    public void createCategoryModel() {  
        categoryModel = new CartesianChartModel();  
  
        ChartSeries numeros = new ChartSeries();  
        numeros.setLabel("números sorteados");  
  
      
        for(Object[] sor: numerosSoreios()){
        	
        	numeros.set(sor[0],new Integer (sor[1].toString())); 
        }
        
      
        categoryModel.addSeries(numeros);  
        
    }  
    
    
    
/*	public List<NumeroSorteado> buscaUf() throws Exception{

		
		CriteriaBuilder criteriaBuilder = em.getCriteriaBuilder();
		CriteriaQuery<NumeroSorteado> criteriaQuery = criteriaBuilder.createQuery(NumeroSorteado.class);
		Root<NumeroSorteado> tipo = criteriaQuery.from(NumeroSorteado.class);
		criteriaQuery.select(tipo);
		
		criteriaQuery.s
		
		Expression<Integer> exp = criteriaBuilder.sum(arg0)
		Predicate condi = criteriaBuilder.sum(tipo.get("desctTipo"));

		criteriaQuery.select(tipo);
		criteriaQuery.where(condi);
		
		return em.createQuery(criteriaQuery).getSingleResult();		
	}*/
    
    public List<Object[]> numerosSoreios(){
        	
    	List<Object[]>  teste = templateNativeQuery.getCountNumeroSorteios();
    	
    	return teste;
    	
    }
    
	public void teste(){
		
		CombAnalise combAnalise = new CombAnalise();
		combAnalise.verificaCombinacoes();
	}

    
}
