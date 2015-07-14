package cl.dgac.arsv.mant.remote;

import java.util.List;

import javax.ejb.Remote;

import cl.dgac.arsv.exceptions.ARSVBusinessException;
import cl.dgac.arsv.model.ArsvUsuario;

@Remote
public interface UsuarioServicesRemote {
	public ArsvUsuario guardarUsuario(ArsvUsuario arsvUsuario) throws ARSVBusinessException;
	
	public ArsvUsuario actualizarUsuario(ArsvUsuario arsvUsuario) throws ARSVBusinessException;
	
	public ArsvUsuario buscarUsuario(Long idArsvUsuario) throws ARSVBusinessException;
	
	public void eliminarUsuario(ArsvUsuario arsvUsuario) throws ARSVBusinessException;

	public List<ArsvUsuario> buscarUsuario() throws ARSVBusinessException;
	
}
