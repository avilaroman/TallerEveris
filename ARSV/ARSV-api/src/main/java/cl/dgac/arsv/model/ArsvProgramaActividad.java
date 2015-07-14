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

import org.hibernate.validator.constraints.Length;

@Entity
@Table(name = "ARSV_PROGR_ACTIVIDADES")
public class ArsvProgramaActividad implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 8950151330664500665L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="PRAC_CODIGO_PROGR_ACTIVIDADES")
	private Long id;
	
	@ManyToOne(targetEntity = OperacionAntartica.class)
	@JoinColumn(name = "SOLI_ID", referencedColumnName="SOLI_ID")
	private OperacionAntartica solicitudOperacion;
	
	@Column(name="PRAC_DESC_EQUIPO")
	@Length(max=1000)
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
