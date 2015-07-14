package cl.dgac.arsv.mant.WS;

import java.util.List;

import javax.jws.WebService;

import cl.dgac.arsv.exceptions.ARSVBusinessException;
import cl.dgac.arsv.model.ArsvRol;

@WebService
public interface RolServicesWS {
	public ArsvRol guardarRol(ArsvRol arsvRol) throws ARSVBusinessException;
	
	public ArsvRol actualizarRol(ArsvRol arsvRol) throws ARSVBusinessException;
	
	public ArsvRol buscarRol(Long idArsvRol) throws ARSVBusinessException;
	
	public void eliminarRol(ArsvRol arsvRol) throws ARSVBusinessException;

	public List<ArsvRol> buscarRol() throws ARSVBusinessException;
	
}
