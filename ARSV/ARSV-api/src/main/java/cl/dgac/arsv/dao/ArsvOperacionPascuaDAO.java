package cl.dgac.arsv.dao;

import java.util.List;

import cl.dgac.arsv.filters.FiltroSolicitudOperPascua;
import cl.dgac.arsv.model.OperacionPascua;
import cl.seis.generic.dao.GenericDAO;



public interface ArsvOperacionPascuaDAO extends GenericDAO<OperacionPascua, Long, FiltroSolicitudOperPascua> {
	public List<OperacionPascua> findSolicitudOperPascua(FiltroSolicitudOperPascua filtro);
}
