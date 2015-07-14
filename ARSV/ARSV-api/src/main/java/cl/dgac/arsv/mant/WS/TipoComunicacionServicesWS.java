package cl.dgac.arsv.mant.WS;

import java.util.List;

import javax.jws.WebService;

import cl.dgac.arsv.exceptions.ARSVBusinessException;
import cl.dgac.arsv.model.ArsvTipoComunicacion;

@WebService
public interface TipoComunicacionServicesWS {
	public ArsvTipoComunicacion guardarTipoComunicacion(ArsvTipoComunicacion arsvTipoComunicacion) throws ARSVBusinessException;
	
	public ArsvTipoComunicacion actualizarTipoComunicacion(ArsvTipoComunicacion arsvTipoComunicacion) throws ARSVBusinessException;
	
	public ArsvTipoComunicacion buscarTipoComunicacion(Long idArsvTipoComunicacion) throws ARSVBusinessException;
	
	public void eliminarTipoComunicacion(ArsvTipoComunicacion arsvTipoComunicacion) throws ARSVBusinessException;

	public List<ArsvTipoComunicacion> buscarUnidad() throws ARSVBusinessException;
	
}
