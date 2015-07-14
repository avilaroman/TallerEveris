package cl.seis.utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.HashSet;
import java.util.Locale;
import java.util.Set;
import java.util.TimeZone;

public class DateUtil {

	public static String sdfMesNombre3Letras = "MMM";
	public static String sdfMesNombreCompleto = "MMMM";
	public static String sdfDia = "dd";
	public static String sdfAnio = "yyyy";
	public static String sdfAnio2 = "yy";
	public static String sdfDiaNumeroIngles = "EEE dd";
	public static String sdfFecha = "dd/MM/yyyy";	
	public static String sdfFechaGuiones = "dd-MM-yyyy";
	public static String sdfFechaHora = "dd/MM/yyyy HH:mm";
	public static String sdfFechaHoraSeg = "dd/MM/yyyy HH:mm:ss";
	public static String sdfHora = "hh:mm";
	public static String sdfHora24 = "HH:mm";
	public static String sdfHora24MinutosSegundos = "HH:mm:ss";
	public static String sdfFechaEstandar = "yyyyMMdd";
	public static String sdfFechaHoraEstandar = "yyyyMMddHHmm";
	public static String sdfFechaHoraZonaEstandar = "yyyyMMddHHmm'Z'";
	public static String sdfFechaAnioSimpleEstandar = "yyMMdd";
	public static String sdfAnioMesEstandar = "yyyyMM";
	public static String sdfHora24Estandar = "HHmm";
	public static String sdfFechaGuionesEstandar = "yyyy-MM-dd";
	public static String sdfFechaGuionesHoraEstandar = "yyyy-MM-dd HH:mm";
	public static String sdfFechaGuionesHoraSegEstandar = "yyyy-MM-dd HH:mm:ss";
	public static String sdfFechaTiempoEstandar = "yyyy-MM-dd'T'HH:mm:ss";
	public static String sdfFechaTiempoZonaEstandar = "yyyy-MM-dd'T'HH:mm:ssZ";

	
	private static SimpleDateFormat generarFormato(String formato) {
		SimpleDateFormat sdf = null;
		
		if (sdfDiaNumeroIngles.equals(formato)) {
			sdf = new SimpleDateFormat(formato, Locale.ENGLISH);
		} else {
			sdf = new SimpleDateFormat(formato, new Locale("es", "CL"));
		}
		
		return sdf;
	}
	
	public static Date generarFecha(String cadena, String formato) {
		SimpleDateFormat sdf = generarFormato(formato);
		
		try {
			if ((null != cadena) && (null != sdf)) {
				return sdf.parse(cadena);
			}
		} catch (ParseException pe) {
			pe.printStackTrace();
		}

		return null;
	}
	
	public static String formatoFecha(Date fecha, String formato) {
		SimpleDateFormat sdf = generarFormato(formato);
		
		if ((null != fecha) && (null != sdf)) {
			return sdf.format(fecha);
		} else {
			return null;
		}
	}
	
	public static Date generarFechaUTCZona(String cadena, String formato) {
		SimpleDateFormat sdf = generarFormato(formato);
		
		try {
			if ((null != cadena) && (null != sdf)) {
				sdf.setTimeZone(TimeZone.getTimeZone("GMT"));
				return sdf.parse(cadena);
			}
		} catch (ParseException pe) {
			pe.printStackTrace();
		}

		return null;
	}
	
	public static String formatoFechaUTCZona(Date fecha, String formato, int horas) {
		SimpleDateFormat sdf = generarFormato(formato);
		
		if (null != sdf) {				
			Calendar cal = Calendar.getInstance();
			
			if (null != fecha)
				cal.setTime(fecha);
			
			// Aplica deplazamineto de horas
			long millis = cal.getTimeInMillis() + (60 * 60 * horas * 1000);
			cal.setTimeInMillis(millis);
			
			sdf.setTimeZone(TimeZone.getTimeZone("GMT"));
			return sdf.format(cal.getTime());
		} else
			return null;
	}	
	
	public static Date generarFechaString(String fechaString) {
		SimpleDateFormat sdf = generarFormato(sdfFecha);
		
		try {
			if (null != fechaString) {
				return sdf.parse(fechaString);
			}
		} catch (ParseException pe) {
			pe.printStackTrace();
		}

		return null;
	}

	public static String generarStringFecha(Date fecha) {
		SimpleDateFormat sdf = generarFormato(sdfFecha);
		
		return sdf.format(fecha);
	}

	public static String generarStringAnioActual2() {
		SimpleDateFormat sdf = generarFormato(sdfAnio2);
		
		return sdf.format(new Date());
	}

	public static Date generarFechaHoraString(String fechaHoraString) {
		SimpleDateFormat sdf = generarFormato(sdfFechaHora);
		
		try {
			if (null != fechaHoraString) {
				return sdf.parse(fechaHoraString);
			}
		} catch (ParseException pe) {
			pe.printStackTrace();
		}

		return null;
	}

	public static String generarStringFechaHora(Date fechaHora) {
		SimpleDateFormat sdf = generarFormato(sdfFechaHora);
		
		return sdf.format(fechaHora);
	}
	
	public static String generarStringHoraMinutoSegundos(Date fechaHora) {
		SimpleDateFormat sdf = generarFormato(sdfHora24MinutosSegundos);
		
		return sdf.format(fechaHora);
	}

	public static Date generarFechaHoraEstandarString(String fechaHoraString) {
		SimpleDateFormat sdf = generarFormato(sdfFechaHoraEstandar);
		
		try {
			if (null != fechaHoraString) {
				return sdf.parse(fechaHoraString);
			}
		} catch (ParseException pe) {
			pe.printStackTrace();
		}

		return null;
	}

	public static String generarStringFechaHoraEstandar(Date fechaHora) {
		SimpleDateFormat sdf = generarFormato(sdfFechaHoraEstandar);
		
		return sdf.format(fechaHora);
	}
	
	public static Date generarFechaMinima() {
		Calendar cal = Calendar.getInstance(Locale.getDefault());

		cal.set(Calendar.YEAR, 1900);
		cal.set(Calendar.MONTH, 0);
		cal.set(Calendar.DAY_OF_MONTH, 1);
		cal.set(Calendar.HOUR, 0);
		cal.set(Calendar.MINUTE, 0);
		cal.set(Calendar.SECOND, 0);
		cal.set(Calendar.MILLISECOND, 0);

		return cal.getTime();
	}

	public static Date generarFechaMaxima() {

		Calendar cal = Calendar.getInstance();
		cal.add(Calendar.YEAR, 100);

		return cal.getTime();
	}
	
	public static Date cambiarAniosFecha(Date fecha, int anios) {
		if (fecha != null) {
	        Calendar cal = Calendar.getInstance();
	        
	        cal.setTimeInMillis(fecha.getTime());
	        cal.add(Calendar.YEAR, anios);
	        
	        return new Date(cal.getTimeInMillis());
		} else {
			return null;
		}
    }

	public static Date cambiarMesesFecha(Date fecha, int meses) {
		if (fecha != null) {
	        Calendar cal = Calendar.getInstance();
	        
	        cal.setTimeInMillis(fecha.getTime());
	        cal.add(Calendar.MONTH, meses);
	        
	        return new Date(cal.getTimeInMillis());
		} else {
			return null;
		}
    }
	
	public static Date cambiarDiasFecha(Date fecha, int dias) {
		if (fecha != null) {
	        Calendar cal = Calendar.getInstance();
	        
	        cal.setTimeInMillis(fecha.getTime());
	        cal.add(Calendar.DATE, dias);
	        
	        return new Date(cal.getTimeInMillis());
		} else {
			return null;
		}
    }
	
	public static Date cambiarHorasFecha(Date fecha, int horas) {
		if (fecha != null) {
	        Calendar cal = Calendar.getInstance();
	        
	        cal.setTimeInMillis(fecha.getTime());
	        cal.add(Calendar.HOUR_OF_DAY, horas);
	        
	        return new Date(cal.getTimeInMillis());
		} else {
			return null;
		}
    }
	
	public static Date sumarDiasHabilesFecha(Date fecha, int dias, Set<Date> festivos) {
		if (dias > 0) {
			if (festivos == null) festivos = new HashSet<Date>(0);
			
	        Calendar cal = Calendar.getInstance();
	        
	        cal.setTimeInMillis(fecha.getTime());
	        
	        for (int i = 1; i <= dias; i++) {
	        	cal.add(Calendar.DATE, 1);
	        	
	        	if (festivos.contains(cal.getTime())) {
	        		dias ++;
	        	} else if((cal.get(Calendar.DAY_OF_WEEK) == Calendar.SUNDAY) || 
	        			(cal.get(Calendar.DAY_OF_WEEK) == Calendar.SATURDAY)) {
	        		dias ++;	
	        	}
	        }	        
	        
	        return new Date(cal.getTimeInMillis());
		} else {
			return fecha;
		}
    }
	
	public static int cantidadDiasMes(Date fecha) {
		Calendar cal = Calendar.getInstance();
		
		cal.setTime(fecha);
		
		return cal.getActualMaximum(Calendar.DAY_OF_MONTH);		
    }
	
	public static int cantidadDiasHabilesEntreFechas(Date fechaInicio, Date fechaFin, Set<Date> festivos) {
		if ((fechaInicio == null) || (fechaFin == null)) return 0;
		
		if (festivos == null) festivos = new HashSet<Date>(0);
			
        Calendar calInicio = Calendar.getInstance();        
        calInicio.setTime(cambiarFechaPrimeraHora(fechaInicio));
        
        Calendar calFin = Calendar.getInstance();        
        calFin.setTime(cambiarFechaPrimeraHora(fechaFin));
        
        int dias = 0;
        
        while (calInicio.getTime().compareTo(calFin.getTime()) < 0) {        	
        	if (!festivos.contains(calInicio.getTime()) && 
        			(calInicio.get(Calendar.DAY_OF_WEEK) != Calendar.SUNDAY) && 
        			(calInicio.get(Calendar.DAY_OF_WEEK) != Calendar.SATURDAY)) {
        		dias ++;	
        	}
        	
        	calInicio.add(Calendar.DATE, 1);
        }	        
	        
	    return dias;
		
    }
	
	public static Date cambiarFechaPrimeraHora(Date fecha) {
        Calendar cal = Calendar.getInstance();
        
        cal.setTimeInMillis(fecha.getTime());
        
        cal.set(Calendar.HOUR_OF_DAY, cal.getActualMinimum(Calendar.HOUR_OF_DAY));
        cal.set(Calendar.MINUTE, cal.getActualMinimum(Calendar.MINUTE));
        cal.set(Calendar.SECOND, cal.getActualMinimum(Calendar.SECOND));
        cal.set(Calendar.MILLISECOND, cal.getActualMinimum(Calendar.MILLISECOND));
        
        return cal.getTime();
    }
	
	public static Date cambiarFechaUltimaHora(Date fecha) {
        Calendar cal = Calendar.getInstance();
        
        cal.setTimeInMillis(fecha.getTime());
        
        cal.set(Calendar.HOUR_OF_DAY, cal.getActualMaximum(Calendar.HOUR_OF_DAY));
        cal.set(Calendar.MINUTE, cal.getActualMaximum(Calendar.MINUTE));
        cal.set(Calendar.SECOND, cal.getActualMaximum(Calendar.SECOND));
        cal.set(Calendar.MILLISECOND, cal.getActualMaximum(Calendar.MILLISECOND));
        
        return cal.getTime();
    }
	
	public static long calcularDiferenciaSegundos(Date fecha1, Date fecha2) {
		if ((fecha1 != null) && (fecha2 != null)) {
	        Calendar cal1 = Calendar.getInstance();        
	        cal1.setTimeInMillis(fecha1.getTime());
	             
	        Calendar cal2 = Calendar.getInstance();        
	        cal2.setTimeInMillis(fecha2.getTime());
	        
	        return Math.abs((cal1.getTimeInMillis() - cal2.getTimeInMillis()) / 1000);
		} else {
			return 0;
		}
    }
}
