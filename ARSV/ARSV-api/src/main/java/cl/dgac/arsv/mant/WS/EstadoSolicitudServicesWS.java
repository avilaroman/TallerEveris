package cl.dgac.arsv.mant.WS;

import java.util.List;

import javax.jws.WebService;

import cl.dgac.arsv.exceptions.ARSVBusinessException;
import cl.dgac.arsv.model.ArsvEstadoSolicitud;

@WebService
public interface EstadoSolicitudServicesWS {
	public ArsvEstadoSolicitud guardarEstadoSolicitud(ArsvEstadoSolicitud arsvEstadoSolicitud) throws ARSVBusinessException;
	
	public ArsvEstadoSolicitud actualizarEstadoSolicitud(ArsvEstadoSolicitud arsvEstadoSolicitud) throws ARSVBusinessException;
	
	public ArsvEstadoSolicitud buscarEstadoSolicitud(Long idArsvEstadoSolicitud) throws ARSVBusinessException;
	
	public void eliminarEstadoSolicitud(ArsvEstadoSolicitud arsvEstadoSolicitud) throws ARSVBusinessException;

	public List<ArsvEstadoSolicitud> buscarEstadoSolicitud() throws ARSVBusinessException;
	
}
