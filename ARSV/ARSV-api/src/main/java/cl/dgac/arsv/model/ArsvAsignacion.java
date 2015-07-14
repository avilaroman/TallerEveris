package cl.dgac.arsv.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.validator.constraints.Length;

@Entity
@Table(name="ARSV_ASIGNACIONES_A_UNI")
public class ArsvAsignacion implements Serializable{

	
	/**
	 * 
	 */
	private static final long serialVersionUID = -6167570861420798624L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)	
	@Column(name="ASIG_CODIGO_ASIGNACION", unique = true, nullable = false)
	private Long id;
	
    @ManyToOne
	@JoinColumn(name="ARUN_CODIGO_UNIDADES")
	private ArsvRuta arsvUnidad;
	
	@Column(name="ASIG_FECHA_ASIGNACION")
	@Temporal(TemporalType.TIMESTAMP)
	private Date fechaAsignacion;
	
	@Column(name="ASIG_COMENTARIO")
	@Length(max=1000)
	private String comentarioTramitador;
	
	@Column(name="ASIG_RESPUESTA")
	@Length(max=1000)
	private String respuestaAsignado;
	
	@Column(name="ASIG_AROAMB_ASIGNA")
	private Long idAroAmbAsigna;	

    @ManyToOne
	@JoinColumn(name="SOAR_CODIGO_SOLI_ARRIBO")
	private SolicitudArriboSobrevuelo solicitudArsv;
    
    @ManyToOne
	@JoinColumn(name="SOOP_CODIGO_SOLI_OPERACIONES")
	private SolicitudOperacion solicitudOperacion;
    
    @ManyToOne
	@JoinColumn(name="SOEX_CODIGO_SOLI_EXTENSIONES")
	private SolicitudExtPermanencia solicitudExt;

	public String getRespuestaAsignado() {
		return respuestaAsignado;
	}

	public void setRespuestaAsignado(String respuestaAsignado) {
		this.respuestaAsignado = respuestaAsignado;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}
	
	public Date getFechaAsignacion() {
		return fechaAsignacion;
	}

	public void setFechaAsignacion(Date fechaAsignacion) {
		this.fechaAsignacion = fechaAsignacion;
	}

	public String getComentarioTramitador() {
		return comentarioTramitador;
	}

	public void setComentarioTramitador(String comentarioTramitador) {
		this.comentarioTramitador = comentarioTramitador;
	}
	
	public SolicitudArriboSobrevuelo getSolicitudArsv() {
		return solicitudArsv;
	}

	public void setSolicitudArsv(SolicitudArriboSobrevuelo solicitudArsv) {
		this.solicitudArsv = solicitudArsv;
	}

	public SolicitudOperacion getSolicitudOperacion() {
		return solicitudOperacion;
	}

	public void setSolicitudOperacion(SolicitudOperacion solicitudOperacion) {
		this.solicitudOperacion = solicitudOperacion;
	}

	public SolicitudExtPermanencia getSolicitudExt() {
		return solicitudExt;
	}

	public void setSolicitudExt(SolicitudExtPermanencia solicitudExt) {
		this.solicitudExt = solicitudExt;
	}

	public ArsvRuta getArsvUnidad() {
		return this.arsvUnidad;
	}

	public void setArsvUnidad(ArsvRuta arsvUnidad) {
		this.arsvUnidad = arsvUnidad;
	}
	
	public String getNombreUnidad() {
		if (arsvUnidad!=null)
			return arsvUnidad.getPosta();
		else
			return "";
	}

	public Long getIdAroAmbAsigna() {
		return idAroAmbAsigna;
	}

	public void setIdAroAmbAsigna(Long idAroAmbAsigna) {
		this.idAroAmbAsigna = idAroAmbAsigna;
	}
	
	public String getNaturalId() {
		String natural = "";
		if (this.getNombreUnidad()!=null)
			natural+=this.getNombreUnidad();
		if (this.getRespuestaAsignado()!=null)
			natural+=this.getRespuestaAsignado();
		if (this.getFechaAsignacion()!=null)
			natural+=this.getFechaAsignacion();
		return natural;
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((getNaturalId() == null) ? 0 : getNaturalId().hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ArsvAsignacion other = (ArsvAsignacion) obj;
		if (getNaturalId() == null) {
			if (other.getNaturalId() != null)
				return false;
		} else if (!getNaturalId().equals(other.getNaturalId()))
			return false;
		return true;
	}
	
}









	

