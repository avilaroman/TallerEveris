package cl.seis.utils;

import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public class FileUtil {

	public static byte[] recuperarBytesArchivo(File file) throws IOException {
		long length = file.length();
		
		if (length > Integer.MAX_VALUE) {
			throw new IOException("Archivo demasiado grande");
		}
		
		byte[] bytes = new byte[(int) length];
		int offset = 0;
		int numRead = 0;
		InputStream is = new FileInputStream(file);
		
		try {
			while ((offset < bytes.length) && (numRead = is.read(bytes, offset, bytes.length - offset)) >= 0) {
				offset += numRead;
			}
		} finally {
			is.close();
		}
		
		if (offset < bytes.length) {
			throw new IOException("No se pudo leer completamente el archivo "
					+ file.getName());
		}
		
		return bytes;
	}

	public static byte[] recuperarBytesEntrada(InputStream is) throws IOException {
		ByteArrayOutputStream baos = new ByteArrayOutputStream();
		byte[] buffer = new byte[1024];
		int length = 0;

		while ((length = is.read(buffer)) != -1) {
			baos.write(buffer, 0, length);
		}
		
		return baos.toByteArray();
	}
	
	public static void crearDirectorio(String ruta) throws Exception {
		File dir = new File(ruta);
		
		if (!dir.exists()) {
			try {
				dir.mkdir();
			} catch (SecurityException se) {
				throw new Exception("No fue posible crear el directorio: " + ruta, se);
			}
		}
	}
		
	public static void generarArchivo(byte [] datos, String ruta) throws Exception {
		BufferedOutputStream bs = null;
		File file = new File(ruta);
		
		boolean existeRuta = file.getParentFile().exists();
		
		if (!existeRuta) {
			boolean resultado = file.getParentFile().mkdirs();
			if (!resultado) 
				throw new Exception("No fue posible obtener la siguente ruta: " + file.getParentFile());
		}
		
		try {
		    FileOutputStream fs = new FileOutputStream(file);
		    bs = new BufferedOutputStream(fs);
		    bs.write(datos);
		    
		    bs.close();
		    bs = null;
		} catch (FileNotFoundException fnfe) {
		    throw new Exception("No se encuentra la siguente ruta: " + ruta, fnfe);
		} catch (IOException e) {
			throw new Exception("No se pudo escribir el archivo en: " + ruta, e);
		} finally {
			if (bs != null) try { bs.close(); } catch (Exception e) {}
		}
	}
	
	public static void renombrarArchivo(String rutaActual, String rutaNueva) throws Exception {
		File fileOld = new File(rutaActual), fileNew = new File(rutaNueva);

		try {
			if (fileNew.exists()) throw new java.io.IOException("Ya existe el archivo: " + rutaNueva);

			fileOld.renameTo(fileNew);
		} catch (Exception e) {
			throw new Exception("No fue posible cambiar el nombre del archivo: " + rutaActual, e);
		}
	}
	
	public static void borrarArchivo(String ruta) throws Exception {
		File file = new File(ruta);

		try {
			if (file.exists()) {
				file.delete();
			}
		} catch (Exception e) {
			throw new Exception("No fue posible eliminar el archivo: " + ruta, e);
		}
	}
	
	public static String obtenerUltimaLineaArchivo(byte[] datos) throws Exception {
		ByteArrayInputStream bais = new ByteArrayInputStream(datos);
		BufferedReader br = new BufferedReader(new InputStreamReader(bais));
		String ultima = null, linea = null;

		try {
			while ((linea = br.readLine()) != null) {
				ultima = linea;
			}
		} catch (IOException e) {
			throw new Exception("Error al leer las líneas desde los datos", e);
		}

		return ultima;
	}
	
}
