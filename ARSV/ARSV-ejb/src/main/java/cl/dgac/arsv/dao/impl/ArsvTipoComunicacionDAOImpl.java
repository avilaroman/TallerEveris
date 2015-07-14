package cl.dgac.arsv.dao.impl;

import java.util.List;

import javax.ejb.Stateless;
import javax.inject.Named;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import cl.dgac.arsv.dao.ArsvTipoComunicacionDAO;
import cl.dgac.arsv.filters.FiltroArsvTipoComunicacion;
import cl.dgac.arsv.model.ArsvTipoComunicacion;
import cl.dgac.arsv.model.ArsvTipoComunicacion_;

@Stateless
@Named(value = "arsvTipoComunicacionDAO")
public class ArsvTipoComunicacionDAOImpl extends BaseDAOImpl<ArsvTipoComunicacion, Long, FiltroArsvTipoComunicacion> implements ArsvTipoComunicacionDAO {
		
	
	public ArsvTipoComunicacionDAOImpl() {
		super(ArsvTipoComunicacion.class);		
	}

	@Override
	public List<ArsvTipoComunicacion> findTiposComunicacion(FiltroArsvTipoComunicacion filtro) {
		return super.findByCriteria(filtro);
	}
		
	@Override
	protected CriteriaQuery<ArsvTipoComunicacion> createFilter(FiltroArsvTipoComunicacion filtro) {
		CriteriaBuilder cb = entityManager.getCriteriaBuilder();
		Predicate restricciones = null, condicion = null;
		
		CriteriaQuery<ArsvTipoComunicacion> cq = cb.createQuery(ArsvTipoComunicacion.class);
		Root<ArsvTipoComunicacion> tipoComunicacion = cq.from(ArsvTipoComunicacion.class);
		cq.select(tipoComunicacion);
					
		// Condiciones
		if ((filtro.getCodigo() != null)) {
			condicion = cb.equal(tipoComunicacion.get(ArsvTipoComunicacion_.id), filtro.getCodigo());
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
