package cl.dgac.arsv.enums;

public enum EstadoSolicitudPendiente {
	ING_DISP,//(Ingresada disponible) Solicitud ingresada, pero que no ha sido reclamada por un Centralizador.
	ING_RECL,//(Ingresada reclamada) Solicitud ha sido ingresada y luego un Centralizador la reclamó para realizar acciones sobre ella.
	ASG_OIRS,//(Asignada a OIRS) Solicitud ha sido asignada a una OIRS, para que dé respuesta a esta.
	DER_ESPC,//(Derivada a Especialista) La solicitud ha sido derivada al especialista, para que dé respuesta a esta.
	DVU_CENT,//(Devuelta Centralizador)	Solicitud que fue asignada a una OIRS que no correspondía y esta la devuelve al Centralizador para que corrija la asignación.
	ESP_ANTC,//(Espera de antecedentes)	En este caso la solicitud fue devuelta al Ciudadano, para que este complete los antecedentes solicitados.
	RES_OIRS,//(Respondida por OIRS) La OIRS local respondió la solicitud y la envió al Centralizador.
	RES_ESPC,//(Respondida por Especialista) La Solicitud ha sido respondida por el especialista y ha sido enviada a OIRS que derivó la solicitud.
	RES_CENT,//(Respondida por Centralizador) El centralizador responde al Ciudadano y la solicitud queda a la espera de recibir conformidad.
	ASG_RECL,//(Asignada reclamada)	Solicitud que ha sido asignada a una Oirs Local y que fue reclamada por un usuario con el rol Encargado OIRS (por confirmar)
	ING_LEID,//(Ingresada Leída) El usuario conectado a clickeado en una solicitud y ésta se desplegó en la pantalla Gestionar Solicitud, pero no realizó ninguna acción, solo la vio y cerró el formulario.
	ING_ANTC,//(Ingresada con antecedentes) EL Ciudadano completa con más antecedentes su solicitud y la vuelve a enviar a OIRS DGAC.
	RES_DISC,//(Ingresada Disconforme) El Ciudadano recibió la respuesta de parte de la OIRS, sin embargo no está conforme con esta.
	RES_ANOL,//(Respondida OIRS Local solicita más  antecedentes) El usuario OIRS Local solicita antecedentes adicionales  del Ciudadano al usuario OIRS Centralizador
	RES_ANES,//(Respondida especialista solicita más antecedentes) El usuario Especialista solicita antecedentes adicionales  del Ciudadano al usuario OIRS Local.
	
}
