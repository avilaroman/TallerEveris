package cl.dgac.arsv.dao.impl;

import java.util.List;

import javax.ejb.Stateless;
import javax.inject.Named;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import cl.dgac.arsv.dao.ArsvBaseOperacionDAO;
import cl.dgac.arsv.filters.FiltroArsvBaseOperacion;
import cl.dgac.arsv.model.ArsvBaseOperacion;
import cl.dgac.arsv.model.ArsvBaseOperacion_;

@Stateless
@Named(value = "arsvBaseOperacionDAO")
public class ArsvBaseOperacionDAOImpl extends BaseDAOImpl<ArsvBaseOperacion, Long, FiltroArsvBaseOperacion> implements ArsvBaseOperacionDAO {
		
	
	public ArsvBaseOperacionDAOImpl() {
		super(ArsvBaseOperacion.class);		
	}

	@Override
	public List<ArsvBaseOperacion> findBasesOperacion(FiltroArsvBaseOperacion filtro) {
		return super.findByCriteria(filtro);
	}
		
	@Override
	protected CriteriaQuery<ArsvBaseOperacion> createFilter(FiltroArsvBaseOperacion filtro) {
		CriteriaBuilder cb = entityManager.getCriteriaBuilder();
		Predicate restricciones = null, condicion = null;
		
		CriteriaQuery<ArsvBaseOperacion> cq = cb.createQuery(ArsvBaseOperacion.class);
		Root<ArsvBaseOperacion> baseOperacion = cq.from(ArsvBaseOperacion.class);
		cq.select(baseOperacion);
					
		// Condiciones
		if ((filtro.getCodigo() != null)) {
			condicion = cb.equal(baseOperacion.get(ArsvBaseOperacion_.id), filtro.getCodigo());
//			
//			if (restricciones == null)
				restricciones = condicion;
//			else 
//				restricciones = cb.and(restricciones, condicion);			
		}		
		
		if (restricciones != null)
			cq.where(restricciones);
		
		return cq;
	}
}
