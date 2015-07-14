package cl.dgac.arsv.dao.impl;

import java.util.List;

import javax.ejb.Stateless;
import javax.inject.Named;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import cl.dgac.arsv.dao.ArsvAsignacionDAO;
import cl.dgac.arsv.filters.FiltroArsvAsignacion;
import cl.dgac.arsv.model.ArsvAsignacion;
import cl.dgac.arsv.model.ArsvAsignacion_;
import cl.dgac.arsv.model.SolicitudArriboSobrevuelo_;
import cl.dgac.arsv.model.SolicitudExtPermanencia_;
import cl.dgac.arsv.model.SolicitudOperacion_;

@Stateless
@Named(value = "arsvAsignacionDAO")
public class ArsvAsignacionDAOImpl extends BaseDAOImpl<ArsvAsignacion, Long, FiltroArsvAsignacion> implements ArsvAsignacionDAO {
		
	
	public ArsvAsignacionDAOImpl() {
		super(ArsvAsignacion.class);		
	}

	@Override
	public List<ArsvAsignacion> findAsignaciones(FiltroArsvAsignacion filtro) {
		return super.findByCriteria(filtro);
	}

	@Override
	protected CriteriaQuery<ArsvAsignacion> createFilter(FiltroArsvAsignacion filtro) {
		CriteriaBuilder cb = entityManager.getCriteriaBuilder();
		Predicate restricciones = null, condicion = null;
		
		CriteriaQuery<ArsvAsignacion> cq = cb.createQuery(ArsvAsignacion.class);
		Root<ArsvAsignacion> asignacion = cq.from(ArsvAsignacion.class);
		cq.select(asignacion);
					
		// Condiciones
		if ((filtro.getIdAsignacion() != null)) {
			condicion = cb.equal(asignacion.get(ArsvAsignacion_.id), filtro.getIdAsignacion());
			
			restricciones = condicion;			
		}		
		
		if ((filtro.getIdSolicitud() != null)) {
			condicion = cb.equal(asignacion.get(ArsvAsignacion_.solicitudArsv).get(SolicitudArriboSobrevuelo_.id), filtro.getIdSolicitud());
			
			if (restricciones == null)
				restricciones = condicion;
			else 
				restricciones = cb.and(restricciones, condicion);			
		}	
		
		if ((filtro.getIdSolicitud() != null)) {
			condicion = cb.equal(asignacion.get(ArsvAsignacion_.solicitudExt).get(SolicitudExtPermanencia_.id), filtro.getIdSolicitud());
			
			if (restricciones == null)
				restricciones = condicion;
			else 
				restricciones = cb.and(restricciones, condicion);			
		}
		
		if ((filtro.getIdSolicitud() != null)) {
			condicion = cb.equal(asignacion.get(ArsvAsignacion_.solicitudOperacion).get(SolicitudOperacion_.id), filtro.getIdSolicitud());
			
			if (restricciones == null)
				restricciones = condicion;
			else 
				restricciones = cb.and(restricciones, condicion);			
		}
		
		if (filtro.getRespuestaAsignado() != null ) {
			Predicate condicionAux = null;
			
			if (filtro.getRespuestaAsignado().booleanValue()) {
				condicion = cb.isNotNull(asignacion.get(ArsvAsignacion_.respuestaAsignado));							
				condicionAux = cb.notEqual(asignacion.get(ArsvAsignacion_.respuestaAsignado), "");

			} else {
				condicion = cb.isNull(asignacion.get(ArsvAsignacion_.respuestaAsignado));
			}
			
			if (restricciones == null) {
				restricciones = condicion;				
			} else { 
				restricciones = cb.and(restricciones, condicion);
			}
			
			if (condicionAux != null)
				restricciones = cb.and(restricciones, condicionAux);
				
		}			
		
		if (restricciones != null)
			cq.where(restricciones);
		
		return cq;
	}
	
}
