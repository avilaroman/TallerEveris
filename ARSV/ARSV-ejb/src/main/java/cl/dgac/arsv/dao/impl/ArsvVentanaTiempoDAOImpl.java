package cl.dgac.arsv.dao.impl;

import java.util.List;

import javax.ejb.Stateless;
import javax.inject.Named;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import cl.dgac.arsv.dao.ArsvVentanaTiempoDAO;
import cl.dgac.arsv.filters.FiltroArsvVentanaTiempo;
import cl.dgac.arsv.model.ArsvVentanaTiempo;
import cl.dgac.arsv.model.ArsvVentanaTiempo_;

@Stateless
@Named(value = "arsvVentanaTiempoDAO")
public class ArsvVentanaTiempoDAOImpl extends BaseDAOImpl<ArsvVentanaTiempo, Long, FiltroArsvVentanaTiempo> implements ArsvVentanaTiempoDAO {
		
	
	public ArsvVentanaTiempoDAOImpl() {
		super(ArsvVentanaTiempo.class);		
	}

	@Override
	public List<ArsvVentanaTiempo> findVentanasTiempo(FiltroArsvVentanaTiempo filtro) {
		return super.findByCriteria(filtro);
	}
		
	@Override
	protected CriteriaQuery<ArsvVentanaTiempo> createFilter(FiltroArsvVentanaTiempo filtro) {
		CriteriaBuilder cb = entityManager.getCriteriaBuilder();
		Predicate restricciones = null, condicion = null;
		
		CriteriaQuery<ArsvVentanaTiempo> cq = cb.createQuery(ArsvVentanaTiempo.class);
		Root<ArsvVentanaTiempo> ventanaTiempo = cq.from(ArsvVentanaTiempo.class);
		cq.select(ventanaTiempo);
					
		// Condiciones
		if ((filtro.getCodigo() != null)) {
			condicion = cb.equal(ventanaTiempo.get(ArsvVentanaTiempo_.id), filtro.getCodigo());
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
