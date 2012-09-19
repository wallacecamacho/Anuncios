package br.com.analise.algorithm;

import java.util.List;

import javax.inject.Inject;
import javax.inject.Named;
import javax.persistence.EntityManager;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Path;
import javax.persistence.criteria.Root;

import org.jboss.solder.logging.Logger;

import br.com.analise.bean.query.TemplateNativeQuery;
import br.com.analise.data.AnaliseRepository;
import br.com.analise.model.NumeroSorteado;

@Named("combAnalise")
public class CombAnalise {

	@Inject
	@AnaliseRepository
	private EntityManager em;
	
	private Logger logger = Logger.getLogger(this.getClass());
	
	@Inject
	TemplateNativeQuery templateNativeQuery;
	
	public void verificaCombinacoes(){
		
		List<Object>  teste = templateNativeQuery.getCountSorteios();
		
		for(Object e : teste ){
			
			logger.info("Sorteio de numero = " + e.toString());
			logger.info("List de numero do sorteio = " + e.toString() + "  -  " + buscaNumerosdoSorteio((Integer)e).size() );
			
			
			
		}
		
	}
	
	
	public List<NumeroSorteado> buscaNumerosdoSorteio(Integer pISorteio) {

		CriteriaBuilder criteriaBuilder = em.getCriteriaBuilder();
		CriteriaQuery<NumeroSorteado> criteriaQuery = criteriaBuilder.createQuery(NumeroSorteado.class);
		Root<NumeroSorteado> numeroSorteado = criteriaQuery.from(NumeroSorteado.class);
		Path<Object> path = numeroSorteado.join("sorteio");
		//ParameterExpression<Integer> param = criteriaBuilder.parameter(Integer.class);
		
		//Predicate condi = criteriaBuilder.equal(numeroSorteado.get("desctTipo"), pDescricao);
		
		criteriaQuery.select(numeroSorteado).where(criteriaBuilder.equal(path, pISorteio));
		
		return em.createQuery(criteriaQuery).getResultList();	

	}
	
}
