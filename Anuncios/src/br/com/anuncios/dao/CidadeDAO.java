package br.com.anuncios.dao;

import java.util.List;

import br.com.anuncios.model.Cidade;
import br.com.anuncios.model.Uf;
/**
 * <p>Generic DAO layer for Cidades</p>
 * <p>Generated at Wed Jun 13 00:29:31 BRT 2012</p>
 *
 * @author Salto-db Generator v1.0.16 / EJB3 + Hibernate DAO
 * @see http://www.hibernate.org/328.html
 */
public interface CidadeDAO extends GenericDAO<Cidade,Integer> {


	public List<Cidade> buscaCidadesByUf(Uf pUf);

}