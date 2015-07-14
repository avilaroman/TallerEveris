package cl.dgac.arsv.model;

import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="Dali", date="2013-07-31T10:25:30.467-0400")
@StaticMetamodel(OperacionAntartica.class)
public class OperacionAntartica_ extends SolicitudOperacion_ {
	public static volatile ListAttribute<OperacionAntartica, ArsvProgramaActividad> arsvProgramaActividad;
	public static volatile ListAttribute<OperacionAntartica, ArsvEquipoUsar> arsvEquipoUsar;
	public static volatile SingularAttribute<OperacionAntartica, ArsvPaisOrigen> paisOrigenPiloto;
	public static volatile SingularAttribute<OperacionAntartica, ArsvPaisOrigen> paisOrigenEmision;
	public static volatile SingularAttribute<OperacionAntartica, ArsvBaseOperacion> arsvBaseOperacion;
	public static volatile SingularAttribute<OperacionAntartica, ArsvTipoComunicacion> arsvTipoComunicacion;
}
