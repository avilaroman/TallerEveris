package cl.dgac.arsv.dao;

import java.util.List;

import cl.dgac.arsv.filters.FiltroArsvEstadoSolicitud;
import cl.dgac.arsv.model.ArsvEstadoSolicitud;
import cl.seis.generic.dao.GenericDAO;



public interface ArsvEstadoSolicitudDAO extends GenericDAO<ArsvEstadoSolicitud, String, FiltroArsvEstadoSolicitud> {
	public List<ArsvEstadoSolicitud> findEstadosSolicitudes(FiltroArsvEstadoSolicitud filtro);
}
