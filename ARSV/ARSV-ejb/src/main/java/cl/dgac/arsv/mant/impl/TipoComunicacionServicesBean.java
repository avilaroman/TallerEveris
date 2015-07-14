package cl.dgac.arsv.mant.impl;
import java.util.List;

import javax.ejb.Stateless;

import org.apache.log4j.Logger;

import cl.dgac.arsv.dao.ArsvTipoComunicacionDAO;
import cl.dgac.arsv.exceptions.ARSVBusinessException;
import cl.dgac.arsv.mant.local.TipoComunicacionServicesLocal;
import cl.dgac.arsv.mant.remote.TipoComunicacionServicesRemote;
import cl.dgac.arsv.model.ArsvTipoComunicacion;


@Stateless(name = "tipoComunicacionServicesBean")
public class TipoComunicacionServicesBean implements TipoComunicacionServicesLocal, TipoComunicacionServicesRemote {

	public static final Logger log = Logger.getLogger(TipoComunicacionServicesBean.class);
	
	private ArsvTipoComunicacionDAO arsvTipoComunicacionDAO;
		
	public TipoComunicacionServicesBean() {
		super();
	}

	public ArsvTipoComunicacion guardarTipoComunicacion(ArsvTipoComunicacion arsvTipoComunicacion) throws ARSVBusinessException {
		try {
			return this.arsvTipoComunicacionDAO.save(arsvTipoComunicacion);
		} catch (Exception e) {
			log.error(e.getMessage());
			throw new ARSVBusinessException(e.getMessage());
		}
	}
	
	public ArsvTipoComunicacion actualizarTipoComunicacion(ArsvTipoComunicacion arsvTipoComunicacion) throws ARSVBusinessException {
		try {
			return this.arsvTipoComunicacionDAO.update(arsvTipoComunicacion);
		} catch (Exception e) {
			log.error(e.getMessage());
			throw new ARSVBusinessException(e.getMessage());
		}
	}
	
	public ArsvTipoComunicacion buscarTipoComunicacion(Long idArsvTipoComunicacion) throws ARSVBusinessException {
		try {
			return this.arsvTipoComunicacionDAO.findById(idArsvTipoComunicacion);
		} catch (Exception e) {
			log.error(e.getMessage());
			throw new ARSVBusinessException(e.getMessage());
		}
	}
	
	public void eliminarTipoComunicacion(ArsvTipoComunicacion arsvTipoComunicacion) throws ARSVBusinessException {
		try {
			this.arsvTipoComunicacionDAO.remove(arsvTipoComunicacion);
		} catch (Exception e) {
			log.error(e.getMessage());
			throw new ARSVBusinessException(e.getMessage());
		}
	}
	
	public List<ArsvTipoComunicacion> buscarTipoComunicacion() throws ARSVBusinessException {
		try {
			return this.arsvTipoComunicacionDAO.findAll();
		} catch (Exception e) {
			log.error(e.getMessage());
			throw new ARSVBusinessException(e.getMessage());
		}
	}
}