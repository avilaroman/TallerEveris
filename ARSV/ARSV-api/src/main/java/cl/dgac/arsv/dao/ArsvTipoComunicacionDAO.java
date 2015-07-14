package cl.dgac.arsv.dao;

import java.util.List;

import cl.dgac.arsv.filters.FiltroArsvTipoComunicacion;
import cl.dgac.arsv.model.ArsvTipoComunicacion;
import cl.seis.generic.dao.GenericDAO;



public interface ArsvTipoComunicacionDAO extends GenericDAO<ArsvTipoComunicacion, Long, FiltroArsvTipoComunicacion> {
	public List<ArsvTipoComunicacion> findTiposComunicacion(FiltroArsvTipoComunicacion filtro);
}
