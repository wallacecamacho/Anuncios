package br.com.anuncios.dao.jpa;

import javax.inject.Inject;
import javax.persistence.EntityManager;

import br.com.anuncios.data.AnuncioRepository;

/**
 * Generated at Wed Jun 13 00:29:31 BRT 2012
 *
 * @author Salto-db Generator v1.0.16 / EJB3 + Hibernate DAO
 */

public final class JpaUtil {

	//private static SessionFactory sessionFactory;
	
	@Inject
	@AnuncioRepository
	private static EntityManager em;

	//private static EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("Anuncios");

	
		
/*	static {
		try {
			//sessionFactory = new AnnotationConfiguration().configure().buildSessionFactory();

		} catch (Throwable ex) {

			throw new ExceptionInInitializerError(ex);
		}
	}*/

	private JpaUtil() {

	}

	/**
	 * Returns the SessionFactory used for this static class.
	 * 
	 * @return SessionFactory
	 */
	public static EntityManager getEntityManager() {
		return em;
		//return entityManagerFactory.createEntityManager();
		
	}

}
