package cl.dgac.arsv.model;

import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="Dali", date="2013-08-09T11:50:10.873-0400")
@StaticMetamodel(DocumentoAdjunto.class)
public class DocumentoAdjunto_ {
	public static volatile SingularAttribute<DocumentoAdjunto, Long> idDocumento;
	public static volatile SingularAttribute<DocumentoAdjunto, String> descripcionDocumento;
	public static volatile SingularAttribute<DocumentoAdjunto, String> mimeType;
	public static volatile SingularAttribute<DocumentoAdjunto, byte[]> documento;
	public static volatile SingularAttribute<DocumentoAdjunto, Solicitud> solicitud;
}
