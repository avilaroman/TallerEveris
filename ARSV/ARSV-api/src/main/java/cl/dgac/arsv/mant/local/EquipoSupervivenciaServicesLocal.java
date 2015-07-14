package cl.dgac.arsv.mant.local;

import java.util.List;

import javax.ejb.Local;

import cl.dgac.arsv.exceptions.ARSVBusinessException;
import cl.dgac.arsv.model.ArsvEquipoSupervivencia;

@Local
public interface EquipoSupervivenciaServicesLocal {
	public ArsvEquipoSupervivencia guardarEquipoSupervivencia(ArsvEquipoSupervivencia arsvEquipoSupervivencia) throws ARSVBusinessException;
	
	public ArsvEquipoSupervivencia actualizarEquipoSupervivencia(ArsvEquipoSupervivencia arsvEquipoSupervivencia) throws ARSVBusinessException;
	
	public ArsvEquipoSupervivencia buscarEquipoSupervivencia(Long idArsvEquipoSupervivencia) throws ARSVBusinessException;
	
	public void eliminarEquipoSupervivencia(ArsvEquipoSupervivencia arsvEquipoSupervivencia) throws ARSVBusinessException;

	public List<ArsvEquipoSupervivencia> buscarEquipoSupervivencia() throws ARSVBusinessException;
	
}
