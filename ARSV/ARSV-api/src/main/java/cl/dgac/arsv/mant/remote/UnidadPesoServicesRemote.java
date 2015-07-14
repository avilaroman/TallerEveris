package cl.dgac.arsv.mant.remote;

import java.util.List;

import javax.ejb.Remote;

import cl.dgac.arsv.exceptions.ARSVBusinessException;
import cl.dgac.arsv.model.ArsvUnidadPeso;

@Remote
public interface UnidadPesoServicesRemote {
	public ArsvUnidadPeso guardarUnidadPeso(ArsvUnidadPeso unidadPeso) throws ARSVBusinessException;
	
	public ArsvUnidadPeso actualizarUnidadPeso(ArsvUnidadPeso unidadPeso) throws ARSVBusinessException;
	
	public ArsvUnidadPeso buscarUnidadPeso(String codigoUnidadPeso) throws ARSVBusinessException;
	
	public void eliminarUnidadPeso(ArsvUnidadPeso unidadPeso) throws ARSVBusinessException;

	public List<ArsvUnidadPeso> buscarUnidadPeso() throws ARSVBusinessException;
	
}
