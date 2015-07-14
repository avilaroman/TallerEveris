package cl.dgac.arsv.filters;

import javax.inject.Named;

import cl.dgac.arsv.model.ArsvRuta;
import cl.seis.generic.filters.FiltroBase;

@Named("filtroArsvRuta")
public class FiltroArsvRuta extends FiltroBase<ArsvRuta> {


	/**
	 * 
	 */
	private static final long serialVersionUID = -9200655029861722900L;

	private Long codigo;
	private boolean descripcionOrdenar = false;
	private Long solicitud;
	private Long tipoRuta;

	public FiltroArsvRuta() {
		super();
	}

	@Override
	public void limpiar() {
		this.codigo = null;
		this.descripcionOrdenar = false;
		this.solicitud = null;
		this.tipoRuta = null;
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

	public Long getSolicitud() {
		return solicitud;
	}

	public void setSolicitud(Long solicitud) {
		this.solicitud = solicitud;
	}

	public Long getTipoRuta() {
		return tipoRuta;
	}

	public void setTipoRuta(Long tipoRuta) {
		this.tipoRuta = tipoRuta;
	}	
	
	

}