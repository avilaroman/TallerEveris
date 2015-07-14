package cl.dgac.arsv.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.validator.constraints.NotEmpty;

@Entity
@Table(name="ARSV_TIPO_SOLICITUD")
public class ArsvTipoSolicitud implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -2342879835012852166L;

	@Id
	@Column(name="TISO_CODIGO_TIPO_SOLICITUD")
	@NotEmpty(message = "{solicitud.validation.list.required}")
	private String codigo;
	
	@Column(name="TISO_DESC_TIPO_SOLICITUD")
	private String descripcion;
	
	public String getCodigo() {
		return codigo;
	}

	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	
}