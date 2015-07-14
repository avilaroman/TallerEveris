package cl.dgac.arsv.mant.local;

import java.util.List;

import javax.ejb.Local;

import cl.dgac.arsv.exceptions.ARSVBusinessException;
import cl.dgac.arsv.model.ArsvProgramaActividad;

@Local
public interface ProgramaActividadServicesLocal {
	public ArsvProgramaActividad guardarProgramaActividad(ArsvProgramaActividad arsvProgramaActividad) throws ARSVBusinessException;
	
	public ArsvProgramaActividad actualizarProgramaActividad(ArsvProgramaActividad arsvProgramaActividad) throws ARSVBusinessException;
	
	public ArsvProgramaActividad buscarProgramaActividad(Long idArsvProgramaActividad) throws ARSVBusinessException;
	
	public void eliminarProgramaActividad(ArsvProgramaActividad arsvProgramaActividad) throws ARSVBusinessException;

	public List<ArsvProgramaActividad> buscarProgramaActividad() throws ARSVBusinessException;
	
}
