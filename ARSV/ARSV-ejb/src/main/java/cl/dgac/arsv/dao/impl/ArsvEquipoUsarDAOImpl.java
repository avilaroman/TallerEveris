package cl.dgac.arsv.dao.impl;

import java.util.List;

import javax.ejb.Stateless;
import javax.inject.Named;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import cl.dgac.arsv.dao.ArsvEquipoUsarDAO;
import cl.dgac.arsv.filters.FiltroArsvEquipoUsar;
import cl.dgac.arsv.model.ArsvEquipoUsar;
import cl.dgac.arsv.model.ArsvEquipoUsar_;

@Stateless
@Named(value = "arsvEquipoUsarDAO")
public class ArsvEquipoUsarDAOImpl extends BaseDAOImpl<ArsvEquipoUsar, Long, FiltroArsvEquipoUsar> implements ArsvEquipoUsarDAO {
		
	
	public ArsvEquipoUsarDAOImpl() {
		super(ArsvEquipoUsar.class);		
	}

	@Override
	public List<ArsvEquipoUsar> findEquiposUsar(FiltroArsvEquipoUsar filtro) {
		return super.findByCriteria(filtro);
	}
	
	@Override
	protected CriteriaQuery<ArsvEquipoUsar> createFilter(FiltroArsvEquipoUsar filtro) {
		CriteriaBuilder cb = entityManager.getCriteriaBuilder();
		Predicate restricciones = null, condicion = null;
		
		CriteriaQuery<ArsvEquipoUsar> cq = cb.createQuery(ArsvEquipoUsar.class);
		Root<ArsvEquipoUsar> equipoUsar = cq.from(ArsvEquipoUsar.class);
		cq.select(equipoUsar);
					
		// Condiciones
		if ((filtro.getCodigo() != null)) {
			condicion = cb.equal(equipoUsar.get(ArsvEquipoUsar_.id), filtro.getCodigo());
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
