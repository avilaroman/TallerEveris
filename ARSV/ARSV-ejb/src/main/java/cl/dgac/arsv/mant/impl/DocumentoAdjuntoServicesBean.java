package cl.dgac.arsv.mant.impl;
import java.util.List;

import javax.ejb.Stateless;

import org.apache.log4j.Logger;

import cl.dgac.arsv.dao.DocumentoAdjuntoDAO;
import cl.dgac.arsv.exceptions.ARSVBusinessException;
import cl.dgac.arsv.mant.WS.DocumentoAdjuntoServicesWS;
import cl.dgac.arsv.mant.local.DocumentoAdjuntoServicesLocal;
import cl.dgac.arsv.mant.remote.DocumentoAdjuntoServicesRemote;
import cl.dgac.arsv.model.DocumentoAdjunto;


@Stateless(name = "documentoAdjuntoServicessBean")
public class DocumentoAdjuntoServicesBean implements DocumentoAdjuntoServicesLocal, DocumentoAdjuntoServicesRemote, DocumentoAdjuntoServicesWS {

	public static final Logger log = Logger.getLogger(DocumentoAdjuntoServicesBean.class);
	
	private DocumentoAdjuntoDAO documentoAdjuntoDAO;
		
	public DocumentoAdjuntoServicesBean() {
		super();
	}

	public DocumentoAdjunto guardarDocumentoAdjunto(DocumentoAdjunto documentoAdjunto) throws ARSVBusinessException {
		try {
			return this.documentoAdjuntoDAO.save(documentoAdjunto);
		} catch (Exception e) {
			log.error(e.getMessage());
			throw new ARSVBusinessException(e.getMessage());
		}
	}
	
	public DocumentoAdjunto actualizarDocumentoAdjunto(DocumentoAdjunto documentoAdjunto) throws ARSVBusinessException {
		try {
			return this.documentoAdjuntoDAO.update(documentoAdjunto);
		} catch (Exception e) {
			log.error(e.getMessage());
			throw new ARSVBusinessException(e.getMessage());
		}
	}
	
	public DocumentoAdjunto buscarDocumentoAdjunto(Long idDocumentoAdjunto) throws ARSVBusinessException {
		try {
			return this.documentoAdjuntoDAO.findById(idDocumentoAdjunto);
		} catch (Exception e) {
			log.error(e.getMessage());
			throw new ARSVBusinessException(e.getMessage());
		}
	}
	
	public void eliminarDocumentoAdjunto(DocumentoAdjunto documentoAdjunto) throws ARSVBusinessException {
		try {
			this.documentoAdjuntoDAO.remove(documentoAdjunto);
		} catch (Exception e) {
			log.error(e.getMessage());
			throw new ARSVBusinessException(e.getMessage());
		}
	}
	
	public List<DocumentoAdjunto> buscarDocumentoAdjunto() throws ARSVBusinessException {
		try {
			return this.documentoAdjuntoDAO.findAll();
		} catch (Exception e) {
			log.error(e.getMessage());
			throw new ARSVBusinessException(e.getMessage());
		}
	}
}