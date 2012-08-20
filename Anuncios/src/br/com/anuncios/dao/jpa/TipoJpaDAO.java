package br.com.anuncios.dao.jpa;

import javax.persistence.EntityManager;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Path;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import br.com.anuncios.dao.TipoDAO;
import br.com.anuncios.model.Tipo;

/**
 * <p>Hibernate DAO layer for Tipos</p>
 * <p>Generated at Wed Jun 13 00:29:31 BRT 2012</p>
 *
 * @author Salto-db Generator v1.0.16 / EJB3 + Hibernate DAO
 * @see http://www.hibernate.org/328.html
 */
public class TipoJpaDAO extends
		AbstractJpaDAO<Tipo, Integer> implements
		TipoDAO {

	public TipoJpaDAO(){}
	
	public TipoJpaDAO(EntityManager pem){
		em = pem;		
	}
	
	
	public Tipo findByIndiceDesc(String pIndice,String pDescricao ){
		
		
		CriteriaBuilder criteriaBuilder = em.getCriteriaBuilder();
		CriteriaQuery<Tipo> criteriaQuery = criteriaBuilder.createQuery(Tipo.class);
		Root<Tipo> tipo = criteriaQuery.from(Tipo.class);
		criteriaQuery.select(tipo);
		
		Path<Object> path = tipo.join("indice");
		criteriaQuery.select(tipo).where(criteriaBuilder.equal(path, pIndice));
		
		Predicate condi = criteriaBuilder.equal(tipo.get("desctTipo"), pDescricao);

		criteriaQuery.select(tipo);
		criteriaQuery.where(condi);
		
		return em.createQuery(criteriaQuery).getSingleResult();		
		
	}
	
}
