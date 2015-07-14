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

import cl.dgac.arsv.dao.ArsvSolicitudArriboSobrevueloDAO;
import cl.dgac.arsv.filters.FiltroSolicitudArriboSobrevuelo;
import cl.dgac.arsv.model.ArsvEstadoSolicitud_;
import cl.dgac.arsv.model.SolicitudArriboSobrevuelo;
import cl.dgac.arsv.model.SolicitudArriboSobrevuelo_;

@Stateless
@Named(value = "arsvSolicitudArriboSobrevueloDAO")
public class ArsvSolicitudArriboSobrevueloDAOImpl extends BaseDAOImpl<SolicitudArriboSobrevuelo, Long, FiltroSolicitudArriboSobrevuelo> implements ArsvSolicitudArriboSobrevueloDAO {
	
	
	public ArsvSolicitudArriboSobrevueloDAOImpl() {
		super(SolicitudArriboSobrevuelo.class);		
	}

	@Override
	public List<SolicitudArriboSobrevuelo> findSolicitudArriboSobrevuelo(FiltroSolicitudArriboSobrevuelo filtro) {
		return super.findByCriteria(filtro);
	}
		
	@Override
	protected CriteriaQuery<SolicitudArriboSobrevuelo> createFilter(FiltroSolicitudArriboSobrevuelo filtro) {
		CriteriaBuilder cb = entityManager.getCriteriaBuilder();
		Predicate restricciones = null, condicion = null;
		
		CriteriaQuery<SolicitudArriboSobrevuelo> cq = cb.createQuery(SolicitudArriboSobrevuelo.class);
		Root<SolicitudArriboSobrevuelo> solicitudArriboSobrevuelo = cq.from(SolicitudArriboSobrevuelo.class);
		cq.select(solicitudArriboSobrevuelo);
					
		// Condiciones
		if ((filtro.getIdSolicitud() != null) && !filtro.getIdSolicitud().equals(0L)) {
			restricciones = cb.equal(solicitudArriboSobrevuelo.get(SolicitudArriboSobrevuelo_.id), filtro.getIdSolicitud());			
		}
		
		if ((filtro.getFechaCreacion() != null)) {
			condicion = cb.equal(solicitudArriboSobrevuelo.get(SolicitudArriboSobrevuelo_.fechaCreacion), filtro.getFechaCreacion());
			
			if (restricciones == null)
				restricciones = condicion;
			else 
				restricciones = cb.and(restricciones, condicion);			
		}		
		
		if ((filtro.getCodigosEstado() != null) && !filtro.getCodigosEstado().isEmpty()) {			
			condicion = solicitudArriboSobrevuelo.get(SolicitudArriboSobrevuelo_.arsvEstadoSolicitud).get(ArsvEstadoSolicitud_.codigo).in(filtro.getCodigosEstado());
						
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
			orderBy.add(cb.asc(solicitudArriboSobrevuelo.get(SolicitudArriboSobrevuelo_.fechaCreacion)));
		
		if (orderBy.size() > 0)
			cq.orderBy(orderBy);
		
		return cq;
	}
	
}
