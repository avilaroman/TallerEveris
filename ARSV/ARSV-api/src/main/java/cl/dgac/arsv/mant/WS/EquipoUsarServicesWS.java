package cl.dgac.arsv.mant.WS;

import java.util.List;

import javax.jws.WebService;

import cl.dgac.arsv.exceptions.ARSVBusinessException;
import cl.dgac.arsv.model.ArsvEquipoUsar;

@WebService
public interface EquipoUsarServicesWS {
	public ArsvEquipoUsar guardarEquipoUsar(ArsvEquipoUsar arsvEquipoUsar) throws ARSVBusinessException;
	
	public ArsvEquipoUsar actualizarEquipoUsar(ArsvEquipoUsar arsvEquipoUsar) throws ARSVBusinessException;
	
	public ArsvEquipoUsar buscarEquipoUsar(Long idArsvEquipoUsar) throws ARSVBusinessException;
	
	public void eliminarEquipoUsar(ArsvEquipoUsar arsvEquipoUsar) throws ARSVBusinessException;

	public List<ArsvEquipoUsar> buscarEquipoUsar() throws ARSVBusinessException;
	
}
