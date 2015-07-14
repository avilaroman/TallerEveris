package cl.seis.generic.dao;

import java.io.Serializable;
import java.util.List;

import javax.enterprise.context.Dependent;
import javax.inject.Named;
import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import cl.seis.generic.utils.GenericQuery;

@Named
@Dependent
public abstract class GenericDAOImpl<E, ID extends Serializable, F> implements GenericDAO<E, ID, F> {

	private final Class<E> persistentClass;
	
	protected EntityManager entityManager;

	protected CriteriaBuilder cb;
	
	protected GenericDAOImpl(Class<E> persistentClass) {
		this.persistentClass = persistentClass;
	}

	public Class<E> getPersistentClass() {
		return persistentClass;
	}

	public EntityManager getEntityManager() {
		return entityManager;
	}
	
	public CriteriaBuilder getCb() {
		return cb;
	}

	public E save(E entity) {
		entityManager.persist(entity);
		entityManager.flush();

		return entity;
	}

	public E update(E entity) {
		entityManager.merge(entity);
		entityManager.flush();

		return entity;
	}

	public void remove(E entity) {
		entityManager.remove(entityManager.merge(entity));
		entityManager.flush();
	}

	public E findById(ID id) {
		return entityManager.find(persistentClass, id);
	}

	@SuppressWarnings("unchecked")
	public List<E> findAll() {
		return entityManager.createQuery(
				"select e from " + persistentClass.getName() + " e")
				.getResultList();
	}

	public List<E> findByCriteria(F filter) {		
		if (filter != null) {
			CriteriaQuery<E> criteria = this.getQuery(filter);
			TypedQuery<E> query = entityManager.createQuery(criteria);

			return query.getResultList();
		} else {
			return this.findAll();
		}
	}

	public List<E> findByCriteriaPagination(F filter, int first, int pageSize) {
		TypedQuery<E> query = null;
		
		if (filter != null) {
			CriteriaQuery<E> criteria = this.getQuery(filter);
			query = entityManager.createQuery(criteria);			
		} else {
			query = entityManager.createQuery(
				"select e from " + persistentClass.getName() + " e", persistentClass);
		}
		
		if (pageSize >= 0) {
			query.setMaxResults(pageSize);
		}
		
		if (first >= 0) {
			query.setFirstResult(first);
		}
		
		return query.getResultList();
	}
	
	public Long count() {
		return (Long) entityManager.createQuery(
				"select count(e) from " + persistentClass.getName() + " e")
				.getSingleResult();
	}
		
	public Long countWithFilter(F filter) {
		CriteriaQuery<Long> cq = this.cb.createQuery(Long.class);
		Root<E> root = cq.from(persistentClass);
		
		GenericQuery query = this.getConditions(filter, cq, root);
		
		cq.select(this.cb.count(root));
		
		if (query.getConditions() != null) cq.where(query.getConditions());
		
		return entityManager.createQuery(cq).getSingleResult();
	}
	
	protected abstract <T> GenericQuery getConditions(F filter, CriteriaQuery<T> cq, Root<E> root);
	
	private CriteriaQuery<E> getQuery(F filter) {
		CriteriaQuery<E> cq = this.cb.createQuery(persistentClass);
		Root<E> root = cq.from(persistentClass);
		cq.select(root);
		
		GenericQuery query = this.getConditions(filter, cq, root);
		
		if (query.getConditions() != null)
			cq.where(query.getConditions());
		
		if (query.getOrderBy() != null)
			if (query.getOrderBy().size() > 0)
				cq.orderBy(query.getOrderBy());
		
		return cq;
	}
}
