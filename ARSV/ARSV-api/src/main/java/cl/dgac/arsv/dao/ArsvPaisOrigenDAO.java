package cl.dgac.arsv.dao;

import java.util.List;

import cl.dgac.arsv.filters.FiltroArsvPaisOrigen;
import cl.dgac.arsv.model.ArsvPaisOrigen;
import cl.seis.generic.dao.GenericDAO;


public interface ArsvPaisOrigenDAO extends GenericDAO<ArsvPaisOrigen, Long, FiltroArsvPaisOrigen> {
	public List<ArsvPaisOrigen> findPaisesOrigen(FiltroArsvPaisOrigen filtro);
}
