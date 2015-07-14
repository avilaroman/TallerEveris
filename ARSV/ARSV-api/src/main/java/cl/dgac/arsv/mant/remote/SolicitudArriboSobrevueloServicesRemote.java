package cl.dgac.arsv.mant.remote;

import java.util.List;

import javax.ejb.Remote;

import cl.dgac.arsv.exceptions.ARSVBusinessException;
import cl.dgac.arsv.model.SolicitudArriboSobrevuelo;

@Remote
public interface SolicitudArriboSobrevueloServicesRemote {
	public SolicitudArriboSobrevuelo guardarSolicitudArriboSobrevuelo(SolicitudArriboSobrevuelo solicitudArriboSobrevuelo) throws ARSVBusinessException;
	
	public SolicitudArriboSobrevuelo actualizarSolicitudArriboSobrevuelo(SolicitudArriboSobrevuelo solicitudArriboSobrevuelo) throws ARSVBusinessException;
	
	public SolicitudArriboSobrevuelo buscarSolicitudArriboSobrevuelo(Long idSolicitudArriboSobrevuelo) throws ARSVBusinessException;
	
	public void eliminarSolicitudArriboSobrevuelo(SolicitudArriboSobrevuelo solicitudArriboSobrevuelo) throws ARSVBusinessException;

	public List<SolicitudArriboSobrevuelo> buscarSolicitudArriboSobrevuelo() throws ARSVBusinessException;
	
}
