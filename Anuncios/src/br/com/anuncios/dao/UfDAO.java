package br.com.anuncios.dao;

import java.util.List;

import br.com.anuncios.model.Uf;
/**
 * <p>Generic DAO layer for Ufs</p>
 * <p>Generated at Wed Jun 13 00:29:31 BRT 2012</p>
 *
 * @author Salto-db Generator v1.0.16 / EJB3 + Hibernate DAO
 * @see http://www.hibernate.org/328.html
 */
public interface UfDAO extends GenericDAO<Uf,String> {

	/*
	 * TODO : Add specific businesses daos here.
	 * These methods will be overwrited if you re-generate this interface.
	 * You might want to extend this interface and to change the dao factory to return 
	 * an instance of the new implemenation in buildUfDAO()
	 */
	  	 
	///**
	// * Find Uf by descricao
	// */
	//public List<Uf> findByDescricao(String descricao);

	public List<Uf> buscaUf() throws Exception;
	
}