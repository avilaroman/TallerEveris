package cl.dgac.arsv.mant.impl;
import java.util.List;

import javax.ejb.Stateless;

import org.apache.log4j.Logger;

import cl.dgac.arsv.dao.ArsvEquipoSupervivenciaDAO;
import cl.dgac.arsv.exceptions.ARSVBusinessException;
import cl.dgac.arsv.mant.local.EquipoSupervivenciaServicesLocal;
import cl.dgac.arsv.mant.remote.EquipoSupervivenciaServicesRemote;
import cl.dgac.arsv.model.ArsvEquipoSupervivencia;


@Stateless(name = "equipoSupervivenciaServicesBean")
public class EquipoSupervivenciaServicesBean implements EquipoSupervivenciaServicesLocal, EquipoSupervivenciaServicesRemote {

	public static final Logger log = Logger.getLogger(EquipoSupervivenciaServicesBean.class);
	
	private ArsvEquipoSupervivenciaDAO arsvEquipoSupervivenciaDAO;
		
	public EquipoSupervivenciaServicesBean() {
		super();
	}

	public ArsvEquipoSupervivencia guardarEquipoSupervivencia(ArsvEquipoSupervivencia arsvEquipoSupervivencia) throws ARSVBusinessException {
		try {
			return this.arsvEquipoSupervivenciaDAO.save(arsvEquipoSupervivencia);
		} catch (Exception e) {
			log.error(e.getMessage());
			throw new ARSVBusinessException(e.getMessage());
		}
	}
	
	public ArsvEquipoSupervivencia actualizarEquipoSupervivencia(ArsvEquipoSupervivencia arsvEquipoSupervivencia) throws ARSVBusinessException {
		try {
			return this.arsvEquipoSupervivenciaDAO.update(arsvEquipoSupervivencia);
		} catch (Exception e) {
			log.error(e.getMessage());
			throw new ARSVBusinessException(e.getMessage());
		}
	}
	
	public ArsvEquipoSupervivencia buscarEquipoSupervivencia(Long idEquipoSupervivencia) throws ARSVBusinessException {
		try {
			return this.arsvEquipoSupervivenciaDAO.findById(idEquipoSupervivencia);
		} catch (Exception e) {
			log.error(e.getMessage());
			throw new ARSVBusinessException(e.getMessage());
		}
	}
	
	public void eliminarEquipoSupervivencia(ArsvEquipoSupervivencia arsvEquipoSupervivencia) throws ARSVBusinessException {
		try {
			this.arsvEquipoSupervivenciaDAO.remove(arsvEquipoSupervivencia);
		} catch (Exception e) {
			log.error(e.getMessage());
			throw new ARSVBusinessException(e.getMessage());
		}
	}
	
	public List<ArsvEquipoSupervivencia> buscarEquipoSupervivencia() throws ARSVBusinessException {
		try {
			return this.arsvEquipoSupervivenciaDAO.findAll();
		} catch (Exception e) {
			log.error(e.getMessage());
			throw new ARSVBusinessException(e.getMessage());
		}
	}
}