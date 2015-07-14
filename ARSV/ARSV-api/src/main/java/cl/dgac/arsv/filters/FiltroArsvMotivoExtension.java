package cl.dgac.arsv.filters;

import javax.inject.Named;

import cl.dgac.arsv.model.ArsvMotivoExtension;
import cl.seis.generic.filters.FiltroBase;

@Named("filtroArsvMotivoExtension")
public class FiltroArsvMotivoExtension extends FiltroBase<ArsvMotivoExtension> {

	
	/**
	 * 
	 */
	private static final long serialVersionUID = 568607653242490075L;

	private Long codigo;
	
	private boolean descripcionOrdenar = false;

	public FiltroArsvMotivoExtension() {
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