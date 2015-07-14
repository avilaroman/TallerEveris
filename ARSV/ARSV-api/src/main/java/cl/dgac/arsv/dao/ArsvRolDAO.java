package cl.dgac.arsv.dao;

import java.util.List;

import cl.dgac.arsv.filters.FiltroArsvRol;
import cl.dgac.arsv.model.ArsvRol;
import cl.seis.generic.dao.GenericDAO;



public interface ArsvRolDAO extends GenericDAO<ArsvRol, Long, FiltroArsvRol> {
	public List<ArsvRol> findRoles(FiltroArsvRol filtro);
}
