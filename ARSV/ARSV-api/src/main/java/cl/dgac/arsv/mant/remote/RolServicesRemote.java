package cl.dgac.arsv.mant.remote;

import java.util.List;

import javax.ejb.Remote;

import cl.dgac.arsv.exceptions.ARSVBusinessException;
import cl.dgac.arsv.model.ArsvRol;

@Remote
public interface RolServicesRemote {
	public ArsvRol guardarRol(ArsvRol arsvRol) throws ARSVBusinessException;
	
	public ArsvRol actualizarRol(ArsvRol arsvRol) throws ARSVBusinessException;
	
	public ArsvRol buscarRol(Long idArsvRol) throws ARSVBusinessException;
	
	public void eliminarRol(ArsvRol arsvRol) throws ARSVBusinessException;

	public List<ArsvRol> buscarRol() throws ARSVBusinessException;
	
}
