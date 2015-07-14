package cl.dgac.arsv.model;

import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="Dali", date="2013-04-11T18:58:58.055-0300")
@StaticMetamodel(ArsvAsignacion.class)
public class ArsvAsignacion_ {
	public static volatile SingularAttribute<ArsvAsignacion, Long> id;
	public static volatile SingularAttribute<ArsvAsignacion, ArsvRuta> arsvUnidad;
	public static volatile SingularAttribute<ArsvAsignacion, Date> fechaAsignacion;
	public static volatile SingularAttribute<ArsvAsignacion, String> comentarioTramitador;
	public static volatile SingularAttribute<ArsvAsignacion, String> respuestaAsignado;
	public static volatile SingularAttribute<ArsvAsignacion, Long> idAroAmbAsigna;
	public static volatile SingularAttribute<ArsvAsignacion, SolicitudArriboSobrevuelo> solicitudArsv;
	public static volatile SingularAttribute<ArsvAsignacion, SolicitudOperacion> solicitudOperacion;
	public static volatile SingularAttribute<ArsvAsignacion, SolicitudExtPermanencia> solicitudExt;
}
