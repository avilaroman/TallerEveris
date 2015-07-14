package cl.dgac.arsv.dao.impl;

import java.io.Serializable;

import javax.annotation.PostConstruct;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import cl.seis.generic.dao.GenericDAOImpl;

@Stateless
public abstract class BaseDAOImpl<E, ID extends Serializable, F> extends GenericDAOImpl<E, ID, F> {
	
	//@PersistenceUnit(name = "ARSV-pu")
	//private EntityManagerFactory emf;
	
	@PersistenceContext(name = "ARSV-pu")
	private EntityManager em;
		
	protected BaseDAOImpl(Class<E> persistentClass) {
		super(persistentClass);
	}
	
	@PostConstruct
	void configuration() {
		super.entityManager = this.em;
	}
	
}
