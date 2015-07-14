package cl.dgac.arsv.dao;

import java.util.List;

import cl.dgac.arsv.filters.FiltroArsvUsuario;
import cl.dgac.arsv.model.ArsvUsuario;
import cl.seis.generic.dao.GenericDAO;



public interface ArsvUsuarioDAO extends GenericDAO<ArsvUsuario, Long, FiltroArsvUsuario> {
	public List<ArsvUsuario> findUsuarios(FiltroArsvUsuario filtro);
}
