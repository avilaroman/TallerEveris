package cl.dgac.arsv.filters;

import javax.inject.Named;

import cl.dgac.arsv.model.ArsvProgramaActividad;
import cl.seis.generic.filters.FiltroBase;

@Named("filtroArsvProgramaActividad")
public class FiltroArsvProgramaActividad extends FiltroBase<ArsvProgramaActividad> {


	/**
	 * 
	 */
	private static final long serialVersionUID = -8634593847868666035L;

	private Long codigo;
	
	private boolean descripcionOrdenar = false;

	public FiltroArsvProgramaActividad() {
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