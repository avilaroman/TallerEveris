package cl.dgac.arsv.mant.local;

import java.util.List;

import javax.ejb.Local;

import cl.dgac.arsv.exceptions.ARSVBusinessException;
import cl.dgac.arsv.model.ArsvRuta;

@Local
public interface RutaServicesLocal {
	public ArsvRuta guardarRuta(ArsvRuta arsvRuta) throws ARSVBusinessException;
	
	public ArsvRuta actualizarRuta(ArsvRuta arsvRuta) throws ARSVBusinessException;
	
	public ArsvRuta buscarRuta(Long idArsvRuta) throws ARSVBusinessException;
	
	public void eliminarRuta(ArsvRuta arsvRuta) throws ARSVBusinessException;

	public List<ArsvRuta> buscarRuta() throws ARSVBusinessException;
	
}
