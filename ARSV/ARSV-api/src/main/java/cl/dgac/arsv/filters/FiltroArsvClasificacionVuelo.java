package cl.dgac.arsv.filters;

import javax.inject.Named;

import cl.dgac.arsv.model.ArsvClasificacion;
import cl.seis.generic.filters.FiltroBase;


@Named("filtroArsvClasificacionVuelo")
public class FiltroArsvClasificacionVuelo extends FiltroBase<ArsvClasificacion> {

	private static final long serialVersionUID = -3158424731488937417L;
	
	private Long codigoClasificacionVuelo;
	
	private boolean descripcionOrdenar = false;

	public FiltroArsvClasificacionVuelo() {
		super();
	}

	@Override
	public void limpiar() {
		this.codigoClasificacionVuelo = null;
		this.descripcionOrdenar = false;
	}

	public Long getCodigoClasificacionVuelo() {
		return codigoClasificacionVuelo;
	}

	public void setCodigoClasificacionVuelo(Long codigoClasificacionVuelo) {
		this.codigoClasificacionVuelo = codigoClasificacionVuelo;
	}

	public boolean isDescripcionOrdenar() {
		return descripcionOrdenar;
	}

	public void setDescripcionOrdenar(boolean descripcionOrdenar) {
		this.descripcionOrdenar = descripcionOrdenar;
	}	

}