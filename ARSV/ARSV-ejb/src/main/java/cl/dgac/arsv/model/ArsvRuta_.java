package cl.dgac.arsv.model;

import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="Dali", date="2013-07-31T10:25:30.460-0400")
@StaticMetamodel(ArsvRuta.class)
public class ArsvRuta_ {
	public static volatile SingularAttribute<ArsvRuta, Long> id;
	public static volatile SingularAttribute<ArsvRuta, Solicitud> solicitud;
	public static volatile SingularAttribute<ArsvRuta, Long> idUnidad;
	public static volatile SingularAttribute<ArsvRuta, String> posta;
	public static volatile SingularAttribute<ArsvRuta, Long> tipoRuta;
	public static volatile SingularAttribute<ArsvRuta, String> aroLocal;
	public static volatile SingularAttribute<ArsvRuta, String> centroControl;
	public static volatile SingularAttribute<ArsvRuta, String> torreControl;
}
