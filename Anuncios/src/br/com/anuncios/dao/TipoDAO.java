package br.com.anuncios.dao;

import br.com.anuncios.model.Tipo;
/**
 * <p>Generic DAO layer for Tipos</p>
 * <p>Generated at Wed Jun 13 00:29:31 BRT 2012</p>
 *
 * @author Salto-db Generator v1.0.16 / EJB3 + Hibernate DAO
 * @see http://www.hibernate.org/328.html
 */
public interface TipoDAO extends GenericDAO<Tipo,Integer> {

	
	public Tipo findByIndiceDesc(String pDescricao, String pIndice);
	
}