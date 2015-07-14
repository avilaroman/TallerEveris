package cl.dgac.arsv.mant.WS;

import java.util.List;

import javax.jws.WebService;

import cl.dgac.arsv.exceptions.ARSVBusinessException;
import cl.dgac.arsv.model.ArsvPaisOrigen;

@WebService
public interface PaisOrigenServicesWS {
	public ArsvPaisOrigen guardarPaisOrigen(ArsvPaisOrigen paisOrigen) throws ARSVBusinessException;
	
	public ArsvPaisOrigen actualizarPaisOrigen(ArsvPaisOrigen paisOrigen) throws ARSVBusinessException;
	
	public ArsvPaisOrigen buscarPaisOrigen(Long idPaisOrigen) throws ARSVBusinessException;
	
	public void eliminarPaisOrigen(ArsvPaisOrigen paisOrigen) throws ARSVBusinessException;

	public List<ArsvPaisOrigen> buscarPaisOrigen() throws ARSVBusinessException;
	
}
