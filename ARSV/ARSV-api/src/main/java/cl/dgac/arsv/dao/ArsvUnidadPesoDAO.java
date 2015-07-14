package cl.dgac.arsv.dao;

import java.util.List;

import cl.dgac.arsv.filters.FiltroArsvUnidadPeso;
import cl.dgac.arsv.model.ArsvUnidadPeso;
import cl.seis.generic.dao.GenericDAO;


public interface ArsvUnidadPesoDAO extends GenericDAO<ArsvUnidadPeso, Long, FiltroArsvUnidadPeso> {
	public List<ArsvUnidadPeso> findUnidadPeso(FiltroArsvUnidadPeso filtro);
}
