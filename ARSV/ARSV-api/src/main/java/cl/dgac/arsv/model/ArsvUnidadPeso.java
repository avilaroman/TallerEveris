package cl.dgac.arsv.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.validator.constraints.NotEmpty;

@Entity
@Table(name = "ARSV_UNIDADES_PESO")
public class ArsvUnidadPeso implements Serializable{

	
	/**
	 * 
	 */
	private static final long serialVersionUID = 4166154908919659617L;

	@Id
	@Column(name="UNPE_CODIGO_UNIDAD")
	@NotEmpty(message = "{solicitud.validation.list.required.clasificacionVuelo}")
	private String codigo;
	
	@Column(name="UNPE_DESC_UNIDAD")
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
