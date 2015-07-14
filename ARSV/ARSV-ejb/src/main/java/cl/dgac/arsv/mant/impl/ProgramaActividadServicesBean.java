package cl.dgac.arsv.mant.impl;
import java.util.List;

import javax.ejb.Stateless;

import org.apache.log4j.Logger;

import cl.dgac.arsv.dao.ArsvProgramaActividadDAO;
import cl.dgac.arsv.exceptions.ARSVBusinessException;
import cl.dgac.arsv.mant.local.ProgramaActividadServicesLocal;
import cl.dgac.arsv.mant.remote.ProgramaActividadServicesRemote;
import cl.dgac.arsv.model.ArsvProgramaActividad;


@Stateless(name = "programaActividadServicesBean")
public class ProgramaActividadServicesBean implements ProgramaActividadServicesLocal, ProgramaActividadServicesRemote {

	public static final Logger log = Logger.getLogger(ProgramaActividadServicesBean.class);
	
	private ArsvProgramaActividadDAO arsvProgramaActividadDAO;
		
	public ProgramaActividadServicesBean() {
		super();
	}

	public ArsvProgramaActividad guardarProgramaActividad(ArsvProgramaActividad arsvProgramaActividad) throws ARSVBusinessException {
		try {
			return this.arsvProgramaActividadDAO.save(arsvProgramaActividad);
		} catch (Exception e) {
			log.error(e.getMessage());
			throw new ARSVBusinessException(e.getMessage());
		}
	}
	
	public ArsvProgramaActividad actualizarProgramaActividad(ArsvProgramaActividad arsvProgramaActividad) throws ARSVBusinessException {
		try {
			return this.arsvProgramaActividadDAO.update(arsvProgramaActividad);
		} catch (Exception e) {
			log.error(e.getMessage());
			throw new ARSVBusinessException(e.getMessage());
		}
	}
	
	public ArsvProgramaActividad buscarProgramaActividad(Long idArsvProgramaActividad) throws ARSVBusinessException {
		try {
			return this.arsvProgramaActividadDAO.findById(idArsvProgramaActividad);
		} catch (Exception e) {
			log.error(e.getMessage());
			throw new ARSVBusinessException(e.getMessage());
		}
	}
	
	public void eliminarProgramaActividad(ArsvProgramaActividad arsvProgramaActividad) throws ARSVBusinessException {
		try {
			this.arsvProgramaActividadDAO.remove(arsvProgramaActividad);
		} catch (Exception e) {
			log.error(e.getMessage());
			throw new ARSVBusinessException(e.getMessage());
		}
	}
	
	public List<ArsvProgramaActividad> buscarProgramaActividad() throws ARSVBusinessException {
		try {
			return this.arsvProgramaActividadDAO.findAll();
		} catch (Exception e) {
			log.error(e.getMessage());
			throw new ARSVBusinessException(e.getMessage());
		}
	}
}