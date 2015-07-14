package cl.dgac.arsv.dao;

import java.util.List;

import cl.dgac.arsv.filters.FiltroArsvEquipoSupervivencia;
import cl.dgac.arsv.model.ArsvEquipoSupervivencia;
import cl.seis.generic.dao.GenericDAO;



public interface ArsvEquipoSupervivenciaDAO extends GenericDAO<ArsvEquipoSupervivencia, Long, FiltroArsvEquipoSupervivencia> {
	public List<ArsvEquipoSupervivencia> findEquiposSupervivencia(FiltroArsvEquipoSupervivencia filtro);
}
