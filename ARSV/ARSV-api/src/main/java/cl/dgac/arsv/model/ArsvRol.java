package cl.dgac.arsv.model;

import java.io.Serializable;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;


/**
 * The persistent class for the arsv_roles database table.
 * 
 */
@Entity
@Table(name="ARSV_ROLES")
public class ArsvRol implements Serializable {



	/**
	 * 
	 */
	private static final long serialVersionUID = 4260534410851880785L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="ROLE_ID_ROL", unique = true, nullable = false)
	private Long roleIdRol;

	@Column(name="ROLE_DESCRIPCION_ROL")
	private String roleDescripcionRol;

	//bi-directional many-to-many association to ArsvUsuario
	@ManyToMany(mappedBy="arsvRoles")
	private Set<ArsvUsuario> arsvUsuarios;

	public Long getRoleIdRol() {
		return this.roleIdRol;
	}

	public void setRoleIdRol(Long roleIdRol) {
		this.roleIdRol = roleIdRol;
	}

	public String getRoleDescripcionRol() {
		return this.roleDescripcionRol;
	}

	public void setRoleDescripcionRol(String roleDescripcionRol) {
		this.roleDescripcionRol = roleDescripcionRol;
	}

	public Set<ArsvUsuario> getArsvUsuarios() {
		return this.arsvUsuarios;
	}

	public void setArsvUsuarios(Set<ArsvUsuario> arsvUsuarios) {
		this.arsvUsuarios = arsvUsuarios;
	}
	
	public String getNaturalId() {
		return this.getRoleDescripcionRol();
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
		ArsvRol other = (ArsvRol) obj;
		if (getNaturalId() == null) {
			if (other.getNaturalId() != null)
				return false;
		} else if (!getNaturalId().equals(other.getNaturalId()))
			return false;
		return true;
	}
}