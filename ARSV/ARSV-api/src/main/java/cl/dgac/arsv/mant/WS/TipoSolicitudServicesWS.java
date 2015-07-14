package cl.dgac.arsv.mant.WS;

import java.util.List;

import javax.jws.WebService;

import cl.dgac.arsv.exceptions.ARSVBusinessException;
import cl.dgac.arsv.model.ArsvTipoSolicitud;

@WebService
public interface TipoSolicitudServicesWS {
	public ArsvTipoSolicitud guardarTipoSolicitud(ArsvTipoSolicitud arsvTipoSolicitud) throws ARSVBusinessException;
	
	public ArsvTipoSolicitud actualizarTipoSolicitud(ArsvTipoSolicitud arsvTipoSolicitud) throws ARSVBusinessException;
	
	public ArsvTipoSolicitud buscarTipoSolicitud(String idArsvTipoSolicitud) throws ARSVBusinessException;
	
	public void eliminarTipoSolicitud(ArsvTipoSolicitud arsvTipoSolicitud) throws ARSVBusinessException;

	public List<ArsvTipoSolicitud> buscarTipoSolicitud() throws ARSVBusinessException;
	
}
