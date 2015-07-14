package cl.dgac.arsv.mant.impl;
import java.util.List;

import javax.ejb.Stateless;

import org.apache.log4j.Logger;

import cl.dgac.arsv.dao.ArsvTipoSolicitudDAO;
import cl.dgac.arsv.exceptions.ARSVBusinessException;
import cl.dgac.arsv.mant.local.TipoSolicitudServicesLocal;
import cl.dgac.arsv.mant.remote.TipoSolicitudServicesRemote;
import cl.dgac.arsv.model.ArsvTipoSolicitud;


@Stateless(name = "tipoSolicitudServicesBean")
public class TipoSolicitudServicesBean implements TipoSolicitudServicesLocal, TipoSolicitudServicesRemote {

	public static final Logger log = Logger.getLogger(TipoSolicitudServicesBean.class);
	
	private ArsvTipoSolicitudDAO arsvTipoSolicitudDAO;
		
	public TipoSolicitudServicesBean() {
		super();
	}

	public ArsvTipoSolicitud guardarTipoSolicitud(ArsvTipoSolicitud arsvTipoSolicitud) throws ARSVBusinessException {
		try {
			return this.arsvTipoSolicitudDAO.save(arsvTipoSolicitud);
		} catch (Exception e) {
			log.error(e.getMessage());
			throw new ARSVBusinessException(e.getMessage());
		}
	}
	
	public ArsvTipoSolicitud actualizarTipoSolicitud(ArsvTipoSolicitud arsvTipoSolicitud) throws ARSVBusinessException {
		try {
			return this.arsvTipoSolicitudDAO.update(arsvTipoSolicitud);
		} catch (Exception e) {
			log.error(e.getMessage());
			throw new ARSVBusinessException(e.getMessage());
		}
	}
	
	public ArsvTipoSolicitud buscarTipoSolicitud(String idArsvTipoSolicitud) throws ARSVBusinessException {
		try {
			return this.arsvTipoSolicitudDAO.findById(idArsvTipoSolicitud);
		} catch (Exception e) {
			log.error(e.getMessage());
			throw new ARSVBusinessException(e.getMessage());
		}
	}
	
	public void eliminarTipoSolicitud(ArsvTipoSolicitud arsvTipoSolicitud) throws ARSVBusinessException {
		try {
			this.arsvTipoSolicitudDAO.remove(arsvTipoSolicitud);
		} catch (Exception e) {
			log.error(e.getMessage());
			throw new ARSVBusinessException(e.getMessage());
		}
	}
	
	public List<ArsvTipoSolicitud> buscarTipoSolicitud() throws ARSVBusinessException {
		try {
			return this.arsvTipoSolicitudDAO.findAll();
		} catch (Exception e) {
			log.error(e.getMessage());
			throw new ARSVBusinessException(e.getMessage());
		}
	}
}