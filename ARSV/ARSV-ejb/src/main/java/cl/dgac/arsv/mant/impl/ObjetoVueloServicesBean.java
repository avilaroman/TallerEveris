package cl.dgac.arsv.mant.impl;
import java.util.List;

import javax.ejb.Stateless;

import org.apache.log4j.Logger;

import cl.dgac.arsv.dao.ArsvObjetoVueloDAO;
import cl.dgac.arsv.exceptions.ARSVBusinessException;
import cl.dgac.arsv.mant.local.ObjetoVueloServicesLocal;
import cl.dgac.arsv.mant.remote.ObjetoVueloServicesRemote;
import cl.dgac.arsv.model.ArsvObjetoVuelo;


@Stateless(name = "objetoVueloServicesBean")
public class ObjetoVueloServicesBean implements ObjetoVueloServicesLocal, ObjetoVueloServicesRemote {

	public static final Logger log = Logger.getLogger(ObjetoVueloServicesBean.class);
	
	private ArsvObjetoVueloDAO arsvObjetoVueloDAO;
		
	public ObjetoVueloServicesBean() {
		super();
	}

	public ArsvObjetoVuelo guardarObjetoVuelo(ArsvObjetoVuelo objetoVuelo) throws ARSVBusinessException {
		try {
			return this.arsvObjetoVueloDAO.save(objetoVuelo);
		} catch (Exception e) {
			log.error(e.getMessage());
			throw new ARSVBusinessException(e.getMessage());
		}
	}
	
	public ArsvObjetoVuelo actualizarObjetoVuelo(ArsvObjetoVuelo objetoVuelo) throws ARSVBusinessException {
		try {
			return this.arsvObjetoVueloDAO.update(objetoVuelo);
		} catch (Exception e) {
			log.error(e.getMessage());
			throw new ARSVBusinessException(e.getMessage());
		}
	}
	
	public ArsvObjetoVuelo buscarObjetoVuelo(Long idObjetoVuelo) throws ARSVBusinessException {
		try {
			return this.arsvObjetoVueloDAO.findById(idObjetoVuelo);
		} catch (Exception e) {
			log.error(e.getMessage());
			throw new ARSVBusinessException(e.getMessage());
		}
	}
	
	public void eliminarObjetoVuelo(ArsvObjetoVuelo objetoVuelo) throws ARSVBusinessException {
		try {
			this.arsvObjetoVueloDAO.remove(objetoVuelo);
		} catch (Exception e) {
			log.error(e.getMessage());
			throw new ARSVBusinessException(e.getMessage());
		}
	}
	
	public List<ArsvObjetoVuelo> buscarObjetoVuelo() throws ARSVBusinessException {
		try {
			return this.arsvObjetoVueloDAO.findAll();
		} catch (Exception e) {
			log.error(e.getMessage());
			throw new ARSVBusinessException(e.getMessage());
		}
	}
}