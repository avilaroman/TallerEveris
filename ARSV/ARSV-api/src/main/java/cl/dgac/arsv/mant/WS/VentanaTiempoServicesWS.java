package cl.dgac.arsv.mant.WS;

import java.util.List;

import javax.jws.WebService;

import cl.dgac.arsv.exceptions.ARSVBusinessException;
import cl.dgac.arsv.model.ArsvVentanaTiempo;

@WebService
public interface VentanaTiempoServicesWS {
	public ArsvVentanaTiempo guardarVentanaTiempo(ArsvVentanaTiempo arsvVentanaTiempo) throws ARSVBusinessException;
	
	public ArsvVentanaTiempo actualizarVentanaTiempo(ArsvVentanaTiempo arsvVentanaTiempo) throws ARSVBusinessException;
	
	public ArsvVentanaTiempo buscarVentanaTiempo(Long idArsvVentanaTiempo) throws ARSVBusinessException;
	
	public void eliminarVentanaTiempo(ArsvVentanaTiempo arsvVentanaTiempo) throws ARSVBusinessException;

	public List<ArsvVentanaTiempo> buscarVentanaTiempo() throws ARSVBusinessException;
	
}
