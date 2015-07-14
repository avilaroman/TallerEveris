package cl.dgac.arsv.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.validator.constraints.NotEmpty;

@Entity
@Table(name = "ARSV_OBJETO_VUELOS")
public class ArsvObjetoVuelo implements Serializable{



	/**
	 * 
	 */
	private static final long serialVersionUID = -4868972719070415893L;

	@Id
	@Column(name="OBVU_CODIGO_OBJETO_VUELOS")
	@NotEmpty(message = "{solicitud.validation.list.required.objetoVuelo}")
	private String codigo;
	
	@Column(name="OBVU_DESC_OBJETO_VUELO")
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
