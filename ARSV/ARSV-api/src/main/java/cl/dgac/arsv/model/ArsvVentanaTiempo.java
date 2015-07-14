package cl.dgac.arsv.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "ARSV_VENTANAS_TIEMPO")
public class ArsvVentanaTiempo implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -2552047638527982515L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="VETI_CODIGO_VENTANAS_TIEMPO")
	private Long id;
	
	@ManyToOne(targetEntity = OperacionPascua.class)
	@JoinColumn(name = "SOLI_ID", referencedColumnName="SOLI_ID")
	private OperacionPascua operacionPascua;
	
	@Column(name="VETI_HORA_INICIAL")
	@Temporal(TemporalType.TIMESTAMP)
	private Date horaInicial;
	
	@Column(name="VETI_HORA_FINAL")
	@Temporal(TemporalType.TIMESTAMP)
	private Date horaFinal;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Date getHoraInicial() {
		return horaInicial;
	}

	public void setHoraInicial(Date horaInicial) {
		this.horaInicial = horaInicial;
	}

	public Date getHoraFinal() {
		return horaFinal;
	}

	public void setHoraFinal(Date horaFinal) {
		this.horaFinal = horaFinal;
	}

	public OperacionPascua getOperacionPascua() {
		return operacionPascua;
	}

	public void setOperacionPascua(OperacionPascua operacionPascua) {
		this.operacionPascua = operacionPascua;
	}
	
	

}
