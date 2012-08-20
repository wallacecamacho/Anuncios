package br.com.anuncios.dao.jpa;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Path;
import javax.persistence.criteria.Root;

import br.com.anuncios.dao.BairroDAO;
import br.com.anuncios.model.Bairro;

/**
 * <p>Hibernate DAO layer for Bairros</p>
 * <p>Generated at Wed Jun 13 00:29:30 BRT 2012</p>
 *
 * @author Salto-db Generator v1.0.16 / EJB3 + Hibernate DAO
 * @see http://www.hibernate.org/328.html
 */
public class BairroJpaDAO extends
		AbstractJpaDAO<Bairro, Integer> implements
		BairroDAO {

	
	public BairroJpaDAO(){}
	
	public BairroJpaDAO(EntityManager pem){
		em = pem;		
	}
	
	public List<Bairro> buscaBairrosByCidade(Integer pIdCidade) {

		CriteriaBuilder criteriaBuilder = em.getCriteriaBuilder();
		CriteriaQuery<Bairro> criteriaQuery = criteriaBuilder.createQuery(Bairro.class);
		Root<Bairro> bairro = criteriaQuery.from(Bairro.class);
		Path<Object> path = bairro.join("cidade");
		criteriaQuery.select(bairro).where(criteriaBuilder.equal(path, pIdCidade));
		
		return em.createQuery(criteriaQuery).getResultList();	

	}


}
