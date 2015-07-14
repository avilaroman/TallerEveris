package cl.dgac.arsv.mant.impl;
import java.util.List;

import javax.ejb.Stateless;

import org.apache.log4j.Logger;

import cl.dgac.arsv.dao.ArsvAsignacionDAO;
import cl.dgac.arsv.exceptions.ARSVBusinessException;
import cl.dgac.arsv.mant.local.AsignacionServicesLocal;
import cl.dgac.arsv.mant.remote.AsignacionServicesRemote;
import cl.dgac.arsv.model.ArsvAsignacion;


@Stateless(name = "asignacionServicesBean")
public class AsignacionServicesBean implements AsignacionServicesLocal, AsignacionServicesRemote {

	public static final Logger log = Logger.getLogger(AsignacionServicesBean.class);
	
	private ArsvAsignacionDAO arsvAsignacionDAO;
		
	public AsignacionServicesBean() {
		super();
	}

	public ArsvAsignacion guardarAsignacion(ArsvAsignacion arsvAsignacion) throws ARSVBusinessException {
		try {
			return this.arsvAsignacionDAO.save(arsvAsignacion);
		} catch (Exception e) {
			log.error(e.getMessage());
			throw new ARSVBusinessException(e.getMessage());
		}
	}
	
	public ArsvAsignacion actualizarAsignacion(ArsvAsignacion arsvAsignacion) throws ARSVBusinessException {
		try {
			return this.arsvAsignacionDAO.update(arsvAsignacion);
		} catch (Exception e) {
			log.error(e.getMessage());
			throw new ARSVBusinessException(e.getMessage());
		}
	}
	
	public ArsvAsignacion buscarAsignacion(Long idArsvAsignacion) throws ARSVBusinessException {
		try {
			return this.arsvAsignacionDAO.findById(idArsvAsignacion);
		} catch (Exception e) {
			log.error(e.getMessage());
			throw new ARSVBusinessException(e.getMessage());
		}
	}
	
	public void eliminarAsignacion(ArsvAsignacion arsvAsignacion) throws ARSVBusinessException {
		try {
			this.arsvAsignacionDAO.remove(arsvAsignacion);
		} catch (Exception e) {
			log.error(e.getMessage());
			throw new ARSVBusinessException(e.getMessage());
		}
	}
	
	public List<ArsvAsignacion> buscarAsignacion() throws ARSVBusinessException {
		try {
			return this.arsvAsignacionDAO.findAll();
		} catch (Exception e) {
			log.error(e.getMessage());
			throw new ARSVBusinessException(e.getMessage());
		}
	}
}