package cl.seis.utils;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.net.InetAddress;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.net.PrintCommandListener;
import org.apache.commons.net.ftp.FTP;
import org.apache.commons.net.ftp.FTPClient;
import org.apache.commons.net.ftp.FTPFile;
import org.apache.commons.net.ftp.FTPReply;

public class FTPUtil {
	
	private static final int CODIGO_ARCHIVO_NO_ENCONTRADO = 550;
	
	private FTPClient ftp = null;
	
	public FTPUtil(InetAddress ip, int puerto, String usuario, String clave) throws Exception {
		ftp = new FTPClient();
		ftp.addProtocolCommandListener(new PrintCommandListener(new PrintWriter(System.out)));
		
		int respuesta;
		try {
			ftp.connect(ip, puerto);
		} catch (Exception e) {
			throw new Exception("Conexión rechazada: " + "(" + ip + ":" + puerto + ")");
		}
			
		respuesta = ftp.getReplyCode();
		
		if (!FTPReply.isPositiveCompletion(respuesta)) {
			ftp.disconnect();
			throw new Exception("Error al conectarse al servidor FTP");
		}
		
		try{
			ftp.login(usuario, clave);
		} catch (Exception e) {
			throw new Exception("Error de autenticación: " + usuario);
		}
		
		ftp.setFileType(FTP.BINARY_FILE_TYPE);
		ftp.enterLocalPassiveMode();
	}

	// Directorios	
	public void crearDirectorio(String ruta) throws Exception {
		if (ruta == null) throw new Exception("Se debe indicar una ruta al para el nuevo directorio");
		
		try {
			if(!this.ftp.makeDirectory(ruta)) {
				throw new Exception("No fue posible crear el directorio");
			}
		} catch (IOException e) {
			throw new Exception("Error al crear el directorio");
		}		
    }
	
	public void borrarDirectorioVacio(String ruta) throws Exception {
		if (ruta == null) throw new Exception("Se debe indicar una ruta para borrar directorio");
		
		try {
			if(!this.ftp.removeDirectory(ruta)) {
				throw new Exception("No fue posible borrar el directorio");
			}
		} catch (IOException e) {
			throw new Exception("Error al borrar el directorio");
		}		
    }
	
	public void borrarDirectorioContenido(String directorioPadre, String directorioActual) throws Exception {
        String directorioListar = directorioPadre;
        
        if (!directorioActual.equals("")) {
            directorioListar += "/" + directorioActual;
        }
 
        FTPFile[] subArchivos = this.ftp.listFiles(directorioListar);
 
        if (subArchivos != null && subArchivos.length > 0) {
            for (FTPFile archivo : subArchivos) {
                String nombreActual = archivo.getName();
                if (nombreActual.equals(".") || nombreActual.equals("..")) {
                    // skip parent directory and the directory itself
                    continue;
                }
                String rutaArchivo = directorioPadre + "/" + directorioActual + "/"
                        + nombreActual;
                if (directorioActual.equals("")) {
                    rutaArchivo = directorioPadre + "/" + nombreActual;
                }
 
                if (archivo.isDirectory()) {
                    // Eliminar el subdirectorio
                    borrarDirectorioContenido(directorioListar, nombreActual);
                } else {
                    // Borrado de archivos
                    boolean borrado = this.ftp.deleteFile(rutaArchivo);
                    if (!borrado) {
                    	throw new Exception("No fue posible borrar el archivo: " + rutaArchivo);
                    } 
                }
            }
 
            // Borrar el directorio en si mismo
            boolean removido = this.ftp.removeDirectory(directorioListar);
            if (!removido) {
            	throw new Exception("No fue posible borrar el directorio: " + directorioListar);
            }
        }
    }
	
	public void cambiarDirectorioPadre() throws Exception {		
		try {
			if(!this.ftp.changeToParentDirectory()) {
				throw new Exception("No fue posible cambiar al directorio padre");
			}
		} catch (IOException e) {
			throw new Exception("Error al cambiar al directorio padre");
		}		
    }
	
	public void cambiarDirectorioTrabajo(String ruta) throws FileNotFoundException, Exception {
		if (ruta == null) throw new Exception("Se debe indicar una ruta de destino");
		
		try {
			if(!this.ftp.changeWorkingDirectory(ruta)) {
				if (this.ftp.getReplyCode() == CODIGO_ARCHIVO_NO_ENCONTRADO) {
					throw new FileNotFoundException("No existe el directorio: " + ruta);
				} else {
					throw new Exception("No fue posible cambiar de directorio de trabajo: " + ruta);
				}
			}
		} catch (FileNotFoundException fnfe) {
			throw fnfe;
		} catch (IOException e) {
			throw new Exception("Error al cambiar de directorio de trabajo: " + ruta);
		}		
    }
	
	// Archivos
	public void guardarArchivo(byte [] datos, String ruta, String nombre) throws Exception {
		if (datos == null) throw new Exception("No hay datos a ser guardados");
		if (ruta == null) throw new Exception("Se debe indicar una ruta de destino");
		if (nombre == null) throw new Exception("Se debe indicar un nombre para el archivo");
		
		InputStream bais = new ByteArrayInputStream(datos);
		
		try {
			if(!this.ftp.storeFile(ruta + "/" + nombre, bais)) {
				throw new Exception("No fue posible guardar el archivo");
			}
		} catch (IOException e) {
			throw new Exception("Error al guardar el archivo");
		}		
    }
	
	public byte [] recuperarArchivo(String ruta, String nombre) throws FileNotFoundException, Exception {
		if (ruta == null) throw new Exception("Se debe indicar la ruta al archivo");
		if (nombre == null) throw new Exception("Se debe indicar el nombre del archivo a recuperar");
		
		ByteArrayOutputStream baos = new ByteArrayOutputStream();
		String uri = ruta + "/" + nombre;
				
		try {
			if(!this.ftp.retrieveFile(uri, baos)) {
				if (this.ftp.getReplyCode() == CODIGO_ARCHIVO_NO_ENCONTRADO) {
					throw new FileNotFoundException("No existe el archivo: " + uri);
				} else {
					throw new Exception("No fue posible recuperar el archivo: " + uri);
				}
			} 
		} catch (FileNotFoundException fnfe) {
			throw fnfe;
		} catch (IOException e) {
			throw new Exception("Error al recuperar el archivo: " + uri);
		} 
		
		return baos.toByteArray();
    }
	
	public boolean existeArchivo(String ruta, String nombre) throws Exception {
		if (ruta == null) throw new Exception("Se debe indicar la ruta al archivo");
		if (nombre == null) throw new Exception("Se debe indicar el nombre del archivo a recuperar");
		
		ByteArrayOutputStream baos = new ByteArrayOutputStream();
		String uri = ruta + "/" + nombre;
				
		try {
			if(!this.ftp.retrieveFile(uri, baos)) {
				if (this.ftp.getReplyCode() == CODIGO_ARCHIVO_NO_ENCONTRADO) {
					return false;
				} 
			} 
		} catch (IOException e) {
			throw new Exception("Error al leer el archivo: " + uri);
		} 
		
		return true;
    }
	
	public void moverArchivo(String rutaOrigen, String nombreOrigen, 
			String rutaDestino, String nombreDestino) throws Exception {
		if (rutaOrigen == null) throw new Exception("Se debe indicar la ruta de origen");
		if (nombreOrigen == null) throw new Exception("Se debe indicar el nombre del archivo de origen");
		
		if (rutaDestino == null) rutaDestino = rutaOrigen;
		if (nombreDestino == null) nombreDestino = nombreOrigen;
		
		if (rutaDestino.equalsIgnoreCase(rutaDestino) && nombreOrigen.endsWith(nombreDestino))
			// No se aplica la operacion 
			return;
		
		try {
			if(!this.ftp.rename(rutaOrigen + "/" + nombreOrigen, rutaDestino + "/" + nombreDestino)) {
				throw new Exception("No fue posible mover el archivo origen: " + rutaOrigen + "/" + nombreOrigen +
						", destino: " + rutaDestino + "/" + nombreDestino);
			}
		} catch (IOException e) {
			throw new Exception("Error al mover el archivo");
		}
    }
	
	public void borrarArchivo(String ruta, String nombre) throws Exception {
		if (ruta == null) throw new Exception("Se debe indicar la ruta al archivo");
		if (nombre == null) throw new Exception("Se debe indicar el nombre del archivo a ser borrado");
		
		try {
			if(!this.ftp.deleteFile(ruta + "/" + nombre)) {
				throw new Exception("No fue posible borrar el archivo");
			}
		} catch (IOException e) {
			throw new Exception("Error al borrar el archivo");
		}
    }
	
	public List<String> listadoArchivos(String ruta, String patronFiltro) throws Exception {
		FTPFile [] archivosFtp = null;
		List<String> listadoArchivos = new ArrayList<String>();
		
		try {
			if ((ruta == null) || "".equals(ruta))
				archivosFtp = ftp.listFiles(); 
			else 
				archivosFtp = ftp.listFiles(ruta);
			
			for (FTPFile archivoFtp : archivosFtp) {
				if (archivoFtp.isFile())
					if ((patronFiltro == null) || "".equals(patronFiltro))
						listadoArchivos.add(archivoFtp.getName());
					else if (archivoFtp.getName().matches(patronFiltro)) {
						listadoArchivos.add(archivoFtp.getName());
					}
			}
		} catch (IOException e) {
			throw new Exception("Error al listar los archivos");
		}
		
		return listadoArchivos;
    }

	public void desconectar() {
		if (this.ftp.isConnected()) {
			try {
				this.ftp.logout();
				this.ftp.disconnect();
			} catch (IOException f) {
				// No se hace nada, las operaciones ya fueron realizadas
			}
		}
	}
}
