package cl.seis.utils;


import java.io.File;
import java.io.FileNotFoundException;
import java.net.InetAddress;
import java.util.List;

import org.apache.log4j.Logger;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class FTPUtilTest {

	private static final Logger log = Logger.getLogger(FTPUtilTest.class);
	private static final String rutaRemota = "/home/ftpseis";
	
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {

	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}
	
	@Test
	public void ftpDirectoriosTest() {		
		String nombreDirectorio = "dir_temp";
		
		FTPUtil ftp = null;
		
		try {
			ftp = new FTPUtil(InetAddress.getByName("192.168.1.141"), 21, "ftpseis", "ftpseis");
			
			// Crear directorio y acceder
			String dirTemp = rutaRemota + "/" + nombreDirectorio;
			
			ftp.crearDirectorio(dirTemp); 
			try {
				ftp.cambiarDirectorioTrabajo(dirTemp);
			} catch (FileNotFoundException e) { 
				Assert.fail("El directorio no fue creado");
			}
			
			// Volver a atras y eliminar directorio
			ftp.cambiarDirectorioPadre();
			
			ftp.borrarDirectorioVacio("./" + nombreDirectorio);			
			try {
				ftp.cambiarDirectorioTrabajo(dirTemp);
				Assert.fail("El directorio no fue borrado");
			} catch (FileNotFoundException e) {}
		} catch (Exception e) {
			log.error("Excepcion: ", e);
		} finally {
			if (ftp != null) ftp.desconectar();
		}		
	}
	
	@Test
	public void ftpArchivosTest() {
		String rutaLocal = "src/test/resources";		
		String nombreArchivo = "prueba_ftp.txt";
		
		File file = new File(rutaLocal + "/" + nombreArchivo);
		FTPUtil ftp = null;
		
		try {
			ftp = new FTPUtil(InetAddress.getByName("192.168.1.141"), 21, "ftpseis", "ftpseis");
			
			byte[] datosEnvio = FileUtil.recuperarBytesArchivo(file);
			
			// Subir archivo y obtenerlo
			ftp.guardarArchivo(datosEnvio, rutaRemota, nombreArchivo);
			byte[] datosRecibidos = ftp.recuperarArchivo(rutaRemota, nombreArchivo);
			Assert.assertEquals(new String(datosEnvio), new String(datosRecibidos));
			
			// Listado de archivos
			List<String> listado = ftp.listadoArchivos(rutaRemota, null);
			Assert.assertNotNull(listado);
			Assert.assertTrue(listado.size() > 0);
			Assert.assertTrue(listado.contains(nombreArchivo));
			
			// Mover (renombrar)
			String nombreNuevoArchivo = "prueba_ftp_temp.txt";
			
			ftp.moverArchivo(rutaRemota, nombreArchivo, rutaRemota, nombreNuevoArchivo);
			datosRecibidos = ftp.recuperarArchivo(rutaRemota, nombreNuevoArchivo);
			Assert.assertEquals(new String(datosEnvio), new String(datosRecibidos));
			
			// Eliminar archivo
			ftp.borrarArchivo(rutaRemota, nombreNuevoArchivo);			
			try {
				datosRecibidos = ftp.recuperarArchivo(rutaRemota, nombreNuevoArchivo);
				Assert.fail("El archivo no fue borrado");
			} catch (FileNotFoundException e) {}
		} catch (Exception e) {
			log.error("Excepcion: ", e);
		} finally {
			if (ftp != null) ftp.desconectar();
		}		
	}
	
}
