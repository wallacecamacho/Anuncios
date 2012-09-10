package br.com.analise.charts;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.inject.Inject;
import javax.inject.Named;
import javax.persistence.EntityManager;

import org.primefaces.model.chart.CartesianChartModel;
import org.primefaces.model.chart.ChartSeries;

import br.com.analise.bean.query.TemplateQuery;
import br.com.analise.data.AnaliseRepository;
import br.com.analise.model.NumeroSorteado;

@Named("chartBean")
public class ChartBean {

	@Inject
	@AnaliseRepository
	private EntityManager em;
	
	@Inject
	TemplateQuery templateQuery;
	
    private CartesianChartModel categoryModel;  
    
    public ChartBean() {  
        createCategoryModel();  
    }  
  
    public CartesianChartModel getCategoryModel() {  
        return categoryModel;  
    }  
    
    @PostConstruct
    private void createCategoryModel() {  
        categoryModel = new CartesianChartModel();  
  
        ChartSeries numeros = new ChartSeries();  
        numeros.setLabel("numeros");  
  
        numeros.set("2004", 120);  
        numeros.set("2005", 100);  
        numeros.set("2006", 44);  
        numeros.set("2007", 150);  
        numeros.set("2008", 25);  
  
        for(NumeroSorteado sor: numerosSoreios()){
        	numeros.set("2004", 120); 
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
    
    public List<NumeroSorteado> numerosSoreios(){
        	
    	List<NumeroSorteado>  teste = templateQuery.getCountNumeroSorteios();
    	
    	return teste;
    	
    }
    
}
