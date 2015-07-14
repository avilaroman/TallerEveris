package cl.dgac.arsv.util.templates;

import java.io.IOException;
import java.io.Serializable;
import java.util.Locale;

import javax.annotation.PostConstruct;
import javax.enterprise.context.ApplicationScoped;

import org.apache.log4j.Logger;

import freemarker.template.Configuration;
import freemarker.template.Template;

@ApplicationScoped
@SuppressWarnings("serial")
public class Templates implements Serializable {

	private Logger log = Logger.getLogger(Templates.class);

	private Configuration cfg;

	@PostConstruct
	protected void init() {
		cfg = new Configuration();
		cfg.setEncoding(Locale.getDefault(), "UTF-8");
		cfg.setEncoding(new Locale("es"), "UTF-8");
		cfg.setEncoding(Locale.ENGLISH, "UTF-8");
		cfg.setClassForTemplateLoading(Templates.class, "");

	}

	public Template getIngresoSolicitud() {
		try {
			Template ret = cfg.getTemplate("notificacionOperador.ftl");
			ret.setEncoding("UTF8");
			return ret;
		} catch (IOException e) {
			log.error(e.getMessage());
			return null;
		}
	}
	
	public Template getIngresoSolicitudAntartica() {
		try {
			Template ret = cfg.getTemplate("notificacionOperadorAntartica.ftl");
			ret.setEncoding("UTF8");
			return ret;
		} catch (IOException e) {
			log.error(e.getMessage());
			return null;
		}
	}
	
	public Template getIngresoSolicitudPascua() {
		try {
			Template ret = cfg.getTemplate("notificacionOperadorPascua.ftl");
			ret.setEncoding("UTF8");
			return ret;
		} catch (IOException e) {
			log.error(e.getMessage());
			return null;
		}
	}
	
	public Template getNotificacionComercial() {
		try {
			Template ret = cfg.getTemplate("notificacionComercial.ftl");
			ret.setEncoding("UTF8");
			return ret;
		} catch (IOException e) {
			log.error(e.getMessage());
			return null;
		}
	}
	
	public Template getNotificacionComercialAntartica() {
		try {
			Template ret = cfg.getTemplate("notificacionComercialAntartica.ftl");
			ret.setEncoding("UTF8");
			return ret;
		} catch (IOException e) {
			log.error(e.getMessage());
			return null;
		}
	}
	
	public Template getNotificacionComercialPascua() {
		try {
			Template ret = cfg.getTemplate("notificacionComercialPascua.ftl");
			ret.setEncoding("UTF8");
			return ret;
		} catch (IOException e) {
			log.error(e.getMessage());
			return null;
		}
	}
	
	public Template getSolicitudPronunciamientoFACH() {
		try {
			Template ret = cfg.getTemplate("solicitudPronunciamientoFACH.ftl");
			ret.setEncoding("UTF8");
			return ret;
		} catch (IOException e) {
			log.error(e.getMessage());
			return null;
		}
	}
	
	public Template getSolicitudPronunciamientoINACH() {
		try {
			Template ret = cfg.getTemplate("solicitudPronunciamientoINACH.ftl");
			ret.setEncoding("UTF8");
			return ret;
		} catch (IOException e) {
			log.error(e.getMessage());
			return null;
		}
	}
	
	public Template getSolicitudPronunciamientoJAC() {
		try {
			Template ret = cfg.getTemplate("solicitudPronunciamientoJAC.ftl");
			ret.setEncoding("UTF8");
			return ret;
		} catch (IOException e) {
			log.error(e.getMessage());
			return null;
		}
	}
	
	public Template getRechazoSolicitud() {
		try {
			Template ret = cfg.getTemplate("notificacionOperadorArsvCerrada.ftl");
			ret.setEncoding("UTF8");
			return ret;
		} catch (IOException e) {
			log.error(e.getMessage());
			return null;
		}
	}
	
	public Template getRechazoSolicitudAntartica() {
		try {
			Template ret = cfg.getTemplate("notificacionOperadorAntarticaCerrada.ftl");
			ret.setEncoding("UTF8");
			return ret;
		} catch (IOException e) {
			log.error(e.getMessage());
			return null;
		}
	}
	
	public Template getAprobadaSolicitudAntartica() {
		try {
			Template ret = cfg.getTemplate("notificacionOperadorAntarticaAprobada.ftl");
			ret.setEncoding("UTF8");
			return ret;
		} catch (IOException e) {
			log.error(e.getMessage());
			return null;
		}
	}
	
	public Template getAprobadaSolicitudPascua() {
		try {
			Template ret = cfg.getTemplate("notificacionOperadorPascuaAprobada.ftl");
			ret.setEncoding("UTF8");
			return ret;
		} catch (IOException e) {
			log.error(e.getMessage());
			return null;
		}
	}
	
	public Template getSolicitudAntecedentes() {
		try {
			Template ret = cfg.getTemplate("solicitudAntecedentes.ftl");
			ret.setEncoding("UTF8");
			return ret;
		} catch (IOException e) {
			log.error(e.getMessage());
			return null;
		}
	}
	
	public Template getSolicitudAntecedentesAntartica() {
		try {
			Template ret = cfg.getTemplate("solicitudAntecedentesAntartica.ftl");
			ret.setEncoding("UTF8");
			return ret;
		} catch (IOException e) {
			log.error(e.getMessage());
			return null;
		}
	}
	
	public Template getSolicitudAntecedentesPascua() {
		try {
			Template ret = cfg.getTemplate("solicitudAntecedentesPascua.ftl");
			ret.setEncoding("UTF8");
			return ret;
		} catch (IOException e) {
			log.error(e.getMessage());
			return null;
		}
	}
}