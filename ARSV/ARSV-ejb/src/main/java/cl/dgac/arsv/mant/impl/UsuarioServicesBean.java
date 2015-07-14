package cl.dgac.arsv.mant.impl;
import java.util.List;

import javax.ejb.Stateless;

import org.apache.log4j.Logger;

import cl.dgac.arsv.dao.ArsvUsuarioDAO;
import cl.dgac.arsv.exceptions.ARSVBusinessException;
import cl.dgac.arsv.mant.local.UsuarioServicesLocal;
import cl.dgac.arsv.mant.remote.UsuarioServicesRemote;
import cl.dgac.arsv.model.ArsvUsuario;


@Stateless(name = "usuarioServicesBean")
public class UsuarioServicesBean implements UsuarioServicesLocal, UsuarioServicesRemote {

	public static final Logger log = Logger.getLogger(UsuarioServicesBean.class);
	
	private ArsvUsuarioDAO arsvUsuarioDAO;
		
	public UsuarioServicesBean() {
		super();
	}

	public ArsvUsuario guardarUsuario(ArsvUsuario arsvUsuario) throws ARSVBusinessException {
		try {
			return this.arsvUsuarioDAO.save(arsvUsuario);
		} catch (Exception e) {
			log.error(e.getMessage());
			throw new ARSVBusinessException(e.getMessage());
		}
	}
	
	public ArsvUsuario actualizarUsuario(ArsvUsuario arsvUsuario) throws ARSVBusinessException {
		try {
			return this.arsvUsuarioDAO.update(arsvUsuario);
		} catch (Exception e) {
			log.error(e.getMessage());
			throw new ARSVBusinessException(e.getMessage());
		}
	}
	
	public ArsvUsuario buscarUsuario(Long idArsvUsuario) throws ARSVBusinessException {
		try {
			return this.arsvUsuarioDAO.findById(idArsvUsuario);
		} catch (Exception e) {
			log.error(e.getMessage());
			throw new ARSVBusinessException(e.getMessage());
		}
	}
	
	public void eliminarUsuario(ArsvUsuario arsvUsuario) throws ARSVBusinessException {
		try {
			this.arsvUsuarioDAO.remove(arsvUsuario);
		} catch (Exception e) {
			log.error(e.getMessage());
			throw new ARSVBusinessException(e.getMessage());
		}
	}
	
	public List<ArsvUsuario> buscarUsuario() throws ARSVBusinessException {
		try {
			return this.arsvUsuarioDAO.findAll();
		} catch (Exception e) {
			log.error(e.getMessage());
			throw new ARSVBusinessException(e.getMessage());
		}
	}
}