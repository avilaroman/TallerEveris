package cl.dgac.arsv.mant.impl;
import java.util.List;

import javax.ejb.Stateless;

import org.apache.log4j.Logger;

import cl.dgac.arsv.dao.ArsvVentanaTiempoDAO;
import cl.dgac.arsv.exceptions.ARSVBusinessException;
import cl.dgac.arsv.mant.local.VentanaTiempoServicesLocal;
import cl.dgac.arsv.mant.remote.VentanaTiempoServicesRemote;
import cl.dgac.arsv.model.ArsvVentanaTiempo;


@Stateless(name = "ventanaTiempoServicesBean")
public class VentanaTiempoServicesBean implements VentanaTiempoServicesLocal, VentanaTiempoServicesRemote {

	public static final Logger log = Logger.getLogger(VentanaTiempoServicesBean.class);
	
	private ArsvVentanaTiempoDAO arsvVentanaTiempoDAO;
		
	public VentanaTiempoServicesBean() {
		super();
	}

	public ArsvVentanaTiempo guardarVentanaTiempo(ArsvVentanaTiempo arsvVentanaTiempo) throws ARSVBusinessException {
		try {
			return this.arsvVentanaTiempoDAO.save(arsvVentanaTiempo);
		} catch (Exception e) {
			log.error(e.getMessage());
			throw new ARSVBusinessException(e.getMessage());
		}
	}
	
	public ArsvVentanaTiempo actualizarVentanaTiempo(ArsvVentanaTiempo arsvVentanaTiempo) throws ARSVBusinessException {
		try {
			return this.arsvVentanaTiempoDAO.update(arsvVentanaTiempo);
		} catch (Exception e) {
			log.error(e.getMessage());
			throw new ARSVBusinessException(e.getMessage());
		}
	}
	
	public ArsvVentanaTiempo buscarVentanaTiempo(Long idArsvVentanaTiempo) throws ARSVBusinessException {
		try {
			return this.arsvVentanaTiempoDAO.findById(idArsvVentanaTiempo);
		} catch (Exception e) {
			log.error(e.getMessage());
			throw new ARSVBusinessException(e.getMessage());
		}
	}
	
	public void eliminarVentanaTiempo(ArsvVentanaTiempo arsvVentanaTiempo) throws ARSVBusinessException {
		try {
			this.arsvVentanaTiempoDAO.remove(arsvVentanaTiempo);
		} catch (Exception e) {
			log.error(e.getMessage());
			throw new ARSVBusinessException(e.getMessage());
		}
	}
	
	public List<ArsvVentanaTiempo> buscarVentanaTiempo() throws ARSVBusinessException {
		try {
			return this.arsvVentanaTiempoDAO.findAll();
		} catch (Exception e) {
			log.error(e.getMessage());
			throw new ARSVBusinessException(e.getMessage());
		}
	}
}