package cl.dgac.arsv.model;

import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="Dali", date="2013-07-31T10:25:30.470-0400")
@StaticMetamodel(SolicitudArriboSobrevuelo.class)
public class SolicitudArriboSobrevuelo_ extends Solicitud_ {
	public static volatile SingularAttribute<SolicitudArriboSobrevuelo, String> observacionConformidad;
	public static volatile SingularAttribute<SolicitudArriboSobrevuelo, String> respuestaAroAmb;
	public static volatile SingularAttribute<SolicitudArriboSobrevuelo, String> comentarioAroAMB;
	public static volatile SingularAttribute<SolicitudArriboSobrevuelo, Date> fechaRespuesta;
	public static volatile ListAttribute<SolicitudArriboSobrevuelo, ArsvAsignacion> asignaciones;
}
