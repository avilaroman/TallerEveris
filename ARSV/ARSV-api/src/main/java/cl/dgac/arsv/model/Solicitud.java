package cl.dgac.arsv.model;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;
import javax.validation.Valid;
import javax.validation.constraints.Future;
import javax.validation.constraints.Min;
import javax.validation.constraints.Pattern;

import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotEmpty;

@Entity
@Table(name = "ARSV_SOLICITUDES")
@Inheritance(strategy = InheritanceType.JOINED)
public abstract class Solicitud implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 6448362175735406060L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "SOLI_ID", unique = true, nullable = false)
	private Long id;
	
	@Column(name = "SOLI_FECHA_CREACION")
	@Temporal(TemporalType.TIMESTAMP)
	private Date fechaCreacion;
	
	@Column(name = "SOLI_FECHA_CIERRE")
	@Temporal(TemporalType.TIMESTAMP)
	private Date fechaCierre;
	
	@Column(name = "SOLI_CALLSIGN")
	@Length(max=50)
	private String callSign;	
	
	@Column(name = "SOLI_DIRECCION")
	@Length(max=50)
	private String direccion;	
	
	@Column(name = "SOLI_DFACTURACION")
	@Length(min = 3, max=50,message = "{solicitud.validation.required.direccionFacturacion}")
	@NotEmpty(message = "{solicitud.validation.required.direccionFacturacion}")
	private String direccionFacturacion;
	
	@Column(name = "SOLI_NOMBRE_EMPRESA")
	@NotEmpty(message = "{solicitud.validation.required.operador}")
	@Pattern(regexp = "[a-zA-Zá-úÁ-ÚñÑ.' ]*", message = "{solicitud.validation.CharacterAccepted.alfabeticos}")
	@Length(max=50)
	private String nombreEmpresa;
	
	@Column(name = "SOLI_RAZON_SOCIAL")
	@Pattern(regexp = "[a-zA-Zá-úÁ-ÚñÑ.' ]*", message = "{solicitud.validation.CharacterAccepted.alfabeticos}")
	@Length(max=50)
	private String razonSocial;

	@Column(name = "SOLI_PILOTO")
	@Pattern(regexp = "[a-zA-Zá-úÁ-ÚñÑ' ]*", message = "{solicitud.validation.CharacterAccepted.alfabeticos}")
	@Length(max=50)
	private String nombrePiloto;

	@Column(name = "SOLI_MTOW")
	@Min(value = 0)
	private Long MTOW;
	
	@Column(name = "SOLI_CANTIDAD_VUELOS")
	@Min(value=0)
	private Long cantidadVuelos;

	@Column(name = "SOLI_OBSERVACIONES")
	@Length(max=5000)
	private String observaciones;
	
	@Column(name = "SOLI_FECHA_INGRESO")
	@Temporal(TemporalType.TIMESTAMP)
	@Future
	private Date fechaArribo;

	@Column(name = "SOLI_FECHA_SALIDA")
	@Temporal(TemporalType.TIMESTAMP)
	private Date fechaSalida;

	@Column(name = "SOLI_VIGENCIA_SEGURO")
	@Temporal(TemporalType.TIMESTAMP)
	private Date vigenciaSeguro;

	@Column(name = "SOLI_EMBARCADOR")
	@Pattern(regexp = "[a-zA-Zá-úÁ-ÚñÑ.' ]*", message = "{solicitud.validation.CharacterAccepted.alfabeticos}")
	@Length(max=50)
	private String embarcador;

	@Column(name = "SOLI_CONSIGNATARIO")
	@Pattern(regexp = "[a-zA-Zá-úÁ-ÚñÑ.' ]*", message = "{solicitud.validation.CharacterAccepted.alfabeticos}")
	@Length(max=50)
	private String consignatario;

	@Column(name = "SOLI_MAIL")
	@Pattern(regexp = "^([0-9a-zA-Z]([-\\.\\w]*[0-9a-zA-Z])*@(([0-9a-zA-Z])+([-\\w]*[0-9a-zA-Z])*\\.)+[a-zA-Z]{2,9})?$", message = "{solicitud.validation.Validate.Correo}")
	@Length(max=50)
	private String correoElectronico;
	
	@Column(name = "SOLI_MAIL_OPERADOR")
	@NotEmpty(message = "{solicitud.validation.required.correo}")
	@Pattern(regexp = "^([0-9a-zA-Z]([-\\.\\w]*[0-9a-zA-Z])*@(([0-9a-zA-Z])+([-\\w]*[0-9a-zA-Z])*\\.)+[a-zA-Z]{2,9})$", message = "{solicitud.validation.Validate.Correo}")
	@Length(max=50,message="maximo 50 caracteres")
	private String correoElectronicoOperador;
	
	@ManyToOne
	@JoinColumn(name = "ESSO_CODIGO_ESTADOS_SOLICITUDES")
	private ArsvEstadoSolicitud arsvEstadoSolicitud;
	
	@Transient
	private ArsvEstadoSolicitud estadoSolicitud;
	
	@Column(name="SOLI_DETALLE_ANTECEDENTES_SOLICITADOS")
	@Length(max=5000)
	private String antecedentesSolicitados;
	
	@Column(name="SOLI_DETALLE_SOLICITUD")
	@Length(max=5000)
	private String detalleSolicitud;

	@ManyToOne(targetEntity = ArsvTipoSolicitud.class)
	@JoinColumn(name = "TISO_CODIGO_TIPO_SOLICITUD")
	@Valid
	private ArsvTipoSolicitud tipoSolicitud;

	@Transient
	private ArsvTipoSolicitud arsvTipoSolicitud;
	
	@ManyToOne
	@JoinColumn(name = "PAOR_ID_PAIS_AERONAVE")
	@Valid
	private ArsvPaisOrigen paisAeronave;
	
	@ManyToOne
	@JoinColumn(name = "PAOR_ID_PAIS")
	@Valid
	private ArsvPaisOrigen paisOrigen;
	
	@ManyToOne
	@JoinColumn(name = "OACI_CODIGO_OACI")
	@Valid
	private ArsvOACI arsvOACI;
	
	@ManyToOne
	@JoinColumn(name = "UNPE_CODIGO_UNIDAD")
	@Valid
	private ArsvUnidadPeso unidadPeso;
	
	@ManyToOne
	@JoinColumn(name = "CLAS_CODIGO_CLASIFICACION")
	private ArsvClasificacion clasificacion;

	@Transient
	private ArsvClasificacion arsvClasificacion;
	
	@ManyToOne
	@JoinColumn(name = "OBVU_CODIGO_OBJETO")
	@Valid
	private ArsvObjetoVuelo objetoVuelo;
	
	@Transient
	private ArsvObjetoVuelo arsvObjetoVuelo;
	
	@OneToMany(targetEntity = SolicitudExtPermanencia.class, mappedBy="solicitud",	cascade = CascadeType.ALL)
	private List<SolicitudExtPermanencia> solicitudExtPermanencias;
	
	@OneToMany(targetEntity = DocumentoAdjunto.class, mappedBy="solicitud", cascade = CascadeType.ALL)
	private List<DocumentoAdjunto> documentosAdjuntos;

	/********************************** Tablas **********************************/
	@OneToMany(targetEntity = ArsvRuta.class, mappedBy="solicitud",	cascade = CascadeType.ALL)
	private List<ArsvRuta> arsvRutas;
	
	@OneToMany(targetEntity = ArsvRuta.class, mappedBy="solicitud",	cascade = CascadeType.ALL)
	private List<ArsvRuta> arsvRutas2;
	
	@Transient
	private List<ArsvRuta> ruta;

	/********************************** Tablas SAC **********************************/
	@Column(name = "SAC_CMATRICULA")
	@NotEmpty(message = "{solicitud.validation.required.matricula}")
	@Length(max=50)
	private String sacAeronave;	

	public Solicitud() {
		super();
		this.paisOrigen = new ArsvPaisOrigen();
		this.paisAeronave = new ArsvPaisOrigen();
		this.clasificacion = new ArsvClasificacion();
		this.objetoVuelo = new ArsvObjetoVuelo();
		this.tipoSolicitud = new ArsvTipoSolicitud();
		this.unidadPeso = new ArsvUnidadPeso();
		this.arsvOACI = new ArsvOACI();
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

	public String getNombrePiloto() {
		return nombrePiloto;
	}

	public void setNombrePiloto(String nombrePiloto) {
		this.nombrePiloto = nombrePiloto;
	}

	public Long getMTOW() {
		return MTOW;
	}

	public void setMTOW(Long mTOW) {
		MTOW = mTOW;
	}

	public String getObservaciones() {
		return observaciones;
	}

	public void setObservaciones(String observaciones) {
		this.observaciones = observaciones;
	}

	public Date getFechaArribo() {
		return fechaArribo;
	}

	public void setFechaArribo(Date fechaArribo) {
		this.fechaArribo = fechaArribo;
	}

	public Date getFechaSalida() {
		return fechaSalida;
	}

	public void setFechaSalida(Date fechaSalida) {
		this.fechaSalida = fechaSalida;
	}

	public Date getVigenciaSeguro() {
		return vigenciaSeguro;
	}

	public void setVigenciaSeguro(Date vigenciaSeguro) {
		this.vigenciaSeguro = vigenciaSeguro;
	}

	public String getEmbarcador() {
		return embarcador;
	}

	public void setEmbarcador(String embarcador) {
		this.embarcador = embarcador;
	}

	public String getConsignatario() {
		return consignatario;
	}

	public void setConsignatario(String consignatario) {
		this.consignatario = consignatario;
	}

	public String getCorreoElectronico() {
		return correoElectronico;
	}

	public void setCorreoElectronico(String correoElectronico) {
		this.correoElectronico = correoElectronico;
	}

	public ArsvTipoSolicitud getTipoSolicitud() {
		return tipoSolicitud;
	}

	public void setTipoSolicitud(ArsvTipoSolicitud tipoSolicitud) {
		this.tipoSolicitud = tipoSolicitud;
	}

	public ArsvPaisOrigen getPaisOrigen() {
		return paisOrigen;
	}

	public void setPaisOrigen(ArsvPaisOrigen paisOrigen) {
		this.paisOrigen = paisOrigen;
	}

	public ArsvClasificacion getClasificacion() {
		return clasificacion;
	}

	public void setClasificacion(ArsvClasificacion clasificacion) {
		this.clasificacion = clasificacion;
	}

	public ArsvObjetoVuelo getObjetoVuelo() {
		return objetoVuelo;
	}

	public void setObjetoVuelo(ArsvObjetoVuelo objetoVuelo) {
		this.objetoVuelo = objetoVuelo;
	}

	public String getNombreEmpresa() {
		return nombreEmpresa;
	}

	public void setNombreEmpresa(String nombreEmpresa) {
		this.nombreEmpresa = nombreEmpresa;
	}

	public String getAntecedentesSolicitados() {
		return antecedentesSolicitados;
	}

	public void setAntecedentesSolicitados(String antecedentesSolicitados) {
		this.antecedentesSolicitados = antecedentesSolicitados;
	}

	public ArsvEstadoSolicitud getArsvEstadoSolicitud() {
		return arsvEstadoSolicitud;
	}

	public void setArsvEstadoSolicitud(ArsvEstadoSolicitud arsvEstadoSolicitud) {
		this.arsvEstadoSolicitud = arsvEstadoSolicitud;
	}

	public String getDetalleSolicitud() {
		return detalleSolicitud;
	}

	public void setDetalleSolicitud(String detalleSolicitud) {
		this.detalleSolicitud = detalleSolicitud;
	}

	public List<ArsvRuta> getArsvRutas() {
		return arsvRutas;
	}

	public void setArsvRutas(List<ArsvRuta> arsvRutas) {
		this.arsvRutas = arsvRutas;
	}

	public String getDireccion() {
		return direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	public String getDireccionFacturacion() {
		return direccionFacturacion;
	}

	public void setDireccionFacturacion(String direccionFacturacion) {
		this.direccionFacturacion = direccionFacturacion;
	}

	public List<SolicitudExtPermanencia> getSolicitudExtPermanencias() {
		return solicitudExtPermanencias;
	}

	public void setSolicitudExtPermanencias(
			List<SolicitudExtPermanencia> solicitudExtPermanencias) {
		this.solicitudExtPermanencias = solicitudExtPermanencias;
	}
	
	public Date getFechaCierre() {
		return fechaCierre;
	}

	public void setFechaCierre(Date fechaCierre) {
		this.fechaCierre = fechaCierre;
	}

	public String getSacAeronave() {
		return sacAeronave;
	}

	public void setSacAeronave(String sacAeronave) {
		this.sacAeronave = sacAeronave;
	}

	public ArsvEstadoSolicitud getEstadoSolicitud() {
		return estadoSolicitud;
	}

	public void setEstadoSolicitud(ArsvEstadoSolicitud estadoSolicitud) {
		this.estadoSolicitud = estadoSolicitud;
	}

	public ArsvTipoSolicitud getArsvTipoSolicitud() {
		return arsvTipoSolicitud;
	}

	public void setArsvTipoSolicitud(ArsvTipoSolicitud arsvTipoSolicitud) {
		this.arsvTipoSolicitud = arsvTipoSolicitud;
	}

	public ArsvClasificacion getArsvClasificacion() {
		return arsvClasificacion;
	}

	public void setArsvClasificacion(ArsvClasificacion arsvClasificacion) {
		this.arsvClasificacion = arsvClasificacion;
	}

	public ArsvObjetoVuelo getArsvObjetoVuelo() {
		return arsvObjetoVuelo;
	}

	public void setArsvObjetoVuelo(ArsvObjetoVuelo arsvObjetoVuelo) {
		this.arsvObjetoVuelo = arsvObjetoVuelo;
	}

	public List<ArsvRuta> getRuta() {
		return ruta;
	}

	public void setRuta(List<ArsvRuta> ruta) {
		this.ruta = ruta;
	}

	public List<ArsvRuta> getArsvRutas2() {
		return arsvRutas2;
	}

	public void setArsvRutas2(List<ArsvRuta> arsvRutas2) {
		this.arsvRutas2 = arsvRutas2;
	}

	public String getRazonSocial() {
		return razonSocial;
	}

	public void setRazonSocial(String razonSocial) {
		this.razonSocial = razonSocial;
	}

	public String getCorreoElectronicoOperador() {
		return correoElectronicoOperador;
	}

	public void setCorreoElectronicoOperador(String correoElectronicoOperador) {
		this.correoElectronicoOperador = correoElectronicoOperador;
	}

	public Long getCantidadVuelos() {
		return cantidadVuelos;
	}

	public void setCantidadVuelos(Long cantidadVuelos) {
		this.cantidadVuelos = cantidadVuelos;
	}

	public String getCallSign() {
		return callSign;
	}

	public void setCallSign(String callSign) {
		this.callSign = callSign;
	}

	public ArsvUnidadPeso getUnidadPeso() {
		return unidadPeso;
	}

	public void setUnidadPeso(ArsvUnidadPeso unidadPeso) {
		this.unidadPeso = unidadPeso;
	}

	public ArsvOACI getArsvOACI() {
		return arsvOACI;
	}

	public void setArsvOACI(ArsvOACI arsvOACI) {
		this.arsvOACI = arsvOACI;
	}

	public ArsvPaisOrigen getPaisAeronave() {
		return paisAeronave;
	}

	public void setPaisAeronave(ArsvPaisOrigen paisAeronave) {
		this.paisAeronave = paisAeronave;
	}

	public List<DocumentoAdjunto> getDocumentosAdjuntos() {
		return documentosAdjuntos;
	}

	public void setDocumentosAdjuntos(List<DocumentoAdjunto> documentosAdjuntos) {
		this.documentosAdjuntos = documentosAdjuntos;
	}
	
	
	
}
