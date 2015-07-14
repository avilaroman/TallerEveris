package cl.dgac.arsv.mant.remote;

import java.util.List;

import javax.ejb.Remote;

import cl.dgac.arsv.exceptions.ARSVBusinessException;
import cl.dgac.arsv.model.ArsvClasificacion;

@Remote
public interface ClasificacionVueloServicesRemote {
	public ArsvClasificacion guardarClasificacion(ArsvClasificacion clasificacion) throws ARSVBusinessException;
	
	public ArsvClasificacion actualizarClasificacion(ArsvClasificacion clasificacion) throws ARSVBusinessException;
	
	public ArsvClasificacion buscarClasificacion(Long idClasificacion) throws ARSVBusinessException;
	
	public void eliminarClasificacion(ArsvClasificacion clasificacion) throws ARSVBusinessException;

	public List<ArsvClasificacion> buscarClasificacion() throws ARSVBusinessException;
	
}
