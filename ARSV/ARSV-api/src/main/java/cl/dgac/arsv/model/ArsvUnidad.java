package cl.dgac.arsv.model;

import java.io.Serializable;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;


/**
 * The persistent class for the arsv_unidades database table.
 * 
 */
@Entity
@Table(name="ARSV_AREA_UNIDADES")
public class ArsvUnidad implements Serializable {


	/**
	 * 
	 */
	private static final long serialVersionUID = 3015976874996493930L;

	@Id
	@Column(name="ARUN_CODIGO_UNIDADES")	
	private Long id;
	
	@Column(name="ARUN_DESC_UNIDADES")
	private String nombre;	

	//bi-directional many-to-one association to ArsvAsignacionAUni
	@OneToMany(mappedBy="arsvUnidad")
	private Set<ArsvAsignacion> arsvAsignacionAUni;
	
	@Column(name = "ARUN_CORREO")
	private String correo;
	
	@Column(name = "ARUN_CONTACTO")
	private String contacto;
	
	@Column(name = "ARUN_FONO")
	private String fono;

	@Column(name = "ARUN_CORREO_ARO")
	private String correoAro;
	
	@Column(name = "ARUN_CONTACTO_ARO")
	private String contactoAro;
	
	@Column(name = "ARUN_FONO_ARO")
	private String fonoARO;
	
	@Column(name = "ARUN_TIPO")
	private String tipo;
	
	@Column(name = "ARUN_NACIONAL")
	private String nacional;
	
	@Column(name = "ARUN_CODIGO_CENTRO")
	private String codigoCentro;
	
	@Column(name = "ARUN_GRUPO_CECO")
	private String grupoCeco;
	
	@Column(name = "ARUN_GRUPO_TOCO")
	private String grupoToco;
	
	@Column(name = "ARUN_GRUPO_ARO")
	private String grupoAro;
	
	public Long getId() {
		return id;
	}
	
	public void setId(Long id) {
		this.id = id;
	}	

	public String getNombre() {
		return nombre;
	}
	
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public Set<ArsvAsignacion> getArsvAsignacionAUni() {
		return this.arsvAsignacionAUni;
	}

	public void setArsvAsignacionAUni(Set<ArsvAsignacion> arsvAsignacionAUni) {
		this.arsvAsignacionAUni = arsvAsignacionAUni;
	}
	
	public String getCorreo() {
		return correo;
	}

	public void setCorreo(String correo) {
		this.correo = correo;
	}

	public String getContacto() {
		return contacto;
	}

	public void setContacto(String contacto) {
		this.contacto = contacto;
	}

	public String getFono() {
		return fono;
	}

	public void setFono(String fono) {
		this.fono = fono;
	}

	public String getCorreoAro() {
		return correoAro;
	}

	public void setCorreoAro(String correoAro) {
		this.correoAro = correoAro;
	}

	public String getContactoAro() {
		return contactoAro;
	}

	public void setContactoAro(String contactoAro) {
		this.contactoAro = contactoAro;
	}

	public String getFonoARO() {
		return fonoARO;
	}

	public void setFonoARO(String fonoARO) {
		this.fonoARO = fonoARO;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public String getNacional() {
		return nacional;
	}

	public void setNacional(String nacional) {
		this.nacional = nacional;
	}

	public String getCodigoCentro() {
		return codigoCentro;
	}

	public void setCodigoCentro(String codigoCentro) {
		this.codigoCentro = codigoCentro;
	}

	public String getGrupoCeco() {
		return grupoCeco;
	}

	public void setGrupoCeco(String grupoCeco) {
		this.grupoCeco = grupoCeco;
	}

	public String getGrupoToco() {
		return grupoToco;
	}

	public void setGrupoToco(String grupoToco) {
		this.grupoToco = grupoToco;
	}

	public String getGrupoAro() {
		return grupoAro;
	}

	public void setGrupoAro(String grupoAro) {
		this.grupoAro = grupoAro;
	}	
	
	
}