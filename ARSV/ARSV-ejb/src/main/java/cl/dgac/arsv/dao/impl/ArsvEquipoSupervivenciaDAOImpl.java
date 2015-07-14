package cl.dgac.arsv.dao.impl;

import java.util.List;

import javax.ejb.Stateless;
import javax.inject.Named;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import cl.dgac.arsv.dao.ArsvEquipoSupervivenciaDAO;
import cl.dgac.arsv.filters.FiltroArsvEquipoSupervivencia;
import cl.dgac.arsv.model.ArsvEquipoSupervivencia;
import cl.dgac.arsv.model.ArsvEquipoSupervivencia_;

@Stateless
@Named(value = "arsvEquipoSupervivenciaDAO")
public class ArsvEquipoSupervivenciaDAOImpl extends BaseDAOImpl<ArsvEquipoSupervivencia, Long, FiltroArsvEquipoSupervivencia> implements ArsvEquipoSupervivenciaDAO {
		
	
	public ArsvEquipoSupervivenciaDAOImpl() {
		super(ArsvEquipoSupervivencia.class);		
	}

	@Override
	public List<ArsvEquipoSupervivencia> findEquiposSupervivencia(FiltroArsvEquipoSupervivencia filtro) {
		return super.findByCriteria(filtro);
	}
	
	@Override
	protected CriteriaQuery<ArsvEquipoSupervivencia> createFilter(FiltroArsvEquipoSupervivencia filtro) {
		CriteriaBuilder cb = entityManager.getCriteriaBuilder();
		Predicate restricciones = null, condicion = null;
		
		CriteriaQuery<ArsvEquipoSupervivencia> cq = cb.createQuery(ArsvEquipoSupervivencia.class);
		Root<ArsvEquipoSupervivencia> equipoSupervivencia = cq.from(ArsvEquipoSupervivencia.class);
		cq.select(equipoSupervivencia);
					
		// Condiciones
		if ((filtro.getCodigo() != null)) {
			condicion = cb.equal(equipoSupervivencia.get(ArsvEquipoSupervivencia_.id), filtro.getCodigo());
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
