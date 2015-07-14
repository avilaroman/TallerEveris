package cl.dgac.arsv.model;

import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="Dali", date="2013-08-07T17:31:45.543-0400")
@StaticMetamodel(SolicitudExtPermanencia.class)
public class SolicitudExtPermanencia_ {
	public static volatile SingularAttribute<SolicitudExtPermanencia, Long> id;
	public static volatile SingularAttribute<SolicitudExtPermanencia, Date> fechaCreacion;
	public static volatile SingularAttribute<SolicitudExtPermanencia, Date> fechaCierre;
	public static volatile SingularAttribute<SolicitudExtPermanencia, Solicitud> solicitud;
	public static volatile SingularAttribute<SolicitudExtPermanencia, String> formulario;
	public static volatile SingularAttribute<SolicitudExtPermanencia, String> motivo;
	public static volatile SingularAttribute<SolicitudExtPermanencia, String> observacion;
	public static volatile SingularAttribute<SolicitudExtPermanencia, String> representante;
	public static volatile SingularAttribute<SolicitudExtPermanencia, Long> cantidadDias;
	public static volatile SingularAttribute<SolicitudExtPermanencia, Long> cantidadDiasOtorgados;
	public static volatile SingularAttribute<SolicitudExtPermanencia, Long> cantidadExtenciones;
	public static volatile SingularAttribute<SolicitudExtPermanencia, Boolean> dsoInformado;
	public static volatile SingularAttribute<SolicitudExtPermanencia, ArsvMotivoExtension> arsvMotivoExtension;
	public static volatile SingularAttribute<SolicitudExtPermanencia, ArsvTipoSolicitud> tipoSolicitud;
	public static volatile SingularAttribute<SolicitudExtPermanencia, String> comentarioAeronavegabilidad;
	public static volatile ListAttribute<SolicitudExtPermanencia, ArsvAsignacion> asignaciones;
	public static volatile SingularAttribute<SolicitudExtPermanencia, ArsvEstadoSolicitud> arsvEstadoSolicitud;
}
