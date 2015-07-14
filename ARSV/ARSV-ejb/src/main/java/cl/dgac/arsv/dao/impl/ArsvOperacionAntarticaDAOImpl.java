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

import cl.dgac.arsv.dao.ArsvOperacionAntarticaDAO;
import cl.dgac.arsv.filters.FiltroSolicitudOperAntartica;
import cl.dgac.arsv.model.ArsvEstadoSolicitud_;
import cl.dgac.arsv.model.OperacionAntartica;
import cl.dgac.arsv.model.OperacionAntartica_;
import cl.dgac.arsv.model.SolicitudOperacion_;

@Stateless
@Named(value = "arsvOperacionAntarticaDAO")
public class ArsvOperacionAntarticaDAOImpl extends BaseDAOImpl<OperacionAntartica, Long, FiltroSolicitudOperAntartica> implements ArsvOperacionAntarticaDAO {
	
	
	public ArsvOperacionAntarticaDAOImpl() {
		super(OperacionAntartica.class);		
	}

	@Override
	public List<OperacionAntartica> findSolicitudOperAntartica(FiltroSolicitudOperAntartica filtro) {
		return super.findByCriteria(filtro);
	}
		
	@Override
	protected CriteriaQuery<OperacionAntartica> createFilter(FiltroSolicitudOperAntartica filtro) {
		CriteriaBuilder cb = entityManager.getCriteriaBuilder();
		Predicate restricciones = null, condicion = null;
		
		CriteriaQuery<OperacionAntartica> cq = cb.createQuery(OperacionAntartica.class);
		Root<OperacionAntartica> solicitudOperacion = cq.from(OperacionAntartica.class);
		cq.select(solicitudOperacion);
					
		// Condiciones
		if ((filtro.getIdSolicitud() != null) && !filtro.getIdSolicitud().equals(0L)) {
			restricciones = cb.equal(solicitudOperacion.get(SolicitudOperacion_.id), filtro.getIdSolicitud());			
		}
		
		if ((filtro.getFechaCreacion() != null)) {
			condicion = cb.equal(solicitudOperacion.get(OperacionAntartica_.fechaCreacion), filtro.getFechaCreacion());
			
			if (restricciones == null)
				restricciones = condicion;
			else 
				restricciones = cb.and(restricciones, condicion);			
		}		
		
		if ((filtro.getCodigosEstado() != null) && !filtro.getCodigosEstado().isEmpty()) {			
			condicion = solicitudOperacion.get(OperacionAntartica_.arsvEstadoSolicitud).get(ArsvEstadoSolicitud_.codigo).in(filtro.getCodigosEstado());
						
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
			orderBy.add(cb.asc(solicitudOperacion.get(OperacionAntartica_.fechaCreacion)));
		
		if (orderBy.size() > 0)
			cq.orderBy(orderBy);
		
		return cq;
	}
	
}
