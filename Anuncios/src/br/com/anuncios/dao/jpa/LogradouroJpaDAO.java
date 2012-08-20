package br.com.anuncios.dao.jpa;

import javax.persistence.EntityManager;

import br.com.anuncios.dao.LogradouroDAO;
import br.com.anuncios.model.Logradouro;

/**
 * <p>Hibernate DAO layer for Logradouros</p>
 * <p>Generated at Wed Jun 13 00:29:31 BRT 2012</p>
 *
 * @author Salto-db Generator v1.0.16 / EJB3 + Hibernate DAO
 * @see http://www.hibernate.org/328.html
 */
public class LogradouroJpaDAO extends
		AbstractJpaDAO<Logradouro, Integer> implements
		LogradouroDAO {

	public LogradouroJpaDAO(){}
	
	public LogradouroJpaDAO(EntityManager pem){
		em = pem;		
	}

}
