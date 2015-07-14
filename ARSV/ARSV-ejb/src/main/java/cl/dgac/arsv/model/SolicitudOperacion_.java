package cl.dgac.arsv.model;

import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="Dali", date="2013-07-31T10:25:30.471-0400")
@StaticMetamodel(SolicitudOperacion.class)
public class SolicitudOperacion_ extends Solicitud_ {
	public static volatile SingularAttribute<SolicitudOperacion, String> licencia;
	public static volatile SingularAttribute<SolicitudOperacion, Long> habilitacion;
	public static volatile SingularAttribute<SolicitudOperacion, String> representante;
	public static volatile SingularAttribute<SolicitudOperacion, Long> numeroTripulantes;
	public static volatile SingularAttribute<SolicitudOperacion, String> objetivo;
	public static volatile SingularAttribute<SolicitudOperacion, Date> horaArribo;
	public static volatile SingularAttribute<SolicitudOperacion, Date> horaSalida;
	public static volatile SingularAttribute<SolicitudOperacion, Long> cantidadAsiento;
	public static volatile SingularAttribute<SolicitudOperacion, Long> tiempoPermanencia;
	public static volatile SingularAttribute<SolicitudOperacion, String> pronunciamientoFACH;
	public static volatile SingularAttribute<SolicitudOperacion, String> pronunciamientoINACH;
	public static volatile SingularAttribute<SolicitudOperacion, String> pronunciamientoJAC;
	public static volatile ListAttribute<SolicitudOperacion, ArsvAsignacion> asignaciones;
}
