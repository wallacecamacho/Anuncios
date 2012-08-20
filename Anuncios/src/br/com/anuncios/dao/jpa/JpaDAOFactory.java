package br.com.anuncios.dao.jpa;

import javax.persistence.EntityManager;

import br.com.anuncios.dao.DAOFactory;
import br.com.anuncios.dao.AnuncioDAO;
import br.com.anuncios.dao.BairroDAO;
import br.com.anuncios.dao.CidadeDAO;
import br.com.anuncios.dao.IndiceDAO;
import br.com.anuncios.dao.LogradouroDAO;
import br.com.anuncios.dao.TipoDAO;
import br.com.anuncios.dao.UfDAO;

/**
 * Generated at Wed Jun 13 00:29:31 BRT 2012
 *
 * @see http://www.hibernate.org/43.html
 * @author Salto-db Generator v1.0.16 / EJB3 + Hibernate DAO
 */
public class JpaDAOFactory extends DAOFactory {


	/* (non-Javadoc)
	 * @see br.com.anuncios.dao.DAOFactory#buildAnuncioDAO()
	 */
	@Override
	public AnuncioDAO buildAnuncioDAO(EntityManager em) {
		return new AnuncioJpaDAO(em);
	}
	
	/* (non-Javadoc)
	 * @see br.com.anuncios.dao.DAOFactory#buildBairroDAO()
	 */
	@Override
	public BairroDAO buildBairroDAO(EntityManager em) {
		return new BairroJpaDAO(em);
	}
	
	/* (non-Javadoc)
	 * @see br.com.anuncios.dao.DAOFactory#buildCidadeDAO()
	 */
	@Override
	public CidadeDAO buildCidadeDAO(EntityManager em) {
		return new CidadeJpaDAO(em);
	}
	
	/* (non-Javadoc)
	 * @see br.com.anuncios.dao.DAOFactory#buildIndiceDAO()
	 */
	@Override
	public IndiceDAO buildIndiceDAO(EntityManager em) {
		return new IndiceJpaDAO(em);
	}
	
	/* (non-Javadoc)
	 * @see br.com.anuncios.dao.DAOFactory#buildLogradouroDAO()
	 */
	@Override
	public LogradouroDAO buildLogradouroDAO(EntityManager em) {
		return new LogradouroJpaDAO(em);
	}
	
	
	/* (non-Javadoc)
	 * @see br.com.anuncios.dao.DAOFactory#buildTipoDAO()
	 */
	@Override
	public TipoDAO buildTipoDAO(EntityManager em) {
		return new TipoJpaDAO(em);
	}
	

	/* (non-Javadoc)
	 * @see br.com.anuncios.dao.DAOFactory#buildUfDAO()
	 */
	@Override
	public UfDAO buildUfDAO(EntityManager em) {
		return new UfJpaDAO(em);
	}
	
}
