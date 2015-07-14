package cl.dgac.arsv.mant.remote;

import java.util.List;

import javax.ejb.Remote;

import cl.dgac.arsv.exceptions.ARSVBusinessException;
import cl.dgac.arsv.model.ArsvOACI;

@Remote
public interface OACIServicesRemote {
	public ArsvOACI guardarOACI(ArsvOACI oACI) throws ARSVBusinessException;
	
	public ArsvOACI actualizarOACI(ArsvOACI oACI) throws ARSVBusinessException;
	
	public ArsvOACI buscarOACI(String codigoOACI) throws ARSVBusinessException;
	
	public void eliminarOACI(ArsvOACI oACI) throws ARSVBusinessException;

	public List<ArsvOACI> buscarOACI() throws ARSVBusinessException;
	
}
