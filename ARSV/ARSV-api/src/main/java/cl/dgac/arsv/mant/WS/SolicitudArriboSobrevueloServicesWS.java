package cl.dgac.arsv.mant.WS;

import java.util.List;

import javax.jws.WebService;

import cl.dgac.arsv.exceptions.ARSVBusinessException;
import cl.dgac.arsv.model.SolicitudArriboSobrevuelo;

@WebService
public interface SolicitudArriboSobrevueloServicesWS {
	public SolicitudArriboSobrevuelo guardarSolicitudArriboSobrevuelo(SolicitudArriboSobrevuelo solicitudArriboSobrevuelo) throws ARSVBusinessException;
	
	public SolicitudArriboSobrevuelo actualizarSolicitudArriboSobrevuelo(SolicitudArriboSobrevuelo solicitudArriboSobrevuelo) throws ARSVBusinessException;
	
	public SolicitudArriboSobrevuelo buscarSolicitudArriboSobrevuelo(Long idSolicitudArriboSobrevuelo) throws ARSVBusinessException;
	
	public void eliminarSolicitudArriboSobrevuelo(SolicitudArriboSobrevuelo solicitudArriboSobrevuelo) throws ARSVBusinessException;

	public List<SolicitudArriboSobrevuelo> buscarSolicitudArriboSobrevuelo() throws ARSVBusinessException;
	
}
