package cl.dgac.arsv.mant.WS;

import java.util.List;

import javax.jws.WebService;

import cl.dgac.arsv.exceptions.ARSVBusinessException;
import cl.dgac.arsv.model.ArsvClasificacion;

@WebService
public interface ClasificacionVueloServicesWS {
	public ArsvClasificacion guardarClasificacion(ArsvClasificacion clasificacion) throws ARSVBusinessException;
	
	public ArsvClasificacion actualizarClasificacion(ArsvClasificacion clasificacion) throws ARSVBusinessException;
	
	public ArsvClasificacion buscarClasificacion(Long idClasificacion) throws ARSVBusinessException;
	
	public void eliminarClasificacion(ArsvClasificacion clasificacion) throws ARSVBusinessException;

	public List<ArsvClasificacion> buscarClasificacion() throws ARSVBusinessException;
	
}
