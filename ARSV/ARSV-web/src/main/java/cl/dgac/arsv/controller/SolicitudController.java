//package cl.dgac.arsv.controller;
//
//import java.io.IOException;
//import java.io.Serializable;
//
//import javax.ejb.EJB;
//import javax.faces.application.FacesMessage;
//import javax.faces.bean.ViewScoped;
//import javax.faces.context.FacesContext;
//import javax.inject.Inject;
//import javax.inject.Named;
//
//import org.apache.log4j.Logger;
//
//import cl.dgac.arsv.exceptions.ARSVBusinessException;
//import cl.dgac.arsv.handler.BrmsClientHandlerInterLocal;
//import cl.dgac.arsv.model.ArsvUsuario;
//import cl.dgac.arsv.service.SeguridadArsvSessionRemote;
//import cl.dgac.arsv.util.MessageFactory;
//
//@Named("solicitudController")
//@ViewScoped
//public class SolicitudController implements Serializable {
//
//	private static final long serialVersionUID = 6028800674648516667L;
//
//	public static final Logger log = Logger.getLogger(SolicitudController.class);
//	
//	@Inject
//	private FacesContext facesContext;  	
//	
//	@Inject
//	private BrmsClientHandlerInterLocal brmsClientHandlerInter;
//	
//	@EJB
//	private SeguridadArsvSessionRemote seguridadService;
//	
//	private int indexMenu;
//	
//	private int indexMenuMantenedor;
//	
//	private String token;
//	
//	private ArsvUsuario usr;
//	
//	private String usuario;
//	
//	private String pass;	
//
//	public void verificarInitBrmsClient(){  
//    	try {
//			brmsClientHandlerInter.verificarProcesoExistente();
//		} catch (ARSVBusinessException e) {
//			facesContext.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Crear Solicitud:", 
//					MessageFactory.getMessage("Brms no iniciado. Consulte administrador")));
//		}
//    }
//    
//    //se llama desde todas las pantallas de internet con un preRenderView
//	//inicia el brms con cualquier usuario siendo utilizado en la solicitud ya que cualquiera la puede ingresar
//    public void initBrmsClientAll() throws ARSVBusinessException{  
//    	log.debug("Se trata de inicializar el cliente REST de BRMS");
//    	if (null == brmsClientHandlerInter.getBrmsClientInternet()){ 	   		
//    		brmsClientHandlerInter.initBrmsClientStatic();
//    	}    	
//    }
//    
//	/**
//	 * Inicia BRMSClient con el usuario conectado a la intranet
//	 */
//	public void initBrmsClientUser() {
//		if (null == token) {
//			redirectError();
//		} else {
//			try {
//				this.usuario = null;
//				this.pass = null;
//				usr = seguridadService.getUsuarioToken(token);
//				this.usuario = usr.getUsuaUser();
//				this.pass = usr.getUsuaClaveUser();
//			} catch (Exception e) {
//				redirectError();
//			}
//		}
//	}
//	
//	private void redirectError() {
//		try {
//			FacesContext.getCurrentInstance().getExternalContext()
//					.redirect("errorCredenciales.xhtml");
//		} catch (IOException e) {
//			log.error(e.getMessage());
//		}
//
//	}
//	
//	public void establecerModoMantenedor(Long _modo) {
//		indexMenuMantenedor = _modo.intValue();
//	}
//
//    
//	public void establecerModo(Long _modo) {
//		indexMenu = _modo.intValue();
//	}
//
//	public int getIndexMenu() {
//		return indexMenu;
//	}
//
//	public void setIndexMenu(int indexMenu) {
//		this.indexMenu = indexMenu;
//	}
//
//	public SeguridadArsvSessionRemote getSeguridadService() {
//		return seguridadService;
//	}
//
//	public void setSeguridadService(SeguridadArsvSessionRemote seguridadService) {
//		this.seguridadService = seguridadService;
//	}
//
//	public String getToken() {
//		return token;
//	}
//
//	public void setToken(String token) {
//		this.token = token;
//	}
//
//	public ArsvUsuario getUsr() {
//		return usr;
//	}
//
//	public void setUsr(ArsvUsuario usr) {
//		this.usr = usr;
//	}
//
//	public BrmsClientHandlerInterLocal getBrmsClientHandlerInter() {
//		return brmsClientHandlerInter;
//	}
//
//	public void setBrmsClientHandlerInter(
//			BrmsClientHandlerInterLocal brmsClientHandlerInter) {
//		this.brmsClientHandlerInter = brmsClientHandlerInter;
//	}
//
//	public String getUsuario() {
//		return usuario;
//	}
//
//	public void setUsuario(String usuario) {
//		this.usuario = usuario;
//	}
//
//	public String getPass() {
//		return pass;
//	}
//
//	public void setPass(String pass) {
//		this.pass = pass;
//	}
//
//	public int getIndexMenuMantenedor() {
//		return indexMenuMantenedor;
//	}
//
//	public void setIndexMenuMantenedor(int indexMenuMantenedor) {
//		this.indexMenuMantenedor = indexMenuMantenedor;
//	}
//	
//
//	
//	
//	
//}
