package cl.dgac.arsv.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Min;

@Entity
@Table(name = "ARSV_TIPOS_COMUNICACIONES")
public class ArsvTipoComunicacion implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -3967346589873471823L;
	
	@Id
	@Column(name="TICO_CODIGO_COMUNICACION")
	@Min(value=1, message="{solicitud.validation.listaGeneral}")
	private Long id;
	
	@Column(name="TICO_DESC_COMUNICACION")
	private String descripcion;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

}
