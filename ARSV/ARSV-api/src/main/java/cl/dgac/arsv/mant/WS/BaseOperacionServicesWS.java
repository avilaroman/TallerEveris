package cl.dgac.arsv.mant.WS;

import java.util.List;

import javax.jws.WebService;

import cl.dgac.arsv.exceptions.ARSVBusinessException;
import cl.dgac.arsv.model.ArsvBaseOperacion;

@WebService
public interface BaseOperacionServicesWS {
	public ArsvBaseOperacion guardarBaseOperacion(ArsvBaseOperacion arsvBaseOperacion) throws ARSVBusinessException;
	
	public ArsvBaseOperacion actualizarBaseOperacion(ArsvBaseOperacion arsvBaseOperacion) throws ARSVBusinessException;
	
	public ArsvBaseOperacion buscarBaseOperacion(Long idArsvBaseOperacion) throws ARSVBusinessException;
	
	public void eliminarBaseOperacion(ArsvBaseOperacion arsvBaseOperacion) throws ARSVBusinessException;

	public List<ArsvBaseOperacion> buscarBaseOperacion() throws ARSVBusinessException;
	
}
