package cl.dgac.arsv.mant.WS;

import java.util.List;

import javax.jws.WebService;

import cl.dgac.arsv.exceptions.ARSVBusinessException;
import cl.dgac.arsv.model.ArsvEquipoSupervivencia;

@WebService
public interface EquipoSupervivenciaServicesWS {
	public ArsvEquipoSupervivencia guardarEquipoSupervivencia(ArsvEquipoSupervivencia arsvEquipoSupervivencia) throws ARSVBusinessException;
	
	public ArsvEquipoSupervivencia actualizarEquipoSupervivencia(ArsvEquipoSupervivencia arsvEquipoSupervivencia) throws ARSVBusinessException;
	
	public ArsvEquipoSupervivencia buscarEquipoSupervivencia(Long idArsvEquipoSupervivencia) throws ARSVBusinessException;
	
	public void eliminarEquipoSupervivencia(ArsvEquipoSupervivencia arsvEquipoSupervivencia) throws ARSVBusinessException;

	public List<ArsvEquipoSupervivencia> buscarEquipoSupervivencia() throws ARSVBusinessException;
	
}
