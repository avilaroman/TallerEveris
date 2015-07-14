package cl.dgac.arsv.filters;

import javax.inject.Named;

import cl.dgac.arsv.model.ArsvAsignacion;
import cl.seis.generic.filters.FiltroBase;

@Named("filtroArsvAsignacion")
public class FiltroArsvAsignacion extends FiltroBase<ArsvAsignacion> {


	/**
	 * 
	 */
	private static final long serialVersionUID = -9185964238867806561L;

	private Long idAsignacion;
	private Long idSolicitud;
	private Boolean respuestaAsignado;

	public FiltroArsvAsignacion() {
		super();
	}

	@Override
	public void limpiar() {
		this.idAsignacion = null;
		this.idSolicitud = null;
		this.respuestaAsignado = null;
	}

	public Long getIdAsignacion() {
		return idAsignacion;
	}

	public void setIdAsignacion(Long idAsignacion) {
		this.idAsignacion = idAsignacion;
	}

	public Long getIdSolicitud() {
		return idSolicitud;
	}

	public void setIdSolicitud(Long idSolicitud) {
		this.idSolicitud = idSolicitud;
	}

	public Boolean getRespuestaAsignado() {
		return respuestaAsignado;
	}

	public void setRespuestaAsignado(Boolean respuestaAsignado) {
		this.respuestaAsignado = respuestaAsignado;
	}




}