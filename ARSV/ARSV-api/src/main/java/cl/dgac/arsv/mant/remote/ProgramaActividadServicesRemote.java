package cl.dgac.arsv.mant.remote;

import java.util.List;

import javax.ejb.Remote;

import cl.dgac.arsv.exceptions.ARSVBusinessException;
import cl.dgac.arsv.model.ArsvProgramaActividad;

@Remote
public interface ProgramaActividadServicesRemote {
	public ArsvProgramaActividad guardarProgramaActividad(ArsvProgramaActividad arsvProgramaActividad) throws ARSVBusinessException;
	
	public ArsvProgramaActividad actualizarProgramaActividad(ArsvProgramaActividad arsvProgramaActividad) throws ARSVBusinessException;
	
	public ArsvProgramaActividad buscarProgramaActividad(Long idArsvProgramaActividad) throws ARSVBusinessException;
	
	public void eliminarProgramaActividad(ArsvProgramaActividad arsvProgramaActividad) throws ARSVBusinessException;

	public List<ArsvProgramaActividad> buscarProgramaActividad() throws ARSVBusinessException;
	
}
