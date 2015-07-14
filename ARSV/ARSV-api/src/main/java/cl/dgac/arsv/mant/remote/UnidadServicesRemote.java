package cl.dgac.arsv.mant.remote;

import java.util.List;

import javax.ejb.Remote;

import cl.dgac.arsv.exceptions.ARSVBusinessException;
import cl.dgac.arsv.model.ArsvUnidad;

@Remote
public interface UnidadServicesRemote {
	public ArsvUnidad guardarUnidad(ArsvUnidad arsvUnidad) throws ARSVBusinessException;
	
	public ArsvUnidad actualizarUnidad(ArsvUnidad arsvUnidad) throws ARSVBusinessException;
	
	public ArsvUnidad buscarUnidad(Long idArsvUnidad) throws ARSVBusinessException;
	
	public void eliminarUnidad(ArsvUnidad arsvUnidad) throws ARSVBusinessException;

	public List<ArsvUnidad> buscarUnidad() throws ARSVBusinessException;
	
}
