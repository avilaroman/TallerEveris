package cl.seis.utils;


import org.apache.log4j.Logger;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class RUTUtilTest {

	private static final Logger log = Logger.getLogger(RUTUtilTest.class);
	
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
	public void validarRut() {
		String rut1 = "10.199.404-L", rut2 = "10.510-967-9";
		
		try {
			Assert.assertFalse(RUTUtil.validarRut(rut1));
			Assert.assertTrue(RUTUtil.validarRut(rut2));
		} catch (Exception e) {
			log.error("Validar RUT: ", e);
		}
		
	}
}
