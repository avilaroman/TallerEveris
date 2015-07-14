package cl.seis.generic.filters;

import java.io.Serializable;

public abstract class FiltroBase<E> implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 380158356296251789L;

	public FiltroBase() {
		super();
	}

	public abstract void limpiar();

}
