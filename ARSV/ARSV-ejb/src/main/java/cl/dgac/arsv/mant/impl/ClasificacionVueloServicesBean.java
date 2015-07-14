package cl.dgac.arsv.mant.impl;
import java.util.List;

import javax.ejb.Stateless;

import org.apache.log4j.Logger;

import cl.dgac.arsv.dao.ArsvClasificacionVueloDAO;
import cl.dgac.arsv.exceptions.ARSVBusinessException;
import cl.dgac.arsv.mant.local.ClasificacionVueloServicesLocal;
import cl.dgac.arsv.mant.remote.ClasificacionVueloServicesRemote;
import cl.dgac.arsv.model.ArsvClasificacion;


@Stateless(name = "clasificacionVueloServicesBean")
public class ClasificacionVueloServicesBean implements ClasificacionVueloServicesLocal, ClasificacionVueloServicesRemote {

	public static final Logger log = Logger.getLogger(ClasificacionVueloServicesBean.class);
	
	private ArsvClasificacionVueloDAO arsvClasificacionVueloDAO;
		
	public ClasificacionVueloServicesBean() {
		super();
	}

	public ArsvClasificacion guardarClasificacion(ArsvClasificacion clasificacion) throws ARSVBusinessException {
		try {
			return this.arsvClasificacionVueloDAO.save(clasificacion);
		} catch (Exception e) {
			log.error(e.getMessage());
			throw new ARSVBusinessException(e.getMessage());
		}
	}
	
	public ArsvClasificacion actualizarClasificacion(ArsvClasificacion clasificacion) throws ARSVBusinessException {
		try {
			return this.arsvClasificacionVueloDAO.update(clasificacion);
		} catch (Exception e) {
			log.error(e.getMessage());
			throw new ARSVBusinessException(e.getMessage());
		}
	}
	
	public ArsvClasificacion buscarClasificacion(Long idClasificacion) throws ARSVBusinessException {
		try {
			return this.arsvClasificacionVueloDAO.findById(idClasificacion);
		} catch (Exception e) {
			log.error(e.getMessage());
			throw new ARSVBusinessException(e.getMessage());
		}
	}
	
	public void eliminarClasificacion(ArsvClasificacion clasificacion) throws ARSVBusinessException {
		try {
			this.arsvClasificacionVueloDAO.remove(clasificacion);
		} catch (Exception e) {
			log.error(e.getMessage());
			throw new ARSVBusinessException(e.getMessage());
		}
	}
	
	public List<ArsvClasificacion> buscarClasificacion() throws ARSVBusinessException {
		try {
			return this.arsvClasificacionVueloDAO.findAll();
		} catch (Exception e) {
			log.error(e.getMessage());
			throw new ARSVBusinessException(e.getMessage());
		}
	}
}