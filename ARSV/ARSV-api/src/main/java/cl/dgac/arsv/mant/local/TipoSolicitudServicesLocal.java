package cl.dgac.arsv.mant.local;

import java.util.List;

import javax.ejb.Local;

import cl.dgac.arsv.exceptions.ARSVBusinessException;
import cl.dgac.arsv.model.ArsvTipoSolicitud;

@Local
public interface TipoSolicitudServicesLocal {
	public ArsvTipoSolicitud guardarTipoSolicitud(ArsvTipoSolicitud arsvTipoSolicitud) throws ARSVBusinessException;
	
	public ArsvTipoSolicitud actualizarTipoSolicitud(ArsvTipoSolicitud arsvTipoSolicitud) throws ARSVBusinessException;
	
	public ArsvTipoSolicitud buscarTipoSolicitud(String idArsvTipoSolicitud) throws ARSVBusinessException;
	
	public void eliminarTipoSolicitud(ArsvTipoSolicitud arsvTipoSolicitud) throws ARSVBusinessException;

	public List<ArsvTipoSolicitud> buscarTipoSolicitud() throws ARSVBusinessException;
	
}
