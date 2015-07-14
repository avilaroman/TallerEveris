package cl.dgac.arsv.model;

import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="Dali", date="2013-07-31T10:25:30.465-0400")
@StaticMetamodel(ArsvVentanaTiempo.class)
public class ArsvVentanaTiempo_ {
	public static volatile SingularAttribute<ArsvVentanaTiempo, Long> id;
	public static volatile SingularAttribute<ArsvVentanaTiempo, OperacionPascua> operacionPascua;
	public static volatile SingularAttribute<ArsvVentanaTiempo, Date> horaInicial;
	public static volatile SingularAttribute<ArsvVentanaTiempo, Date> horaFinal;
}
