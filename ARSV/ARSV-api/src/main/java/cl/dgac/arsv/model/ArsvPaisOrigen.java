package cl.dgac.arsv.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Min;

@Entity
@Table(name="ARSV_PAIS_ORIGEN")
public class ArsvPaisOrigen implements Serializable{



	/**
	 * 
	 */
	private static final long serialVersionUID = -6733744305381738397L;

	@Id
	@Column(name="PAOR_ID_PAIS")
	@Min(value=1, message="{solicitud.validation.list.required.nacionalidad}")
	private Long id;
	
	@Column(name="PAOR_DESC_PAIS")
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
