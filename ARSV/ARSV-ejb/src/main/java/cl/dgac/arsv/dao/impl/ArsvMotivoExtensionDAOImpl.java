package cl.dgac.arsv.dao.impl;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.Stateless;
import javax.inject.Named;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Order;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import cl.dgac.arsv.dao.ArsvMotivoExtensionDAO;
import cl.dgac.arsv.filters.FiltroArsvMotivoExtension;
import cl.dgac.arsv.model.ArsvMotivoExtension;
import cl.dgac.arsv.model.ArsvMotivoExtension_;

@Stateless
@Named(value = "arsvMotivoExtensionDAO")
public class ArsvMotivoExtensionDAOImpl extends BaseDAOImpl<ArsvMotivoExtension, Long, FiltroArsvMotivoExtension> implements ArsvMotivoExtensionDAO {
	
	
	public ArsvMotivoExtensionDAOImpl() {
		super(ArsvMotivoExtension.class);		
	}

	@Override
	public List<ArsvMotivoExtension> findMotivosExtension(FiltroArsvMotivoExtension filtro) {
		return super.findByCriteria(filtro);
	}
		
	@Override
	protected CriteriaQuery<ArsvMotivoExtension> createFilter(FiltroArsvMotivoExtension filtro) {
		CriteriaBuilder cb = entityManager.getCriteriaBuilder();
		Predicate restricciones = null, condicion = null;
		
		CriteriaQuery<ArsvMotivoExtension> cq = cb.createQuery(ArsvMotivoExtension.class);
		Root<ArsvMotivoExtension> motivoExtension = cq.from(ArsvMotivoExtension.class);
		cq.select(motivoExtension);
					
		// Condiciones
		if ((filtro.getCodigo() != null)) {
			condicion = cb.equal(motivoExtension.get(ArsvMotivoExtension_.id), filtro.getCodigo());
//			
//			if (restricciones == null)
				restricciones = condicion;
//			else 
//				restricciones = cb.and(restricciones, condicion);			
		}		
		
		if (restricciones != null)
			cq.where(restricciones);
		
		// Ordenes
		List<Order> orderBy = new ArrayList<Order>();		
		
		if (filtro.isDescripcionOrdenar())
			orderBy.add(cb.asc(motivoExtension.get(ArsvMotivoExtension_.descripcion)));
		
		if (orderBy.size() > 0)
			cq.orderBy(orderBy);
		
		return cq;
	}
	
}
