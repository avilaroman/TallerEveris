package cl.dgac.arsv.mant.impl;
import java.util.List;

import javax.ejb.Stateless;

import org.apache.log4j.Logger;

import cl.dgac.arsv.dao.ArsvRolDAO;
import cl.dgac.arsv.exceptions.ARSVBusinessException;
import cl.dgac.arsv.mant.local.RolServicesLocal;
import cl.dgac.arsv.mant.remote.RolServicesRemote;
import cl.dgac.arsv.model.ArsvRol;


@Stateless(name = "rolServicesBean")
public class RolServicesBean implements RolServicesLocal, RolServicesRemote {

	public static final Logger log = Logger.getLogger(RolServicesBean.class);
	
	private ArsvRolDAO arsvRolDAO;
		
	public RolServicesBean() {
		super();
	}

	public ArsvRol guardarRol(ArsvRol arsvRol) throws ARSVBusinessException {
		try {
			return this.arsvRolDAO.save(arsvRol);
		} catch (Exception e) {
			log.error(e.getMessage());
			throw new ARSVBusinessException(e.getMessage());
		}
	}
	
	public ArsvRol actualizarRol(ArsvRol arsvRol) throws ARSVBusinessException {
		try {
			return this.arsvRolDAO.update(arsvRol);
		} catch (Exception e) {
			log.error(e.getMessage());
			throw new ARSVBusinessException(e.getMessage());
		}
	}
	
	public ArsvRol buscarRol(Long idArsvRol) throws ARSVBusinessException {
		try {
			return this.arsvRolDAO.findById(idArsvRol);
		} catch (Exception e) {
			log.error(e.getMessage());
			throw new ARSVBusinessException(e.getMessage());
		}
	}
	
	public void eliminarRol(ArsvRol arsvRol) throws ARSVBusinessException {
		try {
			this.arsvRolDAO.remove(arsvRol);
		} catch (Exception e) {
			log.error(e.getMessage());
			throw new ARSVBusinessException(e.getMessage());
		}
	}
	
	public List<ArsvRol> buscarRol() throws ARSVBusinessException {
		try {
			return this.arsvRolDAO.findAll();
		} catch (Exception e) {
			log.error(e.getMessage());
			throw new ARSVBusinessException(e.getMessage());
		}
	}
}