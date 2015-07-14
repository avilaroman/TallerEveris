package cl.seis.generic.dao;

import java.io.Serializable;
import java.util.List;

public interface GenericDAO<E, ID extends Serializable, F> {

	public E save(E entity);

	public E update(E entity);

	public void remove(E entity);

	public E findById(ID id);

	public List<E> findAll();
	
	public List<E> findByCriteria(F filter);
	
	public List<E> findByCriteriaPagination(F filter, int first, int pageSize);

	public Long count();
	
	public Long countWithFilter(F filter);
	
}     