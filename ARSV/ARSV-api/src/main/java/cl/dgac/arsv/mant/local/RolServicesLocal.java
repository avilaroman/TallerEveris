package cl.dgac.arsv.mant.local;

import java.util.List;

import javax.ejb.Local;

import cl.dgac.arsv.exceptions.ARSVBusinessException;
import cl.dgac.arsv.model.ArsvRol;

@Local
public interface RolServicesLocal {
	public ArsvRol guardarRol(ArsvRol arsvRol) throws ARSVBusinessException;
	
	public ArsvRol actualizarRol(ArsvRol arsvRol) throws ARSVBusinessException;
	
	public ArsvRol buscarRol(Long idArsvRol) throws ARSVBusinessException;
	
	public void eliminarRol(ArsvRol arsvRol) throws ARSVBusinessException;

	public List<ArsvRol> buscarRol() throws ARSVBusinessException;
	
}
