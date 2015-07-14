package cl.dgac.arsv.filters;

import javax.inject.Named;

import cl.dgac.arsv.model.ArsvPaisOrigen;
import cl.seis.generic.filters.FiltroBase;

@Named("filtroArsvPaisOrigen")
public class FiltroArsvPaisOrigen extends FiltroBase<ArsvPaisOrigen> {

	private static final long serialVersionUID = -5693847989313419868L;
	
	private Long codigo;
	
	private boolean descripcionOrdenar = false;

	public FiltroArsvPaisOrigen() {
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