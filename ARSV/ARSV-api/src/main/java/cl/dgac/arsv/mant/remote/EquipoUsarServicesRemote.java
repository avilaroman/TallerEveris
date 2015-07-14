package cl.dgac.arsv.mant.remote;

import java.util.List;

import javax.ejb.Remote;

import cl.dgac.arsv.exceptions.ARSVBusinessException;
import cl.dgac.arsv.model.ArsvEquipoUsar;

@Remote
public interface EquipoUsarServicesRemote {
	public ArsvEquipoUsar guardarEquipoUsar(ArsvEquipoUsar arsvEquipoUsar) throws ARSVBusinessException;
	
	public ArsvEquipoUsar actualizarEquipoUsar(ArsvEquipoUsar arsvEquipoUsar) throws ARSVBusinessException;
	
	public ArsvEquipoUsar buscarEquipoUsar(Long idArsvEquipoUsar) throws ARSVBusinessException;
	
	public void eliminarEquipoUsar(ArsvEquipoUsar arsvEquipoUsar) throws ARSVBusinessException;

	public List<ArsvEquipoUsar> buscarEquipoUsar() throws ARSVBusinessException;
	
}
