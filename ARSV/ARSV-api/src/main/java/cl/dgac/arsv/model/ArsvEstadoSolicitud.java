package cl.dgac.arsv.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "ARSV_ESTADOS_SOLICITUDES")
public class ArsvEstadoSolicitud implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 7815377120673143292L;

	@Id
	@Column(name="ESSO_CODIGO_ESTADOS_SOLICITUDES")
	private String codigo;
	
	@Column(name="ESSO_DESC_ESTADOS_SOLICITUDES")
	private String descripcion;
	
	
	public ArsvEstadoSolicitud() {
		super();
	}

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