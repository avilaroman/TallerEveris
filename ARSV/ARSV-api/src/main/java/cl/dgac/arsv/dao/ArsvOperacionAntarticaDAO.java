package cl.dgac.arsv.dao;

import java.util.List;

import cl.dgac.arsv.filters.FiltroSolicitudOperAntartica;
import cl.dgac.arsv.model.OperacionAntartica;
import cl.seis.generic.dao.GenericDAO;



public interface ArsvOperacionAntarticaDAO extends GenericDAO<OperacionAntartica, Long, FiltroSolicitudOperAntartica> {
	public List<OperacionAntartica> findSolicitudOperAntartica(FiltroSolicitudOperAntartica filtro);
}
