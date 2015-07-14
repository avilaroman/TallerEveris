package cl.dgac.arsv.filters;

import javax.inject.Named;

import cl.dgac.arsv.model.ArsvEquipoSupervivencia;
import cl.seis.generic.filters.FiltroBase;

@Named("filtroArsvEquipoSupervivencia")
public class FiltroArsvEquipoSupervivencia extends FiltroBase<ArsvEquipoSupervivencia> {

	/**
	 * 
	 */
	private static final long serialVersionUID = -5124177089878339697L;

	private Long codigo;
	
	private boolean descripcionOrdenar = false;

	public FiltroArsvEquipoSupervivencia() {
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