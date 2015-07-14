package cl.dgac.arsv.dao;

import java.util.List;

import cl.dgac.arsv.filters.FiltroArsvVentanaTiempo;
import cl.dgac.arsv.model.ArsvVentanaTiempo;
import cl.seis.generic.dao.GenericDAO;



public interface ArsvVentanaTiempoDAO extends GenericDAO<ArsvVentanaTiempo, Long, FiltroArsvVentanaTiempo> {
	public List<ArsvVentanaTiempo> findVentanasTiempo(FiltroArsvVentanaTiempo filtro);
}
