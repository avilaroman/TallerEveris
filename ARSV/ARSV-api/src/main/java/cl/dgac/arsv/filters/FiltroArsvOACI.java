package cl.dgac.arsv.filters;

import javax.inject.Named;

import cl.dgac.arsv.model.ArsvOACI;
import cl.seis.generic.filters.FiltroBase;

@Named("filtroArsvOACI")
public class FiltroArsvOACI extends FiltroBase<ArsvOACI> {



	/**
	 * 
	 */
	private static final long serialVersionUID = 7958266684259910319L;

	private String codigo;
	
	private boolean descripcionOrdenar = false;
	
	private Long idPais;

	public FiltroArsvOACI() {
		super();
	}

	@Override
	public void limpiar() {
		this.codigo = null;
		this.descripcionOrdenar = false;
		this.idPais = null;
	}

	public String getCodigo() {
		return codigo;
	}

	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}

	public boolean isDescripcionOrdenar() {
		return descripcionOrdenar;
	}

	public void setDescripcionOrdenar(boolean descripcionOrdenar) {
		this.descripcionOrdenar = descripcionOrdenar;
	}

	public Long getIdPais() {
		return idPais;
	}

	public void setIdPais(Long idPais) {
		this.idPais = idPais;
	}	

	
}