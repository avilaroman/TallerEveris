package cl.dgac.arsv.mant.WS;

import java.util.List;

import javax.jws.WebService;

import cl.dgac.arsv.exceptions.ARSVBusinessException;
import cl.dgac.arsv.model.ArsvRuta;

@WebService
public interface RutaServicesWS {
	public ArsvRuta guardarRuta(ArsvRuta arsvRuta) throws ARSVBusinessException;
	
	public ArsvRuta actualizarRuta(ArsvRuta arsvRuta) throws ARSVBusinessException;
	
	public ArsvRuta buscarRuta(Long idArsvRuta) throws ARSVBusinessException;
	
	public void eliminarRuta(ArsvRuta arsvRuta) throws ARSVBusinessException;

	public List<ArsvRuta> buscarRuta() throws ARSVBusinessException;
	
}
