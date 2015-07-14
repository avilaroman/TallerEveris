package cl.dgac.arsv.model;

import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="Dali", date="2013-07-31T10:25:30.461-0400")
@StaticMetamodel(ArsvSeguridad.class)
public class ArsvSeguridad_ {
	public static volatile SingularAttribute<ArsvSeguridad, Long> idSeguridad;
	public static volatile SingularAttribute<ArsvSeguridad, String> usuario;
	public static volatile SingularAttribute<ArsvSeguridad, String> token;
	public static volatile SingularAttribute<ArsvSeguridad, Date> fechaCreacion;
	public static volatile SingularAttribute<ArsvSeguridad, Integer> duracion;
}
