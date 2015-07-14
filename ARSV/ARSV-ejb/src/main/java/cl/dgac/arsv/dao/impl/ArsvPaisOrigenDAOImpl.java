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

import cl.dgac.arsv.dao.ArsvPaisOrigenDAO;
import cl.dgac.arsv.filters.FiltroArsvPaisOrigen;
import cl.dgac.arsv.model.ArsvPaisOrigen;
import cl.dgac.arsv.model.ArsvPaisOrigen_;

@Stateless
@Named(value = "arsvPaisOrigenDAO")
public class ArsvPaisOrigenDAOImpl extends BaseDAOImpl<ArsvPaisOrigen, Long, FiltroArsvPaisOrigen> implements ArsvPaisOrigenDAO {
	
	
	public ArsvPaisOrigenDAOImpl() {
		super(ArsvPaisOrigen.class);		
	}

	@Override
	public List<ArsvPaisOrigen> findPaisesOrigen(FiltroArsvPaisOrigen filtro) {
		return super.findByCriteria(filtro);
	}
		
	@Override
	protected CriteriaQuery<ArsvPaisOrigen> createFilter(FiltroArsvPaisOrigen filtro) {
		CriteriaBuilder cb = entityManager.getCriteriaBuilder();
		Predicate restricciones = null, condicion = null;
		
		CriteriaQuery<ArsvPaisOrigen> cq = cb.createQuery(ArsvPaisOrigen.class);
		Root<ArsvPaisOrigen> paisOrigen = cq.from(ArsvPaisOrigen.class);
		cq.select(paisOrigen);
					
		// Condiciones
		if ((filtro.getCodigo() != null)) {
			condicion = cb.equal(paisOrigen.get(ArsvPaisOrigen_.id), filtro.getCodigo());
//			
//			if (restricciones == null)
				restricciones = condicion;
//			else 
//				restricciones = cb.and(restricciones, condicion);			
		}		
		
		if (restricciones != null)
			cq.where(restricciones);
		
		// Ordenes
		List<Order> orderBy = new ArrayList<Order>();		
		
		if (filtro.isDescripcionOrdenar())
			orderBy.add(cb.asc(paisOrigen.get(ArsvPaisOrigen_.descripcion)));
		
		if (orderBy.size() > 0)
			cq.orderBy(orderBy);
		
		return cq;
	}
	
}
