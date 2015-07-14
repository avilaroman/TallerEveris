package cl.dgac.arsv.dao.impl;

import java.util.List;

import javax.ejb.Stateless;
import javax.inject.Named;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import cl.dgac.arsv.dao.ArsvProgramaActividadDAO;
import cl.dgac.arsv.filters.FiltroArsvProgramaActividad;
import cl.dgac.arsv.model.ArsvProgramaActividad;
import cl.dgac.arsv.model.ArsvProgramaActividad_;

@Stateless
@Named(value = "arsvProgramaActividadDAO")
public class ArsvProgramaActividadDAOImpl extends BaseDAOImpl<ArsvProgramaActividad, Long, FiltroArsvProgramaActividad> implements ArsvProgramaActividadDAO {
		
	
	public ArsvProgramaActividadDAOImpl() {
		super(ArsvProgramaActividad.class);		
	}

	@Override
	public List<ArsvProgramaActividad> findProgramasActividad(FiltroArsvProgramaActividad filtro) {
		return super.findByCriteria(filtro);
	}
		
	@Override
	protected CriteriaQuery<ArsvProgramaActividad> createFilter(FiltroArsvProgramaActividad filtro) {
		CriteriaBuilder cb = entityManager.getCriteriaBuilder();
		Predicate restricciones = null, condicion = null;
							
		CriteriaQuery<ArsvProgramaActividad> cq = cb.createQuery(ArsvProgramaActividad.class);
		Root<ArsvProgramaActividad> programaActividad = cq.from(ArsvProgramaActividad.class);
		cq.select(programaActividad);
					
		// Condiciones
		if ((filtro.getCodigo() != null)) {
			condicion = cb.equal(programaActividad.get(ArsvProgramaActividad_.id), filtro.getCodigo());
//			
//			if (restricciones == null)
				restricciones = condicion;
//			else 
//				restricciones = cb.and(restricciones, condicion);			
		}		
		
		if (restricciones != null)
			cq.where(restricciones);
		
		return cq;
	}
	
}
