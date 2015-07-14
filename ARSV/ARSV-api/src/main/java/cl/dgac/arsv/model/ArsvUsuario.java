package cl.dgac.arsv.model;

import java.io.Serializable;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;


/**
 * The persistent class for the oirs_usuarios database table.
 * 
 */
@Entity
@Table(name="ARSV_USUARIOS")
public class ArsvUsuario implements Serializable {



	/**
	 * 
	 */
	private static final long serialVersionUID = -4893404725025063778L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="USUA_ID_USUARIO", unique = true, nullable = false)
	private Long usuaIdUsuario;

	@Column(name="USUA_CLAVE_USER")
	private String usuaClaveUser;

	@Column(name="USUA_M_ACTIVO")
	private String usuaMActivo;

	@Column(name="USUA_MENCARGADO_UNIDAD")
	private String usuaMencargadoUnidad;

	@Column(name="USUA_MESPECIALISTA")
	private String usuaMespecialista;

	@Column(name="USUA_MJEFE_UNIDAD")
	private String usuaMjefeUnidad;

	@Column(name="USUA_RUT_USUARIO")
	private String usuaRutUsuario;

	@Column(name="USUA_TAPELLIDO_USUARIO")
	private String usuaTapellidoUsuario;

	@Column(name="USUA_TELEFONO")
	private Integer usuaTelefono;

	@Column(name="USUA_TMAIL")
	private String usuaTmail;

	@Column(name="USUA_TNOMBRE_USUARIO")
	private String usuaTnombreUsuario;

	@Column(name="USUA_USER", unique=true)
	private String usuaUser;

	//bi-directional many-to-many association to ArsvRole
    @ManyToMany(fetch = FetchType.EAGER)
	@JoinTable(
		name="ARSV_USUARIOS_ROLES"
		, joinColumns={
			@JoinColumn(name="USUA_ID_USUARIO")
			}
		, inverseJoinColumns={
			@JoinColumn(name="ROLE_ID_ROL")
			}
		)
	private Set<ArsvRol> arsvRoles;

	
	
	public Long getUsuaIdUsuario() {
		return usuaIdUsuario;
	}

	public void setUsuaIdUsuario(Long usuaIdUsuario) {
		this.usuaIdUsuario = usuaIdUsuario;
	}

	public String getUsuaClaveUser() {
		return usuaClaveUser;
	}

	public void setUsuaClaveUser(String usuaClaveUser) {
		this.usuaClaveUser = usuaClaveUser;
	}

	public String getUsuaMActivo() {
		return usuaMActivo;
	}

	public void setUsuaMActivo(String usuaMActivo) {
		this.usuaMActivo = usuaMActivo;
	}

	public String getUsuaMencargadoUnidad() {
		return usuaMencargadoUnidad;
	}

	public void setUsuaMencargadoUnidad(String usuaMencargadoUnidad) {
		this.usuaMencargadoUnidad = usuaMencargadoUnidad;
	}

	public String getUsuaMespecialista() {
		return usuaMespecialista;
	}

	public void setUsuaMespecialista(String usuaMespecialista) {
		this.usuaMespecialista = usuaMespecialista;
	}

	public String getUsuaMjefeUnidad() {
		return usuaMjefeUnidad;
	}

	public void setUsuaMjefeUnidad(String usuaMjefeUnidad) {
		this.usuaMjefeUnidad = usuaMjefeUnidad;
	}

	public String getUsuaRutUsuario() {
		return usuaRutUsuario;
	}

	public void setUsuaRutUsuario(String usuaRutUsuario) {
		this.usuaRutUsuario = usuaRutUsuario;
	}

	public String getUsuaTapellidoUsuario() {
		return usuaTapellidoUsuario;
	}

	public void setUsuaTapellidoUsuario(String usuaTapellidoUsuario) {
		this.usuaTapellidoUsuario = usuaTapellidoUsuario;
	}

	public Integer getUsuaTelefono() {
		return usuaTelefono;
	}

	public void setUsuaTelefono(Integer usuaTelefono) {
		this.usuaTelefono = usuaTelefono;
	}

	public String getUsuaTmail() {
		return usuaTmail;
	}

	public void setUsuaTmail(String usuaTmail) {
		this.usuaTmail = usuaTmail;
	}

	public String getUsuaTnombreUsuario() {
		return usuaTnombreUsuario;
	}

	public void setUsuaTnombreUsuario(String usuaTnombreUsuario) {
		this.usuaTnombreUsuario = usuaTnombreUsuario;
	}

	public String getUsuaUser() {
		return usuaUser;
	}

	public void setUsuaUser(String usuaUser) {
		this.usuaUser = usuaUser;
	}

	public Set<ArsvRol> getArsvRoles() {
		return arsvRoles;
	}

	public void setArsvRoles(Set<ArsvRol> arsvRoles) {
		this.arsvRoles = arsvRoles;
	}

//	public Set<ArsvUnidad> getArsvUnidad() {
//		return arsvUnidad;
//	}
//
//	public void setArsvUnidad(Set<ArsvUnidad> arsvUnidad) {
//		this.arsvUnidad = arsvUnidad;
//	}

	public String toString() {
		return this.getUsuaUser();
	}
	
	public String getNaturalId() {
		String natural = "";
		if (this.getUsuaUser()!=null)
			natural+=this.getUsuaUser();
		if (this.getUsuaClaveUser()!=null)
			natural+=this.getUsuaClaveUser();
		if (this.getUsuaTnombreUsuario()!=null)
			natural+=this.getUsuaTnombreUsuario();
		if (this.getUsuaTapellidoUsuario()!=null)
			natural+=this.getUsuaTapellidoUsuario();
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
		ArsvUsuario other = (ArsvUsuario) obj;
		if (getNaturalId() == null) {
			if (other.getNaturalId() != null)
				return false;
		} else if (!getNaturalId().equals(other.getNaturalId()))
			return false;
		return true;
	}
	
}