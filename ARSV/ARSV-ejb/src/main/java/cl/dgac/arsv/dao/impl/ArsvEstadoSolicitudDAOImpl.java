package cl.dgac.arsv.dao.impl;

import java.util.List;

import javax.ejb.Stateless;
import javax.inject.Named;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import cl.dgac.arsv.dao.ArsvEstadoSolicitudDAO;
import cl.dgac.arsv.filters.FiltroArsvEstadoSolicitud;
import cl.dgac.arsv.model.ArsvEstadoSolicitud;
import cl.dgac.arsv.model.ArsvEstadoSolicitud_;

@Stateless
@Named(value = "arsvEstadoSolicitudDAO")
public class ArsvEstadoSolicitudDAOImpl extends BaseDAOImpl<ArsvEstadoSolicitud, String, FiltroArsvEstadoSolicitud> implements ArsvEstadoSolicitudDAO {
		
	
	public ArsvEstadoSolicitudDAOImpl() {
		super(ArsvEstadoSolicitud.class);		
	}

	@Override
	public List<ArsvEstadoSolicitud> findEstadosSolicitudes(FiltroArsvEstadoSolicitud filtro) {
		return super.findByCriteria(filtro);
	}
	
	@Override
	protected CriteriaQuery<ArsvEstadoSolicitud> createFilter(FiltroArsvEstadoSolicitud filtro) {
		CriteriaBuilder cb = entityManager.getCriteriaBuilder();
		Predicate restricciones = null, condicion = null;
		
		CriteriaQuery<ArsvEstadoSolicitud> cq = cb.createQuery(ArsvEstadoSolicitud.class);
		Root<ArsvEstadoSolicitud> estadoSolicitud = cq.from(ArsvEstadoSolicitud.class);
		cq.select(estadoSolicitud);
					
		// Condiciones
		if ((filtro.getCodigo() != null)) {
			condicion = cb.equal(estadoSolicitud.get(ArsvEstadoSolicitud_.codigo), filtro.getCodigo());
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
