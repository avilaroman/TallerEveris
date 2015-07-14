package cl.dgac.arsv.mant.local;

import java.util.List;

import javax.ejb.Local;

import cl.dgac.arsv.exceptions.ARSVBusinessException;
import cl.dgac.arsv.model.ArsvSeguridad;

@Local
public interface SeguridadServicesLocal {
	public ArsvSeguridad guardarSeguridad(ArsvSeguridad arsvSeguridad) throws ARSVBusinessException;
	
	public ArsvSeguridad actualizarSeguridad(ArsvSeguridad arsvSeguridad) throws ARSVBusinessException;
	
	public ArsvSeguridad buscarSeguridad(Long idArsvSeguridad) throws ARSVBusinessException;
	
	public void eliminarSeguridad(ArsvSeguridad arsvSeguridad) throws ARSVBusinessException;

	public List<ArsvSeguridad> buscarSeguridad() throws ARSVBusinessException;
	
}
