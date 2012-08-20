package br.com.anuncios.dao;

import javax.persistence.EntityManager;

import br.com.anuncios.dao.jpa.JpaDAOFactory;

/**
 * Generated at Wed Jun 13 00:29:31 BRT 2012
 *
 * @see http://www.hibernate.org/328.html
 * @author Salto-db Generator v1.0.16 / EJB3 + Hibernate DAO
 */

public abstract class DAOFactory {

	private static final DAOFactory JPA = new JpaDAOFactory();

	public static final DAOFactory DEFAULT = JPA;
	
    /**
     * Factory method for instantiation of concrete factories.
     */
    public static DAOFactory instance(Class factory) {
        try {
            return (DAOFactory)factory.newInstance();
        } catch (Exception ex) {
            throw new RuntimeException("Couldn't create DAOFactory: " + factory);
        }
    }
	
	public abstract AnuncioDAO buildAnuncioDAO(EntityManager em);
	
	public abstract BairroDAO buildBairroDAO(EntityManager em);
	
	public abstract CidadeDAO buildCidadeDAO(EntityManager em);
	
	public abstract IndiceDAO buildIndiceDAO(EntityManager em);
	
	public abstract LogradouroDAO buildLogradouroDAO(EntityManager em);
		
	public abstract TipoDAO buildTipoDAO(EntityManager em);
	
	public abstract UfDAO buildUfDAO(EntityManager em);
	
}
