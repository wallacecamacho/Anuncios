package br.com.anuncios.dao.jpa;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Path;
import javax.persistence.criteria.Root;

import br.com.anuncios.dao.CidadeDAO;
import br.com.anuncios.model.Cidade;
import br.com.anuncios.model.Uf;

/**
 * <p>Hibernate DAO layer for Cidades</p>
 * <p>Generated at Wed Jun 13 00:29:31 BRT 2012</p>
 *
 * @author Salto-db Generator v1.0.16 / EJB3 + Hibernate DAO
 * @see http://www.hibernate.org/328.html
 */
public class CidadeJpaDAO extends
		AbstractJpaDAO<Cidade, Integer> implements
		CidadeDAO {


	public CidadeJpaDAO(){}
	
	public CidadeJpaDAO(EntityManager pem){
		em = pem;		
	}
	
	public List<Cidade> buscaCidadesByUf(Uf pUf) {

		CriteriaBuilder criteriaBuilder = em.getCriteriaBuilder();
		CriteriaQuery<Cidade> criteriaQuery = criteriaBuilder.createQuery(Cidade.class);
		Root<Cidade> cidade = criteriaQuery.from(Cidade.class);
		Path<Object> path = cidade.join("uf");
		criteriaQuery.select(cidade).where(criteriaBuilder.equal(path, pUf));
		return em.createQuery(criteriaQuery).getResultList();

		
	}

}
