package cl.dgac.arsv.mant.remote;

import java.util.List;

import javax.ejb.Remote;

import cl.dgac.arsv.exceptions.ARSVBusinessException;
import cl.dgac.arsv.model.DocumentoAdjunto;

@Remote
public interface DocumentoAdjuntoServicesRemote {
	public DocumentoAdjunto guardarDocumentoAdjunto(DocumentoAdjunto documentoAdjunto) throws ARSVBusinessException;
	
	public DocumentoAdjunto actualizarDocumentoAdjunto(DocumentoAdjunto documentoAdjunto) throws ARSVBusinessException;
	
	public DocumentoAdjunto buscarDocumentoAdjunto(Long idDocumentoAdjunto) throws ARSVBusinessException;
	
	public void eliminarDocumentoAdjunto(DocumentoAdjunto documentoAdjunto) throws ARSVBusinessException;

	public List<DocumentoAdjunto> buscarDocumentoAdjunto() throws ARSVBusinessException;
	
}
