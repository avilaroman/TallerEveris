package cl.dgac.arsv.mant.WS;

import java.util.List;

import javax.jws.WebService;

import cl.dgac.arsv.exceptions.ARSVBusinessException;
import cl.dgac.arsv.model.ArsvSeguridad;

@WebService
public interface SeguridadServicesWS {
	public ArsvSeguridad guardarSeguridad(ArsvSeguridad arsvSeguridad) throws ARSVBusinessException;
	
	public ArsvSeguridad actualizarSeguridad(ArsvSeguridad arsvSeguridad) throws ARSVBusinessException;
	
	public ArsvSeguridad buscaSeguridad(Long idArsvSeguridad) throws ARSVBusinessException;
	
	public void eliminarSeguridad(ArsvSeguridad arsvSeguridad) throws ARSVBusinessException;

	public List<ArsvSeguridad> buscarSeguridad() throws ARSVBusinessException;
	
}
