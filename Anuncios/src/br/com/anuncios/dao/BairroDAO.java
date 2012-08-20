package br.com.anuncios.dao;

import java.util.List;

import br.com.anuncios.model.Bairro;
/**
 * <p>Generic DAO layer for Bairros</p>
 * <p>Generated at Wed Jun 13 00:29:30 BRT 2012</p>
 *
 * @author Salto-db Generator v1.0.16 / EJB3 + Hibernate DAO
 * @see http://www.hibernate.org/328.html
 */
public interface BairroDAO extends GenericDAO<Bairro,Integer> {



	public List<Bairro> buscaBairrosByCidade(Integer pIdCidade);
	
}