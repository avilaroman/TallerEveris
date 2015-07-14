package cl.dgac.arsv.dao.impl;

import java.util.List;

import javax.ejb.Stateless;
import javax.inject.Named;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import cl.dgac.arsv.dao.DocumentoAdjuntoDAO;
import cl.dgac.arsv.filters.FiltroDocumentoAdjunto;
import cl.dgac.arsv.model.DocumentoAdjunto;
import cl.dgac.arsv.model.DocumentoAdjunto_;

@Stateless
@Named(value = "documentoAdjuntoDAO")
public class DocumentoAdjuntoDAOImpl extends BaseDAOImpl<DocumentoAdjunto, Long, FiltroDocumentoAdjunto> implements DocumentoAdjuntoDAO {
		
	
	public DocumentoAdjuntoDAOImpl() {
		super(DocumentoAdjunto.class);		
	}

	@Override
	public List<DocumentoAdjunto> findDocumentosAdjuntos(FiltroDocumentoAdjunto filtro) {
		return super.findByCriteria(filtro);
	}
		
	@Override
	protected CriteriaQuery<DocumentoAdjunto> createFilter(FiltroDocumentoAdjunto filtro) {
		CriteriaBuilder cb = entityManager.getCriteriaBuilder();
		Predicate restricciones = null, condicion = null;
		
		CriteriaQuery<DocumentoAdjunto> cq = cb.createQuery(DocumentoAdjunto.class);
		Root<DocumentoAdjunto> documentoAdjunto = cq.from(DocumentoAdjunto.class);
		cq.select(documentoAdjunto);
					
		// Condiciones
		if ((filtro.getIdDocumento() != null)) {
			condicion = cb.equal(documentoAdjunto.get(DocumentoAdjunto_.idDocumento), filtro.getIdDocumento());
//			
//			if (restricciones == null)
				restricciones = condicion;
//			else 
//				restricciones = cb.and(restricciones, condicion);			
		}		
		
		if ((filtro.getSolicitud() != null)) {
			condicion = cb.equal(documentoAdjunto.get(DocumentoAdjunto_.solicitud), filtro.getSolicitud());
			
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
