package cl.dgac.arsv.filters;

import javax.inject.Named;

import cl.dgac.arsv.model.ArsvObjetoVuelo;
import cl.seis.generic.filters.FiltroBase;

@Named("filtroArsvObjetoVuelo")
public class FiltroArsvObjetoVuelo extends FiltroBase<ArsvObjetoVuelo> {

	private static final long serialVersionUID = -5693847989313419868L;
	
	private Long codigoObjetoVuelo;
	
	private boolean descripcionOrdenar = false;

	public FiltroArsvObjetoVuelo() {
		super();
	}

	@Override
	public void limpiar() {
		this.codigoObjetoVuelo = null;
		this.descripcionOrdenar = false;
	}
	
	public Long getCodigoObjetoVuelo() {
		return codigoObjetoVuelo;
	}

	public void setCodigoObjetoVuelo(Long codigoObjetoVuelo) {
		this.codigoObjetoVuelo = codigoObjetoVuelo;
	}

	public boolean isDescripcionOrdenar() {
		return descripcionOrdenar;
	}

	public void setDescripcionOrdenar(boolean descripcionOrdenar) {
		this.descripcionOrdenar = descripcionOrdenar;
	}	

}