package cl.dgac.arsv.dao;

import java.util.List;

import cl.dgac.arsv.filters.FiltroSolicitudExtPerm;
import cl.dgac.arsv.model.SolicitudExtPermanencia;
import cl.seis.generic.dao.GenericDAO;



public interface ArsvSolicitudExtDAO extends GenericDAO<SolicitudExtPermanencia, Long, FiltroSolicitudExtPerm> {
	public List<SolicitudExtPermanencia> findSolicitudExtensiones(FiltroSolicitudExtPerm filtro);
}
