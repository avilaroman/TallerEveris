package cl.dgac.arsv.dao;

import java.util.List;

import cl.dgac.arsv.filters.FiltroArsvClasificacionVuelo;
import cl.dgac.arsv.model.ArsvClasificacion;
import cl.seis.generic.dao.GenericDAO;



public interface ArsvClasificacionVueloDAO extends GenericDAO<ArsvClasificacion, Long, FiltroArsvClasificacionVuelo> {
	public List<ArsvClasificacion> findClasificaciones(FiltroArsvClasificacionVuelo filtro);
}
