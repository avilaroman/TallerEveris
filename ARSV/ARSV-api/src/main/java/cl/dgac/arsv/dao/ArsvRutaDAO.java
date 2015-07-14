package cl.dgac.arsv.dao;

import java.util.List;

import cl.dgac.arsv.filters.FiltroArsvRuta;
import cl.dgac.arsv.model.ArsvRuta;
import cl.seis.generic.dao.GenericDAO;



public interface ArsvRutaDAO extends GenericDAO<ArsvRuta, Long, FiltroArsvRuta> {
	public List<ArsvRuta> findRutas(FiltroArsvRuta filtro);
}
