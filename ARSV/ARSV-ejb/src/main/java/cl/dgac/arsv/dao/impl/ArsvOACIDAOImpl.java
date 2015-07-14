package cl.dgac.arsv.dao.impl;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.Stateless;
import javax.inject.Named;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Order;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import cl.dgac.arsv.dao.ArsvOACIDAO;
import cl.dgac.arsv.filters.FiltroArsvOACI;
import cl.dgac.arsv.model.ArsvOACI;
import cl.dgac.arsv.model.ArsvOACI_;

@Stateless
@Named(value = "arsvOACIDAO")
public class ArsvOACIDAOImpl extends BaseDAOImpl<ArsvOACI, Long, FiltroArsvOACI> implements ArsvOACIDAO {
	
	
	public ArsvOACIDAOImpl() {
		super(ArsvOACI.class);		
	}

	@Override
	public List<ArsvOACI> findOACI(FiltroArsvOACI filtro) {
		return super.findByCriteria(filtro);
	}
		
	@Override
	protected CriteriaQuery<ArsvOACI> createFilter(FiltroArsvOACI filtro) {
		CriteriaBuilder cb = entityManager.getCriteriaBuilder();
		Predicate restricciones = null, condicion = null;
		
		CriteriaQuery<ArsvOACI> cq = cb.createQuery(ArsvOACI.class);
		Root<ArsvOACI> oACI = cq.from(ArsvOACI.class);
		cq.select(oACI);
					
		// Condiciones
		if ((filtro.getCodigo() != null)) {
			condicion = cb.equal(oACI.get(ArsvOACI_.codigo), filtro.getCodigo());
//			
//			if (restricciones == null)
				restricciones = condicion;
//			else 
//				restricciones = cb.and(restricciones, condicion);			
		}	
		
		if ((filtro.getIdPais() != null)) {
			condicion = cb.equal(oACI.get(ArsvOACI_.arsvPaisOrigen), filtro.getIdPais());
			
			if (restricciones == null)
				restricciones = condicion;
			else 
				restricciones = cb.and(restricciones, condicion);			
		}
		
		if (restricciones != null)
			cq.where(restricciones);
		
		// Ordenes
		List<Order> orderBy = new ArrayList<Order>();		
		
		if (filtro.isDescripcionOrdenar())
			orderBy.add(cb.asc(oACI.get(ArsvOACI_.descripcion)));
		
		if (orderBy.size() > 0)
			cq.orderBy(orderBy);
		
		return cq;
	}
	
}
