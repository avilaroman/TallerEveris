package cl.dgac.arsv.filters;

import javax.inject.Named;

import cl.dgac.arsv.model.ArsvUsuario;
import cl.seis.generic.filters.FiltroBase;

@Named("filtroArsvUsuario")
public class FiltroArsvUsuario extends FiltroBase<ArsvUsuario> {

	/**
	 * 
	 */
	private static final long serialVersionUID = -1338296460541908773L;

	private String usuario;
	private String clave;

	public FiltroArsvUsuario() {
		super();
	}

	@Override
	public void limpiar() {
		this.usuario = null;
		this.clave = null;
	}

	public String getUsuario() {
		return usuario;
	}

	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}

	public String getClave() {
		return clave;
	}

	public void setClave(String clave) {
		this.clave = clave;
	}
}