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
//import cl.dgac.arsv.dao.ArsvRutaDAO;
//import cl.dgac.arsv.dao.ArsvUnidadDAO;
//import cl.dgac.arsv.exceptions.ARSVBusinessException;
//import cl.dgac.arsv.exceptions.ARSVMailException;
//import cl.dgac.arsv.filters.FiltroArsvRuta;
//import cl.dgac.arsv.handler.BrmsClientHandlerInterLocal;
//import cl.dgac.arsv.model.ArsvClasificacion;
//import cl.dgac.arsv.model.ArsvOACI;
//import cl.dgac.arsv.model.ArsvObjetoVuelo;
//import cl.dgac.arsv.model.ArsvPaisOrigen;
//import cl.dgac.arsv.model.ArsvRuta;
//import cl.dgac.arsv.model.ArsvTipoSolicitud;
//import cl.dgac.arsv.model.ArsvUnidad;
//import cl.dgac.arsv.model.ArsvUnidadPeso;
//import cl.dgac.arsv.model.ArsvUsuario;
//import cl.dgac.arsv.model.DocumentoAdjunto;
//import cl.dgac.arsv.model.SolicitudArriboSobrevuelo;
//import cl.dgac.arsv.service.ClienteSACSessionLocal;
//import cl.dgac.arsv.service.ResponderArsvSessionLocal;
//import cl.dgac.arsv.service.SeguridadArsvSessionLocal;
//import cl.dgac.arsv.service.SolicitudSessionLocal;
//import cl.dgac.arsv.util.AeronaveARSV;
//import cl.dgac.arsv.util.MessageFactory;
//import cl.dgac.arsv.util.OperadorARSV;
//
//@Named("solicitudArsvController")
//@ViewScoped
//public class SolicitudArsvController implements Serializable {
//
//	private static final long serialVersionUID = -267286795473718950L;
//
//	public static final Logger log = Logger.getLogger(SolicitudArsvController.class);
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
//	private SolicitudSessionLocal solicitudService;
//	
//	@Inject
//	private ResponderArsvSessionLocal responderService;
//	
//	@Inject
//	private SeguridadArsvSessionLocal seguridadService;
//	
//	@Inject 
//	private ArsvUnidadDAO arsvUnidadDAO;
//	
//	@Inject
//	private ArsvRutaDAO arsvRutaDAO;
//    
//    
//	/**
//	* El idTask de la tarea que se va a actualizar
//	*/
//	private Long idTask;
//	
//	private ArsvUsuario usr;
//	
//	private Long solicitudId;
//	
//    private SolicitudArriboSobrevuelo nuevaSolicitudArsv;
//    
//	private SolicitudArriboSobrevuelo solicitudArsv;
//    
//    private String mensajeResOperacion;
//
//	private boolean verRespuesta = false;
//
//	private String respuesta;
//
//	private List<ArsvUnidad> lstArsv;
//
//	private Long idSolicitudArsv;	
//	
//	private String tipoSolicitud = "ARRIBO";
//	
//	private List<ArsvRuta> unidadesArsvSeleccionadas;
//	
//	private String comentarioAroAMB;
//	
//	private List<OperadorARSV> operadoresARSV;
//	
//	private List<AeronaveARSV> aeronavesARSV;
//	
//	private ArsvRuta nuevaRuta;
//	
//	private ArsvRuta nuevaRuta2;
//	
//	private DocumentoAdjunto nuevoDocumentoAdjunto;
//	
//	private List<DocumentoAdjunto> documentosNuevos;
//	
//	private StreamedContent downloadFile;
//	
//	private AeronaveARSV aeronaveARSV;
//	
//	private OperadorARSV operadorARSV;
//	
//	private String token;
//	
//	private String usuariosALEnviarBRMS;
//	
//	private String usuariosTCEnviarBRMS;
//	
//	private List<ArsvRuta> rutaPrincipal;
//	
//	private List<ArsvRuta> rutaAlternativa;
//	
//	private List<ArsvOACI> oacis = null;
//	
//	private String usuario;
//	
//	private String pass;
//	
//	private String renderBtnAprovar = "true";
//	
//	
//	
//	/****************************************************************___________METODOS_________****************************************************************/
// 	
//    @Produces   
//    @Named
//    public SolicitudArriboSobrevuelo getNuevaSolicitudArsv() {
//    	return nuevaSolicitudArsv;
//    }
//    
//    @PostConstruct
//    public void initNuevaSolicitud() {	   
//       nuevaSolicitudArsv = new SolicitudArriboSobrevuelo();
//       nuevaRuta = new ArsvRuta();
//       nuevaRuta2 = new ArsvRuta();
//       nuevoDocumentoAdjunto = new DocumentoAdjunto();
//       documentosNuevos = null;
//       renderBtnAprovar = "true";
//       this.aeronaveARSV = new AeronaveARSV();
//
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
//	public void obtenerSolicitud() {
//		try {
//			
//			solicitudArsv = solicitudService.seleccionarSolicitud(idSolicitudArsv);
//			this.solicitudArsv.setAeronave(clienteSACSession.buscarAeronavesSAC(solicitudArsv.getSacAeronave()));
//			
//			rutaPrincipal = solicitudService.getRutaPrincipal(solicitudArsv);
//			rutaAlternativa = solicitudService.getRutaAlternativa(solicitudArsv);
//			
//			if(documentosNuevos == null){
//				documentosNuevos =  solicitudArsv.getDocumentosAdjuntos();
//				
//				if(null == documentosNuevos){
//					documentosNuevos = new ArrayList<DocumentoAdjunto>();
//				}
//			}
//			
//			
//			if (null == solicitudArsv) {
//				facesContext.addMessage(null, new FacesMessage(
//						FacesMessage.SEVERITY_ERROR, "Solicitud operador:",
//						MessageFactory.getMessage("{solicitud.inexistente}")));
//			}
//		} catch (ARSVBusinessException e) {
//			facesContext.addMessage(null,
//					new FacesMessage(FacesMessage.SEVERITY_ERROR,
//							"Solicitud ciudadano:", e.getMessage()));
//		}
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
//					solicitudArsv = solicitudService.seleccionarSolicitud(Long.valueOf(solicitudIdParam));
//				} else if (null != solicitudId){
//					solicitudArsv = solicitudService.seleccionarSolicitud(Long.valueOf(solicitudId));	
//				}		
//				
//				if(documentosNuevos == null){
//					documentosNuevos =  solicitudArsv.getDocumentosAdjuntos();
//					
//					if(null == documentosNuevos){
//						documentosNuevos = new ArrayList<DocumentoAdjunto>();
//					}
//				}
//	
//				if (null == solicitudArsv) {
//					throw new ARSVBusinessException("La solicitud es inaceptable");
//				}
//			} catch (ARSVBusinessException e) {
//				facesContext.addMessage(null,new FacesMessage(FacesMessage.SEVERITY_ERROR,
//								"Solicitud ciudadano:", e.getMessage()));
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
//    		
//    		if(nuevaSolicitudArsv.getArsvRutas()!=null){
//    			for(ArsvRuta ruta : nuevaSolicitudArsv.getArsvRutas()){
//    				ruta.setId(null);
//    				ruta.setSolicitud(nuevaSolicitudArsv);
//    			}
//    		}
//    		
//    		if(nuevaSolicitudArsv.getArsvRutas2()!=null){
//    			for(ArsvRuta ruta : nuevaSolicitudArsv.getArsvRutas2()){
//    				ruta.setId(null);
//    				ruta.setSolicitud(nuevaSolicitudArsv);
//    			}
//    		}
//    		
//    		if(nuevaSolicitudArsv.getDocumentosAdjuntos()!=null){
//    			for(DocumentoAdjunto documento : nuevaSolicitudArsv.getDocumentosAdjuntos()){
//    				documento.setIdDocumento(null);
//    				documento.setSolicitud(nuevaSolicitudArsv);
//    			}
//    		}
//    		
//    		Long solicitudIdNueva = solicitudService.ingresarSolicitudArsv(nuevaSolicitudArsv, tipoSolicitud);	
//    		
//    		facesContext.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Solicitud usuario:", MessageFactory
//  				.getMessage("{solicitud.nuevaSolicitud}", new Object[] {solicitudIdNueva})));
//	  		
//  		} catch(ARSVMailException me){
//  			facesContext.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN, "Solicitud usuario:", me.getMessage()));
//    	
//  		}catch (ARSVBusinessException e) {
//  			facesContext.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Solicitud usuario:", e.getMessage()));
//  		}
//        initNuevaSolicitud();
//    }
//    
//	public String obtenerRespuestas() {
//		try {
//			if (solicitudArsv == null) {
//
//				solicitudArsv = solicitudService.seleccionarSolicitud(idSolicitudArsv);
//			}
//		} catch (ARSVBusinessException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		return "";
//	}
//	
//	public String asignarArsv() throws Exception {
//		if (null == solicitudArsv) {
//			solicitudArsv = solicitudService.seleccionarSolicitud(idSolicitudArsv);
//		}	
//		return "aprobarSolicitud?faces-redirect=true&includeViewParams=true";
//	}
//    
//	public void enviarMasAntecedentes(){
//		boolean enviar=true;
//		if (null == solicitudArsv.getAntecedentesSolicitados() || solicitudArsv.getAntecedentesSolicitados().isEmpty()){
//			facesContext.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Solicitud Antecedentes AROAMB:", 
//					MessageFactory.getMessage("{solicitud.solicitarAntecedentes.vacio}")));
//			enviar = false;			
//		} 
//		if (enviar) {
//			try {
//				if(solicitudArsv.getDocumentosAdjuntos()!=null || solicitudArsv.getDocumentosAdjuntos().size()==0){
//					solicitudService.docDelete(solicitudArsv);
//	    			for(DocumentoAdjunto documento : documentosNuevos){
//	    				documento.setIdDocumento(null);
//	    				documento.setSolicitud(solicitudArsv);
//	    			}
//	    			
//	    			solicitudArsv.setDocumentosAdjuntos(documentosNuevos);
//	    		}
//				
//				initBrmsClientUser();
//				
//				solicitudService.solicitarCentralAntecentes(solicitudArsv,idTask,usuario,pass);	
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
//	
//	/**
//	 * TODO 
//	 * @return
//	 */
//	public String asignarArsvAroAmb() {
//		boolean asignar = true;
//		List<String> listaGruposAROLocal = new ArrayList<String>(0);
//		List<String> listaGruposTorreControl = new ArrayList<String>(0);
//		this.usuariosALEnviarBRMS = "";
//		this.usuariosTCEnviarBRMS = "";
//		
//		 if (null == comentarioAroAMB ||
//		 "".equals(comentarioAroAMB)){ this.comentarioAroAMB = ""; }
//		 
//			log.info("--------->   asignar solicitud");
//
//		if (asignar) {
//			try{
//				FiltroArsvRuta filtroArsvRuta = new FiltroArsvRuta();
//				filtroArsvRuta.setSolicitud(idSolicitudArsv);
//				unidadesArsvSeleccionadas = arsvRutaDAO.findRutas(filtroArsvRuta);
//				
//				for(ArsvRuta ruta : unidadesArsvSeleccionadas) {
//					if (!listaGruposAROLocal.contains(ruta.getAroLocal()))
//						listaGruposAROLocal.add(ruta.getAroLocal());
//					
//					if (!listaGruposTorreControl.contains(ruta.getTorreControl()))
//						listaGruposTorreControl.add(ruta.getTorreControl());
//				}
//				
//
//				for (String grupoAROLocal : listaGruposAROLocal) {
//					if ("".equals(usuariosALEnviarBRMS)) 
//						usuariosALEnviarBRMS = usuariosALEnviarBRMS + grupoAROLocal;
//					else
//						usuariosALEnviarBRMS =  usuariosALEnviarBRMS + " " + grupoAROLocal;
//					
//				}	
//				
//				for (String grupoTorreControl : listaGruposTorreControl) {
//					if ("".equals(usuariosTCEnviarBRMS)) 
//						usuariosTCEnviarBRMS = usuariosTCEnviarBRMS + grupoTorreControl;
//					else
//						usuariosTCEnviarBRMS =  usuariosTCEnviarBRMS + " " + grupoTorreControl;
//				}
//				
//				if(solicitudArsv.getDocumentosAdjuntos()!=null || solicitudArsv.getDocumentosAdjuntos().size()==0){
//					solicitudService.docDelete(solicitudArsv);
//	    			for(DocumentoAdjunto documento : documentosNuevos){
//	    				documento.setIdDocumento(null);
//	    				documento.setSolicitud(solicitudArsv);
//	    			}
//	    			
//	    			solicitudArsv.setDocumentosAdjuntos(documentosNuevos);
//	    		}
//				
//				
//			
//				log.info("--------->   asignar solicitud");
//				
//				initBrmsClientUser();
//				
//				solicitudService.asignarSolicitudArsv(solicitudArsv,
//						unidadesArsvSeleccionadas, comentarioAroAMB,
//						usr.getUsuaIdUsuario(), idTask, usuariosALEnviarBRMS, usuariosTCEnviarBRMS, usuario, pass);
//				
//				usuariosALEnviarBRMS = null;
//				usuariosTCEnviarBRMS = null;
//				unidadesArsvSeleccionadas = null;
//				 
//				RequestContext.getCurrentInstance().addCallbackParam(
//						"showDialog", true);
//				log.info("--------->   notificacion");
//				  
//				 this.setMensajeResOperacion
//				  (MessageFactory.getMessage("{solicitud.asignacionArsv.correcto}"
//				 ));
//				 
//			}catch(ARSVMailException me){
//				facesContext.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN, "No se ha podido notificar al operador:", me.getMessage()));
//			} catch (ARSVBusinessException e) {
//				facesContext.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR,	"Asignar Arsv:", e.getMessage()));
//				RequestContext.getCurrentInstance().addCallbackParam(
//						"showDialog", false);
//			}
//		} else {
//			RequestContext.getCurrentInstance().addCallbackParam("showDialog",
//					false);
//		}
//		return "";
//	}
//	
//	public String tomarConocimientoAprobado() {
//		log.info("metodo para aprobar");
//		try {
//			//carga el usuario y pass del usuario conectado
//			initBrmsClientUser();
//			
//			solicitudService.tomarConocimiento(solicitudArsv,idTask,usuario,pass);
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
//	public void cerrarSolicitudCentralizador() {
//		try {
//			initBrmsClientUser();
//			
//			solicitudService.cerrarSolicitud(solicitudArsv, idTask,usuario,pass);
//			
//			RequestContext.getCurrentInstance().addCallbackParam("showDialog",
//					true);
//			this.setMensajeResOperacion(MessageFactory
//					.getMessage("{solicitud.cerrar.correcto}"));
//		} catch (ARSVMailException me){
//			facesContext.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN, "se ha rechazado solicitud, pero no se ha enviado notificacion", me.getMessage()));
//		} catch (ARSVBusinessException e) {
//			log.error("Error tratando de cerrar la solicitud", e);
//		}
//	}
//	
//	public void cargarOperadorAeronave() {
//
//		String matriculaAeronave = this.nuevaSolicitudArsv.getSacAeronave();
//		if(matriculaAeronave!=null ){
//			try {
//				this.nuevaSolicitudArsv.setAeronave(clienteSACSession.buscarAeronavesSAC(matriculaAeronave)); 
//			} catch (ARSVBusinessException e) {
//				facesContext.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN, "no se ha encontrado la aeronave", e.getMessage()));
//				log.error("Error tratando de cerrar la solicitud"+ e.getMessage());			
//			}
//		
//		}
//	}
//	
//	public void cargarOACI() {
////		Long id = (Long)event.getComponent().getAttributes().get("value");
//		Long id = this.nuevaSolicitudArsv.getPaisOrigen().getId();
//		if(id!=null ){
//			this.oacis = solicitudService.getArsvOACI(id);
//			id = null;
//		}
//	}
//	
//	public void eliminarRuta(Long id) {
//		log.info("----- eliminarDetalle -----");
//		//		Long id = this.nuevoDetalle.getId();
//
//		List<ArsvRuta> rutas = new ArrayList<ArsvRuta>(this.nuevaSolicitudArsv.getArsvRutas());
//
//		for (ArsvRuta ruta : rutas) {
//			if (ruta.getId().equals(id)) {
//				this.nuevaSolicitudArsv.getArsvRutas().remove(ruta);
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
//		nuevaRuta.setTipoRuta(1L);
//
//		nuevaRuta.setSolicitud(nuevaSolicitudArsv);		
//
//		List<ArsvRuta> detalles = nuevaSolicitudArsv.getArsvRutas();
//		ArsvUnidad unidad = arsvUnidadDAO.findById(nuevaRuta.getIdUnidad());
//		nuevaRuta.setAroLocal(unidad.getGrupoAro());
//		nuevaRuta.setCentroControl(unidad.getGrupoCeco());
//		nuevaRuta.setTorreControl(unidad.getGrupoToco());
//		nuevaRuta.setPosta(unidad.getNombre());
//
//		if (null == detalles) {
//			detalles = new ArrayList<ArsvRuta>();
//		}
//		detalles.add(nuevaRuta);
//		nuevaSolicitudArsv.setArsvRutas(detalles);
//
//		nuevaRuta = new ArsvRuta();
//	}
//	
//	public void eliminarRuta2(Long id) {
//		log.info("----- eliminarDetalle -----");
//		//		Long id = this.nuevoDetalle.getId();
//
//		List<ArsvRuta> rutas = new ArrayList<ArsvRuta>(this.nuevaSolicitudArsv.getArsvRutas2());
//
//		for (ArsvRuta ruta : rutas) {
//			if (ruta.getId().equals(id)) {
//				this.nuevaSolicitudArsv.getArsvRutas2().remove(ruta);
//				break;
//			}
//		}
//	}
//	
//	public void agregarRuta2() {
//		log.info("----- agregarRuta -----");
//		
//		// Se incorpora id temporal, en caso de querer eliminar
//		nuevaRuta2.setId((long) (Math.random() * 1000));
//		nuevaRuta2.setTipoRuta(2L);
//		nuevaRuta2.setSolicitud(nuevaSolicitudArsv);		
//
//		List<ArsvRuta> detalles = nuevaSolicitudArsv.getArsvRutas2();
//		ArsvUnidad unidad = arsvUnidadDAO.findById(nuevaRuta2.getIdUnidad());
//		nuevaRuta2.setAroLocal(unidad.getGrupoAro());
//		nuevaRuta2.setCentroControl(unidad.getGrupoCeco());
//		nuevaRuta2.setTorreControl(unidad.getGrupoToco());
//		nuevaRuta2.setPosta(unidad.getNombre());
//
//		if (null == detalles) {
//			detalles = new ArrayList<ArsvRuta>();
//		}
//		detalles.add(nuevaRuta2);
//		nuevaSolicitudArsv.setArsvRutas2(detalles);
//
//		nuevaRuta2 = new ArsvRuta();
//	}
//	
//	
//	/**
//	 *  Metodo utilizado para cargar los archivos adjuntos desde el ingreso de una solicitud
//	 */
//	public void handleFileUpload(FileUploadEvent event){
//		log.info("cargando adjunto");
//		
//		UploadedFile file = event.getFile();
//		
//		
//		nuevoDocumentoAdjunto.setIdDocumento((long) (Math.random() * 1000));
//		nuevoDocumentoAdjunto.setSolicitud(nuevaSolicitudArsv);
//		nuevoDocumentoAdjunto.setDescripcionDocumento(file.getFileName());
//		nuevoDocumentoAdjunto.setDocumento(file.getContents());
//		
//		MimetypesFileTypeMap mimeTypeMap = new MimetypesFileTypeMap();
//		
//		String mimeType = mimeTypeMap.getContentType(file.getFileName());
//		
//		nuevoDocumentoAdjunto.setMimeType(mimeType);
//		
//		List<DocumentoAdjunto> detalles = nuevaSolicitudArsv.getDocumentosAdjuntos();
//
//		if (null == detalles) {
//			detalles = new ArrayList<DocumentoAdjunto>();
//		}
//		detalles.add(nuevoDocumentoAdjunto);
//		nuevaSolicitudArsv.setDocumentosAdjuntos(detalles);
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
//		nuevoDocumentoAdjunto.setSolicitud(solicitudArsv);
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
//	/**
//	 *  metodo para eliminar adjunto desde el ingreso de solicitud
//	 */
//	public void eliminarAdjunto(Long id) {
//		log.info("----- eliminarAdjunto -----");
//		
//
//			
//		List<DocumentoAdjunto> documentos = new ArrayList<DocumentoAdjunto>(this.nuevaSolicitudArsv.getDocumentosAdjuntos());
//
//		for (DocumentoAdjunto documento : documentos) {
//			if (documento.getIdDocumento().equals(id)) {
//				this.nuevaSolicitudArsv.getDocumentosAdjuntos().remove(documento);
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
//	/**
//	 * metodo para descargar archivo adjunto desde ingreso de la solicitud
//	 */
//	public String obtenerArchivo(Long id) {
//		
//
//			
//		List<DocumentoAdjunto> documentos = new ArrayList<DocumentoAdjunto>(this.nuevaSolicitudArsv.getDocumentosAdjuntos());
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
//	
//	
//	
//	
//	public void enviarCompletarAntecedentes() throws Exception {
//		boolean enviar=true;
//		if (null == solicitudArsv.getDetalleSolicitud()  || solicitudArsv.getDetalleSolicitud().isEmpty()){
//			facesContext.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Completar Antecedentes:", 
//					MessageFactory.getMessage("{solicitud.antecedentes.noInfomada}")));
//			enviar=false;
//		}
//		if (enviar){
//			try {
//				if(solicitudArsv.getDocumentosAdjuntos()!=null || solicitudArsv.getDocumentosAdjuntos().size()==0){
//					solicitudService.docDelete(solicitudArsv);
//	    			for(DocumentoAdjunto documento : documentosNuevos){
//	    				documento.setIdDocumento(null);
//	    				documento.setSolicitud(solicitudArsv);
//	    			}
//	    			
//	    			solicitudArsv.setDocumentosAdjuntos(documentosNuevos);
//	    		}
//				
//				responderService.responderComplAntecentes(solicitudArsv);
//				idTask = brmsClientHandlerInter.buscarTareaOperador(solicitudId.toString());
//				brmsClientHandlerInter.completarMasAntecedentes(idTask, solicitudArsv);
//				renderBtnAprovar = "false";
//				
//				facesContext.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Completar Antecedentes:","Antecedentes enviados"));
//				
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
//	public void guardarCompletarAntecedentes() throws Exception {	
//		boolean guardar=true;
//		if (null == solicitudArsv.getDetalleSolicitud()  || solicitudArsv.getDetalleSolicitud().isEmpty()){
//			facesContext.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Completar Antecedentes:", 
//					MessageFactory.getMessage("{solicitud.antecedentes.noInfomada}")));
//			guardar = false;
//		}
//		if(guardar){
//			try {
//				responderService.responderComplAntecentes(solicitudArsv);
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
//	public String verificarAntecedentesSolicitados(){
//		if(solicitudArsv.getAntecedentesSolicitados()!=null){
//			return "true";
//		}
//		else{
//			return "false";
//		}
//	}
//    
//	/****************************************************************___________LIST_CAMPOS_LISTAS___________****************************************************************/
//    
//    public List<ArsvObjetoVuelo> getArsvObjetoVuelo() {
// 	   return solicitudService.getArsvObjetoVuelo();
//    }
//    
//    public List<ArsvPaisOrigen> getArsvPaisesOrigen() {
// 	   return solicitudService.getArsvPaisesOrigen();
//    }
//    
//    public List<ArsvUnidadPeso> getArsvUnidadPeso() {
//  	   return solicitudService.getArsvUnidadPeso();
//    }
//    
//    public List<ArsvClasificacion> getArsvClasificaciones() {
// 	   return solicitudService.getArsvClasificaciones();
//    }
//    
//    public List<OperadorARSV> getOperadoresARSV(){
//    	return this.operadoresARSV; 			
//    }
//    
//    public List<AeronaveARSV> getAeronavesARSV(){
//    	return this.aeronavesARSV; 			
//    }
//    
//    /**
//     * Redirecciona a la pagina solicitarMasAntecedentes  
//  	 *
//     * @return
//     */
//	public String irSolicitudMasAntecedente(){
//		return "solicitarMasAntecedentes?faces-redirect=true&includeViewParams=true";
//	}
//    
//    /****************************************************************___________GETTERS_&_SETTERS___________****************************************************************/
//    
//	public List<ArsvUnidad> getArsvUnidad() {
//		lstArsv = solicitudService.getArsvUnidad();
//		return lstArsv;
//	}
//	
//	public List<ArsvTipoSolicitud> getArsvTipoSolicitud() {
//		return solicitudService.getArsvTipoSolicitud();
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
//	public BrmsClientHandlerInterLocal getBrmsClientHandlerInter() {
//		return brmsClientHandlerInter;
//	}
//
//	public void setBrmsClientHandlerInter(
//			BrmsClientHandlerInterLocal brmsClientHandlerInter) {
//		this.brmsClientHandlerInter = brmsClientHandlerInter;
//	}
//
//	public SolicitudSessionLocal getSolicitudService() {
//		return solicitudService;
//	}
//
//	public void setSolicitudService(SolicitudSessionLocal solicitudService) {
//		this.solicitudService = solicitudService;
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
//	public SolicitudArriboSobrevuelo getSolicitudArsv() {
//		return solicitudArsv;
//	}
//
//	public void setSolicitudArsv(SolicitudArriboSobrevuelo solicitudArsv) {
//		this.solicitudArsv = solicitudArsv;
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
//	public String getRespuesta() {
//		return respuesta;
//	}
//
//	public void setRespuesta(String respuesta) {
//		this.respuesta = respuesta;
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
//	public Long getIdSolicitudArsv() {
//		return idSolicitudArsv;
//	}
//
//	public void setIdSolicitudArsv(Long idSolicitudArsv) {
//		this.idSolicitudArsv = idSolicitudArsv;
//	}
//
//	public void setNuevaSolicitudArsv(SolicitudArriboSobrevuelo nuevaSolicitudArsv) {
//		this.nuevaSolicitudArsv = nuevaSolicitudArsv;
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
//	public List<ArsvRuta> getUnidadesArsvSeleccionadas() {
//		return unidadesArsvSeleccionadas;
//	}
//
//	public void setUnidadesArsvSeleccionadas(List<ArsvRuta> unidadesArsvSeleccionadas) {
//		this.unidadesArsvSeleccionadas = unidadesArsvSeleccionadas;
//	}
//
//	public String getComentarioAroAMB() {
//		return comentarioAroAMB;
//	}
//
//	public void setComentarioAroAMB(String comentarioAroAMB) {
//		this.comentarioAroAMB = comentarioAroAMB;
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
//	public SeguridadArsvSessionLocal getSeguridadService() {
//		return seguridadService;
//	}
//
//	public void setSeguridadService(SeguridadArsvSessionLocal seguridadService) {
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
//	public void setArsvTipoSolicitud(ArsvTipoSolicitud arsvTipoSolicitud) {
//	}
//
//	public ArsvRuta getNuevaRuta2() {
//		return nuevaRuta2;
//	}
//
//	public void setNuevaRuta2(ArsvRuta nuevaRuta2) {
//		this.nuevaRuta2 = nuevaRuta2;
//	}
//
//	public String getUsuariosALEnviarBRMS() {
//		return usuariosALEnviarBRMS;
//	}
//
//	public void setUsuariosALEnviarBRMS(String usuariosALEnviarBRMS) {
//		this.usuariosALEnviarBRMS = usuariosALEnviarBRMS;
//	}
//
//	public String getUsuariosTCEnviarBRMS() {
//		return usuariosTCEnviarBRMS;
//	}
//
//	public void setUsuariosTCEnviarBRMS(String usuariosTCEnviarBRMS) {
//		this.usuariosTCEnviarBRMS = usuariosTCEnviarBRMS;
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
//	public List<ArsvOACI> getOacis() {
//		return oacis;
//	}
//
//	public void setOacis(List<ArsvOACI> oacis) {
//		this.oacis = oacis;
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
