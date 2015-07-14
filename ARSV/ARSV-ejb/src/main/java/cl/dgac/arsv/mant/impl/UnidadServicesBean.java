package cl.dgac.arsv.mant.impl;
import java.util.List;

import javax.ejb.Stateless;

import org.apache.log4j.Logger;

import cl.dgac.arsv.dao.ArsvUnidadDAO;
import cl.dgac.arsv.exceptions.ARSVBusinessException;
import cl.dgac.arsv.mant.local.UnidadServicesLocal;
import cl.dgac.arsv.mant.remote.UnidadServicesRemote;
import cl.dgac.arsv.model.ArsvUnidad;


@Stateless(name = "unidadServicesBean")
public class UnidadServicesBean implements UnidadServicesLocal, UnidadServicesRemote {

	public static final Logger log = Logger.getLogger(UnidadServicesBean.class);
	
	private ArsvUnidadDAO arsvUnidadDAO;
		
	public UnidadServicesBean() {
		super();
	}

	public ArsvUnidad guardarUnidad(ArsvUnidad arsvUnidad) throws ARSVBusinessException {
		try {
			return this.arsvUnidadDAO.save(arsvUnidad);
		} catch (Exception e) {
			log.error(e.getMessage());
			throw new ARSVBusinessException(e.getMessage());
		}
	}
	
	public ArsvUnidad actualizarUnidad(ArsvUnidad arsvUnidad) throws ARSVBusinessException {
		try {
			return this.arsvUnidadDAO.update(arsvUnidad);
		} catch (Exception e) {
			log.error(e.getMessage());
			throw new ARSVBusinessException(e.getMessage());
		}
	}
	
	public ArsvUnidad buscarUnidad(Long idArsvUnidad) throws ARSVBusinessException {
		try {
			return this.arsvUnidadDAO.findById(idArsvUnidad);
		} catch (Exception e) {
			log.error(e.getMessage());
			throw new ARSVBusinessException(e.getMessage());
		}
	}
	
	public void eliminarUnidad(ArsvUnidad arsvUnidad) throws ARSVBusinessException {
		try {
			this.arsvUnidadDAO.remove(arsvUnidad);
		} catch (Exception e) {
			log.error(e.getMessage());
			throw new ARSVBusinessException(e.getMessage());
		}
	}
	
	public List<ArsvUnidad> buscarUnidad() throws ARSVBusinessException {
		try {
			return this.arsvUnidadDAO.findAll();
		} catch (Exception e) {
			log.error(e.getMessage());
			throw new ARSVBusinessException(e.getMessage());
		}
	}
}