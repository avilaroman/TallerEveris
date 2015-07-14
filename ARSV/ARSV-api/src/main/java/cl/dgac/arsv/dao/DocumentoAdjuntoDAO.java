package cl.dgac.arsv.dao;

import java.util.List;

import cl.dgac.arsv.filters.FiltroDocumentoAdjunto;
import cl.dgac.arsv.model.DocumentoAdjunto;
import cl.seis.generic.dao.GenericDAO;



public interface DocumentoAdjuntoDAO extends GenericDAO<DocumentoAdjunto, Long, FiltroDocumentoAdjunto> {
	public List<DocumentoAdjunto> findDocumentosAdjuntos(FiltroDocumentoAdjunto filtro);
}
