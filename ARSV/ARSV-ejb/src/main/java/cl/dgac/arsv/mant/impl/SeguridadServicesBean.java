package cl.dgac.arsv.mant.impl;
import java.util.List;

import javax.ejb.Stateless;

import org.apache.log4j.Logger;

import cl.dgac.arsv.dao.ArsvSeguridadDAO;
import cl.dgac.arsv.exceptions.ARSVBusinessException;
import cl.dgac.arsv.mant.local.SeguridadServicesLocal;
import cl.dgac.arsv.mant.remote.SeguridadServicesRemote;
import cl.dgac.arsv.model.ArsvSeguridad;


@Stateless(name = "seguridadServicesBean")
public class SeguridadServicesBean implements SeguridadServicesLocal, SeguridadServicesRemote {

	public static final Logger log = Logger.getLogger(SeguridadServicesBean.class);
	
	private ArsvSeguridadDAO arsvSeguridadDAO;
		
	public SeguridadServicesBean() {
		super();
	}

	public ArsvSeguridad guardarSeguridad(ArsvSeguridad arsvSeguridad) throws ARSVBusinessException {
		try {
			return this.arsvSeguridadDAO.save(arsvSeguridad);
		} catch (Exception e) {
			log.error(e.getMessage());
			throw new ARSVBusinessException(e.getMessage());
		}
	}
	
	public ArsvSeguridad actualizarSeguridad(ArsvSeguridad arsvSeguridad) throws ARSVBusinessException {
		try {
			return this.arsvSeguridadDAO.update(arsvSeguridad);
		} catch (Exception e) {
			log.error(e.getMessage());
			throw new ARSVBusinessException(e.getMessage());
		}
	}
	
	public ArsvSeguridad buscarSeguridad(Long idArsvSeguridad) throws ARSVBusinessException {
		try {
			return this.arsvSeguridadDAO.findById(idArsvSeguridad);
		} catch (Exception e) {
			log.error(e.getMessage());
			throw new ARSVBusinessException(e.getMessage());
		}
	}
	
	public void eliminarSeguridad(ArsvSeguridad arsvSeguridad) throws ARSVBusinessException {
		try {
			this.arsvSeguridadDAO.remove(arsvSeguridad);
		} catch (Exception e) {
			log.error(e.getMessage());
			throw new ARSVBusinessException(e.getMessage());
		}
	}
	
	public List<ArsvSeguridad> buscarSeguridad() throws ARSVBusinessException {
		try {
			return this.arsvSeguridadDAO.findAll();
		} catch (Exception e) {
			log.error(e.getMessage());
			throw new ARSVBusinessException(e.getMessage());
		}
	}
}