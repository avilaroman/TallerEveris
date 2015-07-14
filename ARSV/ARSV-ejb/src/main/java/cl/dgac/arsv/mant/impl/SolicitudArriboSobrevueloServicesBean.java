package cl.dgac.arsv.mant.impl;
import java.util.List;

import javax.ejb.Stateless;

import org.apache.log4j.Logger;

import cl.dgac.arsv.dao.ArsvSolicitudArriboSobrevueloDAO;
import cl.dgac.arsv.exceptions.ARSVBusinessException;
import cl.dgac.arsv.mant.local.SolicitudArriboSobrevueloServicesLocal;
import cl.dgac.arsv.mant.remote.SolicitudArriboSobrevueloServicesRemote;
import cl.dgac.arsv.model.SolicitudArriboSobrevuelo;


@Stateless(name = "solicitudArriboSobrevueloServicessBean")
public class SolicitudArriboSobrevueloServicesBean implements SolicitudArriboSobrevueloServicesLocal, SolicitudArriboSobrevueloServicesRemote {

	public static final Logger log = Logger.getLogger(SolicitudArriboSobrevueloServicesBean.class);
	
	private ArsvSolicitudArriboSobrevueloDAO arsvSolicitudArriboSobrevueloDAO;
		
	public SolicitudArriboSobrevueloServicesBean() {
		super();
	}

	public SolicitudArriboSobrevuelo guardarSolicitudArriboSobrevuelo(SolicitudArriboSobrevuelo solicitudArriboSobrevuelo) throws ARSVBusinessException {
		try {
			return this.arsvSolicitudArriboSobrevueloDAO.save(solicitudArriboSobrevuelo);
		} catch (Exception e) {
			log.error(e.getMessage());
			throw new ARSVBusinessException(e.getMessage());
		}
	}
	
	public SolicitudArriboSobrevuelo actualizarSolicitudArriboSobrevuelo(SolicitudArriboSobrevuelo solicitudArriboSobrevuelo) throws ARSVBusinessException {
		try {
			return this.arsvSolicitudArriboSobrevueloDAO.update(solicitudArriboSobrevuelo);
		} catch (Exception e) {
			log.error(e.getMessage());
			throw new ARSVBusinessException(e.getMessage());
		}
	}
	
	public SolicitudArriboSobrevuelo buscarSolicitudArriboSobrevuelo(Long idSolicitudArriboSobrevuelo) throws ARSVBusinessException {
		try {
			return this.arsvSolicitudArriboSobrevueloDAO.findById(idSolicitudArriboSobrevuelo);
		} catch (Exception e) {
			log.error(e.getMessage());
			throw new ARSVBusinessException(e.getMessage());
		}
	}
	
	public void eliminarSolicitudArriboSobrevuelo(SolicitudArriboSobrevuelo solicitudArriboSobrevuelo) throws ARSVBusinessException {
		try {
			this.arsvSolicitudArriboSobrevueloDAO.remove(solicitudArriboSobrevuelo);
		} catch (Exception e) {
			log.error(e.getMessage());
			throw new ARSVBusinessException(e.getMessage());
		}
	}
	
	public List<SolicitudArriboSobrevuelo> buscarSolicitudArriboSobrevuelo() throws ARSVBusinessException {
		try {
			return this.arsvSolicitudArriboSobrevueloDAO.findAll();
		} catch (Exception e) {
			log.error(e.getMessage());
			throw new ARSVBusinessException(e.getMessage());
		}
	}
}