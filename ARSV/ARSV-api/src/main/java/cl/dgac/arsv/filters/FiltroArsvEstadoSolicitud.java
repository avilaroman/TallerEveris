package cl.dgac.arsv.filters;

import javax.inject.Named;

import cl.dgac.arsv.model.ArsvEstadoSolicitud;
import cl.seis.generic.filters.FiltroBase;

@Named("filtroArsvEstadoSolicitud")
public class FiltroArsvEstadoSolicitud extends FiltroBase<ArsvEstadoSolicitud> {


	/**
	 * 
	 */
	private static final long serialVersionUID = -3249544001518205514L;

	private Long codigo;
	
	private boolean descripcionOrdenar = false;

	public FiltroArsvEstadoSolicitud() {
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