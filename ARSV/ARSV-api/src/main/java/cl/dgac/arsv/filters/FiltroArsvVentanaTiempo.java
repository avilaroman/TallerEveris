package cl.dgac.arsv.filters;

import javax.inject.Named;

import cl.dgac.arsv.model.ArsvVentanaTiempo;
import cl.seis.generic.filters.FiltroBase;

@Named("filtroArsvVentanaTiempo")
public class FiltroArsvVentanaTiempo extends FiltroBase<ArsvVentanaTiempo> {

	/**
	 * 
	 */
	private static final long serialVersionUID = 6068271793849582934L;

	private Long codigo;
	
	private boolean descripcionOrdenar = false;

	public FiltroArsvVentanaTiempo() {
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