package cl.dgac.arsv.model;

import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.validator.constraints.Length;

@Entity
@Table(name = "ARSV_SOLI_ARRIBO")
public class SolicitudArriboSobrevuelo extends Solicitud {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1329341980272753613L;
		
	@Column(name = "SOAR_OBSERVACION_CONFORMIDAD")
	@Length(max = 5000)	
	private String observacionConformidad;
	
	@Column(name = "SOAR_RESPUESTA_ARO_AMB")
	@Length(max = 5000)	
	private String respuestaAroAmb;
	
	@Column(name = "SOAR_COMENTARIO_AROAMB")
	@Length(max = 5000)	
	private String comentarioAroAMB;
		
	@Column(name = "SOAR_FECHA_RESPUESTA")
	@Temporal(TemporalType.TIMESTAMP)
	private Date fechaRespuesta;
	
	@OneToMany(mappedBy = "solicitudArsv")
	private List<ArsvAsignacion> asignaciones;
			
	
	/**********************************Constructor para los campos lista**********************************/	
	public SolicitudArriboSobrevuelo() {
		super();		
	}
	
	/**********************************Metodos Set y Get**********************************/

	public String getObservacionConformidad() {
		return observacionConformidad;
	}

	public void setObservacionConformidad(String observacionConformidad) {
		this.observacionConformidad = observacionConformidad;
	}

	public String getRespuestaAroAmb() {
		return respuestaAroAmb;
	}

	public void setRespuestaAroAmb(String respuestaAroAmb) {
		this.respuestaAroAmb = respuestaAroAmb;
	}

	public Date getFechaRespuesta() {
		return fechaRespuesta;
	}

	public void setFechaRespuesta(Date fechaRespuesta) {
		this.fechaRespuesta = fechaRespuesta;
	}

	public List<ArsvAsignacion> getAsignaciones() {
		return asignaciones;
	}

	public void setAsignaciones(List<ArsvAsignacion> asignaciones) {
		this.asignaciones = asignaciones;
	}

	public String getComentarioAroAMB() {
		return comentarioAroAMB;
	}

	public void setComentarioAroAMB(String comentarioAroAMB) {
		this.comentarioAroAMB = comentarioAroAMB;
	}


	
}
