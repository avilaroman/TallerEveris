package cl.dgac.arsv.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;


@Entity
@Table(name = "ARSV_SOLI_OPERACIONES_PASCUA")
public class OperacionPascua extends SolicitudOperacion {

	/**
	 * 
	 */
	private static final long serialVersionUID = -4602607963106768234L;
	
	@OneToMany(targetEntity = ArsvVentanaTiempo.class, mappedBy="operacionPascua",	cascade = CascadeType.ALL)
	private List<ArsvVentanaTiempo> arsvVentanaTiempo;

	public OperacionPascua() {
		super();
	}

	public List<ArsvVentanaTiempo> getArsvVentanaTiempo() {
		return arsvVentanaTiempo;
	}

	public void setArsvVentanaTiempo(List<ArsvVentanaTiempo> arsvVentanaTiempo) {
		this.arsvVentanaTiempo = arsvVentanaTiempo;
	}

	
	
	
}
