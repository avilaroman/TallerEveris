package cl.dgac.arsv.filters;

import javax.inject.Named;

import cl.dgac.arsv.model.ArsvTipoComunicacion;
import cl.seis.generic.filters.FiltroBase;

@Named("filtroArsvTipoComunicacion")
public class FiltroArsvTipoComunicacion extends FiltroBase<ArsvTipoComunicacion> {

	/**
	 * 
	 */
	private static final long serialVersionUID = 5166334637457186089L;

	private Long codigo;
	
	private boolean descripcionOrdenar = false;

	public FiltroArsvTipoComunicacion() {
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