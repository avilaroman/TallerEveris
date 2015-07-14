package cl.dgac.arsv.filters;

import javax.inject.Named;

import cl.dgac.arsv.model.ArsvSeguridad;
import cl.seis.generic.filters.FiltroBase;

@Named("filtroArsvSeguridad")
public class FiltroArsvSeguridad extends FiltroBase<ArsvSeguridad> {


	/**
	 * 
	 */
	private static final long serialVersionUID = -7682469684329695776L;

	private String usuario;
	private String token;
	

	public FiltroArsvSeguridad() {
		super();
	}

	@Override
	public void limpiar() {
		this.usuario = null;
		this.token = null;
	}

	public String getUsuario() {
		return usuario;
	}

	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}

	public String getToken() {
		return token;
	}

	public void setToken(String token) {
		this.token = token;
	}

	



}