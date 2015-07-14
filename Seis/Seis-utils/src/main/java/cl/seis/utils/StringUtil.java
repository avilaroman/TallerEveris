package cl.seis.utils;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringUtil {

	private static final String PATRON_CORREO_ELECTRONICO = 
			"^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@" + "[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$";
	
	private static final String PATRON_NUMERICO = "^[0-9]+$";
	
	public StringUtil() {
		super();
	}

	public static String completarCerosIzquierda(int numero, int cantCifras) {
		String result = "";

		int numeroAux = numero;
		int cantCifrasNum = 0;
		while (numeroAux != 0) {
			numeroAux = numeroAux / 10;
			cantCifrasNum += 1;
		}

		for (int i = 0; i < (cantCifras - cantCifrasNum); i++) {
			result = result + "0";
		}

		result = result + ("" + numero);

		return result;
	}

	public static String limpiarCaracteresNoValidosXML(String texto) {
		StringBuffer out = new StringBuffer();
		char caracter;

		if (texto == null || ("".equals(texto)))
			return "";
		for (int i = 0; i < texto.length(); i++) {
			caracter = texto.charAt(i);

			if ((caracter == 0x9) || (caracter == 0xA) || (caracter == 0xD)
					|| ((caracter >= 0x20) && (caracter <= 0xD7FF))
					|| ((caracter >= 0xE000) && (caracter <= 0xFFFD))
					|| ((caracter >= 0x10000) && (caracter <= 0x10FFFF)))
				out.append(caracter);
		}

		return out.toString();
	}

	public static String limpiarCaracteresControl(String cadena) {
		String resultado = "";

		if (cadena != null)
			for (int i = 0; i < cadena.length(); i++) {
				if (Character.getType(cadena.charAt(i)) != Character.CONTROL)
					resultado = resultado + cadena.charAt(i);
			}

		return resultado;
	}
	
	public static String cambiarInicialMayuscula(String palabra) {
		if (palabra != null) 
			if ("".equals(palabra)) 
				return palabra;
			else
				return palabra.substring(0, 1).toUpperCase() + palabra.substring(1);
		else 
			return null;
	}

	public static boolean esValidoEmail(String email) {
		Pattern pattern = Pattern.compile(PATRON_CORREO_ELECTRONICO);
		Matcher matcher = pattern.matcher(email);

		return matcher.matches();
	}
	
	public static boolean esNumerico(String numero) {
		Pattern pattern = Pattern.compile(PATRON_NUMERICO);
		Matcher matcher = pattern.matcher(numero);

		return matcher.matches();
	}
}
