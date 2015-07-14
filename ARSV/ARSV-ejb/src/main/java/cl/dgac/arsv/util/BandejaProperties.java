package cl.dgac.arsv.util;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.util.Properties;

import javax.annotation.PostConstruct;
import javax.ejb.Startup;
import javax.enterprise.context.ApplicationScoped;

import org.apache.log4j.Logger;


@ApplicationScoped
@Startup
public class BandejaProperties extends Properties {

	/**
	 * 
	 */
	private static final long serialVersionUID = 3407280291689662907L;

	public static final String DEFAULT_FILE_NAME = "bandeja.properties";

	private static final String SERVER_CONF_URL = null;
			//System.getProperty("jboss.server.config.dir");

	private static Logger log = Logger.getLogger(BandejaProperties.class);

	@PostConstruct
	protected void init() throws Exception {
		
		log.info("PROPIEDADES DEL SISTEMA CARGADAS EN FORMULARIOS");
		
		try {
			File externalFile = getExternalConfig();
			InputStream elInput=null;
			if (externalFile==null) {
				log.warn("No se encontró archivo de configuración "+DEFAULT_FILE_NAME+ " en "+SERVER_CONF_URL+". Se usará el default");
				elInput  = this.getClass().getClassLoader().getResourceAsStream(DEFAULT_FILE_NAME);
			} else {
				log.info("Usando archivo de configuración de Bandeja "+externalFile.getAbsolutePath());
				elInput = new FileInputStream(externalFile);
			}
			
			this.load(elInput);
		} catch (Exception e) {
			log.error(e.getMessage());
			throw new Exception("No puedo cargar el arhivo properties "
					+ DEFAULT_FILE_NAME, e);
		}
	}

	private File getExternalConfig() {
		if (SERVER_CONF_URL == null)
			return null;
		File ret = new File(SERVER_CONF_URL, DEFAULT_FILE_NAME);

		if (!ret.exists())
			return null;

		return ret;

	}

	public String getHostBRMS() {
		return this.getProperty("brms.host");
	}

	public String getPortBRMS() {
		return this.getProperty("brms.port");
	}

	public String getUser() {
		return this.getProperty("brms.user");
	}

	public String getPass() {
		return this.getProperty("brms.pass");
	}
	
	public String getArsvUrl() {
		return this.getProperty("arsv.url");
	}
	
	public String getArsvUrlPublic() {
		return this.getProperty("arsv.url.public");
	}
}