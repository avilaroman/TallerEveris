package cl.dgac.arsv.model;

import javax.annotation.Generated;
import javax.persistence.metamodel.SetAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="Dali", date="2013-07-31T10:25:30.459-0400")
@StaticMetamodel(ArsvRol.class)
public class ArsvRol_ {
	public static volatile SingularAttribute<ArsvRol, Long> roleIdRol;
	public static volatile SingularAttribute<ArsvRol, String> roleDescripcionRol;
	public static volatile SetAttribute<ArsvRol, ArsvUsuario> arsvUsuarios;
}
