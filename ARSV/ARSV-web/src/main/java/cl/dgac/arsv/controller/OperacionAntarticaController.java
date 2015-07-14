//package cl.dgac.arsv.controller;
//
//import java.io.ByteArrayInputStream;
//import java.io.IOException;
//import java.io.InputStream;
//import java.io.Serializable;
//import java.util.ArrayList;
//import java.util.List;
//
//import javax.activation.MimetypesFileTypeMap;
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
//import org.primefaces.event.FileUploadEvent;
//import org.primefaces.model.DefaultStreamedContent;
//import org.primefaces.model.StreamedContent;
//import org.primefaces.model.UploadedFile;
//
//import cl.dgac.arsv.exceptions.ARSVBusinessException;
//import cl.dgac.arsv.exceptions.ARSVMailException;
//import cl.dgac.arsv.handler.BrmsClientHandlerInterLocal;
//import cl.dgac.arsv.model.ArsvAsignacion;
//import cl.dgac.arsv.model.ArsvBaseOperacion;
//import cl.dgac.arsv.model.ArsvClasificacion;
//import cl.dgac.arsv.model.ArsvEquipoSupervivencia;
//import cl.dgac.arsv.model.ArsvEquipoUsar;
//import cl.dgac.arsv.model.ArsvOACI;
//import cl.dgac.arsv.model.ArsvObjetoVuelo;
//import cl.dgac.arsv.model.ArsvPaisOrigen;
//import cl.dgac.arsv.model.ArsvProgramaActividad;
//import cl.dgac.arsv.model.ArsvRuta;
//import cl.dgac.arsv.model.ArsvTipoComunicacion;
//import cl.dgac.arsv.model.ArsvTipoSolicitud;
//import cl.dgac.arsv.model.ArsvUnidad;
//import cl.dgac.arsv.model.ArsvUnidadPeso;
//import cl.dgac.arsv.model.ArsvUsuario;
//import cl.dgac.arsv.model.DocumentoAdjunto;
//import cl.dgac.arsv.model.OperacionAntartica;
//import cl.dgac.arsv.service.ClienteSACSessionLocal;
//import cl.dgac.arsv.service.ResponderArsvSessionLocal;
//import cl.dgac.arsv.service.SeguridadArsvSessionLocal;
//import cl.dgac.arsv.service.SolicitudOperacionAntarticaSessionLocal;
//import cl.dgac.arsv.util.AeronaveARSV;
//import cl.dgac.arsv.util.MessageFactory;
//import cl.dgac.arsv.util.OACIARSV;
//import cl.dgac.arsv.util.OperadorARSV;
//
//@Named("operacionAntarticaController")
//@ViewScoped
//public class OperacionAntarticaController implements Serializable {
//
//
//	/**
//	 * 
//	 */
//	private static final long serialVersionUID = 6452298355072339229L;
//
//	public static final Logger log = Logger.getLogger(OperacionAntarticaController.class);
//	
//	/****************************************************************___________INJECT___________****************************************************************/
//	
//	@Inject
//	private FacesContext facesContext;  
//	
//    @Inject
//    private ClienteSACSessionLocal clienteSACSession;
//	
//	@Inject
//	private BrmsClientHandlerInterLocal brmsClientHandlerInter;
//	
//	@Inject
//	private SolicitudOperacionAntarticaSessionLocal antarticaSessionLocal;
//	
//	@Inject
//	private ResponderArsvSessionLocal responderService;
//	
//	@Inject
//	private SeguridadArsvSessionLocal seguridadService;
//	
//
//	
//	
//	/****************************************************************___________VARIABLES___________****************************************************************/
//	
//	private String tipoSolicitud = "ARRIBOANTARTICA";
//	
//	/**
//	* El idTask de la tarea que se va a actualizar
//	*/
//	private Long idTask;
//	
//	private Long solicitudId;
//	
//	private List<ArsvAsignacion> listaAsignacion;
//	
//	private List<String> listaAsignacionSeleccionada;
//	
//    private OperacionAntartica nuevaSolicitudAntartica;
//    
//	private OperacionAntartica solicitudOperacion;
//    
//    private String mensajeResOperacion;
//
//	private boolean verRespuesta = false;
//
//	private List<ArsvUnidad> lstArsv;
//
//	private Long idOperacionAntartica;	
//	
//	private List<String> unidadesArsvSeleccionadas;
//	
//	private String pronunciamiento;
//	
//	private List<OperadorARSV> operadoresARSV;
//	
//	private List<AeronaveARSV> aeronavesARSV;
//	
//	private List<OACIARSV> oACIsARSV;
//	
//	private ArsvRuta nuevaRuta;
//	
//	private ArsvPaisOrigen paisOrigen;
//	
//	private ArsvPaisOrigen paisOrigenEmision;
//	
//	private ArsvPaisOrigen paisOrigenPiloto;
//	
//	private ArsvProgramaActividad nuevoPrograma;
//	
//	private ArsvEquipoUsar nuevoEquipo;
//	
//	private AeronaveARSV aeronaveARSV;
//	
//	private OperadorARSV operadorARSV;
//	
//	private String token;
//	
//	private ArsvUsuario usr;
//	
//	private String usuario;
//	
//	private String pass;
//	
//	private List<ArsvOACI> oacis = null;
//	
//	private DocumentoAdjunto nuevoDocumentoAdjunto;
//	
//	private List<DocumentoAdjunto> documentosNuevos;
//	
//	private StreamedContent downloadFile;
//	
//	private String renderBtnAprovar = "true";
//	
//	
//	/****************************************************************___________METODOS_________****************************************************************/
// 	
//    @Produces   
//    @Named
//    public OperacionAntartica getNuevaSolicitudAntartica() {
//    	return nuevaSolicitudAntartica;
//    }
//    
//    public List<ArsvOACI> getOacis() {
//		return oacis;
//	}
//
//	public void setOacis(List<ArsvOACI> oacis) {
//		this.oacis = oacis;
//	}
//
//	@PostConstruct
//    public void initNuevaSolicitud() {	   
//    	nuevaSolicitudAntartica = new OperacionAntartica();
//    	nuevaRuta = new ArsvRuta();
//    	nuevoEquipo = new ArsvEquipoUsar();
//    	nuevoPrograma = new ArsvProgramaActividad();
//    	nuevoDocumentoAdjunto = new DocumentoAdjunto();
//    	documentosNuevos = null;
//    	renderBtnAprovar = "true";
//    	this.aeronaveARSV = new AeronaveARSV();
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
//				usuario = usr.getUsuaUser();
//				pass = usr.getUsuaClaveUser();
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
//	public void obtenerSolicitud() {
//		log.info("---->metodo obtener solicitud");
//		try {
//			solicitudOperacion = antarticaSessionLocal.seleccionarSolicitud(idOperacionAntartica);
//			this.solicitudOperacion.setAeronave(clienteSACSession.buscarAeronavesSAC(solicitudOperacion.getSacAeronave()));
//			
//			if(documentosNuevos == null){
//				documentosNuevos =  solicitudOperacion.getDocumentosAdjuntos();
//				
//				if(null == documentosNuevos){
//					documentosNuevos = new ArrayList<DocumentoAdjunto>();
//				}
//			}
//			
//			if (null == solicitudOperacion) {
//				log.info("Solicitud id en null");
//				facesContext.addMessage(null,new FacesMessage(FacesMessage.SEVERITY_ERROR,"Solicitud Antartica:",MessageFactory.getMessage("{solicitud.inexistente}")));
//			}
//		} catch (ARSVBusinessException e) {
//			facesContext.addMessage(null,new FacesMessage(FacesMessage.SEVERITY_ERROR,"Solicitud Antartica:",e.getMessage()));
//		}
//	}
//	
//	public String tomarConocimientoAprobado() {
//		log.info("metodo para aprobar");
//		try {
//			
//			//carga el usuario y pass del usuario conectado
//			initBrmsClientUser();
//			
//			antarticaSessionLocal.tomarConocimiento(solicitudOperacion,idTask,usuario,pass);
//			
//			RequestContext.getCurrentInstance().addCallbackParam("showDialog",true);
//			this.setMensajeResOperacion(MessageFactory.getMessage("{solicitud.cerrar.correcto}"));
//			
//		} catch (ARSVBusinessException e) {
//			log.error("Error tratando de cerrar la solicitud", e);
//		}
//
//		return null;
//	}
//	
//	public void completarAntecOperador() {		
//		try{
//			String solicitudIdParam = FacesContext.getCurrentInstance()
//					.getExternalContext().getRequestParameterMap()
//					.get("solicitudId");
//			try {
//				if(null != solicitudIdParam){
//					this.setSolicitudId(Long.valueOf(solicitudIdParam));				
//					solicitudOperacion = antarticaSessionLocal.seleccionarSolicitud(Long.valueOf(solicitudIdParam));
//				} else if (null != solicitudId){
//					solicitudOperacion = antarticaSessionLocal.seleccionarSolicitud(Long.valueOf(solicitudId));	
//				}	
//				
//				if(documentosNuevos == null){
//					documentosNuevos =  solicitudOperacion.getDocumentosAdjuntos();
//					
//					if(null == documentosNuevos){
//						documentosNuevos = new ArrayList<DocumentoAdjunto>();
//					}
//				}
//	
//				if (null == solicitudOperacion) {
//					throw new ARSVBusinessException("La solicitud es inaceptable");
//				}
//			} catch (ARSVBusinessException e) {
//				facesContext.addMessage(null,new FacesMessage(FacesMessage.SEVERITY_ERROR,
//								"Solicitud:", e.getMessage()));
//			}
//		
//			if(solicitudId!=null)
//				idTask = brmsClientHandlerInter.buscarTareaOperador(solicitudId.toString());
//		} catch (ARSVBusinessException e) {
//			facesContext.addMessage(null,new FacesMessage(FacesMessage.SEVERITY_ERROR,
//							"Solicitud:", e.getMessage()));
//		}
//	}
//	
//	public void completarPronunciamiento() {		
//		try{
//			String solicitudIdParam = FacesContext.getCurrentInstance()
//					.getExternalContext().getRequestParameterMap()
//					.get("solicitudId");
//			try {
//				if(null != solicitudIdParam){
//					this.setSolicitudId(Long.valueOf(solicitudIdParam));				
//					solicitudOperacion = antarticaSessionLocal.seleccionarSolicitud(Long.valueOf(solicitudIdParam));
//				} else if (null != solicitudId){
//					solicitudOperacion = antarticaSessionLocal.seleccionarSolicitud(Long.valueOf(solicitudId));	
//				}	
//				
//				if(documentosNuevos == null){
//					documentosNuevos =  solicitudOperacion.getDocumentosAdjuntos();
//					
//					if(null == documentosNuevos){
//						documentosNuevos = new ArrayList<DocumentoAdjunto>();
//					}
//				}
//	
//				if (null == solicitudOperacion) {
//					throw new ARSVBusinessException("La solicitud es inaceptable");
//				}
//			} catch (ARSVBusinessException e) {
//				facesContext.addMessage(null,new FacesMessage(FacesMessage.SEVERITY_ERROR,
//								"Solicitud:", e.getMessage()));
//			}
//			
//			if(solicitudId!=null)
//				idTask = brmsClientHandlerInter.buscarTareaOperador(solicitudId.toString());
//		} catch (ARSVBusinessException e) {
//			facesContext.addMessage(null,new FacesMessage(FacesMessage.SEVERITY_ERROR,
//							"Solicitud:", e.getMessage()));
//		}
//	}
//    
//    public void register() {    	
//    	log.debug("Registrando nueva solicitud..");
//    	try {		
//    		if(null!=nuevaSolicitudAntartica.getArsvEquipoUsar()){
//    			for(ArsvEquipoUsar equipo : nuevaSolicitudAntartica.getArsvEquipoUsar()){
//    				equipo.setId(null);
//    				equipo.setSolicitudOperacion(nuevaSolicitudAntartica);
//    			}
//    		}
//    		if(null!=nuevaSolicitudAntartica.getArsvProgramaActividad()){
//    			for(ArsvProgramaActividad programa : nuevaSolicitudAntartica.getArsvProgramaActividad()){
//    				programa.setId(null);
//    				programa.setSolicitudOperacion(nuevaSolicitudAntartica);
//    			}
//    		}
//    		
//    		if(nuevaSolicitudAntartica.getDocumentosAdjuntos()!=null){
//    			for(DocumentoAdjunto documento : nuevaSolicitudAntartica.getDocumentosAdjuntos()){
//    				documento.setIdDocumento(null);
//    				documento.setSolicitud(nuevaSolicitudAntartica);
//    			}
//    		}
//
//    		Long solicitudIdNueva = antarticaSessionLocal.ingresarSolicitudOperAnt(nuevaSolicitudAntartica, tipoSolicitud);	
//    		facesContext.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Solicitud usuario:", MessageFactory
//  				.getMessage("{solicitud.nuevaSolicitud}", new Object[] {solicitudIdNueva})));
//    	} catch(ARSVMailException me){
//  			facesContext.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN, "Solicitud usuario:", me.getMessage()));	
//    	//} catch(BRMSClientException br){
//    	//	facesContext.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Solicitud usuario:", br.getMessage()));
//  		} catch (ARSVBusinessException e) {
//  			facesContext.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Solicitud usuario:", e.getMessage()));
//  		}
//        initNuevaSolicitud();
//    }
//    
//	public String obtenerRespuestas() {
//		try {
//			if (solicitudOperacion == null) {
//
//				solicitudOperacion = antarticaSessionLocal
//						.seleccionarSolicitud(idOperacionAntartica);
//			}
//		} catch (ARSVBusinessException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//
//		return "";
//	}
//	
//	public String verificarAntecedentesSolicitados(){
//		if(solicitudOperacion.getAntecedentesSolicitados()!=null){
//			return "true";
//		}
//		else{
//			return "false";
//		}
//	}
//    
//	public void enviarCompletarAntecedentes() throws Exception {
//		boolean enviar=true;
//		if (null == solicitudOperacion.getDetalleSolicitud()  || solicitudOperacion.getDetalleSolicitud().isEmpty()){
//			facesContext.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Completar Antecedentes:", 
//					MessageFactory.getMessage("{solicitud.antecedentes.noInfomada}")));
//			enviar=false;
//		}
//		if (enviar){
//			try {
//				if(solicitudOperacion.getDocumentosAdjuntos()!=null || solicitudOperacion.getDocumentosAdjuntos().size()==0){
//					antarticaSessionLocal.docDelete(solicitudOperacion);
//	    			for(DocumentoAdjunto documento : documentosNuevos){
//	    				documento.setIdDocumento(null);
//	    				documento.setSolicitud(solicitudOperacion);
//	    			}
//	    			
//	    			solicitudOperacion.setDocumentosAdjuntos(documentosNuevos);
//	    		}
//				
//				responderService.responderComplAntecentes(solicitudOperacion);
//				idTask = brmsClientHandlerInter.buscarTareaOperador(solicitudId.toString());
//				brmsClientHandlerInter.completarMasAntecedentes(idTask, solicitudOperacion);
//
//				renderBtnAprovar = "false";
//				
//				facesContext.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Completar Antecedentes:","Antecedentes enviados"));
//			} catch (Exception e) {
//				facesContext.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Completar Antecedentes:", 
//						e.getMessage()));
//				RequestContext.getCurrentInstance().addCallbackParam("showDialog", false);
//			}
//		}
//		else {
//			RequestContext.getCurrentInstance().addCallbackParam("showDialog", false);	
//		}		
//	}
//	
//	public void enviarPronunciamientoFACH() throws Exception {
//		boolean enviar=true;
//		if (null == pronunciamiento  || pronunciamiento.isEmpty()){
//			facesContext.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Pronunciamiento FACH:", 
//					MessageFactory.getMessage("{solicitud.antecedentes.noInfomada}")));
//			enviar=false;
//		}
//		if (enviar){
//			try {
//				if(solicitudOperacion.getDocumentosAdjuntos()!=null || solicitudOperacion.getDocumentosAdjuntos().size()==0){
//					antarticaSessionLocal.docDelete(solicitudOperacion);
//	    			for(DocumentoAdjunto documento : documentosNuevos){
//	    				documento.setIdDocumento(null);
//	    				documento.setSolicitud(solicitudOperacion);
//	    			}
//	    			
//	    			solicitudOperacion.setDocumentosAdjuntos(documentosNuevos);
//	    		}
//				
//				responderService.enviarPronunciamientoFACH(solicitudOperacion, pronunciamiento);
//				idTask = brmsClientHandlerInter.buscarTareaOperador(solicitudId.toString());
//				brmsClientHandlerInter.enviarPronunciamiento(idTask, solicitudOperacion);
//				renderBtnAprovar = "false";
//				
//				facesContext.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Pronunciamiento:","enviado"));
//				
//			} catch (Exception e) {
//				facesContext.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Pronunciamiento FACH:", 
//						e.getMessage()));
//				RequestContext.getCurrentInstance().addCallbackParam("showDialog", false);
//			}
//		}
//		else {
//			RequestContext.getCurrentInstance().addCallbackParam("showDialog", false);	
//		}		
//	}
//	
//	public void enviarPronunciamientoJAC() throws Exception {
//		boolean enviar=true;
//		if (null == pronunciamiento  || pronunciamiento.isEmpty()){
//			facesContext.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Pronunciamiento JAC:", 
//					MessageFactory.getMessage("{solicitud.antecedentes.noInfomada}")));
//			enviar=false;
//		}
//		if (enviar){
//			try {
//				if(solicitudOperacion.getDocumentosAdjuntos()!=null || solicitudOperacion.getDocumentosAdjuntos().size()==0){
//					antarticaSessionLocal.docDelete(solicitudOperacion);
//	    			for(DocumentoAdjunto documento : documentosNuevos){
//	    				documento.setIdDocumento(null);
//	    				documento.setSolicitud(solicitudOperacion);
//	    			}
//	    			
//	    			solicitudOperacion.setDocumentosAdjuntos(documentosNuevos);
//	    		}
//				
//				responderService.enviarPronunciamientoJAC(solicitudOperacion, pronunciamiento);
//				idTask = brmsClientHandlerInter.buscarTareaOperador(solicitudId.toString());
//				brmsClientHandlerInter.enviarPronunciamiento(idTask, solicitudOperacion);
//
//				renderBtnAprovar = "false";
//				
//				facesContext.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Pronunciamiento:","enviado"));
//			} catch (Exception e) {
//				facesContext.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Pronunciamiento JAC:", 
//						e.getMessage()));
//				RequestContext.getCurrentInstance().addCallbackParam("showDialog", false);
//			}
//		}
//		else {
//			RequestContext.getCurrentInstance().addCallbackParam("showDialog", false);	
//		}		
//	}
//	
//	public void enviarPronunciamientoINACH() throws Exception {
//		boolean enviar=true;
//		if (null == pronunciamiento  || pronunciamiento.isEmpty()){
//			facesContext.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Pronunciamiento INACH:", 
//					MessageFactory.getMessage("{solicitud.antecedentes.noInfomada}")));
//			enviar=false;
//		}
//		if (enviar){
//			try {
//				if(solicitudOperacion.getDocumentosAdjuntos()!=null || solicitudOperacion.getDocumentosAdjuntos().size()==0){
//					antarticaSessionLocal.docDelete(solicitudOperacion);
//	    			for(DocumentoAdjunto documento : documentosNuevos){
//	    				documento.setIdDocumento(null);
//	    				documento.setSolicitud(solicitudOperacion);
//	    			}
//	    			
//	    			solicitudOperacion.setDocumentosAdjuntos(documentosNuevos);
//	    		}
//				
//				responderService.enviarPronunciamientoINACH(solicitudOperacion, pronunciamiento);
//				idTask = brmsClientHandlerInter.buscarTareaOperador(solicitudId.toString());
//				brmsClientHandlerInter.enviarPronunciamiento(idTask, solicitudOperacion);
//				renderBtnAprovar = "false";
//				
//				facesContext.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Pronunciamiento:","enviado"));
//			} catch (Exception e) {
//				facesContext.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Pronunciamiento INACH:", 
//						e.getMessage()));
//				RequestContext.getCurrentInstance().addCallbackParam("showDialog", false);
//			}
//		}
//		else {
//			RequestContext.getCurrentInstance().addCallbackParam("showDialog", false);	
//		}		
//	}
//	
//	public void asignarArsvAroAmb() {
//		boolean asignar = true;
//		if (asignar) {
//			try {
//				
//				if (null == solicitudOperacion) {
//					solicitudOperacion = antarticaSessionLocal.seleccionarSolicitud(idOperacionAntartica);
//				}
//				
//				if(solicitudOperacion.getDocumentosAdjuntos()!=null || solicitudOperacion.getDocumentosAdjuntos().size()==0){
//					antarticaSessionLocal.docDelete(solicitudOperacion);
//	    			for(DocumentoAdjunto documento : documentosNuevos){
//	    				documento.setIdDocumento(null);
//	    				documento.setSolicitud(solicitudOperacion);
//	    			}
//	    			
//	    			solicitudOperacion.setDocumentosAdjuntos(documentosNuevos);
//	    		}
//				
//				//carga el usuario y pass del usuario conectado
//				initBrmsClientUser();
//				
//				log.info("Invoca a: solicitarPronunciamiento");
//				antarticaSessionLocal.solicitarPronunciamiento(solicitudOperacion, idTask,usuario,pass);
//
//				log.info("solicitarPronunciamiento: ok");
//				 
//				RequestContext.getCurrentInstance().addCallbackParam(
//						"showDialog", true);
//			} catch (ARSVMailException me){	
//				facesContext.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN, "no se ha logrado notificar", me.getMessage()));
//			} catch (ARSVBusinessException e) {
//				facesContext.addMessage(null,
//						new FacesMessage(FacesMessage.SEVERITY_ERROR,
//								"Asignar Arsv:", e.getMessage()));
//				RequestContext.getCurrentInstance().addCallbackParam(
//						"showDialog", false);
//			}
//		} else {
//			RequestContext.getCurrentInstance().addCallbackParam("showDialog",
//					false);
//		}
//	}
//	
//	public List<String> getNombreSelUnidades() {
//		List<String> lstSelecArsv = null;
//		if (null != unidadesArsvSeleccionadas
//				&& unidadesArsvSeleccionadas.size() > 0) {
//			lstSelecArsv = new ArrayList<String>();
//			for (String seleccionada : unidadesArsvSeleccionadas) {
//				for (ArsvUnidad uni : lstArsv) {
//					if (uni.getId().toString().equals(seleccionada)) {
//						lstSelecArsv.add(uni.getNombre());
//						break;
//					}
//				}
//			}
//		}
//		return lstSelecArsv;
//	}
//	
//	public String metodoRespuestaAction() {
//		verRespuesta = true;
//
//		try {
//			if (idOperacionAntartica != null)
//				solicitudOperacion = antarticaSessionLocal.seleccionarSolicitud(idOperacionAntartica);
//		} catch (ARSVBusinessException e2) {
//			e2.printStackTrace();
//		}
//
//		try {
//			if ((listaAsignacion != null && listaAsignacion.size() != 0))
//				return "verRespuesta?faces-redirect=true&includeViewParams=true";
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
//
//		return null;
//	}
//	
//	public void aprobarSolicitudAroAMB() {
//		try {
//			if(solicitudOperacion.getDocumentosAdjuntos()!=null || solicitudOperacion.getDocumentosAdjuntos().size()==0){
//				antarticaSessionLocal.docDelete(solicitudOperacion);
//    			for(DocumentoAdjunto documento : documentosNuevos){
//    				documento.setIdDocumento(null);
//    				documento.setSolicitud(solicitudOperacion);
//    			}
//    			
//    			solicitudOperacion.setDocumentosAdjuntos(documentosNuevos);
//    		}
//			//carga el usuario y pass del usuario conectado
//			initBrmsClientUser();
//			
//			antarticaSessionLocal.aprobarSolicitudAroAMB(solicitudOperacion, idTask, usuario, pass);
//			
//			RequestContext.getCurrentInstance().addCallbackParam("showDialog",true);
//			this.setMensajeResOperacion(MessageFactory.getMessage("{solicitud.cerrar.correcto}"));
//		} catch (ARSVMailException me){
//			facesContext.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN, "se ha rechazado solicitud, pero no se ha enviado notificacion", me.getMessage()));
//		} catch (ARSVBusinessException e) {
//			log.error("Error tratando de cerrar la solicitud", e);
//		}
//	}
//
//	public void cerrarSolicitudAroAMB() {
//		try {
//			
//			//carga el usuario y pass del usuario conectado
//			initBrmsClientUser();
//			
//			antarticaSessionLocal.cerrarSolicitud(solicitudOperacion, idTask, usuario, pass);
//			
//			RequestContext.getCurrentInstance().addCallbackParam("showDialog",true);
//			this.setMensajeResOperacion(MessageFactory.getMessage("{solicitud.cerrar.correcto}"));
//		} catch (ARSVMailException me){
//			facesContext.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN, "se ha rechazado solicitud, pero no se ha enviado notificacion", me.getMessage()));
//		} catch (ARSVBusinessException e) {
//			log.error("Error tratando de cerrar la solicitud", e);
//		}
//	}
//	
//	public void cargarOperadorAeronave() {
//
//		String matriculaAeronave = this.nuevaSolicitudAntartica.getSacAeronave();
//		if(matriculaAeronave!=null ){
//			try {
//				this.nuevaSolicitudAntartica.setAeronave(clienteSACSession.buscarAeronavesSAC(matriculaAeronave));
//			} catch (ARSVBusinessException e) {
//				e.printStackTrace();
//			}
//		
//		}
//		
//	}
//	
//	public void cargarOACI() {
////		Long id = (Long)event.getComponent().getAttributes().get("value");
//		Long id = this.nuevaSolicitudAntartica.getPaisOrigen().getId();
//		if(id!=null ){
//			this.oacis = antarticaSessionLocal.getArsvOACI(id);
//			id = null;
//		}
//	}
//	
//	public void eliminarRuta(Long id) {
//		log.info("----- eliminarDetalle -----");
//
//		List<ArsvRuta> rutas = new ArrayList<ArsvRuta>(this.nuevaSolicitudAntartica.getArsvRutas());
//
//		for (ArsvRuta ruta : rutas) {
//			if (ruta.getId().equals(id)) {
//				this.nuevaSolicitudAntartica.getArsvRutas().remove(ruta);
//				break;
//			}
//		}
//	}
//	
//	public void agregarRuta() {
//		log.info("----- agregarRuta -----");
//		
//		// Se incorpora id temporal, en caso de querer eliminar
//		nuevaRuta.setId((long) (Math.random() * 1000));
//
//		nuevaRuta.setSolicitud(nuevaSolicitudAntartica);
//
//		List<ArsvRuta> detalles = nuevaSolicitudAntartica.getArsvRutas();
//
//		if (null == detalles) {
//			detalles = new ArrayList<ArsvRuta>();
//		}
//		detalles.add(nuevaRuta);
//		nuevaSolicitudAntartica.setArsvRutas(detalles);
//
//		nuevaRuta = new ArsvRuta();
//	}
//	
//	public void eliminarActividad(Long id) {
//		log.info("----- eliminarActividad -----");
//
//		List<ArsvProgramaActividad> programas = new ArrayList<ArsvProgramaActividad>(this.nuevaSolicitudAntartica.getArsvProgramaActividad());
//
//		for (ArsvProgramaActividad programa : programas) {
//			if (programa.getId().equals(id)) {
//				this.nuevaSolicitudAntartica.getArsvProgramaActividad().remove(programa);
//				break;
//			}
//		}
//	}
//	
//	public void agregarActividad() {
//		log.info("----- agregarActividad -----");
//		
//		if(!nuevoPrograma.getDescripcion().equals("")){
//			// Se incorpora id temporal, en caso de querer eliminar
//			nuevoPrograma.setId((long) (Math.random() * 1000));
//
//			nuevoPrograma.setSolicitudOperacion(nuevaSolicitudAntartica);
//
//			List<ArsvProgramaActividad> detalles = nuevaSolicitudAntartica.getArsvProgramaActividad();
//
//			if (null == detalles) {
//				detalles = new ArrayList<ArsvProgramaActividad>();
//			}
//			
//			
//			
//			detalles.add(nuevoPrograma);
//			nuevaSolicitudAntartica.setArsvProgramaActividad(detalles);
//
//			nuevoPrograma = new ArsvProgramaActividad();
//		}
//		
//		
//	}
//	
//	public void eliminarEquipo(Long id) {
//		log.info("----- eliminarEquipo -----");
//
//		List<ArsvEquipoUsar> equipos = new ArrayList<ArsvEquipoUsar>(this.nuevaSolicitudAntartica.getArsvEquipoUsar());
//
//		for (ArsvEquipoUsar equipo : equipos) {
//			if (equipo.getId().equals(id)) {
//				this.nuevaSolicitudAntartica.getArsvEquipoUsar().remove(equipo);
//				break;
//			}
//		}
//		
//	}
//	
//	public void agregarEquipo() {
//		log.info("----- agregarEquipo -----");
//		
//		// Se incorpora id temporal, en caso de querer eliminar
//		nuevoEquipo.setId((long) (Math.random() * 1000));
//
//		nuevoEquipo.setSolicitudOperacion(nuevaSolicitudAntartica);
//
//		List<ArsvEquipoUsar> detalles = nuevaSolicitudAntartica.getArsvEquipoUsar();
//
//		if (null == detalles) {
//			detalles = new ArrayList<ArsvEquipoUsar>();
//		}
//		detalles.add(nuevoEquipo);
//		nuevaSolicitudAntartica.setArsvEquipoUsar(detalles);
//
//		nuevoEquipo = new ArsvEquipoUsar();
//		
//		
//	}
//	
//	/*
//	 * TODO Metodo utilizado para cargar los archivos adjuntos
//	 */
//	public void handleFileUpload(FileUploadEvent event){
//		log.info("cargando adjunto");
//		
//		UploadedFile file = event.getFile();
//		
//		
//		nuevoDocumentoAdjunto.setIdDocumento((long) (Math.random() * 1000));
//		nuevoDocumentoAdjunto.setSolicitud(nuevaSolicitudAntartica);
//		nuevoDocumentoAdjunto.setDescripcionDocumento(file.getFileName());
//		nuevoDocumentoAdjunto.setDocumento(file.getContents());
//		
//		MimetypesFileTypeMap mimeTypeMap = new MimetypesFileTypeMap();
//		
//		String mimeType = mimeTypeMap.getContentType(file.getFileName());
//		
//		nuevoDocumentoAdjunto.setMimeType(mimeType);
//		
//		List<DocumentoAdjunto> detalles = nuevaSolicitudAntartica.getDocumentosAdjuntos();
//
//		if (null == detalles) {
//			detalles = new ArrayList<DocumentoAdjunto>();
//		}
//		detalles.add(nuevoDocumentoAdjunto);
//		nuevaSolicitudAntartica.setDocumentosAdjuntos(detalles);
//
//		nuevoDocumentoAdjunto = new DocumentoAdjunto();
//	}
//	
//	/**
//	 *  Metodo utilizado para cargar los archivos adjuntos desde formularios de bandeja
//	 */
//	public void handleFileUploadAtender(FileUploadEvent event){
//		log.info("cargando adjunto");
//		
//		UploadedFile file = event.getFile();
//		
//		nuevoDocumentoAdjunto.setIdDocumento((long) (Math.random() * 1000));
//		nuevoDocumentoAdjunto.setSolicitud(solicitudOperacion);
//		nuevoDocumentoAdjunto.setDescripcionDocumento(file.getFileName());
//		nuevoDocumentoAdjunto.setDocumento(file.getContents());
//		
//		MimetypesFileTypeMap mimeTypeMap = new MimetypesFileTypeMap();
//		
//		String mimeType = mimeTypeMap.getContentType(file.getFileName());
//		
//		nuevoDocumentoAdjunto.setMimeType(mimeType);
//		
//		documentosNuevos.add(nuevoDocumentoAdjunto);
//
//		nuevoDocumentoAdjunto = new DocumentoAdjunto();
//		
//	}
//	
//	/*
//	 * TODO metodo para eliminar adjunto
//	 */
//	public void eliminarAdjunto(Long id) {
//		log.info("----- eliminarAdjunto -----");
//		
//
//			
//		List<DocumentoAdjunto> documentos = new ArrayList<DocumentoAdjunto>(this.nuevaSolicitudAntartica.getDocumentosAdjuntos());
//
//		for (DocumentoAdjunto documento : documentos) {
//			if (documento.getIdDocumento().equals(id)) {
//				this.nuevaSolicitudAntartica.getDocumentosAdjuntos().remove(documento);
//				break;
//			}
//		}					
//	}
//	
//	/**
//	 * metodo para eliminar adjunto desde formularios de bandeja
//	 */
//	public void eliminarAdjuntoAtender(Long id) {
//		log.info("----- eliminarAdjunto -----");
//
//		for (DocumentoAdjunto documento : documentosNuevos) {
//			if (documento.getIdDocumento().equals(id)) {
//				this.documentosNuevos.remove(documento);
//				break;
//			}
//		}					
//	}
//	
//	/*
//	 * TODO metodo para descargar archivo adjunto
//	 */
//	public String obtenerArchivo(Long id) {
//		
//
//			
//		List<DocumentoAdjunto> documentos = new ArrayList<DocumentoAdjunto>(this.nuevaSolicitudAntartica.getDocumentosAdjuntos());
//			
//		for (DocumentoAdjunto documento : documentos) {
//			if (documento.getIdDocumento().equals(id)) {;
//				byte[] bytes = documento.getDocumento();
//				InputStream is = new ByteArrayInputStream(bytes);
//				downloadFile = new DefaultStreamedContent(is,documento.getMimeType(),documento.getDescripcionDocumento());
//			}
//		}	
//		
//		return null;	
//	}
//	
//	/**
//	 * metodo para descargar archivo adjunto desde formularios de bandeja
//	 */
//	public String obtenerArchivoAtender(Long id) {
//		
//		for (DocumentoAdjunto documento : documentosNuevos) {
//			if (documento.getIdDocumento().equals(id)) {;
//				byte[] bytes = documento.getDocumento();
//				InputStream is = new ByteArrayInputStream(bytes);
//				downloadFile = new DefaultStreamedContent(is,documento.getMimeType(),documento.getDescripcionDocumento());
//			}
//		}	
//		
//		return null;	
//	}
//	
//	public StreamedContent getDownloadFile() {
//        return downloadFile;
//    }
//	
//    public void setDownloadFile(StreamedContent downloadFile) {
//	   this.downloadFile = downloadFile;
//    }
//	
//	public void enviarMasAntecedentes(){
//		boolean enviar=true;
//		if (null == solicitudOperacion.getAntecedentesSolicitados() || solicitudOperacion.getAntecedentesSolicitados().isEmpty()){
//			facesContext.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Solicitud Antecedentes AROAMB:", 
//					MessageFactory.getMessage("{solicitud.solicitarAntecedentes.vacio}")));
//			enviar = false;			
//		} 
//		if (enviar) {
//			try {
//				if(solicitudOperacion.getDocumentosAdjuntos()!=null || solicitudOperacion.getDocumentosAdjuntos().size()==0){
//					antarticaSessionLocal.docDelete(solicitudOperacion);
//	    			for(DocumentoAdjunto documento : documentosNuevos){
//	    				documento.setIdDocumento(null);
//	    				documento.setSolicitud(solicitudOperacion);
//	    			}
//	    			
//	    			solicitudOperacion.setDocumentosAdjuntos(documentosNuevos);
//	    		}
//				
//				//carga el usuario y pass del usuario conectado
//				initBrmsClientUser();
//				
//				antarticaSessionLocal.solicitarCentralAntecentes(solicitudOperacion,idTask,usuario,pass);	
//							
//				
//				renderBtnAprovar = "false";
//				facesContext.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Usuario: ","Se ha enviado la solicitud de antecedentes"));
//			} catch (ARSVMailException me){
//				facesContext.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN, "No se ha logrado enviar la notificacion", me.getMessage()));
//			} catch (ARSVBusinessException e) {
//				facesContext.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Solicitud antecedentes: ", e.getMessage()));
//				RequestContext.getCurrentInstance().addCallbackParam("showDialog", false);
//			}		
//		} else { 
//			RequestContext.getCurrentInstance().addCallbackParam("showDialog", false);			
//		}	
//	}
//	
//	public void enviarAPronunciamiento(){
//		boolean enviar=true;
//		if (enviar) {
//			try {
//				
//				//carga el usuario y pass del usuario conectado
//				initBrmsClientUser();
//			
//				antarticaSessionLocal.solicitarPronunciamiento(solicitudOperacion,idTask,usuario,pass);	
//							
//				
//				RequestContext.getCurrentInstance().addCallbackParam("showDialog", true);
//				this.setMensajeResOperacion(MessageFactory.getMessage("{solicitud.enviar.resultado.ok}"));
//			} catch (ARSVMailException me){
//				facesContext.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN, "No se ha logrado enviar la notificacion", me.getMessage()));
//			} catch (ARSVBusinessException e) {
//				facesContext.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Solicitud antecedentes: ", e.getMessage()));
//				RequestContext.getCurrentInstance().addCallbackParam("showDialog", false);
//			}		
//		} else { 
//			RequestContext.getCurrentInstance().addCallbackParam("showDialog", false);			
//		}	
//	}
//	
//	public void guardarCompletarAntecedentes() throws Exception {	
//		boolean guardar=true;
//		if (null == solicitudOperacion.getDetalleSolicitud()  || solicitudOperacion.getDetalleSolicitud().isEmpty()){
//			facesContext.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Completar Antecedentes:", 
//					MessageFactory.getMessage("{solicitud.antecedentes.noInfomada}")));
//			guardar = false;
//		}
//		if(guardar){
//			try {
//				responderService.responderComplAntecentes(solicitudOperacion);
//				RequestContext.getCurrentInstance().addCallbackParam("showDialog", true);
//				this.setMensajeResOperacion(MessageFactory.getMessage("{solicitud.antecedentes.guardar.resultado.ok}"));
//			} catch (Exception e) {
//				facesContext.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Completar Antecedentes:", 
//						e.getMessage()));
//				RequestContext.getCurrentInstance().addCallbackParam("showDialog", false);
//			}
//		} else { 
//			RequestContext.getCurrentInstance().addCallbackParam("showDialog", false);			
//		}		
//	}
//	
//	/****************************************************************___________LIST_CAMPOS_LISTAS___________****************************************************************/
//    
//    public List<ArsvObjetoVuelo> getArsvObjetoVuelo() {
// 	   return antarticaSessionLocal.getArsvObjetoVuelo();
//    }
//    
//    public List<ArsvPaisOrigen> getArsvPaisesOrigen() {
// 	   return antarticaSessionLocal.getArsvPaisesOrigen();
//    }
//    
//    public List<ArsvClasificacion> getArsvClasificaciones() {
// 	   return antarticaSessionLocal.getArsvClasificaciones();
//    }
//    
////    public List<AeronaveARSV> getAeronaveARSV(){
////    	try {
////			return clienteSACSession.buscarAeronavesSAC();
////		} catch (ARSVBusinessException e) {
////			return null;
////		}    			
////    }
//    
//    public List<OperadorARSV> getOperadoresARSV(){
//    	return this.operadoresARSV; 			
//    }
//    
//    public List<AeronaveARSV> getAeronavesARSV(){
//    	return this.aeronavesARSV; 			
//    }
//    
//    public List<OACIARSV> getOACIsARSV(){
//    	return this.oACIsARSV; 			
//    }
//    
//    public List<ArsvUnidadPeso> getArsvUnidadPeso() {
//    	   return antarticaSessionLocal.getArsvUnidadPeso();
//    }
//
//    
//    public List<ArsvBaseOperacion> getArsvBaseOperaciones(){
//    	return antarticaSessionLocal.getArsvBaseOperaciones(); 			
//    }
//    
//    public List<ArsvTipoComunicacion> getArsvTipoComunicaciones(){
//    	return antarticaSessionLocal.getArsvTipoComunicaciones(); 			
//    }
//    
//    public List<ArsvEquipoSupervivencia> getArsvEquiposSupervivencias(){
//    	return antarticaSessionLocal.getArsvEquiposSupervivencia(); 			
//    } 
//    
//    
//    /****************************************************************___________REDIRECCIONES___________****************************************************************/
//
//	public String irSolicitudMasAntecedente(){
//			log.info("Redireccion a: solicitarMasAntecedentesAntartica");
//		
//		return "solicitarMasAntecedentesAntartica?faces-redirect=true&includeViewParams=true";
//	}
//    
//    /****************************************************************___________GETTERS_&_SETTERS___________****************************************************************/
//    
//	public List<ArsvUnidad> getArsvUnidad() {
//		lstArsv = antarticaSessionLocal.getArsvUnidad();
//		return lstArsv;
//	}
//	
//	public List<ArsvTipoSolicitud> getArsvTipoSolicitud() {
//		return antarticaSessionLocal.getArsvTipoSolicitud();
//	}
//
//	public FacesContext getFacesContext() {
//		return facesContext;
//	}
//
//	public void setFacesContext(FacesContext facesContext) {
//		this.facesContext = facesContext;
//	}
//
//	public ClienteSACSessionLocal getClienteSACSession() {
//		return clienteSACSession;
//	}
//
//	public void setClienteSACSession(ClienteSACSessionLocal clienteSACSession) {
//		this.clienteSACSession = clienteSACSession;
//	}
//
//	public SolicitudOperacionAntarticaSessionLocal getAntarticaSessionLocal() {
//		return antarticaSessionLocal;
//	}
//
//	public void setAntarticaSessionLocal(SolicitudOperacionAntarticaSessionLocal antarticaSessionLocal) {
//		this.antarticaSessionLocal = antarticaSessionLocal;
//	}
//
//	public ResponderArsvSessionLocal getResponderService() {
//		return responderService;
//	}
//
//	public void setResponderService(ResponderArsvSessionLocal responderService) {
//		this.responderService = responderService;
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
//	public ArsvUsuario getUsr() {
//		return usr;
//	}
//
//	public void setUsr(ArsvUsuario usr) {
//		this.usr = usr;
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
//	public List<ArsvAsignacion> getListaAsignacion() {
//		return listaAsignacion;
//	}
//
//	public void setListaAsignacion(List<ArsvAsignacion> listaAsignacion) {
//		this.listaAsignacion = listaAsignacion;
//	}
//
//	public List<String> getListaAsignacionSeleccionada() {
//		return listaAsignacionSeleccionada;
//	}
//
//	public void setListaAsignacionSeleccionada(
//			List<String> listaAsignacionSeleccionada) {
//		this.listaAsignacionSeleccionada = listaAsignacionSeleccionada;
//	}
//
//	public OperacionAntartica getSolicitudOperacion() {
//		return solicitudOperacion;
//	}
//
//	public void setSolicitudOperacion(OperacionAntartica solicitudOperacion) {
//		this.solicitudOperacion = solicitudOperacion;
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
//	public boolean isVerRespuesta() {
//		return verRespuesta;
//	}
//
//	public void setVerRespuesta(boolean verRespuesta) {
//		this.verRespuesta = verRespuesta;
//	}
//
//	public List<ArsvUnidad> getLstArsv() {
//		return lstArsv;
//	}
//
//	public void setLstArsv(List<ArsvUnidad> lstArsv) {
//		this.lstArsv = lstArsv;
//	}
//
//	public Long getIdOperacionAntartica() {
//		return idOperacionAntartica;
//	}
//
//	public void setIdOperacionAntartica(Long idOperacionAntartica) {
//		this.idOperacionAntartica = idOperacionAntartica;
//	}
//
//	public void setNuevaSolicitudAntartica(OperacionAntartica nuevaSolicitudAntartica) {
//		this.nuevaSolicitudAntartica = nuevaSolicitudAntartica;
//	}
//
//	public ArsvRuta getNuevaRuta() {
//		return nuevaRuta;
//	}
//
//	public void setNuevaRuta(ArsvRuta nuevaRuta) {
//		this.nuevaRuta = nuevaRuta;
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
//	public List<OACIARSV> getoACIsARSV() {
//		return oACIsARSV;
//	}
//
//	public void setoACIsARSV(List<OACIARSV> oACIsARSV) {
//		this.oACIsARSV = oACIsARSV;
//	}
//
//	public List<String> getUnidadesArsvSeleccionadas() {
//		return unidadesArsvSeleccionadas;
//	}
//
//	public void setUnidadesArsvSeleccionadas(List<String> unidadesArsvSeleccionadas) {
//		this.unidadesArsvSeleccionadas = unidadesArsvSeleccionadas;
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
//	public void setOperadoresARSV(List<OperadorARSV> operadoresARSV) {
//		this.operadoresARSV = operadoresARSV;
//	}
//
//	public void setAeronavesARSV(List<AeronaveARSV> aeronavesARSV) {
//		this.aeronavesARSV = aeronavesARSV;
//	}
//
//	public ArsvProgramaActividad getNuevoPrograma() {
//		return nuevoPrograma;
//	}
//
//	public void setNuevoPrograma(ArsvProgramaActividad nuevoPrograma) {
//		this.nuevoPrograma = nuevoPrograma;
//	}
//
//	public ArsvEquipoUsar getNuevoEquipo() {
//		return nuevoEquipo;
//	}
//
//	public void setNuevoEquipo(ArsvEquipoUsar nuevoEquipo) {
//		this.nuevoEquipo = nuevoEquipo;
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
//	public String getTipoSolicitud() {
//		return tipoSolicitud;
//	}
//
//	public void setTipoSolicitud(String tipoSolicitud) {
//		this.tipoSolicitud = tipoSolicitud;
//	}
//
//	public String getPronunciamiento() {
//		return pronunciamiento;
//	}
//
//	public void setPronunciamiento(String pronunciamiento) {
//		this.pronunciamiento = pronunciamiento;
//	}
//
//	public ArsvPaisOrigen getPaisOrigen() {
//		return paisOrigen;
//	}
//
//	public void setPaisOrigen(ArsvPaisOrigen paisOrigen) {
//		this.paisOrigen = paisOrigen;
//	}
//
//	public ArsvPaisOrigen getPaisOrigenEmision() {
//		return paisOrigenEmision;
//	}
//
//	public void setPaisOrigenEmision(ArsvPaisOrigen paisOrigenEmision) {
//		this.paisOrigenEmision = paisOrigenEmision;
//	}
//
//	public ArsvPaisOrigen getPaisOrigenPiloto() {
//		return paisOrigenPiloto;
//	}
//
//	public void setPaisOrigenPiloto(ArsvPaisOrigen paisOrigenPiloto) {
//		this.paisOrigenPiloto = paisOrigenPiloto;
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
//	public DocumentoAdjunto getNuevoDocumentoAdjunto() {
//		return nuevoDocumentoAdjunto;
//	}
//
//	public void setNuevoDocumentoAdjunto(DocumentoAdjunto nuevoDocumentoAdjunto) {
//		this.nuevoDocumentoAdjunto = nuevoDocumentoAdjunto;
//	}
//
//	public List<DocumentoAdjunto> getDocumentosNuevos() {
//		return documentosNuevos;
//	}
//
//	public void setDocumentosNuevos(List<DocumentoAdjunto> documentosNuevos) {
//		this.documentosNuevos = documentosNuevos;
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
//}
