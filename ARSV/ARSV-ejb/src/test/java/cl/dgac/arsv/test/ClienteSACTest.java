/*package cl.dgac.arsv.test;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.fail;

import java.util.List;

import javax.inject.Inject;

import org.apache.log4j.Logger;
import org.jboss.arquillian.container.test.api.Deployment;
import org.jboss.arquillian.junit.Arquillian;
import org.jboss.shrinkwrap.api.spec.JavaArchive;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;

import cl.dgac.arsv.service.ClienteSACSessionLocal;
import cl.dgac.arsv.service.impl.ClienteSACSessionBean;
import cl.dgac.arsv.util.AeronaveARSV;
import cl.dgac.sac.exceptions.SACBusinessException;
import cl.dgac.sac.model.SacAeronave;
import cl.dgac.sac.model.SacTipoAeronave;
import cl.dgac.sac.services.AeronavesServicesWS;

@RunWith(Arquillian.class)
public class ClienteSACTest extends BaseARSVTest {
		
	private static final Logger log = Logger.getLogger(ClienteSACTest.class);
	
	@Inject
	private ClienteSACSessionLocal clienteSAC;
	
	@Deployment
    public static JavaArchive createTestArchive() {
		final JavaArchive jar = BaseARSVTest.createTestArchive();
				
		jar.addClasses(ClienteSACSessionLocal.class, ClienteSACSessionBean.class,
				AeronavesServicesWS.class, SacAeronave.class, 
				SacTipoAeronave.class, SACBusinessException.class);
		
		jar.addAsResource("sac_ws.properties");
		
        log.info(jar.toString(true));
        
        return jar;
	}
	
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
	public void testBuscarAeronavesSAC() {
		try {			
			List<AeronaveARSV> result = this.clienteSAC.buscarAeronavesSAC();		
			assertNotNull(result);
			
			log.info("Cantidad de Aeronaves SAC: " + result.size());
			
		} catch (Exception e) {
			log.error(e.getMessage());
			fail(e.getMessage());
		}
	}

}
*/