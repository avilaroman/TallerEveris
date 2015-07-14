package cl.dgac.arsv.model;

import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.Min;

import org.hibernate.validator.constraints.Length;

@Entity
@Table(name = "ARSV_SOLI_OPERACIONES")
public abstract class SolicitudOperacion extends Solicitud {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 5411375235454722208L;
	
	@Column(name = "SOOP_LICENCIA")
	@Length(max=50)
	private String licencia;
	
	@Column(name = "SOOP_HABILITACION")
	@Min(value = 0)
	private Long habilitacion;
	
	@Column(name = "SOOP_REPRESENTANTE")
	@Length(max=50)
	private String representante;
	
	@Column(name = "SOOP_NUMERO_TRIPULANTES")
	@Min(value=0)
	private Long numeroTripulantes;
	
	@Column(name = "SOOP_OBJETIVO")
	@Length(max=50)
	private String objetivo;
	
	@Column(name = "SOOP_HORA_ARRIBO")
	@Temporal(TemporalType.TIMESTAMP)
	private Date horaArribo;
	
	@Column(name = "SOOP_HORA_SALIDA")
	@Temporal(TemporalType.TIMESTAMP)
	private Date horaSalida;
	
	@Column(name = "SOOP_CANTIDAD_ASIENTOS")
	@Min(value=0)
	private Long cantidadAsiento;
	
	@Column(name = "SOOP_TIEMPO_PERMANENCIAS")
	@Min(value=0)
	private Long tiempoPermanencia;
	
	@Column(name="SOOP_PRONUNCIAMIENTO_FACH")
	@Length(max=5000)
	private String pronunciamientoFACH;
	
	@Column(name="SOOP_PRONUNCIAMIENTO_INACH")
	@Length(max=5000)
	private String pronunciamientoINACH;
	
	@Column(name="SOOP_PRONUNCIAMIENTO_JAC")
	@Length(max=5000)
	private String pronunciamientoJAC;
	
	@OneToMany(mappedBy = "solicitudOperacion")
	private List<ArsvAsignacion> asignaciones;
	
	
	
	
	/**********************************Constructor para los campos lista**********************************/	
	public SolicitudOperacion() {
		super();
	}

	public String getLicencia() {
		return licencia;
	}

	public void setLicencia(String licencia) {
		this.licencia = licencia;
	}

	public Long getHabilitacion() {
		return habilitacion;
	}

	public void setHabilitacion(Long habilitacion) {
		this.habilitacion = habilitacion;
	}

	public String getRepresentante() {
		return representante;
	}

	public void setRepresentante(String representante) {
		this.representante = representante;
	}

	public Long getNumeroTripulantes() {
		return numeroTripulantes;
	}

	public void setNumeroTripulantes(Long numeroTripulantes) {
		this.numeroTripulantes = numeroTripulantes;
	}

	public String getObjetivo() {
		return objetivo;
	}

	public void setObjetivo(String objetivo) {
		this.objetivo = objetivo;
	}

	public Date getHoraArribo() {
		return horaArribo;
	}

	public void setHoraArribo(Date horaArribo) {
		this.horaArribo = horaArribo;
	}

	public Date getHoraSalida() {
		return horaSalida;
	}

	public void setHoraSalida(Date horaSalida) {
		this.horaSalida = horaSalida;
	}

	public Long getCantidadAsiento() {
		return cantidadAsiento;
	}

	public void setCantidadAsiento(Long cantidadAsiento) {
		this.cantidadAsiento = cantidadAsiento;
	}

	public Long getTiempoPermanencia() {
		return tiempoPermanencia;
	}

	public void setTiempoPermanencia(Long tiempoPermanencia) {
		this.tiempoPermanencia = tiempoPermanencia;
	}

	public List<ArsvAsignacion> getAsignaciones() {
		return asignaciones;
	}

	public void setAsignaciones(List<ArsvAsignacion> asignaciones) {
		this.asignaciones = asignaciones;
	}

	public String getPronunciamientoFACH() {
		return pronunciamientoFACH;
	}

	public void setPronunciamientoFACH(String pronunciamientoFACH) {
		this.pronunciamientoFACH = pronunciamientoFACH;
	}

	public String getPronunciamientoINACH() {
		return pronunciamientoINACH;
	}

	public void setPronunciamientoINACH(String pronunciamientoINACH) {
		this.pronunciamientoINACH = pronunciamientoINACH;
	}

	public String getPronunciamientoJAC() {
		return pronunciamientoJAC;
	}

	public void setPronunciamientoJAC(String pronunciamientoJAC) {
		this.pronunciamientoJAC = pronunciamientoJAC;
	}
}
