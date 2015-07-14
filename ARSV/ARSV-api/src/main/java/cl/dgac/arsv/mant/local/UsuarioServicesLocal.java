package cl.dgac.arsv.mant.local;

import java.util.List;

import javax.ejb.Local;

import cl.dgac.arsv.exceptions.ARSVBusinessException;
import cl.dgac.arsv.model.ArsvUsuario;

@Local
public interface UsuarioServicesLocal {
	public ArsvUsuario guardarUsuario(ArsvUsuario arsvUsuario) throws ARSVBusinessException;
	
	public ArsvUsuario actualizarUsuario(ArsvUsuario arsvUsuario) throws ARSVBusinessException;
	
	public ArsvUsuario buscarUsuario(Long idArsvUsuario) throws ARSVBusinessException;
	
	public void eliminarUsuario(ArsvUsuario arsvUsuario) throws ARSVBusinessException;

	public List<ArsvUsuario> buscarUsuario() throws ARSVBusinessException;
	
}
