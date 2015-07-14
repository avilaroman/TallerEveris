package cl.dgac.arsv.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Transient;
import javax.validation.Valid;

@Entity
@Table(name = "ARSV_SOLI_OPERACIONES_ANTARTICA")
public class OperacionAntartica extends SolicitudOperacion{

	/**
	 * 
	 */
	private static final long serialVersionUID = 4672806069623320569L;
	
	@OneToMany(targetEntity = ArsvProgramaActividad.class, mappedBy="solicitudOperacion",	cascade = CascadeType.ALL)
	private List<ArsvProgramaActividad> arsvProgramaActividad;
	
	@Transient
	private List<ArsvProgramaActividad> programaActividad;
	
	@OneToMany(targetEntity = ArsvEquipoUsar.class, mappedBy="solicitudOperacion",	cascade = CascadeType.ALL)
	private List<ArsvEquipoUsar> arsvEquipoUsar;
	
	@Transient
	private List<ArsvEquipoUsar> equipoUsar;
	
	@ManyToOne
	@JoinColumn(name = "PAOR_ID_PAIS_PILOTO")
	@Valid
	private ArsvPaisOrigen paisOrigenPiloto;
	
	@ManyToOne
	@JoinColumn(name = "PAOR_ID_PAIS_EMISION")
	@Valid
	private ArsvPaisOrigen paisOrigenEmision;
	
	@ManyToOne
	@JoinColumn(name = "BAOP_CODIGO_BASE")
	private ArsvBaseOperacion arsvBaseOperacion;
	
	@ManyToOne
	@JoinColumn(name = "TICO_CODIGO_COMUNICACION")
	private ArsvTipoComunicacion arsvTipoComunicacion;

	public OperacionAntartica() {
		super();
		this.arsvBaseOperacion = new ArsvBaseOperacion();
		this.arsvTipoComunicacion = new ArsvTipoComunicacion();
		this.paisOrigenEmision = new ArsvPaisOrigen();
		this.paisOrigenPiloto = new ArsvPaisOrigen();
	}

	public List<ArsvProgramaActividad> getArsvProgramaActividad() {
		return arsvProgramaActividad;
	}

	public void setArsvProgramaActividad(
			List<ArsvProgramaActividad> arsvProgramaActividad) {
		this.arsvProgramaActividad = arsvProgramaActividad;
	}

	public List<ArsvProgramaActividad> getProgramaActividad() {
		return programaActividad;
	}

	public void setProgramaActividad(List<ArsvProgramaActividad> programaActividad) {
		this.programaActividad = programaActividad;
	}

	public List<ArsvEquipoUsar> getArsvEquipoUsar() {
		return arsvEquipoUsar;
	}

	public void setArsvEquipoUsar(List<ArsvEquipoUsar> arsvEquipoUsar) {
		this.arsvEquipoUsar = arsvEquipoUsar;
	}

	public List<ArsvEquipoUsar> getEquipoUsar() {
		return equipoUsar;
	}

	public void setEquipoUsar(List<ArsvEquipoUsar> equipoUsar) {
		this.equipoUsar = equipoUsar;
	}

	public ArsvPaisOrigen getPaisOrigenPiloto() {
		return paisOrigenPiloto;
	}

	public void setPaisOrigenPiloto(ArsvPaisOrigen paisOrigenPiloto) {
		this.paisOrigenPiloto = paisOrigenPiloto;
	}

	public ArsvPaisOrigen getPaisOrigenEmision() {
		return paisOrigenEmision;
	}

	public void setPaisOrigenEmision(ArsvPaisOrigen paisOrigenEmision) {
		this.paisOrigenEmision = paisOrigenEmision;
	}

	public ArsvBaseOperacion getArsvBaseOperacion() {
		return arsvBaseOperacion;
	}

	public void setArsvBaseOperacion(ArsvBaseOperacion arsvBaseOperacion) {
		this.arsvBaseOperacion = arsvBaseOperacion;
	}

	public ArsvTipoComunicacion getArsvTipoComunicacion() {
		return arsvTipoComunicacion;
	}

	public void setArsvTipoComunicacion(ArsvTipoComunicacion arsvTipoComunicacion) {
		this.arsvTipoComunicacion = arsvTipoComunicacion;
	}
	
	

}
