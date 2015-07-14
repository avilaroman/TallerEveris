package cl.dgac.arsv.dao;

import java.util.List;

import cl.dgac.arsv.filters.FiltroSolicitud;
import cl.dgac.arsv.model.Solicitud;
import cl.seis.generic.dao.GenericDAO;



public interface ArsvSolicitudDAO extends GenericDAO<Solicitud, Long, FiltroSolicitud> {
	public List<Solicitud> findSolicitudes(FiltroSolicitud filtro);
}
