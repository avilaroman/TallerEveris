package cl.dgac.arsv.mant.remote;

import java.util.List;

import javax.ejb.Remote;

import cl.dgac.arsv.exceptions.ARSVBusinessException;
import cl.dgac.arsv.model.ArsvVentanaTiempo;

@Remote
public interface VentanaTiempoServicesRemote {
	public ArsvVentanaTiempo guardarVentanaTiempo(ArsvVentanaTiempo arsvVentanaTiempo) throws ARSVBusinessException;
	
	public ArsvVentanaTiempo actualizarVentanaTiempo(ArsvVentanaTiempo arsvVentanaTiempo) throws ARSVBusinessException;
	
	public ArsvVentanaTiempo buscarVentanaTiempo(Long idArsvVentanaTiempo) throws ARSVBusinessException;
	
	public void eliminarVentanaTiempo(ArsvVentanaTiempo arsvVentanaTiempo) throws ARSVBusinessException;

	public List<ArsvVentanaTiempo> buscarVentanaTiempo() throws ARSVBusinessException;
	
}
