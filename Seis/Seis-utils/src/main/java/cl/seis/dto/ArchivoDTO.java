package cl.seis.dto;

import java.io.Serializable;

public class ArchivoDTO implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 2686913007062605102L;

	private String nombre;
	private byte[] datos;
	private Long tamanio;
	private String contentType;

	public ArchivoDTO() {

	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public byte[] getDatos() {
		return datos;
	}

	public void setDatos(byte[] datos) {
		this.datos = datos;
	}

	public Long getTamanio() {
		return tamanio;
	}

	public void setTamanio(Long tamanio) {
		this.tamanio = tamanio;
	}

	public String getContentType() {
		return contentType;
	}

	public void setContentType(String contentType) {
		this.contentType = contentType;
	}
}
