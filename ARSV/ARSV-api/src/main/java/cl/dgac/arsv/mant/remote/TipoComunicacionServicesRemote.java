package cl.dgac.arsv.mant.remote;

import java.util.List;

import javax.ejb.Remote;

import cl.dgac.arsv.exceptions.ARSVBusinessException;
import cl.dgac.arsv.model.ArsvTipoComunicacion;

@Remote
public interface TipoComunicacionServicesRemote {
	public ArsvTipoComunicacion guardarTipoComunicacion(ArsvTipoComunicacion arsvTipoComunicacion) throws ARSVBusinessException;
	
	public ArsvTipoComunicacion actualizarTipoComunicacion(ArsvTipoComunicacion arsvTipoComunicacion) throws ARSVBusinessException;
	
	public ArsvTipoComunicacion buscarTipoComunicacion(Long idArsvTipoComunicacion) throws ARSVBusinessException;
	
	public void eliminarTipoComunicacion(ArsvTipoComunicacion arsvTipoComunicacion) throws ARSVBusinessException;

	public List<ArsvTipoComunicacion> buscarTipoComunicacion() throws ARSVBusinessException;
	
}
