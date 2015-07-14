package cl.dgac.arsv.enums;

public enum EstadoSolicitudCerrado {
	FIN_CONF,//(Finalizada Conforme) El ciudadano está conforme con la respuesta de la solicitud, y manifiesta esta conformidad al aprobar la respuesta en el formulario desplegado al clickear el  link.
	FIN_CADU,//(Finalizada por caducidad) La solicitud caducó debido al tiempo transcurrido, estando en poder del Ciudadano.
	CER_CENT,//(Cerrada por Centralizador) El centralizador tiene la facultad de poder cerrar una solicitud, y al hacerlo queda en estado FIN_CCEN.
	DER_EXTR;//(Derivación a externo) el centralizador deriva la solicitud a un organismo externo
}
