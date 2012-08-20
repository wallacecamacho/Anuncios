package br.com.anuncios.dao.jpa;

import java.io.Serializable;
import java.lang.reflect.ParameterizedType;

import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.LockModeType;
import javax.persistence.Query;

import br.com.anuncios.dao.GenericDAO;
import br.com.anuncios.data.AnuncioRepository;

//import org.hibernate.Criteria;
//import org.hibernate.FlushMode;
//import org.hibernate.Query;
//import org.hibernate.LockMode;
//import org.hibernate.Session;
//import org.hibernate.criterion.Restrictions;
//import org.hibernate.criterion.Criterion;
//import org.hibernate.criterion.Example;

/**
 * Generated at Wed Jun 13 00:29:31 BRT 2012
 *
 * @author Salto-db Generator v1.0.16 / EJB3 + Hibernate DAO
 * @see http://www.hibernate.org/328.html
 */
public abstract class AbstractJpaDAO<T, ID extends Serializable> implements GenericDAO<T, ID> {

	//private Session session;
	
	@Inject
	@AnuncioRepository
	protected EntityManager em;

	private Class<T> persistentClass;

	@SuppressWarnings("unchecked")
	public AbstractJpaDAO() {
		this.persistentClass = (Class<T>) ((ParameterizedType) getClass().getGenericSuperclass()).getActualTypeArguments()[0];
	}

/*    public void setSession(Session session) {
		this.session = session;
	}

	protected Session getSession() {
		if (session == null)
           session = HibernateUtil.getSessionFactory().getCurrentSession();
       return session;
    }*/
	
	
	public EntityManager getEm() {
		if (em == null){
			em =  JpaUtil.getEntityManager();
		}
		return em;
	}

	public void setEm(EntityManager em) {
		this.em = em;
	}

	public Class<T> getPersistentClass() {
        return persistentClass;
    }

	public T getById(ID id) {
		return (T) getEm().find(getPersistentClass(), id);
	}


	public T getById(ID id, boolean lock) {
		if (lock) {
			return (T) getEm().find(getPersistentClass(), id, LockModeType.READ);
			//(getPersistentClass(), id, LockMode.UPGRADE);
		} else
			return getById(id);
	}


	public T loadById(ID id) {
		return (T) getEm().find(getPersistentClass(), id);
	}

	public void save(T entity) {
		getEm().persist(entity);
	}

	public void update(T entity) {
		getEm().merge(entity);
	}


	public void delete(T entity) {
		getEm().remove(entity);
	}

	public void deleteById(ID id) 	{
		getEm().remove(loadById(id));
	}

//	@SuppressWarnings("unchecked")
//    public List<T> findAll() {
//        return findByCriteria();
//    }
	
//	/**
//     * Use this inside subclasses as a convenience method.
//     */
//    @SuppressWarnings("unchecked")
//    protected List<T> findByCriteria(Criterion... criterion) {
//        //Criteria crit = getSession().createCriteria(getPersistentClass());
//    	CriteriaBuilder criteriaBuilder = getEm().getCriteriaBuilder();
//    	CriteriaQuery<T> criteriaQuery = criteriaBuilder.createQuery(T);
//        for (Criterion c : criterion) {
//            crit.add(c);
//        }
//        return crit.list();
//   }
   
//   	/**
// 	 * Find by criteria.
//	 */
//	@SuppressWarnings("unchecked")
//	public List<T> findByCriteria(Map criterias) {
//	
//		Criteria criteria = getSession().createCriteria(getPersistentClass());
//		criteria.add(Restrictions.allEq(criterias));
//		return criteria.list();
//	}
	
	/**
	 * This method will execute an HQL query and return the number of affected entities.
	 */
	public int executeQuery(String query, String namedParams[],	Object params[]) {
		Query q = getEm().createQuery(query);
		
		if (namedParams != null) {
			for (int i = 0; i < namedParams.length; i++) {
				q.setParameter(namedParams[i], params[i]);
			}
		}

		return q.executeUpdate();
	}
	
	protected int executeQuery(String query) {
		return executeQuery(query, null, null);
	}
	
	/**
	 * This method will execute a Named HQL query and return the number of affected entities.
	 */
	protected int executeNamedQuery(String namedQuery, String namedParams[],	Object params[]) {
		javax.persistence.Query q = getEm().createNamedQuery(namedQuery);
		
		if (namedParams != null) {
			for (int i = 0; i < namedParams.length; i++) {
				q.setParameter(namedParams[i], params[i]);
			}
		}

		return q.executeUpdate();
	}
	
	protected int executeNamedQuery(String namedQuery) {
		return executeNamedQuery(namedQuery, null, null);
	}
	

}
