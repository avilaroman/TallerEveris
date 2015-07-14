package cl.dgac.arsv.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.Valid;

@Entity
@Table(name = "ARSV_OACIS")
public class ArsvOACI implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -166328712170335212L;

	@Id
	@Column(name="OACI_CODIGO_OACI")
	private String codigo;
	
	@Column(name="OACI_DESC_OACI")
	private String descripcion;
	
	@ManyToOne(targetEntity = ArsvPaisOrigen.class)
	@JoinColumn(name = "PAOR_ID_PAIS")
	@Valid
	private ArsvPaisOrigen arsvPaisOrigen;

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

	public ArsvPaisOrigen getArsvPaisOrigen() {
		return arsvPaisOrigen;
	}

	public void setArsvPaisOrigen(ArsvPaisOrigen arsvPaisOrigen) {
		this.arsvPaisOrigen = arsvPaisOrigen;
	}
	
	

	
}