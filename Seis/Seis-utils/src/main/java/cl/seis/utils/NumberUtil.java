package cl.seis.utils;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class NumberUtil {

	public static double redondearMedioInclusive(double numero, int cifras) {
		BigDecimal bd = new BigDecimal(numero).setScale(cifras,
				RoundingMode.HALF_EVEN);

		return bd.doubleValue();
	}

	public static double redondearHaciaArriba(double numero, int cifras) {
		BigDecimal bd = new BigDecimal(numero)
				.setScale(cifras, RoundingMode.UP);

		return bd.doubleValue();
	}

	public static double redondearHaciaAbajo(double numero, int cifras) {
		BigDecimal bd = new BigDecimal(numero).setScale(cifras,
				RoundingMode.FLOOR);

		return bd.doubleValue();
	}

	public static boolean esNumeroEntero(String valor) {
		if (valor == null) return false;
		
		try {
			Long.parseLong(valor);
			return true;
		} catch (NumberFormatException nfe) {
			return false;
		}
	}

	public static boolean esNumeroDecimal(String valor) {
		if (valor == null) return false;
		
		try {
			Double.parseDouble(valor);
			return true;
		} catch (NumberFormatException nfe) {
			return false;
		}
	}
}
