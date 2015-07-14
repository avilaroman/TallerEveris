package cl.dgac.arsv.dao.impl;

import java.util.List;

import javax.ejb.Stateless;
import javax.inject.Named;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import cl.dgac.arsv.dao.ArsvRutaDAO;
import cl.dgac.arsv.filters.FiltroArsvRuta;
import cl.dgac.arsv.model.ArsvRuta;
import cl.dgac.arsv.model.ArsvRuta_;

@Stateless
@Named(value = "arsvRutaDAO")
public class ArsvRutaDAOImpl extends BaseDAOImpl<ArsvRuta, Long, FiltroArsvRuta> implements ArsvRutaDAO {
		
	
	public ArsvRutaDAOImpl() {
		super(ArsvRuta.class);		
	}

	@Override
	public List<ArsvRuta> findRutas(FiltroArsvRuta filtro) {
		return super.findByCriteria(filtro);
	}
		
	@Override
	protected CriteriaQuery<ArsvRuta> createFilter(FiltroArsvRuta filtro) {
		CriteriaBuilder cb = entityManager.getCriteriaBuilder();
		Predicate restricciones = null, condicion = null;
		
		CriteriaQuery<ArsvRuta> cq = cb.createQuery(ArsvRuta.class);
		Root<ArsvRuta> ruta = cq.from(ArsvRuta.class);
		cq.select(ruta);
					
		// Condiciones
		if ((filtro.getCodigo() != null)) {
			condicion = cb.equal(ruta.get(ArsvRuta_.id), filtro.getCodigo());
//			
//			if (restricciones == null)
				restricciones = condicion;
//			else 
//				restricciones = cb.and(restricciones, condicion);			
		}		
		
		if ((filtro.getSolicitud() != null)) {
			condicion = cb.equal(ruta.get(ArsvRuta_.solicitud), filtro.getSolicitud());
			
			if (restricciones == null)
				restricciones = condicion;
			else 
				restricciones = cb.and(restricciones, condicion);			
		}	
		
		if ((filtro.getTipoRuta() != null)) {
			condicion = cb.equal(ruta.get(ArsvRuta_.tipoRuta), filtro.getTipoRuta());
			
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
