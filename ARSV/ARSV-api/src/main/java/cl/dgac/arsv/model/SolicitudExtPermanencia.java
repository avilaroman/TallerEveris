package cl.dgac.arsv.model;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;
import javax.validation.Valid;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.Length;

@Entity
@Table(name = "ARSV_SOLI_EXTENSIONES")
public class SolicitudExtPermanencia implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -1755171685734493014L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "SOEX_ID", unique = true, nullable = false)
	private Long id;
	
	@Column(name = "SOEX_FECHA_CREACION")
	@Temporal(TemporalType.TIMESTAMP)
	private Date fechaCreacion;
	
	@Column(name = "SOEX_FECHA_CIERRE")
	@Temporal(TemporalType.TIMESTAMP)
	private Date fechaCierre;
	
	@ManyToOne(targetEntity = Solicitud.class)
	@JoinColumn(name = "SOLI_ID", referencedColumnName="SOLI_ID")
	private Solicitud solicitud;

	@Column(name = "SOEX_FORMULARIOS")
	@Length(max=50)
	private String formulario;
	
	@Column(name = "SOEX_MOTIVOS")
	@Length(max=50)
	private String motivo;
	
	@Column(name = "SOEX_OBSERVACIONES")
	@Length(max=5000)
	private String observacion;
	
	@Column(name = "SOEX_REPRESENTANTES")
	private String representante;
	
	@Column(name = "SOEX_CANTIDAD_DIAS")
	@NotNull(message = "{ext.validation.requires.dias}")
	@Min(value=0)
	private Long cantidadDias;
	
	@Column(name = "SOEX_CANTIDAD_DIAS_OTORGADOS")
	@Min(value=0)
	private Long cantidadDiasOtorgados;
	
	@Column(name = "SOEX_CANTIDAD_EXTENCIONES")
	private Long cantidadExtenciones;
	
	@Column(name = "SOEX_DSO_INFORMADO")
	private boolean dsoInformado;

	@ManyToOne(targetEntity = ArsvMotivoExtension.class)
	@JoinColumn(name = "MOEX_CODIGO_MOTIVO_EXTENSION")
	@Valid
	private ArsvMotivoExtension arsvMotivoExtension;
	
	@Transient
	private ArsvMotivoExtension motivoExtension;
	
	@ManyToOne(targetEntity = ArsvTipoSolicitud.class)@JoinColumn(name = "TISO_CODIGO_TIPO_SOLICITUD")
	@Valid
	private ArsvTipoSolicitud tipoSolicitud;
	
	@Transient
	private ArsvTipoSolicitud arsvTipoSolicitud;
	
	@Column(name = "SOEX_COMENTARIO_AERO")
	@Length(max=5000)
	private String comentarioAeronavegabilidad;
	
	@OneToMany(mappedBy = "solicitudExt")
	private List<ArsvAsignacion> asignaciones;
	
	@ManyToOne
	@JoinColumn(name = "ESSO_CODIGO_ESTADOS_SOLICITUDES")
	private ArsvEstadoSolicitud arsvEstadoSolicitud;

	
	public SolicitudExtPermanencia(){
		super();
		this.arsvMotivoExtension = new ArsvMotivoExtension();
		this.tipoSolicitud = new ArsvTipoSolicitud();
	}

	public String getFormulario() {
		return formulario;
	}

	public void setFormulario(String formulario) {
		this.formulario = formulario;
	}

	public String getMotivo() {
		return motivo;
	}

	public void setMotivo(String motivo) {
		this.motivo = motivo;
	}

	public String getObservacion() {
		return observacion;
	}

	public void setObservacion(String observacion) {
		this.observacion = observacion;
	}

	public String getRepresentante() {
		return representante;
	}

	public void setRepresentante(String representante) {
		this.representante = representante;
	}

	public ArsvMotivoExtension getArsvMotivoExtension() {
		return arsvMotivoExtension;
	}

	public void setArsvMotivoExtension(ArsvMotivoExtension arsvMotivoExtension) {
		this.arsvMotivoExtension = arsvMotivoExtension;
	}

	public Long getCantidadDias() {
		return cantidadDias;
	}

	public void setCantidadDias(Long cantidadDias) {
		this.cantidadDias = cantidadDias;
	}

	public Solicitud getSolicitud() {
		return solicitud;
	}

	public void setSolicitud(Solicitud solicitud) {
		this.solicitud = solicitud;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Date getFechaCreacion() {
		return fechaCreacion;
	}

	public void setFechaCreacion(Date fechaCreacion) {
		this.fechaCreacion = fechaCreacion;
	}

	public ArsvTipoSolicitud getTipoSolicitud() {
		return tipoSolicitud;
	}

	public void setTipoSolicitud(ArsvTipoSolicitud tipoSolicitud) {
		this.tipoSolicitud = tipoSolicitud;
	}

	public Long getCantidadDiasOtorgados() {
		return cantidadDiasOtorgados;
	}

	public void setCantidadDiasOtorgados(Long cantidadDiasOtorgados) {
		this.cantidadDiasOtorgados = cantidadDiasOtorgados;
	}

	public String getComentarioAeronavegabilidad() {
		return comentarioAeronavegabilidad;
	}

	public void setComentarioAeronavegabilidad(String comentarioAeronavegabilidad) {
		this.comentarioAeronavegabilidad = comentarioAeronavegabilidad;
	}

	public Date getFechaCierre() {
		return fechaCierre;
	}

	public void setFechaCierre(Date fechaCierre) {
		this.fechaCierre = fechaCierre;
	}

	public List<ArsvAsignacion> getAsignaciones() {
		return asignaciones;
	}

	public void setAsignaciones(List<ArsvAsignacion> asignaciones) {
		this.asignaciones = asignaciones;
	}

	public ArsvMotivoExtension getMotivoExtension() {
		return motivoExtension;
	}

	public void setMotivoExtension(ArsvMotivoExtension motivoExtension) {
		this.motivoExtension = motivoExtension;
	}

	public ArsvTipoSolicitud getArsvTipoSolicitud() {
		return arsvTipoSolicitud;
	}

	public void setArsvTipoSolicitud(ArsvTipoSolicitud arsvTipoSolicitud) {
		this.arsvTipoSolicitud = arsvTipoSolicitud;
	}

	public ArsvEstadoSolicitud getArsvEstadoSolicitud() {
		return arsvEstadoSolicitud;
	}

	public void setArsvEstadoSolicitud(ArsvEstadoSolicitud arsvEstadoSolicitud) {
		this.arsvEstadoSolicitud = arsvEstadoSolicitud;
	}

	public Long getCantidadExtenciones() {
		return cantidadExtenciones;
	}

	public void setCantidadExtenciones(Long cantidadExtenciones) {
		this.cantidadExtenciones = cantidadExtenciones;
	}

	public boolean isDsoInformado() {
		return dsoInformado;
	}

	public void setDsoInformado(boolean dsoInformado) {
		this.dsoInformado = dsoInformado;
	}	
	
	
}
