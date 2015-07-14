//package cl.dgac.arsv.test;
//
//import org.apache.log.ContextMap;
//import org.apache.log.ErrorHandler;
//import org.apache.log.LogEvent;
//import org.apache.log.LogTarget;
//import org.apache.log.Logger;
//import org.apache.log.Priority;
//import org.apache.log.util.LoggerListener;
//import org.jboss.arquillian.container.test.api.Deployment;
//import org.jboss.arquillian.junit.Arquillian;
//import org.jboss.shrinkwrap.api.ArchivePaths;
//import org.jboss.shrinkwrap.api.ShrinkWrap;
//import org.jboss.shrinkwrap.api.asset.EmptyAsset;
//import org.jboss.shrinkwrap.api.spec.JavaArchive;
//import org.junit.After;
//import org.junit.AfterClass;
//import org.junit.Before;
//import org.junit.BeforeClass;
//import org.junit.runner.RunWith;
//
//import cl.dgac.arsv.service.MailArsvSessionLocal;
//import cl.dgac.arsv.service.MailArsvSessionRemote;
//import cl.dgac.arsv.service.MailArsvSessionWS;
//import cl.dgac.arsv.service.impl.MailArsvSessionBean;
//
//import freemarker.cache.CacheStorage;
//import freemarker.cache.TemplateCache;
//import freemarker.cache.TemplateLoader;
//import freemarker.template.Configuration;
//import freemarker.template.EmptyMap;
//import freemarker.template.ObjectWrapper;
//import freemarker.template.SimpleHash;
//import freemarker.template.SimpleSequence;
//import freemarker.template.Template;
//import freemarker.template.TemplateBooleanModel;
//import freemarker.template.TemplateCollectionModel;
//import freemarker.template.TemplateDateModel;
//import freemarker.template.TemplateException;
//import freemarker.template.TemplateExceptionHandler;
//import freemarker.template.TemplateHashModel;
//import freemarker.template.TemplateHashModelEx;
//import freemarker.template.TemplateMethodModel;
//import freemarker.template.TemplateMethodModelEx;
//import freemarker.template.TemplateModel;
//import freemarker.template.TemplateModelException;
//import freemarker.template.TemplateModelIterator;
//import freemarker.template.TemplateNodeModel;
//import freemarker.template.TemplateNumberModel;
//import freemarker.template.TemplateScalarModel;
//import freemarker.template.TemplateSequenceModel;
//import freemarker.template.TemplateTransformModel;
//import freemarker.template.WrappingTemplateModel;
//import freemarker.template.utility.UndeclaredThrowableException;
//
//@RunWith(Arquillian.class)
//public abstract class BaseARSVTest {
//
//	@Deployment
//	public static JavaArchive createTestArchive() {
//		final JavaArchive jar = ShrinkWrap.create(JavaArchive.class, "arsv-ejb-test.jar");
//
//		// API
//		jar.addPackages(true, "cl.dgac.arsv.exceptions");
//		jar.addPackages(true, "cl.dgac.arsv.model");
//		jar.addPackages(true, "cl.dgac.arsv.util");
//
//		// DAO
//		jar.addPackages(true, "cl.dgac.arsv.filters");
//		jar.addPackages(true, "cl.dgac.arsv.dao");
//
//		// Utils
//		jar.addPackages(true, "cl.seis.generic.filters");
//		jar.addPackages(true, "cl.seis.generic.dao");
//
//		// SAC
//		jar.addPackages(true, "cl.dgac.sac");
//		
//		// BRMS
//		jar.addPackages(true, "cl.dgac.arsv.handler");		
//		jar.addPackages(true, "cl.dgac.brms");		
//		jar.addPackages(true, "org.apache.http");
//				
//		// Mail
//		jar.addClasses(MailArsvSessionLocal.class, MailArsvSessionRemote.class, 
//				MailArsvSessionWS.class, MailArsvSessionBean.class);
//		jar.addPackages(true, "org.apache.commons.codec");
//		
//		// Freemarker y dependencias
//		jar.addPackages(true, "freemarker.core");
//		jar.addPackages(true, "freemarker.log");
//
//		jar.addClasses(Configuration.class, TemplateException.class,
//				TemplateExceptionHandler.class, SimpleHash.class,
//				TemplateHashModelEx.class, TemplateHashModel.class,
//				TemplateModel.class, WrappingTemplateModel.class,
//				TemplateModelException.class, ObjectWrapper.class,
//				TemplateLoader.class, CacheStorage.class, TemplateCache.class,
//				Template.class, TemplateMethodModelEx.class,
//				TemplateMethodModel.class, SimpleSequence.class,
//				TemplateSequenceModel.class, TemplateScalarModel.class,
//				TemplateDateModel.class, TemplateBooleanModel.class,
//				TemplateCollectionModel.class, TemplateTransformModel.class,
//				TemplateModelIterator.class, TemplateNumberModel.class,
//				TemplateNodeModel.class, EmptyMap.class, Logger.class,
//				ErrorHandler.class, LogEvent.class, LoggerListener.class,
//				LogTarget.class, Priority.class, ContextMap.class,
//				UndeclaredThrowableException.class);
//
//		// Configuracion
//		jar.addAsResource("META-INF/test-persistence.xml", "META-INF/persistence.xml");
//		jar.addAsManifestResource(EmptyAsset.INSTANCE, ArchivePaths.create("beans.xml"));
//
//		// Tests
//		jar.addClasses(BaseARSVTest.class);
//
//		return jar;
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
//}
