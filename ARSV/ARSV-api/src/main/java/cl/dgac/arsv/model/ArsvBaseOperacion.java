package cl.dgac.arsv.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "ARSV_BASES_OPERACION")
public class ArsvBaseOperacion implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 3249001870809283643L;
	
	@Id
	@Column(name="BAOP_CODIGO_BASE")
	private Long id;
	
	@Column(name="BAOP_DESC_BASE")
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
