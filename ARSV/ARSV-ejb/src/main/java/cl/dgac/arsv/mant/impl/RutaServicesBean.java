package cl.dgac.arsv.mant.impl;
import java.util.List;

import javax.ejb.Stateless;

import org.apache.log4j.Logger;

import cl.dgac.arsv.dao.ArsvRutaDAO;
import cl.dgac.arsv.exceptions.ARSVBusinessException;
import cl.dgac.arsv.mant.local.RutaServicesLocal;
import cl.dgac.arsv.mant.remote.RutaServicesRemote;
import cl.dgac.arsv.model.ArsvRuta;


@Stateless(name = "rutaServicesBean")
public class RutaServicesBean implements RutaServicesLocal, RutaServicesRemote {

	public static final Logger log = Logger.getLogger(RutaServicesBean.class);
	
	private ArsvRutaDAO arsvRutaDAO;
		
	public RutaServicesBean() {
		super();
	}

	public ArsvRuta guardarRuta(ArsvRuta arsvRuta) throws ARSVBusinessException {
		try {
			return this.arsvRutaDAO.save(arsvRuta);
		} catch (Exception e) {
			log.error(e.getMessage());
			throw new ARSVBusinessException(e.getMessage());
		}
	}
	
	public ArsvRuta actualizarRuta(ArsvRuta arsvRuta) throws ARSVBusinessException {
		try {
			return this.arsvRutaDAO.update(arsvRuta);
		} catch (Exception e) {
			log.error(e.getMessage());
			throw new ARSVBusinessException(e.getMessage());
		}
	}
	
	public ArsvRuta buscarRuta(Long idArsvRuta) throws ARSVBusinessException {
		try {
			return this.arsvRutaDAO.findById(idArsvRuta);
		} catch (Exception e) {
			log.error(e.getMessage());
			throw new ARSVBusinessException(e.getMessage());
		}
	}
	
	public void eliminarRuta(ArsvRuta arsvRuta) throws ARSVBusinessException {
		try {
			this.arsvRutaDAO.remove(arsvRuta);
		} catch (Exception e) {
			log.error(e.getMessage());
			throw new ARSVBusinessException(e.getMessage());
		}
	}
	
	public List<ArsvRuta> buscarRuta() throws ARSVBusinessException {
		try {
			return this.arsvRutaDAO.findAll();
		} catch (Exception e) {
			log.error(e.getMessage());
			throw new ARSVBusinessException(e.getMessage());
		}
	}
}