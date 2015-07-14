package cl.dgac.arsv.mant.WS;

import java.util.List;

import javax.jws.WebService;

import cl.dgac.arsv.exceptions.ARSVBusinessException;
import cl.dgac.arsv.model.ArsvUnidad;

@WebService
public interface UnidadServicesWS {
	public ArsvUnidad guardarUnidad(ArsvUnidad arsvUnidad) throws ARSVBusinessException;
	
	public ArsvUnidad actualizarUnidad(ArsvUnidad arsvUnidad) throws ARSVBusinessException;
	
	public ArsvUnidad buscarUnidad(Long idArsvUnidad) throws ARSVBusinessException;
	
	public void eliminarUnidad(ArsvUnidad arsvUnidad) throws ARSVBusinessException;

	public List<ArsvUnidad> buscarUnidad() throws ARSVBusinessException;
	
}
