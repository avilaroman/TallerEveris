package cl.dgac.arsv.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "ARSV_EQUIPOS_USAR")
public class ArsvEquipoUsar implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -6588377241728886087L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="EQUS_CODIGO_EQUIPO_USAR")
	private Long id;
	
	@ManyToOne(targetEntity = OperacionAntartica.class)
	@JoinColumn(name = "SOLI_ID", referencedColumnName="SOLI_ID")
	private OperacionAntartica solicitudOperacion;
	
	@Column(name="EQUS_DESC_EQUIPO")
	private String descripcion;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public OperacionAntartica getSolicitudOperacion() {
		return solicitudOperacion;
	}

	public void setSolicitudOperacion(OperacionAntartica solicitudOperacion) {
		this.solicitudOperacion = solicitudOperacion;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	
	
}
