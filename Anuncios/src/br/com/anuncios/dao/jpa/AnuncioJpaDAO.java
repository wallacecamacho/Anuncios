package br.com.anuncios.dao.jpa;

import javax.persistence.EntityManager;

import br.com.anuncios.dao.AnuncioDAO;
import br.com.anuncios.model.Anuncio;

/**
 * <p>Hibernate DAO layer for Anuncios</p>
 * <p>Generated at Wed Jun 13 00:29:30 BRT 2012</p>
 *
 * @author Salto-db Generator v1.0.16 / EJB3 + Hibernate DAO
 * @see http://www.hibernate.org/328.html
 */
public class AnuncioJpaDAO extends
		AbstractJpaDAO<Anuncio, Integer> implements
		AnuncioDAO {

	public AnuncioJpaDAO(){}
	
	public AnuncioJpaDAO(EntityManager pem){
		em = pem;		
	}

	
}
