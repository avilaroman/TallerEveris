package cl.dgac.arsv.filters;

import javax.inject.Named;

import cl.dgac.arsv.model.ArsvUnidadPeso;
import cl.seis.generic.filters.FiltroBase;

@Named("filtroArsvUnidadPeso")
public class FiltroArsvUnidadPeso extends FiltroBase<ArsvUnidadPeso> {




	/**
	 * 
	 */
	private static final long serialVersionUID = 7361912212351896671L;

	private String codigo;
	
	private boolean descripcionOrdenar = false;

	public FiltroArsvUnidadPeso() {
		super();
	}

	@Override
	public void limpiar() {
		this.codigo = null;
		this.descripcionOrdenar = false;
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

}