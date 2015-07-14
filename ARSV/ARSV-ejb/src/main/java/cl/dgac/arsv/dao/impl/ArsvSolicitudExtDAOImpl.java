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

import cl.dgac.arsv.dao.ArsvSolicitudExtDAO;
import cl.dgac.arsv.filters.FiltroSolicitudExtPerm;
import cl.dgac.arsv.model.SolicitudExtPermanencia;
import cl.dgac.arsv.model.SolicitudExtPermanencia_;

@Stateless
@Named(value = "arsvSolicitudExtDAO")
public class ArsvSolicitudExtDAOImpl extends BaseDAOImpl<SolicitudExtPermanencia, Long, FiltroSolicitudExtPerm> implements ArsvSolicitudExtDAO {
	
	
	public ArsvSolicitudExtDAOImpl() {
		super(SolicitudExtPermanencia.class);		
	}

	@Override
	public List<SolicitudExtPermanencia> findSolicitudExtensiones(FiltroSolicitudExtPerm filtro) {
		return super.findByCriteria(filtro);
	}
		
	@Override
	protected CriteriaQuery<SolicitudExtPermanencia> createFilter(FiltroSolicitudExtPerm filtro) {
		CriteriaBuilder cb = entityManager.getCriteriaBuilder();
		Predicate restricciones = null, condicion = null;
		
		CriteriaQuery<SolicitudExtPermanencia> cq = cb.createQuery(SolicitudExtPermanencia.class);
		Root<SolicitudExtPermanencia> solicitudExtPermanencia = cq.from(SolicitudExtPermanencia.class);
		cq.select(solicitudExtPermanencia);
					
		// Condiciones
		if ((filtro.getIdSolicitud() != null) && !filtro.getIdSolicitud().equals(0L)) {
			restricciones = cb.equal(solicitudExtPermanencia.get(SolicitudExtPermanencia_.id), filtro.getIdSolicitud());			
		}
		
//		if ((filtro.getUsuario() != null)) {
//			Join<SolicitudExtPermanencia, GestionSolicitud> gestionSolicitud = 
//					solicitudExtPermanencia.join(SolicitudExtPermanencia_.gestionesSolicitud);
//			
//			condicion = cb.equal(gestionSolicitud.get(GestionSolicitud_.arsvUsuario).get(ArsvUsuario_.usuaClaveUser), filtro.getUsuario());
//			
//			if (restricciones == null)
//				restricciones = condicion;
//			else 
//				restricciones = cb.and(restricciones, condicion);			
//		}	
		
//		if ((filtro.getIdUnidad() != null)) {
//			Join<SolicitudExtPermanencia, ArsvAsignacion> asignacionSolicitud = 
//					solicitudExtPermanencia.join(SolicitudExtPermanencia_.asignaciones);
//			
//			condicion = cb.equal(asignacionSolicitud.get(ArsvAsignacion_.arsvUnidad).get(ArsvUnidad_.id), filtro.getIdUnidad());
//			
//			if (restricciones == null)
//				restricciones = condicion;
//			else 
//				restricciones = cb.and(restricciones, condicion);			
//		}
		
		if ((filtro.getFechaCreacion() != null)) {
			condicion = cb.equal(solicitudExtPermanencia.get(SolicitudExtPermanencia_.fechaCreacion), filtro.getFechaCreacion());
			
			if (restricciones == null)
				restricciones = condicion;
			else 
				restricciones = cb.and(restricciones, condicion);			
		}		
		
//		if ((filtro.getCodigosEstado() != null) && !filtro.getCodigosEstado().isEmpty()) {			
//			condicion = solicitudExtPermanencia.get(SolicitudExtPermanencia_.arsvEstadoSolicitud).get(ArsvEstadoSolicitud_.codigo).in(filtro.getCodigosEstado());
//						
//			if (restricciones == null)
//				restricciones = condicion;
//			else 
//				restricciones = cb.and(restricciones, condicion);			
//		}	
		
		if (restricciones != null)
			cq.where(restricciones);
			
		// Ordenes
		List<Order> orderBy = new ArrayList<Order>();
		
		if (filtro.isFechaCreacionOrdenar())
			orderBy.add(cb.asc(solicitudExtPermanencia.get(SolicitudExtPermanencia_.fechaCreacion)));
		
		if (orderBy.size() > 0)
			cq.orderBy(orderBy);
		
		return cq;
	}
	
}
