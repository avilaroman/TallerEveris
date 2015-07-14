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

import cl.dgac.arsv.dao.ArsvObjetoVueloDAO;
import cl.dgac.arsv.filters.FiltroArsvObjetoVuelo;
import cl.dgac.arsv.model.ArsvObjetoVuelo;
import cl.dgac.arsv.model.ArsvObjetoVuelo_;

@Stateless
@Named(value = "arsvObjetoVueloDAO")
public class ArsvObjetoVueloDAOImpl extends BaseDAOImpl<ArsvObjetoVuelo, Long, FiltroArsvObjetoVuelo> implements ArsvObjetoVueloDAO {
		
	
	public ArsvObjetoVueloDAOImpl() {
		super(ArsvObjetoVuelo.class);		
	}

	@Override
	public List<ArsvObjetoVuelo> findObjetos(FiltroArsvObjetoVuelo filtro) {
		return super.findByCriteria(filtro);
	}
		
	@Override
	protected CriteriaQuery<ArsvObjetoVuelo> createFilter(FiltroArsvObjetoVuelo filtro) {
		CriteriaBuilder cb = entityManager.getCriteriaBuilder();
		Predicate restricciones = null, condicion = null;
		
		CriteriaQuery<ArsvObjetoVuelo> cq = cb.createQuery(ArsvObjetoVuelo.class);
		Root<ArsvObjetoVuelo> objetoVuelo = cq.from(ArsvObjetoVuelo.class);
		cq.select(objetoVuelo);
					
		if ((filtro.getCodigoObjetoVuelo() != null)) {
			condicion = cb.equal(objetoVuelo.get(ArsvObjetoVuelo_.codigo), filtro.getCodigoObjetoVuelo());
//			
//			if (restricciones == null)
				restricciones = condicion;
//			else 
//				restricciones = ctb.and(restricciones, condicion);			
		}		
		
		if (restricciones != null)
			cq.where(restricciones);
		
		// Ordenes
		List<Order> orderBy = new ArrayList<Order>();		
		
		if (filtro.isDescripcionOrdenar())
			orderBy.add(cb.asc(objetoVuelo.get(ArsvObjetoVuelo_.descripcion)));
		
		if (orderBy.size() > 0)
			cq.orderBy(orderBy);
		
		return cq;
	}
	
}
