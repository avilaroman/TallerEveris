package cl.seis.utils;


import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import org.apache.log4j.Logger;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class DateUtilTest {

	private static final Logger log = Logger.getLogger(DateUtilTest.class);
	
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
	public void sumarDiasHabilesFechaTest() {
		Date fecha = DateUtil.generarFechaString("24/04/2014");
		int dias = 7;
		
		Set<Date> festivos = new HashSet<Date>(0);
		festivos.add(DateUtil.generarFechaString("01/05/2014"));
		festivos.add(DateUtil.generarFechaString("21/05/2014"));
		
		try {			
			fecha = DateUtil.sumarDiasHabilesFecha(fecha, dias, festivos);
			Assert.assertEquals("06/05/2014", DateUtil.generarStringFecha(fecha));
			log.info("Fecha: " + DateUtil.generarStringFecha(fecha));
		} catch (Exception e) {
			log.error("Error: ", e);
		}		
	}
	
	@Test
	public void cantidadDiasHabilesEntreFechasTest() {
		Date fechaInicio = DateUtil.generarFechaString("24/04/2014"),
				fechaFin = DateUtil.generarFechaString("06/05/2014");
				
		Set<Date> festivos = new HashSet<Date>(0);
		festivos.add(DateUtil.generarFechaString("01/05/2014"));
		festivos.add(DateUtil.generarFechaString("21/05/2014"));
		
		try {			
			int dias = DateUtil.cantidadDiasHabilesEntreFechas(fechaInicio, fechaFin, festivos);
			Assert.assertEquals(7, dias);
			log.info("Dias: " + dias);
		} catch (Exception e) {
			log.error("Error: ", e);
		}
		
	}
}
