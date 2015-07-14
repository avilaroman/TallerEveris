package cl.dgac.arsv.mant.local;

import java.util.List;

import javax.ejb.Local;

import cl.dgac.arsv.exceptions.ARSVBusinessException;
import cl.dgac.arsv.model.ArsvUnidad;

@Local
public interface UnidadServicesLocal {
	public ArsvUnidad guardarUnidad(ArsvUnidad arsvUnidad) throws ARSVBusinessException;
	
	public ArsvUnidad actualizarUnidad(ArsvUnidad arsvUnidad) throws ARSVBusinessException;
	
	public ArsvUnidad buscarUnidad(Long idArsvUnidad) throws ARSVBusinessException;
	
	public void eliminarUnidad(ArsvUnidad arsvUnidad) throws ARSVBusinessException;

	public List<ArsvUnidad> buscarUnidad() throws ARSVBusinessException;
	
}
