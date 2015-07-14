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
@Table(name="ARSV_RUTAS")
public class ArsvRuta implements Serializable{
	


	/**
	 * 
	 */
	private static final long serialVersionUID = 7054777271765480395L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="RUTA_CODIGO_RUTA")
	private Long id;
	
	@ManyToOne(targetEntity = Solicitud.class)
	@JoinColumn(name = "SOLI_ID", referencedColumnName="SOLI_ID")
	private Solicitud solicitud;
	
	@Column(name = "RUTA_ID_UNIDAD")
	private Long idUnidad;
	
	@Column(name = "OACI_COACI_POSTA")
	private String posta;
	
	@Column(name = "OACI_TIPO_RUTA")
	private Long tipoRuta;
	
	@Column(name = "RUTA_ARO_LOCAL")
	private String aroLocal;

	@Column(name = "RUTA_CENTRO_CONTROL")
	private String centroControl;

	@Column(name = "RUTA_TORRE_CONTROL")
	private String torreControl;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Solicitud getSolicitud() {
		return solicitud;
	}

	public void setSolicitud(Solicitud solicitud) {
		this.solicitud = solicitud;
	}

	public String getPosta() {
		return posta;
	}

	public void setPosta(String posta) {
		this.posta = posta;
	}

	public String getAroLocal() {
		return aroLocal;
	}

	public void setAroLocal(String aroLocal) {
		this.aroLocal = aroLocal;
	}

	public String getCentroControl() {
		return centroControl;
	}

	public void setCentroControl(String centroControl) {
		this.centroControl = centroControl;
	}

	public String getTorreControl() {
		return torreControl;
	}

	public void setTorreControl(String torreControl) {
		this.torreControl = torreControl;
	}

	public Long getIdUnidad() {
		return idUnidad;
	}

	public void setIdUnidad(Long idUnidad) {
		this.idUnidad = idUnidad;
	}

	public Long getTipoRuta() {
		return tipoRuta;
	}

	public void setTipoRuta(Long tipoRuta) {
		this.tipoRuta = tipoRuta;
	}

	
	
}
