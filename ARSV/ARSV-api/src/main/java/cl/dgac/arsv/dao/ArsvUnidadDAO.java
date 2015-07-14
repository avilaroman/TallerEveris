package cl.dgac.arsv.dao;

import java.util.List;

import cl.dgac.arsv.filters.FiltroArsvUnidad;
import cl.dgac.arsv.model.ArsvUnidad;
import cl.seis.generic.dao.GenericDAO;



public interface ArsvUnidadDAO extends GenericDAO<ArsvUnidad, Long, FiltroArsvUnidad> {
	public List<ArsvUnidad> findUnidades(FiltroArsvUnidad filtro);
}
