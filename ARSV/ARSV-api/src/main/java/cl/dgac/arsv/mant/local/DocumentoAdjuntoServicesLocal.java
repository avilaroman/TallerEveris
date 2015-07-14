package cl.dgac.arsv.mant.local;

import java.util.List;

import javax.ejb.Local;

import cl.dgac.arsv.exceptions.ARSVBusinessException;
import cl.dgac.arsv.model.DocumentoAdjunto;

@Local
public interface DocumentoAdjuntoServicesLocal {
	public DocumentoAdjunto guardarDocumentoAdjunto(DocumentoAdjunto documentoAdjunto) throws ARSVBusinessException;
	
	public DocumentoAdjunto actualizarDocumentoAdjunto(DocumentoAdjunto documentoAdjunto) throws ARSVBusinessException;
	
	public DocumentoAdjunto buscarDocumentoAdjunto(Long idDocumentoAdjunto) throws ARSVBusinessException;
	
	public void eliminarDocumentoAdjunto(DocumentoAdjunto documentoAdjunto) throws ARSVBusinessException;

	public List<DocumentoAdjunto> buscarDocumentoAdjunto() throws ARSVBusinessException;
	
}
