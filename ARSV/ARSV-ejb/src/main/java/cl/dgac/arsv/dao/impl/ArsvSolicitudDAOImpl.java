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

import cl.dgac.arsv.dao.ArsvSolicitudDAO;
import cl.dgac.arsv.filters.FiltroSolicitud;
import cl.dgac.arsv.model.ArsvEstadoSolicitud_;
import cl.dgac.arsv.model.Solicitud;
import cl.dgac.arsv.model.Solicitud_;

@Stateless
@Named(value = "arsvSolicitudDAO")
public class ArsvSolicitudDAOImpl extends BaseDAOImpl<Solicitud, Long, FiltroSolicitud> implements ArsvSolicitudDAO {
	
	
	public ArsvSolicitudDAOImpl() {
		super(Solicitud.class);		
	}

	@Override
	public List<Solicitud> findSolicitudes(FiltroSolicitud filtro) {
		return super.findByCriteria(filtro);
	}
		
	@Override
	protected CriteriaQuery<Solicitud> createFilter(FiltroSolicitud filtro) {
		CriteriaBuilder cb = entityManager.getCriteriaBuilder();
		Predicate restricciones = null, condicion = null;
		
		CriteriaQuery<Solicitud> cq = cb.createQuery(Solicitud.class);
		Root<Solicitud> solicitud = cq.from(Solicitud.class);
		cq.select(solicitud);
					
		// Condiciones
		if ((filtro.getIdSolicitud() != null) && !filtro.getIdSolicitud().equals(0L)) {
			restricciones = cb.equal(solicitud.get(Solicitud_.id), filtro.getIdSolicitud());			
		}
		
		if ((filtro.getFechaCreacion() != null)) {
			condicion = cb.equal(solicitud.get(Solicitud_.fechaCreacion), filtro.getFechaCreacion());
			
			if (restricciones == null)
				restricciones = condicion;
			else 
				restricciones = cb.and(restricciones, condicion);			
		}		
		
		if ((filtro.getCodigosEstado() != null) && !filtro.getCodigosEstado().isEmpty()) {			
			condicion = solicitud.get(Solicitud_.arsvEstadoSolicitud).get(ArsvEstadoSolicitud_.codigo).in(filtro.getCodigosEstado());
						
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
			orderBy.add(cb.asc(solicitud.get(Solicitud_.fechaCreacion)));
		
		if (orderBy.size() > 0)
			cq.orderBy(orderBy);
		
		return cq;
	}
	
}
