package cl.dgac.arsv.mant.local;

import java.util.List;

import javax.ejb.Local;

import cl.dgac.arsv.exceptions.ARSVBusinessException;
import cl.dgac.arsv.model.ArsvEquipoUsar;

@Local
public interface EquipoUsarServicesLocal {
	public ArsvEquipoUsar guardarEquipoUsar(ArsvEquipoUsar arsvEquipoUsar) throws ARSVBusinessException;
	
	public ArsvEquipoUsar actualizarEquipoUsar(ArsvEquipoUsar arsvEquipoUsar) throws ARSVBusinessException;
	
	public ArsvEquipoUsar buscarEquipoUsar(Long idArsvEquipoUsar) throws ARSVBusinessException;
	
	public void eliminarEquipoUsar(ArsvEquipoUsar arsvEquipoUsar) throws ARSVBusinessException;

	public List<ArsvEquipoUsar> buscarEquipoUsar() throws ARSVBusinessException;
	
}
