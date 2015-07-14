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

import cl.dgac.arsv.dao.ArsvOperacionPascuaDAO;
import cl.dgac.arsv.filters.FiltroSolicitudOperPascua;
import cl.dgac.arsv.model.ArsvEstadoSolicitud_;
import cl.dgac.arsv.model.OperacionPascua;
import cl.dgac.arsv.model.OperacionPascua_;

@Stateless
@Named(value = "arsvOperacionPascuaDAO")
public class ArsvOperacionPascuaDAOImpl extends BaseDAOImpl<OperacionPascua, Long, FiltroSolicitudOperPascua> implements ArsvOperacionPascuaDAO {
	
	
	public ArsvOperacionPascuaDAOImpl() {
		super(OperacionPascua.class);		
	}

	@Override
	public List<OperacionPascua> findSolicitudOperPascua(FiltroSolicitudOperPascua filtro) {
		return super.findByCriteria(filtro);
	}
		
	@Override
	protected CriteriaQuery<OperacionPascua> createFilter(FiltroSolicitudOperPascua filtro) {
		CriteriaBuilder cb = entityManager.getCriteriaBuilder();
		Predicate restricciones = null, condicion = null;
		
		CriteriaQuery<OperacionPascua> cq = cb.createQuery(OperacionPascua.class);
		Root<OperacionPascua> solicitudOperacion = cq.from(OperacionPascua.class);
		cq.select(solicitudOperacion);
					
		// Condiciones
		if ((filtro.getIdSolicitud() != null) && !filtro.getIdSolicitud().equals(0L)) {
			restricciones = cb.equal(solicitudOperacion.get(OperacionPascua_.id), filtro.getIdSolicitud());			
		}
		
		if ((filtro.getFechaCreacion() != null)) {
			condicion = cb.equal(solicitudOperacion.get(OperacionPascua_.fechaCreacion), filtro.getFechaCreacion());
			
			if (restricciones == null)
				restricciones = condicion;
			else 
				restricciones = cb.and(restricciones, condicion);			
		}		
		
		if ((filtro.getCodigosEstado() != null) && !filtro.getCodigosEstado().isEmpty()) {			
			condicion = solicitudOperacion.get(OperacionPascua_.arsvEstadoSolicitud).get(ArsvEstadoSolicitud_.codigo).in(filtro.getCodigosEstado());
						
			if (restricciones == null)
				restricciones = condicion;
			else 
				restricciones = cb.and(restricciones, condicion);			
		}	
		
		if (restricciones != null)
			cq.where(restricciones);
			
		// Ordenes
		List<Order> orderBy = new ArrayList<Order>();
		
		if (filtro.isFechaCreacionOrdenar())
			orderBy.add(cb.asc(solicitudOperacion.get(OperacionPascua_.fechaCreacion)));
		
		if (orderBy.size() > 0)
			cq.orderBy(orderBy);
		
		return cq;
	}
	
}
