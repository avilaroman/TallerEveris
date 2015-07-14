package cl.dgac.arsv.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name="ARSV_SEGURIDAD")
public class ArsvSeguridad implements Serializable {



	/**
	 * 
	 */
	private static final long serialVersionUID = -2456985070696641432L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)	
	@Column(name="SEG_ID_SEGURIDAD", unique = true, nullable = false)
	private Long idSeguridad;
		
	@Column(name="USUA_USUARIO")
	private String usuario;
			
	@Column(name="SEG_TOKEN")
	private String token;
	
	@Column(name="SEG_FECHA_CREACION")
	@Temporal(TemporalType.TIMESTAMP)
	private Date fechaCreacion;
	
	@Column(name="SEG_DURACION")
	private Integer duracion;

	public Long getIdSeguridad() {
		return idSeguridad;
	}

	public void setIdSeguridad(Long idSeguridad) {
		this.idSeguridad = idSeguridad;
	}

	public String getToken() {
		return token;
	}

	public void setToken(String token) {
		this.token = token;
	}

	public Date getFechaCreacion() {
		return fechaCreacion;
	}

	public void setFechaCreacion(Date fechaCreacion) {
		this.fechaCreacion = fechaCreacion;
	}

	
	public Integer getDuracion() {
		return duracion;
	}

	public void setDuracion(Integer duracion) {
		this.duracion = duracion;
	}

	public String getUsuario() {
		return usuario;
	}

	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}
}
