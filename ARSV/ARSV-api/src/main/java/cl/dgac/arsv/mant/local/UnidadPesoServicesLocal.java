package cl.dgac.arsv.mant.local;

import java.util.List;

import javax.ejb.Local;

import cl.dgac.arsv.exceptions.ARSVBusinessException;
import cl.dgac.arsv.model.ArsvUnidadPeso;

@Local
public interface UnidadPesoServicesLocal {
	public ArsvUnidadPeso guardarUnidadPeso(ArsvUnidadPeso unidadPeso) throws ARSVBusinessException;
	
	public ArsvUnidadPeso actualizarUnidadPeso(ArsvUnidadPeso unidadPeso) throws ARSVBusinessException;
	
	public ArsvUnidadPeso buscarUnidadPeso(String codigoUnidadPeso) throws ARSVBusinessException;
	
	public void eliminarUnidadPeso(ArsvUnidadPeso unidadPeso) throws ARSVBusinessException;

	public List<ArsvUnidadPeso> buscarUnidadPeso() throws ARSVBusinessException;
	
}
