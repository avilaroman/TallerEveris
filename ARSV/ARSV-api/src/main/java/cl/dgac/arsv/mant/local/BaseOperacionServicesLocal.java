package cl.dgac.arsv.mant.local;

import java.util.List;

import javax.ejb.Local;

import cl.dgac.arsv.exceptions.ARSVBusinessException;
import cl.dgac.arsv.model.ArsvBaseOperacion;

@Local
public interface BaseOperacionServicesLocal {
	public ArsvBaseOperacion guardarBaseOperacion(ArsvBaseOperacion arsvBaseOperacion) throws ARSVBusinessException;
	
	public ArsvBaseOperacion actualizarBaseOperacion(ArsvBaseOperacion arsvBaseOperacion) throws ARSVBusinessException;
	
	public ArsvBaseOperacion buscarBaseOperacion(Long idArsvBaseOperacion) throws ARSVBusinessException;
	
	public void eliminarBaseOperacion(ArsvBaseOperacion arsvBaseOperacion) throws ARSVBusinessException;

	public List<ArsvBaseOperacion> buscarBaseOperacion() throws ARSVBusinessException;
	
}
