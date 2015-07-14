package cl.dgac.arsv.model;

import java.io.Serializable;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.validator.constraints.Length;

@Entity
@Table(name="ARSV_DOCUMENTOS_ADJUNTOS")
public class DocumentoAdjunto implements Serializable {

	


	/**
	 * 
	 */
	private static final long serialVersionUID = 860735447696610169L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)	
	@Column(name="DOAD_ID_DOCUMENTO_ADJUNTO", unique = true, nullable = false)
	private Long idDocumento;
	
	@Column(name="DOAD_DESCRIPCION_DOCUMENTO_ADJUNTO")
	@Length(max=20)
	private String descripcionDocumento;
	
	@Column(name="DOAD_MIMETYPE_DOCUMENTO_ADJUNTO")
	private String mimeType;
	
	@Basic(fetch=FetchType.LAZY, optional=false)
	@Column(name="DOAD_ADJUNTO_BINARIO")
	private byte[] documento;	
	
	@ManyToOne(targetEntity = Solicitud.class)
	@JoinColumn(name = "SOLI_ID", referencedColumnName="SOLI_ID")
	private Solicitud solicitud;
	
	public DocumentoAdjunto() {
		super();
	}

	public byte[] getDocumento() {
		return documento;
	}

	public void setDocumento(byte[] documento) {
		this.documento = documento;
	}

	public Long getIdDocumento() {
		return idDocumento;
	}

	public void setIdDocumento(Long idDocumento) {
		this.idDocumento = idDocumento;
	}

	public String getDescripcionDocumento() {
		return descripcionDocumento;
	}

	public void setDescripcionDocumento(String descripcionDocumento) {
		this.descripcionDocumento = descripcionDocumento;
	}

	public String getMimeType() {
		return mimeType;
	}

	public void setMimeType(String mimeType) {
		this.mimeType = mimeType;
	}

	public Solicitud getSolicitud() {
		return solicitud;
	}

	public void setSolicitud(Solicitud solicitud) {
		this.solicitud = solicitud;
	}
	
	
}