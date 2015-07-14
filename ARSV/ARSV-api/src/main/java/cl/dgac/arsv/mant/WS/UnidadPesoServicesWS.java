package cl.dgac.arsv.mant.WS;

import java.util.List;

import javax.jws.WebService;

import cl.dgac.arsv.exceptions.ARSVBusinessException;
import cl.dgac.arsv.model.ArsvUnidadPeso;

@WebService
public interface UnidadPesoServicesWS {
	public ArsvUnidadPeso guardarUnidadPeso(ArsvUnidadPeso unidadPeso) throws ARSVBusinessException;
	
	public ArsvUnidadPeso actualizarUnidadPeso(ArsvUnidadPeso unidadPeso) throws ARSVBusinessException;
	
	public ArsvUnidadPeso buscarUnidadPeso(String codigoUnidadPeso) throws ARSVBusinessException;
	
	public void eliminarUnidadPeso(ArsvUnidadPeso unidadPeso) throws ARSVBusinessException;

	public List<ArsvUnidadPeso> buscarUnidadPeso() throws ARSVBusinessException;
	
}
