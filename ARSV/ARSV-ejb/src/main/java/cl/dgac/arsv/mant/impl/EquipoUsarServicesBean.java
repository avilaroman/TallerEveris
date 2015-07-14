package cl.dgac.arsv.mant.impl;
import java.util.List;

import javax.ejb.Stateless;

import org.apache.log4j.Logger;

import cl.dgac.arsv.dao.ArsvEquipoUsarDAO;
import cl.dgac.arsv.exceptions.ARSVBusinessException;
import cl.dgac.arsv.mant.local.EquipoUsarServicesLocal;
import cl.dgac.arsv.mant.remote.EquipoUsarServicesRemote;
import cl.dgac.arsv.model.ArsvEquipoUsar;


@Stateless(name = "equipoUsarServicesBean")
public class EquipoUsarServicesBean implements EquipoUsarServicesLocal, EquipoUsarServicesRemote {

	public static final Logger log = Logger.getLogger(EquipoUsarServicesBean.class);
	
	private ArsvEquipoUsarDAO arsvEquipoUsarDAO;
		
	public EquipoUsarServicesBean() {
		super();
	}

	public ArsvEquipoUsar guardarEquipoUsar(ArsvEquipoUsar arsvEquipoUsar) throws ARSVBusinessException {
		try {
			return this.arsvEquipoUsarDAO.save(arsvEquipoUsar);
		} catch (Exception e) {
			log.error(e.getMessage());
			throw new ARSVBusinessException(e.getMessage());
		}
	}
	
	public ArsvEquipoUsar actualizarEquipoUsar(ArsvEquipoUsar arsvEquipoUsar) throws ARSVBusinessException {
		try {
			return this.arsvEquipoUsarDAO.update(arsvEquipoUsar);
		} catch (Exception e) {
			log.error(e.getMessage());
			throw new ARSVBusinessException(e.getMessage());
		}
	}
	
	public ArsvEquipoUsar buscarEquipoUsar(Long idArsvEquipoUsar) throws ARSVBusinessException {
		try {
			return this.arsvEquipoUsarDAO.findById(idArsvEquipoUsar);
		} catch (Exception e) {
			log.error(e.getMessage());
			throw new ARSVBusinessException(e.getMessage());
		}
	}
	
	public void eliminarEquipoUsar(ArsvEquipoUsar arsvEquipoUsar) throws ARSVBusinessException {
		try {
			this.arsvEquipoUsarDAO.remove(arsvEquipoUsar);
		} catch (Exception e) {
			log.error(e.getMessage());
			throw new ARSVBusinessException(e.getMessage());
		}
	}
	
	public List<ArsvEquipoUsar> buscarEquipoUsar() throws ARSVBusinessException {
		try {
			return this.arsvEquipoUsarDAO.findAll();
		} catch (Exception e) {
			log.error(e.getMessage());
			throw new ARSVBusinessException(e.getMessage());
		}
	}
}