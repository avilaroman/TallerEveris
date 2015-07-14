package cl.dgac.arsv.dao;

import java.util.List;

import cl.dgac.arsv.filters.FiltroArsvEquipoUsar;
import cl.dgac.arsv.model.ArsvEquipoUsar;
import cl.seis.generic.dao.GenericDAO;



public interface ArsvEquipoUsarDAO extends GenericDAO<ArsvEquipoUsar, Long, FiltroArsvEquipoUsar> {
	public List<ArsvEquipoUsar> findEquiposUsar(FiltroArsvEquipoUsar filtro);
}
