package cl.dgac.arsv.mant.WS;

import java.util.List;

import javax.jws.WebService;

import cl.dgac.arsv.exceptions.ARSVBusinessException;
import cl.dgac.arsv.model.ArsvUsuario;

@WebService
public interface UsuarioServicesWS {
	public ArsvUsuario guardarUsuario(ArsvUsuario arsvUsuario) throws ARSVBusinessException;
	
	public ArsvUsuario actualizarUsuario(ArsvUsuario arsvUsuario) throws ARSVBusinessException;
	
	public ArsvUsuario buscarUsuario(Long idArsvUsuario) throws ARSVBusinessException;
	
	public void eliminarUsuario(ArsvUsuario arsvUsuario) throws ARSVBusinessException;

	public List<ArsvUsuario> buscarUsuario() throws ARSVBusinessException;
	
}
