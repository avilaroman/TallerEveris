package cl.dgac.arsv.mant.local;

import java.util.List;

import javax.ejb.Local;

import cl.dgac.arsv.exceptions.ARSVBusinessException;
import cl.dgac.arsv.model.ArsvTipoComunicacion;

@Local
public interface TipoComunicacionServicesLocal {
	public ArsvTipoComunicacion guardarTipoComunicacion(ArsvTipoComunicacion arsvTipoComunicacion) throws ARSVBusinessException;
	
	public ArsvTipoComunicacion actualizarTipoComunicacion(ArsvTipoComunicacion arsvTipoComunicacion) throws ARSVBusinessException;
	
	public ArsvTipoComunicacion buscarTipoComunicacion(Long idArsvTipoComunicacion) throws ARSVBusinessException;
	
	public void eliminarTipoComunicacion(ArsvTipoComunicacion arsvTipoComunicacion) throws ARSVBusinessException;

	public List<ArsvTipoComunicacion> buscarTipoComunicacion() throws ARSVBusinessException;
	
}
