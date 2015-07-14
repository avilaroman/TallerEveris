package cl.dgac.arsv.filters;

import javax.inject.Named;

import cl.dgac.arsv.model.ArsvBaseOperacion;
import cl.seis.generic.filters.FiltroBase;

@Named("filtroArsvBaseOperacion")
public class FiltroArsvBaseOperacion extends FiltroBase<ArsvBaseOperacion> {



	/**
	 * 
	 */
	private static final long serialVersionUID = 5513397537538765568L;

	private Long codigo;
	
	private boolean descripcionOrdenar = false;

	public FiltroArsvBaseOperacion() {
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