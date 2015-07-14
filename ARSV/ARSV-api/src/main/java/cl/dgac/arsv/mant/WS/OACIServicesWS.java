package cl.dgac.arsv.mant.WS;

import java.util.List;

import javax.jws.WebService;

import cl.dgac.arsv.exceptions.ARSVBusinessException;
import cl.dgac.arsv.model.ArsvOACI;

@WebService
public interface OACIServicesWS {
	public ArsvOACI guardarOACI(ArsvOACI oACI) throws ARSVBusinessException;
	
	public ArsvOACI actualizarOACI(ArsvOACI oACI) throws ARSVBusinessException;
	
	public ArsvOACI buscarOACI(String codigoOACI) throws ARSVBusinessException;
	
	public void eliminarOACI(ArsvOACI oACI) throws ARSVBusinessException;

	public List<ArsvOACI> buscarOACI() throws ARSVBusinessException;
	
}
