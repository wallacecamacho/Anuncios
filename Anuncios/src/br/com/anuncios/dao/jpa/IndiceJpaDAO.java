package br.com.anuncios.dao.jpa;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import br.com.anuncios.dao.IndiceDAO;
import br.com.anuncios.model.Indice;

/**
 * <p>Hibernate DAO layer for Indices</p>
 * <p>Generated at Wed Jun 13 00:29:31 BRT 2012</p>
 *
 * @author Salto-db Generator v1.0.16 / EJB3 + Hibernate DAO
 * @see http://www.hibernate.org/328.html
 */
public class IndiceJpaDAO extends
		AbstractJpaDAO<Indice, String> implements
		IndiceDAO {
	

	public IndiceJpaDAO(){}
	
	public IndiceJpaDAO(EntityManager pem){
		em = pem;		
	}
	
	@Override
	public List<Indice> findAll() {
		CriteriaBuilder cb = em.getCriteriaBuilder();
		CriteriaQuery<Indice> criteria = cb.createQuery(Indice.class);
		Root<Indice> indice = criteria.from(Indice.class);
		criteria.select(indice).orderBy(cb.asc(indice.get("idIndice")));
		return getEm().createQuery(criteria).getResultList();		
		 
	}

	
}
