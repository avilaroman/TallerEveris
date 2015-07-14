package cl.dgac.arsv.mant.remote;

import java.util.List;

import javax.ejb.Remote;

import cl.dgac.arsv.exceptions.ARSVBusinessException;
import cl.dgac.arsv.model.ArsvBaseOperacion;

@Remote
public interface BaseOperacionServicesRemote {
	public ArsvBaseOperacion guardarBaseOperacion(ArsvBaseOperacion arsvBaseOperacion) throws ARSVBusinessException;
	
	public ArsvBaseOperacion actualizarBaseOperacion(ArsvBaseOperacion arsvBaseOperacion) throws ARSVBusinessException;
	
	public ArsvBaseOperacion buscarBaseOperacion(Long idArsvBaseOperacion) throws ARSVBusinessException;
	
	public void eliminarBaseOperacion(ArsvBaseOperacion arsvBaseOperacion) throws ARSVBusinessException;

	public List<ArsvBaseOperacion> buscarBaseOperacion() throws ARSVBusinessException;
	
}
