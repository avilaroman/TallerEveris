package cl.dgac.arsv.model;

import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="Dali", date="2013-08-12T10:33:56.661-0400")
@StaticMetamodel(Solicitud.class)
public class Solicitud_ {
	public static volatile SingularAttribute<Solicitud, Long> id;
	public static volatile SingularAttribute<Solicitud, Date> fechaCreacion;
	public static volatile SingularAttribute<Solicitud, Date> fechaCierre;
	public static volatile SingularAttribute<Solicitud, String> callSign;
	public static volatile SingularAttribute<Solicitud, String> direccion;
	public static volatile SingularAttribute<Solicitud, String> direccionFacturacion;
	public static volatile SingularAttribute<Solicitud, String> nombreEmpresa;
	public static volatile SingularAttribute<Solicitud, String> razonSocial;
	public static volatile SingularAttribute<Solicitud, String> nombrePiloto;
	public static volatile SingularAttribute<Solicitud, Long> MTOW;
	public static volatile SingularAttribute<Solicitud, Long> cantidadVuelos;
	public static volatile SingularAttribute<Solicitud, String> observaciones;
	public static volatile SingularAttribute<Solicitud, Date> fechaArribo;
	public static volatile SingularAttribute<Solicitud, Date> fechaSalida;
	public static volatile SingularAttribute<Solicitud, Date> vigenciaSeguro;
	public static volatile SingularAttribute<Solicitud, String> embarcador;
	public static volatile SingularAttribute<Solicitud, String> consignatario;
	public static volatile SingularAttribute<Solicitud, String> correoElectronico;
	public static volatile SingularAttribute<Solicitud, String> correoElectronicoOperador;
	public static volatile SingularAttribute<Solicitud, ArsvEstadoSolicitud> arsvEstadoSolicitud;
	public static volatile SingularAttribute<Solicitud, String> antecedentesSolicitados;
	public static volatile SingularAttribute<Solicitud, String> detalleSolicitud;
	public static volatile SingularAttribute<Solicitud, ArsvTipoSolicitud> tipoSolicitud;
	public static volatile SingularAttribute<Solicitud, ArsvPaisOrigen> paisAeronave;
	public static volatile SingularAttribute<Solicitud, ArsvPaisOrigen> paisOrigen;
	public static volatile SingularAttribute<Solicitud, ArsvOACI> arsvOACI;
	public static volatile SingularAttribute<Solicitud, ArsvUnidadPeso> unidadPeso;
	public static volatile SingularAttribute<Solicitud, ArsvClasificacion> clasificacion;
	public static volatile SingularAttribute<Solicitud, ArsvObjetoVuelo> objetoVuelo;
	public static volatile ListAttribute<Solicitud, SolicitudExtPermanencia> solicitudExtPermanencias;
	public static volatile ListAttribute<Solicitud, DocumentoAdjunto> documentosAdjuntos;
	public static volatile ListAttribute<Solicitud, ArsvRuta> arsvRutas;
	public static volatile ListAttribute<Solicitud, ArsvRuta> arsvRutas2;
	public static volatile SingularAttribute<Solicitud, String> sacAeronave;
}
