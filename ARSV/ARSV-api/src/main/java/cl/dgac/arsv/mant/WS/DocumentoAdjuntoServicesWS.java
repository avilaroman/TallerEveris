package cl.dgac.arsv.mant.WS;

import java.util.List;

import javax.jws.WebService;

import cl.dgac.arsv.exceptions.ARSVBusinessException;
import cl.dgac.arsv.model.DocumentoAdjunto;

@WebService
public interface DocumentoAdjuntoServicesWS {
	public DocumentoAdjunto guardarDocumentoAdjunto(DocumentoAdjunto documentoAdjunto) throws ARSVBusinessException;
	
	public DocumentoAdjunto actualizarDocumentoAdjunto(DocumentoAdjunto documentoAdjunto) throws ARSVBusinessException;
	
	public DocumentoAdjunto buscarDocumentoAdjunto(Long idDocumentoAdjunto) throws ARSVBusinessException;
	
	public void eliminarDocumentoAdjunto(DocumentoAdjunto documentoAdjunto) throws ARSVBusinessException;

	public List<DocumentoAdjunto> buscarDocumentoAdjunto() throws ARSVBusinessException;
	
}
