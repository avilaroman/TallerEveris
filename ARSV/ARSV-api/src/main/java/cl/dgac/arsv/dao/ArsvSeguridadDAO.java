package cl.dgac.arsv.dao;

import java.util.List;

import cl.dgac.arsv.filters.FiltroArsvSeguridad;
import cl.dgac.arsv.model.ArsvSeguridad;
import cl.seis.generic.dao.GenericDAO;



public interface ArsvSeguridadDAO extends GenericDAO<ArsvSeguridad, Long, FiltroArsvSeguridad> {
	public List<ArsvSeguridad> findSeguridades(FiltroArsvSeguridad filtro);
}
