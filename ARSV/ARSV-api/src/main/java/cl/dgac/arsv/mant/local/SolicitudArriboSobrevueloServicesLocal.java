package cl.dgac.arsv.mant.local;

import java.util.List;

import javax.ejb.Local;

import cl.dgac.arsv.exceptions.ARSVBusinessException;
import cl.dgac.arsv.model.SolicitudArriboSobrevuelo;

@Local
public interface SolicitudArriboSobrevueloServicesLocal {
	public SolicitudArriboSobrevuelo guardarSolicitudArriboSobrevuelo(SolicitudArriboSobrevuelo solicitudArriboSobrevuelo) throws ARSVBusinessException;
	
	public SolicitudArriboSobrevuelo actualizarSolicitudArriboSobrevuelo(SolicitudArriboSobrevuelo solicitudArriboSobrevuelo) throws ARSVBusinessException;
	
	public SolicitudArriboSobrevuelo buscarSolicitudArriboSobrevuelo(Long idSolicitudArriboSobrevuelo) throws ARSVBusinessException;
	
	public void eliminarSolicitudArriboSobrevuelo(SolicitudArriboSobrevuelo solicitudArriboSobrevuelo) throws ARSVBusinessException;

	public List<SolicitudArriboSobrevuelo> buscarSolicitudArriboSobrevuelo() throws ARSVBusinessException;
	
}
