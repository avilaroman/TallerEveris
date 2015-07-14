package cl.dgac.arsv.enums;

public enum EstadoMisTareas {
	ING_RECL,//(Ingresada reclamada) Solicitud ha sido ingresada y luego un Centralizador la reclamó para realizar acciones sobre ella.
	ING_LEID,//(Ingresada Leída) El usuario conectado a clickeado en una solicitud y ésta se desplegó en la pantalla Gestionar Solicitud, pero no realizó ninguna acción, solo la vio y cerró el formulario.
	ASG_RECL,//(Asignada reclamada)	Solicitud que ha sido asignada a una Oirs Local y que fue reclamada por un usuario con el rol Encargado OIRS (por confirmar)
	DER_ESPC;//(Derivada a Especialista) La solicitud ha sido derivada al especialista, para que dé respuesta a esta.
	
}
