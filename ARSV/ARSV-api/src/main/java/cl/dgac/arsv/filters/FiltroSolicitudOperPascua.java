package cl.dgac.arsv.filters;

import java.util.Date;
import java.util.List;

import javax.inject.Named;

import cl.dgac.arsv.model.OperacionPascua;
import cl.seis.generic.filters.FiltroBase;

@Named("filtroSolicitudOperPascua")
public class FiltroSolicitudOperPascua extends FiltroBase<OperacionPascua> {

	/**
	 * 
	 */
	private static final long serialVersionUID = 4117058033628876204L;
	private Long idSolicitud;
	private String usuario;
	private Date fechaCreacion;
	private List<String> codigosEstado;
	
	private boolean fechaCreacionOrdenar = false;
	private Long idUnidad;

	public FiltroSolicitudOperPascua() {
		super();
	}

	@Override
	public void limpiar() {
		this.idSolicitud = null;
		this.usuario = null;
		this.fechaCreacion = null;
		this.codigosEstado = null;		
		this.fechaCreacionOrdenar = false;
		this.idUnidad = null;
	}

	public Long getIdSolicitud() {
		return idSolicitud;
	}

	public void setIdSolicitud(Long idSolicitud) {
		this.idSolicitud = idSolicitud;
	}
	
	public String getUsuario() {
		return usuario;
	}

	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}

	public Date getFechaCreacion() {
		return fechaCreacion;
	}

	public void setFechaCreacion(Date fechaCreacion) {
		this.fechaCreacion = fechaCreacion;
	}

	public List<String> getCodigosEstado() {
		return codigosEstado;
	}

	public void setCodigosEstado(List<String> codigosEstado) {
		this.codigosEstado = codigosEstado;
	}

	public boolean isFechaCreacionOrdenar() {
		return fechaCreacionOrdenar;
	}

	public void setFechaCreacionOrdenar(boolean fechaCreacionOrdenar) {
		this.fechaCreacionOrdenar = fechaCreacionOrdenar;
	}

	public Long getIdUnidad() {
		return idUnidad;
	}

	public void setIdUnidad(Long idUnidad) {
		this.idUnidad = idUnidad;
	}		
	
}