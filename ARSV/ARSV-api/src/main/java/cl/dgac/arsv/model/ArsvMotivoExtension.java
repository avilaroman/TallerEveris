package cl.dgac.arsv.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Min;

@Entity
@Table(name = "ARSV_MOTIVOS_EXTENSIONES")
public class ArsvMotivoExtension implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -6144395358788343797L;

	@Id
	@Column(name="MOEX_CODIGO_MOTIVO_EXTENSION")
	@Min(value=1, message="{solicitud.validation.list.required}")
	private Long id;
	
	@Column(name="MOEX_DESC_MOTIVO_EXTENSION")
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
