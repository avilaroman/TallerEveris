package cl.dgac.arsv.mant.local;

import java.util.List;

import javax.ejb.Local;

import cl.dgac.arsv.exceptions.ARSVBusinessException;
import cl.dgac.arsv.model.ArsvEstadoSolicitud;

@Local
public interface EstadoSolicitudServicesLocal {
	public ArsvEstadoSolicitud guardarEstadoSolicitud(ArsvEstadoSolicitud arsvEstadoSolicitud) throws ARSVBusinessException;
	
	public ArsvEstadoSolicitud actualizarEstadoSolicitud(ArsvEstadoSolicitud arsvEstadoSolicitud) throws ARSVBusinessException;
	
	public ArsvEstadoSolicitud buscarEstadoSolicitud(String idArsvEstadoSolicitud) throws ARSVBusinessException;
	
	public void eliminarEstadoSolicitud(ArsvEstadoSolicitud arsvEstadoSolicitud) throws ARSVBusinessException;

	public List<ArsvEstadoSolicitud> buscarEstadoSolicitud() throws ARSVBusinessException;
	
}
