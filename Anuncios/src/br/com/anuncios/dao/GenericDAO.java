package br.com.anuncios.dao;

import java.io.Serializable;

/**
 * Generated at Wed Jun 13 00:29:31 BRT 2012
 *
 * @author Salto-db Generator v1.0.16 / EJB3 + Hibernate DAO
 * @see http://www.hibernate.org/328.html
 */
public interface GenericDAO<T, ID extends Serializable> {

	
	T getById(ID id, boolean lock);

	T getById(ID id);
	
	T loadById(ID id);

	//List<T> findAll();
	
	//List<T> findByCriteria(Map criterias);
	
	//public List<T> findByExample(T exampleInstance, String[] excludeProperty);

	void save(T entity);

	void update(T entity);

	//void saveOrUpdate(T entity);

	void delete(T entity);
	
	void deleteById(ID id);
	
	
	int executeQuery(String query, String namedParams[], Object params[]);
	
}