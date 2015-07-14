package cl.dgac.arsv.dao;

import java.util.List;

import cl.dgac.arsv.filters.FiltroArsvObjetoVuelo;
import cl.dgac.arsv.model.ArsvObjetoVuelo;
import cl.seis.generic.dao.GenericDAO;


public interface ArsvObjetoVueloDAO extends GenericDAO<ArsvObjetoVuelo, Long, FiltroArsvObjetoVuelo> {
	public List<ArsvObjetoVuelo> findObjetos(FiltroArsvObjetoVuelo filtro);
}
