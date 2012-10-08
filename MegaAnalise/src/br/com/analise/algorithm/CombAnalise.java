package br.com.analise.algorithm;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

import javax.enterprise.context.RequestScoped;
import javax.enterprise.context.SessionScoped;
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
@RequestScoped
public class CombAnalise implements Serializable{

	@Inject
	@AnaliseRepository
	private EntityManager em;

	private Logger logger = Logger.getLogger(this.getClass());

	@Inject
	TemplateNativeQuery templateNativeQuery;
	

	Map mapaComb = new TreeMap();

	public void verificaCombinacoes(){



		List<Object>  qtdNumSorteios = templateNativeQuery.getCountNumeros();
		
		//quantidade de numeros para analisar (numeros da cartela)
		
		inicio:
		for(Object objI : qtdNumSorteios){
			
			List listaComb = new ArrayList();
			
			logger.info("Sorteio de numero = " + objI);

			List<Object> resultadoPorNum =  listaResultados((Integer)objI);
			List<Object> resultadoPorNumInner =  listaResultados((Integer)objI);
			
		
			
				for(int h = 0; h <= resultadoPorNum.size() -1; h++){
					logger.info("iteracao = " + h);					
					Object[] rt =	(Object[]) resultadoPorNum.get(h);
					
					
					for(int j = 0; j <= rt.length -2; j++){
						logger.info("rt = " + rt[j]);
						
						iteracao1:
						for(int hj = 0; hj <= resultadoPorNum.size() -1; hj++){
							
							Object[] rtg =	(Object[]) resultadoPorNum.get(hj);
							
							for(int jt = 0; jt <= rtg.length -2; jt++){
								logger.info("rtg = " + rtg[jt]);
								
								logger.info("Iteração de comparação - iterando o item  " +rt[j] +" do sorteio " + rt[rt.length-1]);
								
								logger.info("comparando o item  " +rtg[jt] +" do sorteio " + rtg[rtg.length-1]);
								
								if( rt[rt.length-1] == rtg[rtg.length-1] ){
									continue iteracao1;
								}
								
								//excluindo o mesmo sorteio e comparação de um numero da cartela com o numero de objI
								if( (rt[j] != objI) && (rt[rt.length-1] != rtg[rtg.length-1] )){
									logger.info("iteracao = " + jt);	
									
									if( rt[j] == rtg[jt] ){
										listaComb.add(rtg);
										
									}
									
									
								}
								
							}
							
						}
						
					}

				

				}


			
				mapaComb.put(objI, listaComb);


		}

		
		/*
		//Quantidade de sorteios realizados
		List<Object>  qtdSorteios = templateNativeQuery.getCountSorteios();

		for(Object e : qtdSorteios ){

			logger.info("Sorteio de numero = " + e.toString());
			//logger.info("List de numero do sorteio = " + e.toString() + "  -  " + buscaNumerosdoSorteio((Integer)e).size() );

			//Busca os números do sorteio i
			List<NumeroSorteado> numerosSort = buscaNumerosdoSorteio((Integer)e);

			//Para cada número do sorteio
			for(NumeroSorteado num : numerosSort ){

				logger.info("numero sorteado = " + num.getNumeroSorteado());

				//Consulta todos os sorteios que contem o numero de i
				//for(int i=0; i<=numerosSort.size()-1; i++){

				//Consulta todos os numeros do sorteio que contem o numero de i 
				List<NumeroSorteado> contemNumero = buscaNumeros(num.getNumeroSorteado());

				//
				for(NumeroSorteado sort: contemNumero){
					for(NumeroSorteado num2 : numerosSort ){ //segundo nível


						if(num2.getNumeroSorteado()==sort.getNumeroSorteado() ){

							logger.info("numero sorteado é igual = " + num.getNumeroSorteado());
							logger.info("Sorteio a comparar = " + num2.getIdNumeroSorteado());
							logger.info("Sorteio comparado = " + sort.getIdNumeroSorteado());

						}

					}

				}

				//}

			}

		}

		*/

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
		javax.persistence.Query q = em.createNativeQuery(query);

		if (namedParams != null) {
			for (int i = 0; i < namedParams.length; i++) {
				q.setParameter(namedParams[i], params[i]);
			}
		}

		return q.getResultList();
	}


	public List<Object> listaResultados(Integer tparam){

		String[] vetNamedParam = {"param"};
		//Integer[] vetParams = {1};

		return	executeQuery(listaResultados, vetNamedParam, tparam );

	}

	private static String listaResultados = "select  s.dezena1 dez,  s.dezena2,  s.dezena3, s.dezena4, s.dezena5, s.dezena6, s.idSorteio  from Sorteio s " +
			"where s.dezena1 = :param or s.dezena2 = :param or s.dezena3 = :param or s.dezena4 = :param or s.dezena5 = :param or s.dezena6 = :param  ";
	
	public void teste(){
		logger.info("chamadaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa");
	}

}
