package cl.dgac.arsv.dao;

import java.util.List;

import cl.dgac.arsv.filters.FiltroArsvProgramaActividad;
import cl.dgac.arsv.model.ArsvProgramaActividad;
import cl.seis.generic.dao.GenericDAO;



public interface ArsvProgramaActividadDAO extends GenericDAO<ArsvProgramaActividad, Long, FiltroArsvProgramaActividad> {
	public List<ArsvProgramaActividad> findProgramasActividad(FiltroArsvProgramaActividad filtro);
}
