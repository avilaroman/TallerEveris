package cl.seis.utils;

import java.util.StringTokenizer;


public class RUTUtil {

	public static String obtenerRUT(String rut) {
		String aux = null;
		
		if (rut != null) {
			aux = rut.replaceAll("\\.", "");
			
			StringTokenizer st = new StringTokenizer(aux, "-");
			
			if (st.hasMoreTokens())
				return st.nextToken();
			else 
				return null;
		} else {
			return null;
		}
	}

	public static String obtenerDV(String rut) {		
		if (rut != null) {			
			StringTokenizer st = new StringTokenizer(rut, "-");
			
			if (st.hasMoreTokens()) {
				st.nextToken();
				
				if (st.hasMoreTokens())
					return st.nextToken();
				else 
					return null;
			} else 
				return null;
		} else {
			return null;
		}
	}
	
	public static Long obtenerNumeroRUT(String rut) {
		String numeroRUT = obtenerRUT(rut);
		
		if (numeroRUT != null) {
			try {
				return Long.parseLong(numeroRUT);
			} catch (NumberFormatException nfe) {
				return null;
			}
		} else {
			return null;
		}
	}
	
	public static boolean validarRut(String rut) throws Exception {
		boolean validacion = false;
		
		try {
			rut = rut.toUpperCase();
			rut = rut.replace(".", "");
			rut = rut.replace("-", "");
			int rutAux = Integer.parseInt(rut.substring(0, rut.length() - 1));

			char dv = rut.charAt(rut.length() - 1);

			int m = 0, s = 1;
			for (; rutAux != 0; rutAux /= 10) {
				s = (s + rutAux % 10 * (9 - m++ % 6)) % 11;
			}
			if (dv == (char) (s != 0 ? s + 47 : 75)) {
				validacion = true;
			}

		} catch (NumberFormatException e) {
			throw new Exception("Error de formato en el RUT");
		} 
		
		return validacion;
	}
}
