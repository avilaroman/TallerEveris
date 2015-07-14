package cl.dgac.arsv.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Min;

@Entity
@Table(name = "ARSV_EQUIPOS_SUPERVIVENCIAS")
public class ArsvEquipoSupervivencia implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -8513526253923978205L;

	@Id
	@Column(name="EQSU_CODIGO_EQUIPO")
	@Min(value=1, message="{solicitud.validation.listaGeneral}")
	private Long id;
	
	@Column(name="EQSU_DESC_EQUIPO")
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
