package cl.dgac.arsv.filters;

import javax.inject.Named;

import cl.dgac.arsv.model.ArsvUnidad;
import cl.seis.generic.filters.FiltroBase;

@Named("filtroArsvUnidad")
public class FiltroArsvUnidad extends FiltroBase<ArsvUnidad> {

	
	/**
	 * 
	 */
	private static final long serialVersionUID = 5036470710274457156L;

	private Long idUnidad;
	private Long idGrupo;
	private Long idSolicitud;
	
	private boolean descripcionOrdenar = false;

	public FiltroArsvUnidad() {
		super();
	}

	@Override
	public void limpiar() {
		this.idUnidad = null;
		this.idGrupo = null;
		this.descripcionOrdenar = false;
		this.idSolicitud = null;
	}

	public Long getIdUnidad() {
		return idUnidad;
	}

	public void setIdUnidad(Long idUnidad) {
		this.idUnidad = idUnidad;
	}

	public Long getIdGrupo() {
		return idGrupo;
	}

	public void setIdGrupo(Long idGrupo) {
		this.idGrupo = idGrupo;
	}

	public boolean isDescripcionOrdenar() {
		return descripcionOrdenar;
	}

	public void setDescripcionOrdenar(boolean descripcionOrdenar) {
		this.descripcionOrdenar = descripcionOrdenar;
	}

	public Long getIdSolicitud() {
		return idSolicitud;
	}

	public void setIdSolicitud(Long idSolicitud) {
		this.idSolicitud = idSolicitud;
	}

	

}