package cl.dgac.arsv.mant.remote;

import java.util.List;

import javax.ejb.Remote;

import cl.dgac.arsv.exceptions.ARSVBusinessException;
import cl.dgac.arsv.model.ArsvEstadoSolicitud;

@Remote
public interface EstadoSolicitudServicesRemote {
	public ArsvEstadoSolicitud guardarEstadoSolicitud(ArsvEstadoSolicitud arsvEstadoSolicitud) throws ARSVBusinessException;
	
	public ArsvEstadoSolicitud actualizarEstadoSolicitud(ArsvEstadoSolicitud arsvEstadoSolicitud) throws ARSVBusinessException;
	
	public ArsvEstadoSolicitud buscarEstadoSolicitud(String idArsvEstadoSolicitud) throws ARSVBusinessException;
	
	public void eliminarEstadoSolicitud(ArsvEstadoSolicitud arsvEstadoSolicitud) throws ARSVBusinessException;

	public List<ArsvEstadoSolicitud> buscarEstadoSolicitud() throws ARSVBusinessException;
	
}
