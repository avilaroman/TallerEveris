package cl.dgac.arsv.mant.WS;

import java.util.List;

import javax.jws.WebService;

import cl.dgac.arsv.exceptions.ARSVBusinessException;
import cl.dgac.arsv.model.ArsvObjetoVuelo;

@WebService
public interface ObjetoVueloServicesWS {
	public ArsvObjetoVuelo guardarObjetoVuelo(ArsvObjetoVuelo objetoVuelo) throws ARSVBusinessException;
	
	public ArsvObjetoVuelo actualizarObjetoVuelo(ArsvObjetoVuelo objetoVuelo) throws ARSVBusinessException;
	
	public ArsvObjetoVuelo buscarObjetoVuelo(Long idObjetoVuelo) throws ARSVBusinessException;
	
	public void eliminarObjetoVuelo(ArsvObjetoVuelo objetoVuelo) throws ARSVBusinessException;

	public List<ArsvObjetoVuelo> buscarObjetoVuelo() throws ARSVBusinessException;
	
}
