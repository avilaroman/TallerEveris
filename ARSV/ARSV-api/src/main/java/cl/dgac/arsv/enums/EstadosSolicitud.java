package cl.dgac.arsv.enums;

public enum EstadosSolicitud {

	REGI("REGI","Registrada"),
	INCO("INCO","Incompleta"),
	COMP("COMP","Completa"),
	CORR("CORR","Corregida"),
	ENTR("ENTR","En Tramite"),
	APRO("APRO","Aprobada"),
	RECH("RECH","Rechazada"),
	INFO("INFO","Informada a Operador"),
	ANUL("ANUL","Anulada"),
	CANC("CANC","Cancelada");

	String codeEstadosSolicitud;
	
	String description;
	
	public String getCodeEstadosSolicitud() {
		return codeEstadosSolicitud;
	}

	EstadosSolicitud(String code, String desc){
		this.codeEstadosSolicitud = code;
		this.description = desc;
	}
	
	public String getDescription() {
		return description;
	}
}