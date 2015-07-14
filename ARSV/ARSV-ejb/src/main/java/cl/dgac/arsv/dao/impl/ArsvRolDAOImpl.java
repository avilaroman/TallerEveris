package cl.dgac.arsv.dao.impl;

import java.util.List;

import javax.ejb.Stateless;
import javax.inject.Named;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import cl.dgac.arsv.dao.ArsvRolDAO;
import cl.dgac.arsv.filters.FiltroArsvRol;
import cl.dgac.arsv.model.ArsvRol;
import cl.dgac.arsv.model.ArsvRol_;

@Stateless
@Named(value = "arsvRolDAO")
public class ArsvRolDAOImpl extends BaseDAOImpl<ArsvRol, Long, FiltroArsvRol> implements ArsvRolDAO {
		
	
	public ArsvRolDAOImpl() {
		super(ArsvRol.class);		
	}

	@Override
	public List<ArsvRol> findRoles(FiltroArsvRol filtro) {
		return super.findByCriteria(filtro);
	}
		
	@Override
	protected CriteriaQuery<ArsvRol> createFilter(FiltroArsvRol filtro) {
		CriteriaBuilder cb = entityManager.getCriteriaBuilder();
		Predicate restricciones = null, condicion = null;
		
		CriteriaQuery<ArsvRol> cq = cb.createQuery(ArsvRol.class);
		Root<ArsvRol> rol = cq.from(ArsvRol.class);
		cq.select(rol);
					
		// Condiciones
		if ((filtro.getCodigo() != null)) {
			condicion = cb.equal(rol.get(ArsvRol_.roleIdRol), filtro.getCodigo());
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
