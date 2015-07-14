package cl.dgac.arsv.mant.remote;

import java.util.List;

import javax.ejb.Remote;

import cl.dgac.arsv.exceptions.ARSVBusinessException;
import cl.dgac.arsv.model.ArsvEquipoSupervivencia;

@Remote
public interface EquipoSupervivenciaServicesRemote {
	public ArsvEquipoSupervivencia guardarEquipoSupervivencia(ArsvEquipoSupervivencia arsvEquipoSupervivencia) throws ARSVBusinessException;
	
	public ArsvEquipoSupervivencia actualizarEquipoSupervivencia(ArsvEquipoSupervivencia arsvEquipoSupervivencia) throws ARSVBusinessException;
	
	public ArsvEquipoSupervivencia buscarEquipoSupervivencia(Long idArsvEquipoSupervivencia) throws ARSVBusinessException;
	
	public void eliminarEquipoSupervivencia(ArsvEquipoSupervivencia arsvEquipoSupervivencia) throws ARSVBusinessException;

	public List<ArsvEquipoSupervivencia> buscarEquipoSupervivencia() throws ARSVBusinessException;
	
}
