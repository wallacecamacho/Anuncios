package br.com.anuncios.dao.jpa;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import br.com.anuncios.dao.UfDAO;
import br.com.anuncios.model.Uf;

/**
 * <p>Hibernate DAO layer for Ufs</p>
 * <p>Generated at Wed Jun 13 00:29:31 BRT 2012</p>
 *
 * @author Salto-db Generator v1.0.16 / EJB3 + Hibernate DAO
 * @see http://www.hibernate.org/328.html
 */
public class UfJpaDAO extends
		AbstractJpaDAO<Uf, String> implements
		UfDAO {

	///**
	// * Find Uf by descricao
	// */
	//public List<Uf> findByDescricao(String descricao) {
	//	return findByCriteria(Restrictions.eq("descricao", descricao));
	//}
	
	public UfJpaDAO(){}
	
	public UfJpaDAO(EntityManager pem){
		em = pem;		
	}

	public List<Uf> buscaUf() throws Exception{

		
		CriteriaBuilder criteriaBuilder = em.getCriteriaBuilder();
		CriteriaQuery<Uf> criteriaQuery = criteriaBuilder.createQuery(Uf.class);
		Root<Uf> uf = criteriaQuery.from(Uf.class);
		criteriaQuery.select(uf).orderBy(criteriaBuilder.asc(uf.get("idUf")));		

		return em.createQuery(criteriaQuery).getResultList();

	}
	
}
