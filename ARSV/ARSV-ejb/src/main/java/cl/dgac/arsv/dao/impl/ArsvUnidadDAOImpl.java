package cl.dgac.arsv.dao.impl;

import java.util.List;

import javax.ejb.Stateless;
import javax.inject.Named;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import cl.dgac.arsv.dao.ArsvUnidadDAO;
import cl.dgac.arsv.filters.FiltroArsvUnidad;
import cl.dgac.arsv.model.ArsvUnidad;
import cl.dgac.arsv.model.ArsvUnidad_;

@Stateless
@Named(value = "arsvUnidadDAO")
public class ArsvUnidadDAOImpl extends BaseDAOImpl<ArsvUnidad, Long, FiltroArsvUnidad> implements ArsvUnidadDAO {
		
	
	public ArsvUnidadDAOImpl() {
		super(ArsvUnidad.class);		
	}

	@Override
	public List<ArsvUnidad> findUnidades(FiltroArsvUnidad filtro) {
		return super.findByCriteria(filtro);
	}
		
	@Override
	protected CriteriaQuery<ArsvUnidad> createFilter(FiltroArsvUnidad filtro) {
		CriteriaBuilder cb = entityManager.getCriteriaBuilder();
		Predicate restricciones = null, condicion = null;
		
		CriteriaQuery<ArsvUnidad> cq = cb.createQuery(ArsvUnidad.class);
		Root<ArsvUnidad> unidad = cq.from(ArsvUnidad.class);
		cq.select(unidad);
					
		// Condiciones
		if ((filtro.getIdUnidad() != null)) {
			condicion = cb.equal(unidad.get(ArsvUnidad_.id), filtro.getIdUnidad());
//			
//			if (restricciones == null)
				restricciones = condicion;
//			else 
//				restricciones = cb.and(restricciones, condicion);			
		}		
		
//		if ((filtro.getIdGrupo() != null)) {
//			condicion = cb.equal(unidad.get(ArsvUnidad_.arsvGruposUsuario).get(ArsvGrupoUsuario_.grupIdGrupo), filtro.getIdGrupo());
//			
//			if (restricciones == null)
//				restricciones = condicion;
//			else 
//				restricciones = cb.and(restricciones, condicion);			
//		}	
//		
		if (restricciones != null)
			cq.where(restricciones);
		
		return cq;
	}
	
}
