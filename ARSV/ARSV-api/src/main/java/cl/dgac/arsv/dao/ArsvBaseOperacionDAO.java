package cl.dgac.arsv.dao;

import java.util.List;

import cl.dgac.arsv.filters.FiltroArsvBaseOperacion;
import cl.dgac.arsv.model.ArsvBaseOperacion;
import cl.seis.generic.dao.GenericDAO;



public interface ArsvBaseOperacionDAO extends GenericDAO<ArsvBaseOperacion, Long, FiltroArsvBaseOperacion> {
	public List<ArsvBaseOperacion> findBasesOperacion(FiltroArsvBaseOperacion filtro);
}
