package cl.dgac.arsv.filters;

import javax.inject.Named;

import cl.dgac.arsv.model.ArsvRol;
import cl.seis.generic.filters.FiltroBase;

@Named("filtroArsvRol")
public class FiltroArsvRol extends FiltroBase<ArsvRol> {

	/**
	 * 
	 */
	private static final long serialVersionUID = -2367994385678508082L;

	private Long codigo;
	
	private boolean descripcionOrdenar = false;

	public FiltroArsvRol() {
		super();
	}

	@Override
	public void limpiar() {
		this.codigo = null;
		this.descripcionOrdenar = false;
	}

	public Long getCodigo() {
		return codigo;
	}

	public void setCodigo(Long codigo) {
		this.codigo = codigo;
	}

	public boolean isDescripcionOrdenar() {
		return descripcionOrdenar;
	}

	public void setDescripcionOrdenar(boolean descripcionOrdenar) {
		this.descripcionOrdenar = descripcionOrdenar;
	}	

}