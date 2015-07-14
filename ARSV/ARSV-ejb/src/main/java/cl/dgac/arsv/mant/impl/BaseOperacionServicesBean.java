package cl.dgac.arsv.mant.impl;
import java.util.List;

import javax.ejb.Stateless;

import org.apache.log4j.Logger;

import cl.dgac.arsv.dao.ArsvBaseOperacionDAO;
import cl.dgac.arsv.exceptions.ARSVBusinessException;
import cl.dgac.arsv.mant.local.BaseOperacionServicesLocal;
import cl.dgac.arsv.mant.remote.BaseOperacionServicesRemote;
import cl.dgac.arsv.model.ArsvBaseOperacion;


@Stateless(name = "baseOperacionServicessBean")
public class BaseOperacionServicesBean implements BaseOperacionServicesLocal, BaseOperacionServicesRemote {

	public static final Logger log = Logger.getLogger(BaseOperacionServicesBean.class);
	
	private ArsvBaseOperacionDAO arsvBaseOperacionDAO;
		
	public BaseOperacionServicesBean() {
		super();
	}

	public ArsvBaseOperacion guardarBaseOperacion(ArsvBaseOperacion arsvBaseOperacion) throws ARSVBusinessException {
		try {
			return this.arsvBaseOperacionDAO.save(arsvBaseOperacion);
		} catch (Exception e) {
			log.error(e.getMessage());
			throw new ARSVBusinessException(e.getMessage());
		}
	}
	
	public ArsvBaseOperacion actualizarBaseOperacion(ArsvBaseOperacion arsvBaseOperacion) throws ARSVBusinessException {
		try {
			return this.arsvBaseOperacionDAO.update(arsvBaseOperacion);
		} catch (Exception e) {
			log.error(e.getMessage());
			throw new ARSVBusinessException(e.getMessage());
		}
	}
	
	public ArsvBaseOperacion buscarBaseOperacion(Long idBaseOperacion) throws ARSVBusinessException {
		try {
			return this.arsvBaseOperacionDAO.findById(idBaseOperacion);
		} catch (Exception e) {
			log.error(e.getMessage());
			throw new ARSVBusinessException(e.getMessage());
		}
	}
	
	public void eliminarBaseOperacion(ArsvBaseOperacion arsvBaseOperacion) throws ARSVBusinessException {
		try {
			this.arsvBaseOperacionDAO.remove(arsvBaseOperacion);
		} catch (Exception e) {
			log.error(e.getMessage());
			throw new ARSVBusinessException(e.getMessage());
		}
	}
	
	public List<ArsvBaseOperacion> buscarBaseOperacion() throws ARSVBusinessException {
		try {
			return this.arsvBaseOperacionDAO.findAll();
		} catch (Exception e) {
			log.error(e.getMessage());
			throw new ARSVBusinessException(e.getMessage());
		}
	}
}