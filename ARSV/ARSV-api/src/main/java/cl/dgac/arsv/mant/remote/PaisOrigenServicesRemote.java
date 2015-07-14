package cl.dgac.arsv.mant.remote;

import java.util.List;

import javax.ejb.Remote;

import cl.dgac.arsv.exceptions.ARSVBusinessException;
import cl.dgac.arsv.model.ArsvPaisOrigen;

@Remote
public interface PaisOrigenServicesRemote {
	public ArsvPaisOrigen guardarPaisOrigen(ArsvPaisOrigen paisOrigen) throws ARSVBusinessException;
	
	public ArsvPaisOrigen actualizarPaisOrigen(ArsvPaisOrigen paisOrigen) throws ARSVBusinessException;
	
	public ArsvPaisOrigen buscarPaisOrigen(Long idPaisOrigen) throws ARSVBusinessException;
	
	public void eliminarPaisOrigen(ArsvPaisOrigen paisOrigen) throws ARSVBusinessException;

	public List<ArsvPaisOrigen> buscarPaisOrigen() throws ARSVBusinessException;
	
}
