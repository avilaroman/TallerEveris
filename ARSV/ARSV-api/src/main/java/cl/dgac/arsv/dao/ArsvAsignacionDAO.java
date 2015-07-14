package cl.dgac.arsv.dao;

import java.util.List;

import cl.dgac.arsv.filters.FiltroArsvAsignacion;
import cl.dgac.arsv.model.ArsvAsignacion;
import cl.seis.generic.dao.GenericDAO;



public interface ArsvAsignacionDAO extends GenericDAO<ArsvAsignacion, Long, FiltroArsvAsignacion> {
	public List<ArsvAsignacion> findAsignaciones(FiltroArsvAsignacion filtro);
}
