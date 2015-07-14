package cl.dgac.arsv.dao.impl;

import java.util.List;

import javax.ejb.Stateless;
import javax.inject.Named;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import cl.dgac.arsv.dao.ArsvTipoSolicitudDAO;
import cl.dgac.arsv.filters.FiltroArsvTipoSolicitud;
import cl.dgac.arsv.model.ArsvTipoSolicitud;
import cl.dgac.arsv.model.ArsvTipoSolicitud_;

@Stateless
@Named(value = "arsvTipoSolicitudDAO")
public class ArsvTipoSolicitudDAOImpl extends BaseDAOImpl<ArsvTipoSolicitud, String, FiltroArsvTipoSolicitud> implements ArsvTipoSolicitudDAO {
		
	
	public ArsvTipoSolicitudDAOImpl() {
		super(ArsvTipoSolicitud.class);		
	}

	@Override
	public List<ArsvTipoSolicitud> findTiposSolicitud(FiltroArsvTipoSolicitud filtro) {
		return super.findByCriteria(filtro);
	}
		
	@Override
	protected CriteriaQuery<ArsvTipoSolicitud> createFilter(FiltroArsvTipoSolicitud filtro) {
		CriteriaBuilder cb = entityManager.getCriteriaBuilder();
		Predicate restricciones = null, condicion = null;
		
		CriteriaQuery<ArsvTipoSolicitud> cq = cb.createQuery(ArsvTipoSolicitud.class);
		Root<ArsvTipoSolicitud> tipoSolicitud = cq.from(ArsvTipoSolicitud.class);
		cq.select(tipoSolicitud);
					
		// Condiciones
		if ((filtro.getCodigo() != null)) {
			condicion = cb.equal(tipoSolicitud.get(ArsvTipoSolicitud_.codigo), filtro.getCodigo());
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
