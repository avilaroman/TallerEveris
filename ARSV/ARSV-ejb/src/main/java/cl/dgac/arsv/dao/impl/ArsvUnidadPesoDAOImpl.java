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

import cl.dgac.arsv.dao.ArsvUnidadPesoDAO;
import cl.dgac.arsv.filters.FiltroArsvUnidadPeso;
import cl.dgac.arsv.model.ArsvUnidadPeso;
import cl.dgac.arsv.model.ArsvUnidadPeso_;

@Stateless
@Named(value = "arsvUnidadPesoDAO")
public class ArsvUnidadPesoDAOImpl extends BaseDAOImpl<ArsvUnidadPeso, Long, FiltroArsvUnidadPeso> implements ArsvUnidadPesoDAO {
	
	
	public ArsvUnidadPesoDAOImpl() {
		super(ArsvUnidadPeso.class);		
	}

	@Override
	public List<ArsvUnidadPeso> findUnidadPeso(FiltroArsvUnidadPeso filtro) {
		return super.findByCriteria(filtro);
	}
		
	@Override
	protected CriteriaQuery<ArsvUnidadPeso> createFilter(FiltroArsvUnidadPeso filtro) {
		CriteriaBuilder cb = entityManager.getCriteriaBuilder();
		Predicate restricciones = null, condicion = null;
		
		CriteriaQuery<ArsvUnidadPeso> cq = cb.createQuery(ArsvUnidadPeso.class);
		Root<ArsvUnidadPeso> unidadPeso = cq.from(ArsvUnidadPeso.class);
		cq.select(unidadPeso);
					
		// Condiciones
		if ((filtro.getCodigo() != null)) {
			condicion = cb.equal(unidadPeso.get(ArsvUnidadPeso_.codigo), filtro.getCodigo());
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
			orderBy.add(cb.asc(unidadPeso.get(ArsvUnidadPeso_.descripcion)));
		
		if (orderBy.size() > 0)
			cq.orderBy(orderBy);
		
		return cq;
	}
	
}
