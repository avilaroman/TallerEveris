package cl.dgac.arsv.filters;

import javax.inject.Named;

import cl.dgac.arsv.model.ArsvTipoSolicitud;
import cl.seis.generic.filters.FiltroBase;

@Named("filtroArsvTipoSolicitud")
public class FiltroArsvTipoSolicitud extends FiltroBase<ArsvTipoSolicitud> {

	/**
	 * 
	 */
	private static final long serialVersionUID = 4564882395594274315L;

	private String codigo;
	
	private boolean descripcionOrdenar = false;

	public FiltroArsvTipoSolicitud() {
		super();
	}

	@Override
	public void limpiar() {
		this.codigo = null;
		this.descripcionOrdenar = false;
	}

	public boolean isDescripcionOrdenar() {
		return descripcionOrdenar;
	}

	public void setDescripcionOrdenar(boolean descripcionOrdenar) {
		this.descripcionOrdenar = descripcionOrdenar;
	}

	public String getCodigo() {
		return codigo;
	}

	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}

}