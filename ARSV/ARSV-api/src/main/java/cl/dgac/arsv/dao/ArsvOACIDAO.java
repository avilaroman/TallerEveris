package cl.dgac.arsv.dao;

import java.util.List;

import cl.dgac.arsv.filters.FiltroArsvOACI;
import cl.dgac.arsv.model.ArsvOACI;
import cl.seis.generic.dao.GenericDAO;


public interface ArsvOACIDAO extends GenericDAO<ArsvOACI, Long, FiltroArsvOACI> {
	public List<ArsvOACI> findOACI(FiltroArsvOACI filtro);
}
