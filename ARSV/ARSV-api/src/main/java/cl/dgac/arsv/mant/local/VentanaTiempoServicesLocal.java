package cl.dgac.arsv.mant.local;

import java.util.List;

import javax.ejb.Local;

import cl.dgac.arsv.exceptions.ARSVBusinessException;
import cl.dgac.arsv.model.ArsvVentanaTiempo;

@Local
public interface VentanaTiempoServicesLocal {
	public ArsvVentanaTiempo guardarVentanaTiempo(ArsvVentanaTiempo arsvVentanaTiempo) throws ARSVBusinessException;
	
	public ArsvVentanaTiempo actualizarVentanaTiempo(ArsvVentanaTiempo arsvVentanaTiempo) throws ARSVBusinessException;
	
	public ArsvVentanaTiempo buscarVentanaTiempo(Long idArsvVentanaTiempo) throws ARSVBusinessException;
	
	public void eliminarVentanaTiempo(ArsvVentanaTiempo arsvVentanaTiempo) throws ARSVBusinessException;

	public List<ArsvVentanaTiempo> buscarVentanaTiempo() throws ARSVBusinessException;
	
}
