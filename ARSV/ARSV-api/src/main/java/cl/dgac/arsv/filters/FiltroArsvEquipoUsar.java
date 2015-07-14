package cl.dgac.arsv.filters;

import javax.inject.Named;

import cl.dgac.arsv.model.ArsvEquipoUsar;
import cl.seis.generic.filters.FiltroBase;

@Named("filtroArsvEquipoUsar")
public class FiltroArsvEquipoUsar extends FiltroBase<ArsvEquipoUsar> {


	/**
	 * 
	 */
	private static final long serialVersionUID = 4421868230358095697L;

	private Long codigo;
	
	private boolean descripcionOrdenar = false;

	public FiltroArsvEquipoUsar() {
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