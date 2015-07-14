//package cl.dgac.arsv.controller;
//
//import java.io.IOException;
//import java.io.Serializable;
//import java.util.List;
//
//import javax.annotation.PostConstruct;
//import javax.enterprise.inject.Produces;
//import javax.faces.application.FacesMessage;
//import javax.faces.bean.ViewScoped;
//import javax.faces.context.FacesContext;
//import javax.inject.Inject;
//import javax.inject.Named;
//
//import org.apache.log4j.Logger;
//import org.primefaces.context.RequestContext;
//
//import cl.dgac.arsv.exceptions.ARSVBusinessException;
//import cl.dgac.arsv.model.ArsvClasificacion;
//import cl.dgac.arsv.model.ArsvMotivoExtension;
//import cl.dgac.arsv.model.ArsvObjetoVuelo;
//import cl.dgac.arsv.model.ArsvPaisOrigen;
//import cl.dgac.arsv.model.ArsvRuta;
//import cl.dgac.arsv.model.ArsvUsuario;
//import cl.dgac.arsv.model.OperacionAntartica;
//import cl.dgac.arsv.model.OperacionPascua;
//import cl.dgac.arsv.model.SolicitudArriboSobrevuelo;
//import cl.dgac.arsv.model.SolicitudExtPermanencia;
//import cl.dgac.arsv.service.ClienteSACSessionLocal;
//import cl.dgac.arsv.service.SeguridadArsvSessionLocal;
//import cl.dgac.arsv.service.SolicitudExtSessionLocal;
//import cl.dgac.arsv.service.SolicitudOperacionAntarticaSessionLocal;
//import cl.dgac.arsv.service.SolicitudOperacionPascuaSessionLocal;
//import cl.dgac.arsv.service.SolicitudSessionLocal;
//import cl.dgac.arsv.util.AeronaveARSV;
//import cl.dgac.arsv.util.MessageFactory;
//import cl.dgac.arsv.util.OperadorARSV;
//
//@Named("solicitudExtController")
//@ViewScoped
//public class SolicitudExtController implements Serializable{
//
//	/**
//	 * 
//	 */
//	private static final long serialVersionUID = 843945266959703749L;
//	
//	public static final Logger log = Logger.getLogger(SolicitudExtController.class);
//	
//	@Inject
//	private FacesContext facesContext; 
//	
//    @Inject
//    private ClienteSACSessionLocal clienteSACSession;
//    
//	@Inject
//	private SolicitudExtSessionLocal solicitudExtService;
//	
//	@Inject
//	private SolicitudSessionLocal solicitudArsvService;
//	
//	@Inject 
//	private SolicitudOperacionAntarticaSessionLocal antarticaSessionLocal;
//	
//	@Inject 
//	private SolicitudOperacionPascuaSessionLocal operacionPascuaSessionLocal;
//	
//	@Inject
//	private SeguridadArsvSessionLocal seguridadService;
//	
//    private SolicitudExtPermanencia nuevaSolicitudExt;
//    
//    private SolicitudExtPermanencia solicitudExt;
//    
//    private SolicitudArriboSobrevuelo solicitudArriboSobrevuelo;
//    
//    private OperacionAntartica operacionAntartica;
//    
//    private OperacionPascua operacionPascua;
//    
//	private AeronaveARSV aeronaveARSV;
//	
//	private OperadorARSV operadorARSV;
//	
//	private List<OperadorARSV> operadoresARSV;
//	
//	private List<AeronaveARSV> aeronavesARSV;
//	
//	private Long solicitudId;
//	
//	private Long idTask;
//	
//	private String mensajeResOperacion;
//	
//	private String token;
//	
//	private ArsvUsuario usr;
//	
//	private String usuario;
//	
//	private String pass;
//    
//	private String extSoliUrl = null;
//	
//	private String fieldExt = "false";
//	
//	private String botonesExt = "true";
//	
//	private String renderDSO = "false";
//	
//	private String renderBtnAprovar = "true";
//	
//	private List<ArsvRuta> rutaPrincipal;
//	
//	private List<ArsvRuta> rutaAlternativa;
//    
//    @Produces   
//    @Named
//    public SolicitudExtPermanencia getNuevaSolicitudExt() {
//    	return nuevaSolicitudExt;
//    }
//    
//    @PostConstruct
//    public void initNuevaSolicitud() {	   
//       nuevaSolicitudExt = new SolicitudExtPermanencia();
//       solicitudArriboSobrevuelo = null;
//       operacionAntartica = null;
//       operacionPascua = null;
//       extSoliUrl = null;
//       botonesExt = "true";
//       fieldExt = "false";
//       renderDSO = "false";
//       renderBtnAprovar = "true";
//       this.aeronaveARSV = new AeronaveARSV();
//    }   
//    
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
//    public void register() {    	
//    	log.debug("Registrando nueva solicitud..");
//    	try {		
//    		
//    		if(null!=solicitudArriboSobrevuelo){
//	    		Long solicitudIdNueva = solicitudExtService.ingresarArsvExtPerm(nuevaSolicitudExt, solicitudArriboSobrevuelo);	
//	    		facesContext.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Solicitud usuario:", MessageFactory
//	  				.getMessage("{solicitud.nuevaSolicitud}", new Object[] {solicitudIdNueva})));
//    		}
//    		
//    		if(null!=operacionAntartica){
//	    		Long solicitudIdNueva = solicitudExtService.ingresarAntarticaExtPerm(nuevaSolicitudExt, operacionAntartica);	
//	    		facesContext.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Solicitud usuario:", MessageFactory
//	  				.getMessage("{solicitud.nuevaSolicitud}", new Object[] {solicitudIdNueva})));
//    		}
//    		
//    		if(null!=operacionPascua){
//	    		Long solicitudIdNueva = solicitudExtService.ingresarPascuaExtPerm(nuevaSolicitudExt, operacionPascua);	
//	    		facesContext.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Solicitud usuario:", MessageFactory
//	  				.getMessage("{solicitud.nuevaSolicitud}", new Object[] {solicitudIdNueva})));
//    		}
//    		
//	  		
//  		} catch (ARSVBusinessException e) {
//  			facesContext.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Solicitud usuario:", e.getMessage()));
//  		}
//        initNuevaSolicitud();
//    }
//	
//	public void cargarExtPerm(Long id){
//		this.solicitudId = id;
//	}
//	
//	public void obtenerSolicitud() {
//		try {
//			String matriculaAeronave = null;
//			if(null!=solicitudArsvService.seleccionarSolicitud(solicitudId)){
//				solicitudArriboSobrevuelo = solicitudArsvService.seleccionarSolicitud(solicitudId);
//				
//				if(null == solicitudArriboSobrevuelo || !solicitudArriboSobrevuelo.getTipoSolicitud().getCodigo().equals("ARRIBO")){
//					this.extSoliUrl = null;
//					this.botonesExt = "true";
//					this.fieldExt = "false";
//					facesContext.addMessage(null, new FacesMessage(
//							FacesMessage.SEVERITY_ERROR, "Solicitud:",
//							MessageFactory.getMessage("{solicitud.inexistente}")));
//				}else{
//					matriculaAeronave = this.solicitudArriboSobrevuelo.getSacAeronave();
//					
//					rutaPrincipal = solicitudArsvService.getRutaPrincipal(solicitudArriboSobrevuelo);
//					rutaAlternativa = solicitudArsvService.getRutaAlternativa(solicitudArriboSobrevuelo);
//					
//					if(matriculaAeronave!=null ){
//						try {
//							this.solicitudArriboSobrevuelo.setAeronave(clienteSACSession.buscarAeronavesSAC(matriculaAeronave));
//						} catch (ARSVBusinessException e) {
//							// TODO Auto-generated catch block
//							e.printStackTrace();
//						}			
//					}
//					this.extSoliUrl = "/extArsv.xhtml";
//					this.botonesExt = "false";
//					this.fieldExt = "true";
//				}				
//			}
//			
//			if(null!=operacionPascuaSessionLocal.seleccionarOperacion(solicitudId)){
//				operacionPascua = operacionPascuaSessionLocal.seleccionarOperacion(solicitudId);
//				if(null == operacionPascua || !operacionPascua.getTipoSolicitud().getCodigo().equals("ARRIBOPASCUA")){
//					this.extSoliUrl = null;
//					this.botonesExt = "true";
//					this.fieldExt = "false";
//					facesContext.addMessage(null, new FacesMessage(
//							FacesMessage.SEVERITY_ERROR, "Solicitud:",
//							MessageFactory.getMessage("{solicitud.inexistente}")));
//				}else{
//					matriculaAeronave = this.operacionPascua.getSacAeronave();
//					
//					rutaPrincipal = operacionPascuaSessionLocal.getRutaPrincipal(operacionPascua);
//					rutaAlternativa = operacionPascuaSessionLocal.getRutaAlternativa(operacionPascua);
//					
//					if(matriculaAeronave!=null ){
//						try {
//							this.operacionPascua.setAeronave(clienteSACSession.buscarAeronavesSAC(matriculaAeronave));
//						} catch (ARSVBusinessException e) {
//							// TODO Auto-generated catch block
//							e.printStackTrace();
//						}			
//					}
//					this.extSoliUrl = "/extPascua.xhtml";
//					this.botonesExt = "false";
//					this.fieldExt = "true";
//				}	
//			}
//			
//			if(null!=antarticaSessionLocal.seleccionarSolicitud(solicitudId)){
//				operacionAntartica = antarticaSessionLocal.seleccionarSolicitud(solicitudId);
//				if(null == operacionAntartica || !operacionAntartica.getTipoSolicitud().getCodigo().equals("ARRIBOANTARTICA")){
//					this.extSoliUrl = null;
//					this.botonesExt = "true";
//					this.fieldExt = "false";
//					facesContext.addMessage(null, new FacesMessage(
//							FacesMessage.SEVERITY_ERROR, "Solicitud:",
//							MessageFactory.getMessage("{solicitud.inexistente}")));
//				}else{
//					matriculaAeronave = this.operacionAntartica.getSacAeronave();
//					
//					if(matriculaAeronave!=null ){
//						try {
//							this.operacionAntartica.setAeronave(clienteSACSession.buscarAeronavesSAC(matriculaAeronave));
//						} catch (ARSVBusinessException e) {
//							// TODO Auto-generated catch block
//							e.printStackTrace();
//						}			
//					}
//					this.extSoliUrl = "/extAntartica.xhtml";
//					this.botonesExt = "false";
//					this.fieldExt = "true";
//				}	
//			}
//			
//			
//
//		} catch (ARSVBusinessException e) {
//			this.extSoliUrl = null;
//			this.botonesExt = "true";
//			this.fieldExt = "false";
//			facesContext.addMessage(null,
//					new FacesMessage(FacesMessage.SEVERITY_ERROR,
//							"Solicitud:", e.getMessage()));
//		}
//	}
//	
//	public void obtenerSolicitudExtension() {
//		try {
//			solicitudExt = solicitudExtService.seleccionarSolicitud(solicitudId);
//			
//			if (null == solicitudExt) {
//				facesContext.addMessage(null, new FacesMessage(
//						FacesMessage.SEVERITY_ERROR, "Solicitud:",
//						MessageFactory.getMessage("{solicitud.inexistente}")));
//			}
//			
//			String matriculaAeronave = this.solicitudExt.getSolicitud().getSacAeronave();
//			if(matriculaAeronave!=null ){
//				try {
//					this.solicitudExt.getSolicitud().setAeronave(clienteSACSession.buscarAeronavesSAC(matriculaAeronave));
//				} catch (ARSVBusinessException e) {
//					// TODO Auto-generated catch block
//					e.printStackTrace();
//				}			
//			}
//		} catch (ARSVBusinessException e) {
//			facesContext.addMessage(null,
//					new FacesMessage(FacesMessage.SEVERITY_ERROR,
//							"Solicitud:", e.getMessage()));
//		}
//	}
//	
//	
//	/*
//	 * Obtiene la solicitud de arribo y sobrevuelo para el prerender de atenderextensionarsv
//	 */
//	public void obtenerSolicitudArsvExt() {
//		try {
//			//solicitudArriboSobrevuelo = solicitudArsvService.seleccionarSolicitud(solicitudId);
//			solicitudExt = solicitudExtService.seleccionarSolicitud(solicitudId);
//			solicitudArriboSobrevuelo = solicitudArsvService.seleccionarSolicitud(solicitudExt.getSolicitud().getId());
//			
//			String matriculaAeronave = this.solicitudArriboSobrevuelo.getSacAeronave();
//			if(matriculaAeronave!=null ){
//				try {
//					this.solicitudArriboSobrevuelo.setAeronave(clienteSACSession.buscarAeronavesSAC(matriculaAeronave));
//				} catch (ARSVBusinessException e) {
//					// TODO Auto-generated catch block
//					e.printStackTrace();
//				}
//			
//			}
//			
//			if (null == solicitudExt) {
//				facesContext.addMessage(null, new FacesMessage(
//						FacesMessage.SEVERITY_ERROR, "Solicitud:",
//						MessageFactory.getMessage("{solicitud.inexistente}")));
//			}
//		} catch (ARSVBusinessException e) {
//			facesContext.addMessage(null,
//					new FacesMessage(FacesMessage.SEVERITY_ERROR,
//							"Solicitud:", e.getMessage()));
//		}
//	}
//	
//	/*
//	 * Redirecciona a pagina segun tipo de solicitud a la cual se le aplico la extension
//	 */
//	public void redireccionExtSolicitud() {
//		try{
//			solicitudExt = solicitudExtService.seleccionarSolicitud(solicitudId);
//			
//			solicitudArriboSobrevuelo = solicitudArsvService.seleccionarSolicitud(solicitudExt.getSolicitud().getId());
//			operacionAntartica =  antarticaSessionLocal.seleccionarSolicitud(solicitudExt.getSolicitud().getId());
//			operacionPascua = operacionPascuaSessionLocal.seleccionarOperacion(solicitudExt.getSolicitud().getId());
//			
//			if(solicitudArriboSobrevuelo!=null){
//				FacesContext.getCurrentInstance().getExternalContext()
//				.redirect("atenderSolicitudArsvExt.xhtml?idTask="+ idTask + "&solicitudId=" + solicitudId + "&token=" + token);
//			}
//			
//			if(operacionAntartica!=null){
//				FacesContext.getCurrentInstance().getExternalContext()
//				.redirect("atenderSolicitudAntarticaExt.xhtml?idTask="+ idTask + "&solicitudId=" + solicitudId + "&token=" + token);
//			}
//			
//			if(operacionPascua!=null){
//				FacesContext.getCurrentInstance().getExternalContext()
//				.redirect("atenderSolicitudPascuaExt.xhtml?idTask="+ idTask + "&solicitudId=" + solicitudId + "&token=" + token);
//			}
//			
//			else{
//				FacesContext.getCurrentInstance().getExternalContext()
//				.redirect("error.xhtml");
//			}
//		}catch(Exception e){
//			e.getMessage();
//		}
//	}
//	
//	public void obtenerSolicitudAntartica() {
//		try{
//			solicitudExt = solicitudExtService.seleccionarSolicitud(solicitudId);
//
//			operacionAntartica =  antarticaSessionLocal.seleccionarSolicitud(solicitudExt.getSolicitud().getId());
//			
//			if(operacionAntartica.getSolicitudExtPermanencias()!=null){
//				if(operacionAntartica.getSolicitudExtPermanencias().size()>2){
//					this.renderDSO = "true";
//					facesContext.addMessage(null,
//							new FacesMessage(FacesMessage.SEVERITY_ERROR,
//									"Estimado: ", 
//										"Esta solicitud a recibido mas de 2 solicitudes de extension de permanencia, por lo cual debe consultar a DSO para poder aprobar esta solicitud."));
//				}
//			}
//
//		}catch(Exception e){
//			e.getMessage();
//		}
//	}
//	
//	public void obtenerSolicitudPascua() {
//		try{
//			solicitudExt = solicitudExtService.seleccionarSolicitud(solicitudId);
//
//			operacionPascua = operacionPascuaSessionLocal.seleccionarOperacion(solicitudExt.getSolicitud().getId());
//
//		}catch(Exception e){
//			e.getMessage();
//		}
//	}
//	
//	public void obtenerSolicitudArsv() {
//		try{
//			solicitudExt = solicitudExtService.seleccionarSolicitud(solicitudId);
//
//			solicitudArriboSobrevuelo = solicitudArsvService.seleccionarSolicitud(solicitudExt.getSolicitud().getId());
//
//		}catch(Exception e){
//			e.getMessage();
//		}
//	}
//	
//	public String tomarConocimientoAprobado() {
//		log.info("metodo para aprobar");
//		try {
//			initBrmsClientUser();
//			
//			solicitudExtService.tomarConocimiento(solicitudExt, idTask, usuario, pass);
//
//			RequestContext.getCurrentInstance().addCallbackParam("showDialog",
//					true);
//			this.setMensajeResOperacion(MessageFactory
//					.getMessage("{solicitud.cerrar.correcto}"));
//		} catch (ARSVBusinessException e) {
//			log.error("Error tratando de cerrar la solicitud", e);
//		}
//
//		return null;
//	}	
//	
//	public String aprobarExt() {
//		try{
//			if (null == solicitudExt) {
//				
//				solicitudExt = solicitudExtService.seleccionarSolicitud(solicitudId);
//			}
//		
//		
//			initBrmsClientUser();
//			
//			solicitudExtService.asignarExtPerm(solicitudExt, idTask, usuario, pass);
//			renderBtnAprovar = "false";
//
//			facesContext.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Solicitud usuario:", "La solicitud ha sido aprobada correctamente")); 
//
//		}catch(ARSVBusinessException e){
//			facesContext.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Solicitud usuario:", "No se ha podido aprobar la solicitud")); 
//		}
//		
//		return null;
//		
//	}
//	
//	public void aprobarExtAero() throws Exception {
//		if (null == solicitudExt) {
//			solicitudExt = solicitudExtService.seleccionarSolicitud(solicitudId);
//		}
//		
//		initBrmsClientUser();
//		
//		solicitudExtService.asignarExtPermAero(solicitudExt, idTask,usuario,pass);
//	}	
//	
//	public void cerrarSolicitudExt() {
//		try {
//			
//			initBrmsClientUser();
//			
//			solicitudExtService.cerrarSolicitud(solicitudExt, idTask, usuario, pass);
//
//			RequestContext.getCurrentInstance().addCallbackParam("showDialog",
//					true);
//			this.setMensajeResOperacion(MessageFactory
//					.getMessage("{solicitud.cerrar.correcto}"));
//		} catch (ARSVBusinessException e) {
//			log.error("Error tratando de cerrar la solicitud", e);
//		}
//	}
//	
//    public List<ArsvMotivoExtension> getArsvMotivoExtension() {
//  	   return solicitudExtService.getArsvMotivoExtension();
//     }
//    
//    public List<ArsvObjetoVuelo> getArsvObjetoVuelo() {
//  	   return solicitudExtService.getArsvObjetoVuelo();
//     }
//     
//     public List<ArsvPaisOrigen> getArsvPaisesOrigen() {
//  	   return solicitudExtService.getArsvPaisesOrigen();
//     }
//     
//     public List<ArsvClasificacion> getArsvClasificaciones() {
//  	   return solicitudExtService.getArsvClasificaciones();
//     }
//     
//     public List<OperadorARSV> getOperadoresARSV(){
//     	return this.operadoresARSV; 			
//     }
//     
//     public List<AeronaveARSV> getAeronavesARSV(){
//     	return this.aeronavesARSV; 			
//     }
//
//	public ClienteSACSessionLocal getClienteSACSession() {
//		return clienteSACSession;
//	}
//
//	public void setClienteSACSession(ClienteSACSessionLocal clienteSACSession) {
//		this.clienteSACSession = clienteSACSession;
//	}
//
//	public SolicitudExtSessionLocal getSolicitudExtService() {
//		return solicitudExtService;
//	}
//
//	public void setSolicitudExtService(SolicitudExtSessionLocal solicitudExtService) {
//		this.solicitudExtService = solicitudExtService;
//	}
//
//	public AeronaveARSV getAeronaveARSV() {
//		return aeronaveARSV;
//	}
//
//	public void setAeronaveARSV(AeronaveARSV aeronaveARSV) {
//		this.aeronaveARSV = aeronaveARSV;
//	}
//
//	public OperadorARSV getOperadorARSV() {
//		return operadorARSV;
//	}
//
//	public void setOperadorARSV(OperadorARSV operadorARSV) {
//		this.operadorARSV = operadorARSV;
//	}
//
//
//
//	public void setNuevaSolicitudExt(SolicitudExtPermanencia nuevaSolicitudExt) {
//		this.nuevaSolicitudExt = nuevaSolicitudExt;
//	}
//
//	public void setOperadoresARSV(List<OperadorARSV> operadoresARSV) {
//		this.operadoresARSV = operadoresARSV;
//	}
//
//	public void setAeronavesARSV(List<AeronaveARSV> aeronavesARSV) {
//		this.aeronavesARSV = aeronavesARSV;
//	}
//
//	public Long getSolicitudId() {
//		return solicitudId;
//	}
//
//	public void setSolicitudId(Long solicitudId) {
//		this.solicitudId = solicitudId;
//	}
//
//	public SolicitudExtPermanencia getSolicitudExt() {
//		return solicitudExt;
//	}
//
//	public void setSolicitudExt(SolicitudExtPermanencia solicitudExt) {
//		this.solicitudExt = solicitudExt;
//	}
//
//	public SolicitudArriboSobrevuelo getSolicitudArriboSobrevuelo() {
//		return solicitudArriboSobrevuelo;
//	}
//
//	public SolicitudSessionLocal getSolicitudArsvService() {
//		return solicitudArsvService;
//	}
//
//	public void setSolicitudArsvService(SolicitudSessionLocal solicitudArsvService) {
//		this.solicitudArsvService = solicitudArsvService;
//	}
//
//	public Long getIdTask() {
//		return idTask;
//	}
//
//	public void setIdTask(Long idTask) {
//		this.idTask = idTask;
//	}
//
//	public String getMensajeResOperacion() {
//		return mensajeResOperacion;
//	}
//
//	public void setMensajeResOperacion(String mensajeResOperacion) {
//		this.mensajeResOperacion = mensajeResOperacion;
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
//	public SeguridadArsvSessionLocal getSeguridadService() {
//		return seguridadService;
//	}
//
//	public void setSeguridadService(SeguridadArsvSessionLocal seguridadService) {
//		this.seguridadService = seguridadService;
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
//	public void setSolicitudArriboSobrevuelo(
//			SolicitudArriboSobrevuelo solicitudArriboSobrevuelo) {
//		this.solicitudArriboSobrevuelo = solicitudArriboSobrevuelo;
//	}
//
//	public OperacionAntartica getOperacionAntartica() {
//		return operacionAntartica;
//	}
//
//	public void setOperacionAntartica(OperacionAntartica operacionAntartica) {
//		this.operacionAntartica = operacionAntartica;
//	}
//
//	public OperacionPascua getOperacionPascua() {
//		return operacionPascua;
//	}
//
//	public void setOperacionPascua(OperacionPascua operacionPascua) {
//		this.operacionPascua = operacionPascua;
//	}
//
//	public SolicitudOperacionAntarticaSessionLocal getAntarticaSessionLocal() {
//		return antarticaSessionLocal;
//	}
//
//	public void setAntarticaSessionLocal(
//			SolicitudOperacionAntarticaSessionLocal antarticaSessionLocal) {
//		this.antarticaSessionLocal = antarticaSessionLocal;
//	}
//
//	public SolicitudOperacionPascuaSessionLocal getOperacionPascuaSessionLocal() {
//		return operacionPascuaSessionLocal;
//	}
//
//	public void setOperacionPascuaSessionLocal(
//			SolicitudOperacionPascuaSessionLocal operacionPascuaSessionLocal) {
//		this.operacionPascuaSessionLocal = operacionPascuaSessionLocal;
//	}
//
//	public String getExtSoliUrl() {
//		return extSoliUrl;
//	}
//
//	public void setExtSoliUrl(String extSoliUrl) {
//		this.extSoliUrl = extSoliUrl;
//	}
//
//	public List<ArsvRuta> getRutaPrincipal() {
//		return rutaPrincipal;
//	}
//
//	public void setRutaPrincipal(List<ArsvRuta> rutaPrincipal) {
//		this.rutaPrincipal = rutaPrincipal;
//	}
//
//	public List<ArsvRuta> getRutaAlternativa() {
//		return rutaAlternativa;
//	}
//
//	public void setRutaAlternativa(List<ArsvRuta> rutaAlternativa) {
//		this.rutaAlternativa = rutaAlternativa;
//	}
//
//	public String getBotonesExt() {
//		return botonesExt;
//	}
//
//	public void setBotonesExt(String botonesExt) {
//		this.botonesExt = botonesExt;
//	}
//
//	public String getFieldExt() {
//		return fieldExt;
//	}
//
//	public void setFieldExt(String fieldExt) {
//		this.fieldExt = fieldExt;
//	}
//
//	public String getRenderDSO() {
//		return renderDSO;
//	}
//
//	public void setRenderDSO(String renderDSO) {
//		this.renderDSO = renderDSO;
//	}
//
//	public String getRenderBtnAprovar() {
//		return renderBtnAprovar;
//	}
//
//	public void setRenderBtnAprovar(String renderBtnAprovar) {
//		this.renderBtnAprovar = renderBtnAprovar;
//	}
//	
//	
//	
//
//	
//}
