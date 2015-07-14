package cl.dgac.arsv.dao.impl;

import java.util.List;

import javax.ejb.Stateless;
import javax.inject.Named;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import cl.dgac.arsv.dao.ArsvSeguridadDAO;
import cl.dgac.arsv.filters.FiltroArsvSeguridad;
import cl.dgac.arsv.model.ArsvSeguridad;
import cl.dgac.arsv.model.ArsvSeguridad_;

@Stateless
@Named(value = "arsvSeguridadDAO")
public class ArsvSeguridadDAOImpl extends BaseDAOImpl<ArsvSeguridad, Long, FiltroArsvSeguridad> implements ArsvSeguridadDAO {
		
	
	public ArsvSeguridadDAOImpl() {
		super(ArsvSeguridad.class);		
	}

	@Override
	public List<ArsvSeguridad> findSeguridades(FiltroArsvSeguridad filtro) {
		return super.findByCriteria(filtro);
	}
		
	@Override
	protected CriteriaQuery<ArsvSeguridad> createFilter(FiltroArsvSeguridad filtro) {
		CriteriaBuilder cb = entityManager.getCriteriaBuilder();
		Predicate restricciones = null, condicion = null;
		
		CriteriaQuery<ArsvSeguridad> cq = cb.createQuery(ArsvSeguridad.class);
		Root<ArsvSeguridad> seguridad = cq.from(ArsvSeguridad.class);
		cq.select(seguridad);
					
		// Condiciones
		if ((filtro.getUsuario() != null && !filtro.getUsuario().equals(0L))) {
			condicion = cb.equal(seguridad.get(ArsvSeguridad_.usuario), filtro.getUsuario());
			
			restricciones = condicion;
		}		

		if ((filtro.getToken() != null)) {
			condicion = cb.equal(seguridad.get(ArsvSeguridad_.token), ("".equals(filtro.getToken())) ? null : filtro.getToken());

			if (restricciones == null)
				restricciones = condicion;
			else
				restricciones = cb.and(restricciones, condicion);
		}
		
		if (restricciones != null)
			cq.where(restricciones);
		
		return cq;
	}
	
}
