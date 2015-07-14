package cl.dgac.arsv.filters;

import javax.inject.Named;

import cl.dgac.arsv.model.DocumentoAdjunto;
import cl.dgac.arsv.model.Solicitud;
import cl.seis.generic.filters.FiltroBase;

@Named("filtroDocumentoAdjunto")
public class FiltroDocumentoAdjunto extends FiltroBase<DocumentoAdjunto> {


	
	/**
	 * 
	 */
	private static final long serialVersionUID = 4582094107178313717L;

	private Solicitud solicitud;
	
	private Long idDocumento;

	private boolean fechaCreacionOrdenar = false;


	public FiltroDocumentoAdjunto() {
		super();
	}

	@Override
	public void limpiar() {
		this.solicitud = null;		
		this.fechaCreacionOrdenar = false;
		this.idDocumento = null;
	}


	public Solicitud getSolicitud() {
		return solicitud;
	}

	public void setSolicitud(Solicitud solicitud) {
		this.solicitud = solicitud;
	}

	public boolean isFechaCreacionOrdenar() {
		return fechaCreacionOrdenar;
	}

	public void setFechaCreacionOrdenar(boolean fechaCreacionOrdenar) {
		this.fechaCreacionOrdenar = fechaCreacionOrdenar;
	}

	public Long getIdDocumento() {
		return idDocumento;
	}

	public void setIdDocumento(Long idDocumento) {
		this.idDocumento = idDocumento;
	}
	
	
	
}