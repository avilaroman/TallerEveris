package cl.dgac.arsv.dao;

import java.util.List;

import cl.dgac.arsv.filters.FiltroArsvTipoSolicitud;
import cl.dgac.arsv.model.ArsvTipoSolicitud;
import cl.seis.generic.dao.GenericDAO;



public interface ArsvTipoSolicitudDAO extends GenericDAO<ArsvTipoSolicitud, String, FiltroArsvTipoSolicitud> {
	public List<ArsvTipoSolicitud> findTiposSolicitud(FiltroArsvTipoSolicitud filtro);
}
