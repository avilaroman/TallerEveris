package cl.dgac.arsv.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.validator.constraints.NotEmpty;

@Entity
@Table(name="ARSV_CLASIFICACIONES")
public class ArsvClasificacion implements Serializable{



	/**
	 * 
	 */
	private static final long serialVersionUID = 4731475318413869488L;

	@Id
	@Column(name="CLAS_CODIGO_CLASIFICACION")
	@NotEmpty(message = "{solicitud.validation.list.required.clasificacionVuelo}")
	private String codigo;
	
	@Column(name="CLAS_DESC_CLASIFICACION")
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
