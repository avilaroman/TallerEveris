package cl.dgac.arsv.mant.WS;

import java.util.List;

import javax.jws.WebService;

import cl.dgac.arsv.exceptions.ARSVBusinessException;
import cl.dgac.arsv.model.ArsvProgramaActividad;

@WebService
public interface ProgramaActividadServicesWS {
	public ArsvProgramaActividad guardarProgramaActividad(ArsvProgramaActividad arsvProgramaActividad) throws ARSVBusinessException;
	
	public ArsvProgramaActividad actualizarProgramaActividad(ArsvProgramaActividad arsvProgramaActividad) throws ARSVBusinessException;
	
	public ArsvProgramaActividad buscarProgramaActividad(Long idArsvProgramaActividad) throws ARSVBusinessException;
	
	public void eliminarProgramaActividad(ArsvProgramaActividad arsvProgramaActividad) throws ARSVBusinessException;

	public List<ArsvProgramaActividad> buscarProgramaActividad() throws ARSVBusinessException;
	
}
