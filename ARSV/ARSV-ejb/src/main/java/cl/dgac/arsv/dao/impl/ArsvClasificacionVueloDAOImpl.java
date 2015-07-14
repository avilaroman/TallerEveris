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

import cl.dgac.arsv.dao.ArsvClasificacionVueloDAO;
import cl.dgac.arsv.filters.FiltroArsvClasificacionVuelo;
import cl.dgac.arsv.model.ArsvClasificacion;
import cl.dgac.arsv.model.ArsvClasificacion_;

@Stateless
@Named(value = "arsvClasificacionVueloDAO")
public class ArsvClasificacionVueloDAOImpl extends BaseDAOImpl<ArsvClasificacion, Long, FiltroArsvClasificacionVuelo> implements ArsvClasificacionVueloDAO {
	
	public ArsvClasificacionVueloDAOImpl() {
		super(ArsvClasificacion.class);		
	}

	@Override
	public List<ArsvClasificacion> findClasificaciones(FiltroArsvClasificacionVuelo filtro) {
		return super.findByCriteria(filtro);
	}

	@Override
	protected CriteriaQuery<ArsvClasificacion> createFilter(FiltroArsvClasificacionVuelo filtro) {
		CriteriaBuilder cb = entityManager.getCriteriaBuilder();
		Predicate restricciones = null, condicion = null;
		
		CriteriaQuery<ArsvClasificacion> cq = cb.createQuery(ArsvClasificacion.class);
		Root<ArsvClasificacion> clasificacion = cq.from(ArsvClasificacion.class);
		cq.select(clasificacion);
					
		if ((filtro.getCodigoClasificacionVuelo() != null)) {
			condicion = cb.equal(clasificacion.get(ArsvClasificacion_.codigo), filtro.getCodigoClasificacionVuelo());
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
			orderBy.add(cb.asc(clasificacion.get(ArsvClasificacion_.descripcion)));
		
		if (orderBy.size() > 0)
			cq.orderBy(orderBy);
		
		return cq;
	}
		
}
