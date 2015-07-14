//package cl.dgac.arsv.test;
//
//import static org.junit.Assert.assertNotNull;
//import static org.junit.Assert.fail;
//
//import java.util.ArrayList;
//import java.util.List;
//
//import javax.inject.Inject;
//
//import org.apache.log4j.Logger;
//import org.jboss.arquillian.container.test.api.Deployment;
//import org.jboss.arquillian.junit.Arquillian;
//import org.jboss.shrinkwrap.api.spec.JavaArchive;
//import org.junit.After;
//import org.junit.AfterClass;
//import org.junit.Before;
//import org.junit.BeforeClass;
//import org.junit.Test;
//import org.junit.runner.RunWith;
//
//import cl.dgac.arsv.filters.FiltroSolicitudArriboSobrevuelo;
//import cl.dgac.arsv.model.SolicitudArriboSobrevuelo;
//import cl.dgac.arsv.service.SolicitudSessionLocal;
//import cl.dgac.arsv.service.SolicitudSessionRemote;
//import cl.dgac.arsv.service.SolicitudSessionWS;
//import cl.dgac.arsv.service.impl.SolicitudesSessionBean;
//import cl.seis.utils.DateUtil;
//
//@RunWith(Arquillian.class)
//public class SolicitudesARSVTest extends BaseARSVTest {
//		
//	private static final Logger log = Logger.getLogger(SolicitudesARSVTest.class);
//	
//	@Inject
//	private SolicitudSessionLocal solicitudesARSV;
//	
//	@Deployment
//    public static JavaArchive createTestArchive() {
//		final JavaArchive jar = BaseARSVTest.createTestArchive();
//
//		jar.addClasses(SolicitudSessionLocal.class, SolicitudSessionRemote.class, 
//				SolicitudSessionWS.class, SolicitudesSessionBean.class, DateUtil.class);
//		
//        log.info(jar.toString(true));
//        
//        return jar;
//	}
//	
//	@BeforeClass
//	public static void setUpBeforeClass() throws Exception {		
//	}
//
//	@AfterClass
//	public static void tearDownAfterClass() throws Exception {
//	}
//
//	@Before
//	public void setUp() throws Exception {
//	}
//
//	@After
//	public void tearDown() throws Exception {
//	}
//	
//	@Test
//	public void testBuscarSolicitudesUsuario() {
//		List<String> estados = new ArrayList<String>();
//		
//		estados.add("uno");
//		estados.add("dos");
//		
//		FiltroSolicitudArriboSobrevuelo filtro = new FiltroSolicitudArriboSobrevuelo();
//		
//		filtro.setIdSolicitud(1L);
//		filtro.setUsuario("hmartinez");
//		filtro.setFechaCreacion(DateUtil.generarFechaString("01/03/2013"));
//		filtro.setCodigosEstado(estados);
//		filtro.setIdUnidad(1L);
//				
//		try {			
//			List<SolicitudArriboSobrevuelo> result = 
//					this.solicitudesARSV.buscarSolicitudesUsuario(filtro);		
//			assertNotNull(result);
//			
//			log.info("Cantidad de Solicitudes: " + result.size());
//			
//		} catch (Exception e) {
//			log.error(e.getMessage());
//			fail(e.getMessage());
//		}
//	}
//
//}
