package cl.dgac.arsv.mant.remote;

import java.util.List;

import javax.ejb.Remote;

import cl.dgac.arsv.exceptions.ARSVBusinessException;
import cl.dgac.arsv.model.ArsvSeguridad;

@Remote
public interface SeguridadServicesRemote {
	public ArsvSeguridad guardarSeguridad(ArsvSeguridad arsvSeguridad) throws ARSVBusinessException;
	
	public ArsvSeguridad actualizarSeguridad(ArsvSeguridad arsvSeguridad) throws ARSVBusinessException;
	
	public ArsvSeguridad buscarSeguridad(Long idArsvSeguridad) throws ARSVBusinessException;
	
	public void eliminarSeguridad(ArsvSeguridad arsvSeguridad) throws ARSVBusinessException;

	public List<ArsvSeguridad> buscarSeguridad() throws ARSVBusinessException;
	
}
