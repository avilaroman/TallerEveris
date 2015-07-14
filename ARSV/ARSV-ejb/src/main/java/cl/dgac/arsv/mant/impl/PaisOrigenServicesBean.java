package cl.dgac.arsv.mant.impl;
import java.util.List;

import javax.ejb.Stateless;

import org.apache.log4j.Logger;

import cl.dgac.arsv.dao.ArsvPaisOrigenDAO;
import cl.dgac.arsv.exceptions.ARSVBusinessException;
import cl.dgac.arsv.mant.local.PaisOrigenServicesLocal;
import cl.dgac.arsv.mant.remote.PaisOrigenServicesRemote;
import cl.dgac.arsv.model.ArsvPaisOrigen;


@Stateless(name = "paisOrigenServicesBean")
public class PaisOrigenServicesBean implements PaisOrigenServicesLocal, PaisOrigenServicesRemote {

	public static final Logger log = Logger.getLogger(PaisOrigenServicesBean.class);
	
	private ArsvPaisOrigenDAO arsvPaisOrigenDAO;
		
	public PaisOrigenServicesBean() {
		super();
	}

	public ArsvPaisOrigen guardarPaisOrigen(ArsvPaisOrigen paisOrigen) throws ARSVBusinessException {
		try {
			return this.arsvPaisOrigenDAO.save(paisOrigen);
		} catch (Exception e) {
			log.error(e.getMessage());
			throw new ARSVBusinessException(e.getMessage());
		}
	}
	
	public ArsvPaisOrigen actualizarPaisOrigen(ArsvPaisOrigen paisOrigen) throws ARSVBusinessException {
		try {
			return this.arsvPaisOrigenDAO.update(paisOrigen);
		} catch (Exception e) {
			log.error(e.getMessage());
			throw new ARSVBusinessException(e.getMessage());
		}
	}
	
	public ArsvPaisOrigen buscarPaisOrigen(Long idPaisOrigen) throws ARSVBusinessException {
		try {
			return this.arsvPaisOrigenDAO.findById(idPaisOrigen);
		} catch (Exception e) {
			log.error(e.getMessage());
			throw new ARSVBusinessException(e.getMessage());
		}
	}
	
	public void eliminarPaisOrigen(ArsvPaisOrigen paisOrigen) throws ARSVBusinessException {
		try {
			this.arsvPaisOrigenDAO.remove(paisOrigen);
		} catch (Exception e) {
			log.error(e.getMessage());
			throw new ARSVBusinessException(e.getMessage());
		}
	}
	
	public List<ArsvPaisOrigen> buscarPaisOrigen() throws ARSVBusinessException {
		try {
			return this.arsvPaisOrigenDAO.findAll();
		} catch (Exception e) {
			log.error(e.getMessage());
			throw new ARSVBusinessException(e.getMessage());
		}
	}
}