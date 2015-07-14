package cl.dgac.arsv.mant.remote;

import java.util.List;

import javax.ejb.Remote;

import cl.dgac.arsv.exceptions.ARSVBusinessException;
import cl.dgac.arsv.model.ArsvTipoSolicitud;

@Remote
public interface TipoSolicitudServicesRemote {
	public ArsvTipoSolicitud guardarTipoSolicitud(ArsvTipoSolicitud arsvTipoSolicitud) throws ARSVBusinessException;
	
	public ArsvTipoSolicitud actualizarTipoSolicitud(ArsvTipoSolicitud arsvTipoSolicitud) throws ARSVBusinessException;
	
	public ArsvTipoSolicitud buscarTipoSolicitud(String idArsvTipoSolicitud) throws ARSVBusinessException;
	
	public void eliminarTipoSolicitud(ArsvTipoSolicitud arsvTipoSolicitud) throws ARSVBusinessException;

	public List<ArsvTipoSolicitud> buscarTipoSolicitud() throws ARSVBusinessException;
	
}
