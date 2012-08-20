package br.com.anuncios.dao;

import java.util.List;

import br.com.anuncios.model.Indice;
/**
 * <p>Generic DAO layer for Indices</p>
 * <p>Generated at Wed Jun 13 00:29:31 BRT 2012</p>
 *
 * @author Salto-db Generator v1.0.16 / EJB3 + Hibernate DAO
 * @see http://www.hibernate.org/328.html
 */
public interface IndiceDAO extends GenericDAO<Indice,String> {

	/*
	 * TODO : Add specific businesses daos here.
	 * These methods will be overwrited if you re-generate this interface.
	 * You might want to extend this interface and to change the dao factory to return 
	 * an instance of the new implemenation in buildIndiceDAO()
	 */
	
	List<Indice> findAll();
	  	 
}