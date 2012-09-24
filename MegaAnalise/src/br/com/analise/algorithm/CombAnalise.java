package br.com.analise.algorithm;

import java.util.List;

import javax.inject.Inject;
import javax.inject.Named;
import javax.persistence.EntityManager;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Path;
import javax.persistence.criteria.Predicate;
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
		
		
		
		
		
		//Quantidade de sorteios realizados
		List<Object>  qtdSorteios = templateNativeQuery.getCountSorteios();
		
		for(Object e : qtdSorteios ){
			
			logger.info("Sorteio de numero = " + e.toString());
			//logger.info("List de numero do sorteio = " + e.toString() + "  -  " + buscaNumerosdoSorteio((Integer)e).size() );
			
			//Busca os n�meros do sorteio i
			 List<NumeroSorteado> numerosSort = buscaNumerosdoSorteio((Integer)e);
			
			 //Para cada n�mero do sorteio
			for(NumeroSorteado num : numerosSort ){
				
				logger.info("numero sorteado = " + num.getNumeroSorteado());
				
				//Consulta todos os sorteios que contem o numero de i
				//for(int i=0; i<=numerosSort.size()-1; i++){
					
					//Consulta todos os numeros do sorteio que contem o numero de i 
					List<NumeroSorteado> contemNumero = buscaNumeros(num.getNumeroSorteado());
					
					//
					for(NumeroSorteado sort: contemNumero){
					for(NumeroSorteado num2 : numerosSort ){ //segundo n�vel
						
							
							if(num2.getNumeroSorteado()==sort.getNumeroSorteado() ){
								
								logger.info("numero sorteado � igual = " + num.getNumeroSorteado());
								logger.info("Sorteio a comparar = " + num2.getIdNumeroSorteado());
								logger.info("Sorteio comparado = " + sort.getIdNumeroSorteado());
								
							}
							
						}
					
				}
				
			//}
			
			}
			
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
	
	public List<NumeroSorteado> buscaNumeros(Integer pNum) {

		CriteriaBuilder criteriaBuilder = em.getCriteriaBuilder();
		CriteriaQuery<NumeroSorteado> criteriaQuery = criteriaBuilder.createQuery(NumeroSorteado.class);
		Root<NumeroSorteado> numeroSorteado = criteriaQuery.from(NumeroSorteado.class);
		//Path<Object> path = numeroSorteado.join("sorteio");
		//ParameterExpression<Integer> param = criteriaBuilder.parameter(Integer.class);
		
		Predicate condi = criteriaBuilder.equal(numeroSorteado.get("numeroSorteado"), pNum);
		
		criteriaQuery.select(numeroSorteado).where(condi);
		
		return em.createQuery(criteriaQuery).getResultList();	

	}
	
	
	
	public List<Object> executeQuery(String query, String namedParams[],	Object... params) {
		javax.persistence.Query q = em.createNamedQuery(query);
		
		if (namedParams != null) {
			for (int i = 0; i < namedParams.length; i++) {
				q.setParameter(namedParams[i], params[i]);
			}
		}

		return q.getResultList();
	}
	

	public void listaResultados(){
		
		String[] vetNamedParam = {"param"};
		//Integer[] vetParams = {1};
		Integer vetParams1 = 1;
		executeQuery(listaResultados, vetNamedParam, vetParams1 );
		
	}
	
	private static String listaResultados = "select  s.dezena1 dez,  s.dezena2,  s.dezena3, s.dezena4, s.dezena5, s.dezena6, s.idSorteio  from sorteio s " +
			"where s.s.dezena1 = :param or s.s.dezena2 = :param or s.s.dezena3 = :param or s.s.dezena4 = :param or s.s.dezena5 = :param or s.s.dezena5 = :param or s.s.dezena6 = :param  ";
	
}
