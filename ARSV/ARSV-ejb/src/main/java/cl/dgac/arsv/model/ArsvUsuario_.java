package cl.dgac.arsv.model;

import javax.annotation.Generated;
import javax.persistence.metamodel.SetAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="Dali", date="2013-07-31T10:25:30.464-0400")
@StaticMetamodel(ArsvUsuario.class)
public class ArsvUsuario_ {
	public static volatile SingularAttribute<ArsvUsuario, Long> usuaIdUsuario;
	public static volatile SingularAttribute<ArsvUsuario, String> usuaClaveUser;
	public static volatile SingularAttribute<ArsvUsuario, String> usuaMActivo;
	public static volatile SingularAttribute<ArsvUsuario, String> usuaMencargadoUnidad;
	public static volatile SingularAttribute<ArsvUsuario, String> usuaMespecialista;
	public static volatile SingularAttribute<ArsvUsuario, String> usuaMjefeUnidad;
	public static volatile SingularAttribute<ArsvUsuario, String> usuaRutUsuario;
	public static volatile SingularAttribute<ArsvUsuario, String> usuaTapellidoUsuario;
	public static volatile SingularAttribute<ArsvUsuario, Integer> usuaTelefono;
	public static volatile SingularAttribute<ArsvUsuario, String> usuaTmail;
	public static volatile SingularAttribute<ArsvUsuario, String> usuaTnombreUsuario;
	public static volatile SingularAttribute<ArsvUsuario, String> usuaUser;
	public static volatile SetAttribute<ArsvUsuario, ArsvRol> arsvRoles;
}
