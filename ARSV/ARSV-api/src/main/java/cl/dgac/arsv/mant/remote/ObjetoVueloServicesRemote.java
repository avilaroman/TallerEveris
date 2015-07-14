package cl.dgac.arsv.mant.remote;

import java.util.List;

import javax.ejb.Remote;

import cl.dgac.arsv.exceptions.ARSVBusinessException;
import cl.dgac.arsv.model.ArsvObjetoVuelo;

@Remote
public interface ObjetoVueloServicesRemote {
	public ArsvObjetoVuelo guardarObjetoVuelo(ArsvObjetoVuelo objetoVuelo) throws ARSVBusinessException;
	
	public ArsvObjetoVuelo actualizarObjetoVuelo(ArsvObjetoVuelo objetoVuelo) throws ARSVBusinessException;
	
	public ArsvObjetoVuelo buscarObjetoVuelo(Long idObjetoVuelo) throws ARSVBusinessException;
	
	public void eliminarObjetoVuelo(ArsvObjetoVuelo objetoVuelo) throws ARSVBusinessException;

	public List<ArsvObjetoVuelo> buscarObjetoVuelo() throws ARSVBusinessException;
	
}
