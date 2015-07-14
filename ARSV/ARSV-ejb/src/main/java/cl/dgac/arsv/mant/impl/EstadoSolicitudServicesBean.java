package cl.dgac.arsv.mant.impl;
import java.util.List;

import javax.ejb.Stateless;

import org.apache.log4j.Logger;

import cl.dgac.arsv.dao.ArsvEstadoSolicitudDAO;
import cl.dgac.arsv.exceptions.ARSVBusinessException;
import cl.dgac.arsv.mant.local.EstadoSolicitudServicesLocal;
import cl.dgac.arsv.mant.remote.EstadoSolicitudServicesRemote;
import cl.dgac.arsv.model.ArsvEstadoSolicitud;


@Stateless(name = "estadoSolicitudServicesBean")
public class EstadoSolicitudServicesBean implements EstadoSolicitudServicesLocal, EstadoSolicitudServicesRemote {

	public static final Logger log = Logger.getLogger(EstadoSolicitudServicesBean.class);
	
	private ArsvEstadoSolicitudDAO arsvEstadoSolicitudDAO;
		
	public EstadoSolicitudServicesBean() {
		super();
	}

	public ArsvEstadoSolicitud guardarEstadoSolicitud(ArsvEstadoSolicitud arsvEstadoSolicitud) throws ARSVBusinessException {
		try {
			return this.arsvEstadoSolicitudDAO.save(arsvEstadoSolicitud);
		} catch (Exception e) {
			log.error(e.getMessage());
			throw new ARSVBusinessException(e.getMessage());
		}
	}
	
	public ArsvEstadoSolicitud actualizarEstadoSolicitud(ArsvEstadoSolicitud arsvEstadoSolicitud) throws ARSVBusinessException {
		try {
			return this.arsvEstadoSolicitudDAO.update(arsvEstadoSolicitud);
		} catch (Exception e) {
			log.error(e.getMessage());
			throw new ARSVBusinessException(e.getMessage());
		}
	}
	
	public ArsvEstadoSolicitud buscarEstadoSolicitud(String idEstadoSolicitud) throws ARSVBusinessException {
		try {
			return this.arsvEstadoSolicitudDAO.findById(idEstadoSolicitud);
		} catch (Exception e) {
			log.error(e.getMessage());
			throw new ARSVBusinessException(e.getMessage());
		}
	}
	
	public void eliminarEstadoSolicitud(ArsvEstadoSolicitud arsvEstadoSolicitud) throws ARSVBusinessException {
		try {
			this.arsvEstadoSolicitudDAO.remove(arsvEstadoSolicitud);
		} catch (Exception e) {
			log.error(e.getMessage());
			throw new ARSVBusinessException(e.getMessage());
		}
	}
	
	public List<ArsvEstadoSolicitud> buscarEstadoSolicitud() throws ARSVBusinessException {
		try {
			return this.arsvEstadoSolicitudDAO.findAll();
		} catch (Exception e) {
			log.error(e.getMessage());
			throw new ARSVBusinessException(e.getMessage());
		}
	}
}