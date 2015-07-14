package cl.dgac.arsv.mant.local;

import java.util.List;

import javax.ejb.Local;

import cl.dgac.arsv.exceptions.ARSVBusinessException;
import cl.dgac.arsv.model.ArsvAsignacion;

@Local
public interface AsignacionServicesLocal {
	public ArsvAsignacion guardarAsignacion(ArsvAsignacion arsvAsignacion) throws ARSVBusinessException;
	
	public ArsvAsignacion actualizarAsignacion(ArsvAsignacion arsvAsignacion) throws ARSVBusinessException;
	
	public ArsvAsignacion buscarAsignacion(Long idArsvAsignacion) throws ARSVBusinessException;
	
	public void eliminarAsignacion(ArsvAsignacion arsvAsignacion) throws ARSVBusinessException;

	public List<ArsvAsignacion> buscarAsignacion() throws ARSVBusinessException;
	
}
