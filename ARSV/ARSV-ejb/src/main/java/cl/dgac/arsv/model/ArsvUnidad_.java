package cl.dgac.arsv.model;

import javax.annotation.Generated;
import javax.persistence.metamodel.SetAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="Dali", date="2013-07-31T10:25:30.463-0400")
@StaticMetamodel(ArsvUnidad.class)
public class ArsvUnidad_ {
	public static volatile SingularAttribute<ArsvUnidad, Long> id;
	public static volatile SingularAttribute<ArsvUnidad, String> nombre;
	public static volatile SetAttribute<ArsvUnidad, ArsvAsignacion> arsvAsignacionAUni;
	public static volatile SingularAttribute<ArsvUnidad, String> correo;
	public static volatile SingularAttribute<ArsvUnidad, String> contacto;
	public static volatile SingularAttribute<ArsvUnidad, String> fono;
	public static volatile SingularAttribute<ArsvUnidad, String> correoAro;
	public static volatile SingularAttribute<ArsvUnidad, String> contactoAro;
	public static volatile SingularAttribute<ArsvUnidad, String> fonoARO;
	public static volatile SingularAttribute<ArsvUnidad, String> tipo;
	public static volatile SingularAttribute<ArsvUnidad, String> nacional;
	public static volatile SingularAttribute<ArsvUnidad, String> codigoCentro;
	public static volatile SingularAttribute<ArsvUnidad, String> grupoCeco;
	public static volatile SingularAttribute<ArsvUnidad, String> grupoToco;
	public static volatile SingularAttribute<ArsvUnidad, String> grupoAro;
}
