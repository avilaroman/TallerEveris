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
//import cl.dgac.arsv.dao.ArsvUnidadDAO;
//import cl.dgac.arsv.exceptions.ARSVBusinessException;
//import cl.dgac.arsv.exceptions.ARSVMailException;
//import cl.dgac.arsv.handler.BrmsClientHandlerInterLocal;
//import cl.dgac.arsv.handler.impl.BrmsClientHandlerInter;
//import cl.dgac.arsv.model.ArsvClasificacion;
//import cl.dgac.arsv.model.ArsvOACI;
//import cl.dgac.arsv.model.ArsvObjetoVuelo;
//import cl.dgac.arsv.model.ArsvPaisOrigen;
//import cl.dgac.arsv.model.ArsvRuta;
//import cl.dgac.arsv.model.ArsvUnidad;
//import cl.dgac.arsv.model.ArsvUnidadPeso;
//import cl.dgac.arsv.model.ArsvUsuario;
//import cl.dgac.arsv.model.ArsvVentanaTiempo;
//import cl.dgac.arsv.model.DocumentoAdjunto;
//import cl.dgac.arsv.model.OperacionPascua;
//import cl.dgac.arsv.service.ClienteSACSessionLocal;
//import cl.dgac.arsv.service.ResponderArsvSessionLocal;
//import cl.dgac.arsv.service.SeguridadArsvSessionLocal;
//import cl.dgac.arsv.service.SolicitudOperacionPascuaSessionLocal;
//import cl.dgac.arsv.util.AeronaveARSV;
//import cl.dgac.arsv.util.MessageFactory;
//
//@Named("operacionPascuaController")
//@ViewScoped
//public class OperacionPascuaController implements Serializable {
//
//
//	/**
//	 * 
//	 */
//	private static final long serialVersionUID = 2140869672228280694L;
//
//	public static final Logger log = Logger.getLogger(OperacionPascuaController.class);
//	
//	private String token;
//	
//	private ArsvUsuario usr;
//	
//	/*********************** Seccion de Inject ******************************/
//	
//	@Inject
//	private FacesContext facesContext;  
//	
//    @Inject
//    private ClienteSACSessionLocal clienteSACSession;
//	
//	@Inject
//	private SolicitudOperacionPascuaSessionLocal pascuaSessionLocal;
//	
//	@Inject
//	private SeguridadArsvSessionLocal seguridadServiceOperacionPascua;
//	
//	@Inject
//	private BrmsClientHandlerInterLocal brmsClientHandlerInter;
//	
//	@Inject
//	private ResponderArsvSessionLocal responderService;
//	
//	@Inject
//	private ArsvUnidadDAO arsvUnidadDAO;
//	
//	/**
//	* El idTask de la tarea que se va a actualizar
//	*/
//	private Long idTask;
//	
//	private String mensajeResOperacion;
//	
//	private OperacionPascua nuevaOperacionPascua;
//    
//	private OperacionPascua operacionPascua;
//	
//	private ArsvRuta nuevaRuta;
//	
//	private ArsvRuta nuevaRuta2;
//	
//	private DocumentoAdjunto nuevoDocumentoAdjunto;
//	
//	private List<DocumentoAdjunto> documentosNuevos;
//	
//	private List<ArsvUnidad> lstArsv;
//	
//	private String tipoSolicitud = "ARRIBOPASCUA";
//	
//	private AeronaveARSV aeronaveARSV;
//	
//	private Long solicitudId;
//	
//	private Long idOperacionPascua;	
//	
//	private ArsvVentanaTiempo nuevaVentanaTiempo;
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
//	private StreamedContent downloadFile;
//	
//	private String renderBtnAprovar = "true";
//
//
//	@Produces   
//    @Named
//    public OperacionPascua getNuevaOperacionPascua() {
//    	return nuevaOperacionPascua;
//    }
//    
//    @PostConstruct
//    public void initNuevaSolicitud() {	   
//       nuevaOperacionPascua = new OperacionPascua();
//       nuevaVentanaTiempo = new ArsvVentanaTiempo();
//       nuevaRuta = new ArsvRuta();
//       nuevaRuta2 = new ArsvRuta();
//       nuevoDocumentoAdjunto = new DocumentoAdjunto();
//       documentosNuevos = null;
//       renderBtnAprovar = "true";
//       //this.operadorARSV = new OperadorARSV();
//       this.aeronaveARSV = new AeronaveARSV();
//    }
//
//	
//	
//	public void initBrmsClientUser() {
//		if (null == token) {
//			redirectError();
//		} else {
//			try {
//				this.usuario = null;
//				this.pass = null;
//				usr = seguridadServiceOperacionPascua.getUsuarioToken(token);
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
//	public String tomarConocimientoAprobado() {
//		log.info("metodo para aprobar");
//		try {
//			
//			//carga el usuario y pass del usuario conectado
//			initBrmsClientUser();
//			
//			pascuaSessionLocal.tomarConocimiento(operacionPascua,idTask,usuario,pass);
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
//	
//	public void completarAntecOperador() {	
//		try{
//			String solicitudIdParam = FacesContext.getCurrentInstance()
//					.getExternalContext().getRequestParameterMap()
//					.get("solicitudId");
//			try {
//				if(null != solicitudIdParam){
//					this.setSolicitudId(Long.valueOf(solicitudIdParam));				
//					operacionPascua = pascuaSessionLocal.seleccionarOperacion(Long.valueOf(solicitudIdParam));
//				} else if (null != solicitudId){
//					operacionPascua = pascuaSessionLocal.seleccionarOperacion(Long.valueOf(solicitudId));	
//				}				
//				
//				if(documentosNuevos == null){
//					documentosNuevos =  operacionPascua.getDocumentosAdjuntos();
//					
//					if(null == documentosNuevos){
//						documentosNuevos = new ArrayList<DocumentoAdjunto>();
//					}
//				}
//	
//				if (null == operacionPascua) {
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
//	public void enviarCompletarAntecedentes() throws Exception {
//		boolean enviar=true;
//		if (null == operacionPascua.getDetalleSolicitud()  || operacionPascua.getDetalleSolicitud().isEmpty()){
//			facesContext.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Completar Antecedentes:", 
//					MessageFactory.getMessage("{solicitud.antecedentes.noInfomada}")));
//			enviar=false;
//		}
//		if (enviar){
//			try {
//				if(operacionPascua.getDocumentosAdjuntos()!=null || operacionPascua.getDocumentosAdjuntos().size()==0){
//					pascuaSessionLocal.docDelete(operacionPascua);
//	    			for(DocumentoAdjunto documento : documentosNuevos){
//	    				documento.setIdDocumento(null);
//	    				documento.setSolicitud(operacionPascua);
//	    			}
//	    			
//	    			operacionPascua.setDocumentosAdjuntos(documentosNuevos);
//	    		}
//				
//				responderService.responderComplAntecentes(operacionPascua);
//				idTask = brmsClientHandlerInter.buscarTareaOperador(solicitudId.toString());
//				brmsClientHandlerInter.completarMasAntecedentes(idTask, operacionPascua);
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
//	public void eliminarVentanaTiempo(Long id) {
//		log.info("----- eliminarVentana -----");
//		//		Long id = this.nuevoDetalle.getId();
//
//		List<ArsvVentanaTiempo> ventanas = new ArrayList<ArsvVentanaTiempo>(this.operacionPascua.getArsvVentanaTiempo());
//
//		for (ArsvVentanaTiempo ventana : ventanas) {
//			if (ventana.getId().equals(id)) {
//				this.operacionPascua.getArsvVentanaTiempo().remove(ventana);
//				break;
//			}
//		}
//	}
//	
//	public void agregarVentanaTiempo() {
//		log.info("----- agregarVentana -----");
//		
//		if(!nuevaVentanaTiempo.getHoraInicial().equals("") && !nuevaVentanaTiempo.getHoraFinal().equals("")){
//			// Se incorpora id temporal, en caso de querer eliminar
//			nuevaVentanaTiempo.setId((long) (Math.random() * 1000));
//
//			nuevaVentanaTiempo.setOperacionPascua(operacionPascua);
//
//			List<ArsvVentanaTiempo> detalles = operacionPascua.getArsvVentanaTiempo();
//
//			if (null == detalles) {
//				detalles = new ArrayList<ArsvVentanaTiempo>();
//			}
//			detalles.add(nuevaVentanaTiempo);
//			operacionPascua.setArsvVentanaTiempo(detalles);
//
//			nuevaVentanaTiempo = new ArsvVentanaTiempo();
//		}		
//	}
//	
//	public void enviarVentanas(){
//		try {		
//    		if(operacionPascua.getArsvVentanaTiempo().size()!=0){
//	    		if(null!=operacionPascua.getArsvVentanaTiempo() || !operacionPascua.getArsvVentanaTiempo().isEmpty()){
//	    			for(ArsvVentanaTiempo ventana : operacionPascua.getArsvVentanaTiempo()){
//	    				ventana.setId(null);
//	    				ventana.setOperacionPascua(operacionPascua);
//	    			}
//	    			//carga el usuario y pass del usuario conectado
//	    			initBrmsClientUser();
//    		
//	    			pascuaSessionLocal.enviarVentanas(operacionPascua, idTask,usuario,pass);	
//	    		
//	    			renderBtnAprovar = "false";
//	    			facesContext.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Se han enviado las ventanas de tiempo", null ));
//	    		}
//	    	}
//    		else{
//    			facesContext.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Debe ingresar ventana de tiempo",null));
//    		}
//  		} catch(ARSVMailException me){
//  			facesContext.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN, "Solicitud usuario:", me.getMessage()));
//    	
//  		}catch (ARSVBusinessException e) {
//  			facesContext.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Solicitud usuario:", e.getMessage()));
//  		}
//	}
//	
//	public void guardarCompletarAntecedentes() throws Exception {	
//		boolean guardar=true;
//		if (null == operacionPascua.getDetalleSolicitud()  || operacionPascua.getDetalleSolicitud().isEmpty()){
//			facesContext.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Completar Antecedentes:", 
//					MessageFactory.getMessage("{solicitud.antecedentes.noInfomada}")));
//			guardar = false;
//		}
//		if(guardar){
//			try {
//				responderService.responderComplAntecentes(operacionPascua);
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
//	public void enviarMasAntecedentes(){
//		boolean enviar=true;
//		if (null == operacionPascua.getAntecedentesSolicitados() || operacionPascua.getAntecedentesSolicitados().isEmpty()){
//			facesContext.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Solicitud Antecedentes AROAMB:", 
//					MessageFactory.getMessage("{solicitud.solicitarAntecedentes.vacio}")));
//			enviar = false;			
//		} 
//		if (enviar) {
//			try {
//				if(operacionPascua.getDocumentosAdjuntos()!=null || operacionPascua.getDocumentosAdjuntos().size()==0){
//					pascuaSessionLocal.docDelete(operacionPascua);
//	    			for(DocumentoAdjunto documento : documentosNuevos){
//	    				documento.setIdDocumento(null);
//	    				documento.setSolicitud(operacionPascua);
//	    			}
//	    			
//	    			operacionPascua.setDocumentosAdjuntos(documentosNuevos);
//	    		}
//				
//				
//				//carga el usuario y pass del usuario conectado
//				initBrmsClientUser();
//				
//				pascuaSessionLocal.solicitarCentralAntecentes(operacionPascua,idTask,usuario,pass);	
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
//	public void register() {    	
//    	log.debug("Registrando nueva solicitud..");
//    	try {		
//    		
//    		if(null!=nuevaOperacionPascua.getArsvRutas()){
//    			for(ArsvRuta ruta : nuevaOperacionPascua.getArsvRutas()){
//    				ruta.setId(null);
//    				ruta.setSolicitud(nuevaOperacionPascua);
//    			}
//    		}
//    		
//    		if(null!=nuevaOperacionPascua.getArsvRutas2()){
//    			for(ArsvRuta ruta : nuevaOperacionPascua.getArsvRutas2()){
//    				ruta.setId(null);
//    				ruta.setSolicitud(nuevaOperacionPascua);
//    			}
//    		}
//    		
//    		if(nuevaOperacionPascua.getDocumentosAdjuntos()!=null){
//    			for(DocumentoAdjunto documento : nuevaOperacionPascua.getDocumentosAdjuntos()){
//    				documento.setIdDocumento(null);
//    				documento.setSolicitud(nuevaOperacionPascua);
//    			}
//    		}
//    		
//    		Long solicitudIdNueva = pascuaSessionLocal.ingresarSolicitudOperacion(nuevaOperacionPascua, tipoSolicitud);	
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
//	public void cargarOperadorAeronave() {
//
//		String matriculaAeronave = this.nuevaOperacionPascua.getSacAeronave();
//		if(matriculaAeronave!=null ){
//			try {
//				this.nuevaOperacionPascua.setAeronave(clienteSACSession.buscarAeronavesSAC(matriculaAeronave)); 
//			} catch (ARSVBusinessException e) {
//				facesContext.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN, "no se ha encontrado la aeronave", e.getMessage()));
//				log.error("Error tratando de cerrar la solicitud"+ e.getMessage());			
//			}
//		
//		}
//		
//	}
//	
//	public void obtenerSolicitud() {
//		try {
//			if(null==operacionPascua){
//				operacionPascua = pascuaSessionLocal.seleccionarOperacion(idOperacionPascua);
//				this.operacionPascua.setAeronave(clienteSACSession.buscarAeronavesSAC(operacionPascua.getSacAeronave()));
//				
//				rutaPrincipal = pascuaSessionLocal.getRutaPrincipal(operacionPascua);
//				rutaAlternativa = pascuaSessionLocal.getRutaAlternativa(operacionPascua);
//				
//				if(documentosNuevos == null){
//					documentosNuevos =  operacionPascua.getDocumentosAdjuntos();
//					
//					if(null == documentosNuevos){
//						documentosNuevos = new ArrayList<DocumentoAdjunto>();
//					}
//				}
//				
//				if (null == operacionPascua) {
//					facesContext.addMessage(null, new FacesMessage(
//							FacesMessage.SEVERITY_ERROR, "Solicitud ciudadano:",
//							MessageFactory.getMessage("{solicitud.inexistente}")));
//				}
//			}
//		} catch (ARSVBusinessException e) {
//			facesContext.addMessage(null,
//					new FacesMessage(FacesMessage.SEVERITY_ERROR,
//							"Solicitud ciudadano:", e.getMessage()));
//		}
//	}
//	
//	
//	public void eliminarRuta(Long id) {
//		log.info("----- eliminarDetalle -----");
//		//		Long id = this.nuevoDetalle.getId();
//
//		List<ArsvRuta> rutas = new ArrayList<ArsvRuta>(this.nuevaOperacionPascua.getArsvRutas());
//
//		for (ArsvRuta ruta : rutas) {
//			if (ruta.getId().equals(id)) {
//				this.nuevaOperacionPascua.getArsvRutas().remove(ruta);
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
//		nuevaRuta.setSolicitud(nuevaOperacionPascua);		
//
//		List<ArsvRuta> detalles = nuevaOperacionPascua.getArsvRutas();
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
//		nuevaOperacionPascua.setArsvRutas(detalles);
//
//		nuevaRuta = new ArsvRuta();
//	}
//	
//	public void eliminarRuta2(Long id) {
//		log.info("----- eliminarDetalle -----");
//		//		Long id = this.nuevoDetalle.getId();
//
//		List<ArsvRuta> rutas = new ArrayList<ArsvRuta>(this.nuevaOperacionPascua.getArsvRutas2());
//
//		for (ArsvRuta ruta : rutas) {
//			if (ruta.getId().equals(id)) {
//				this.nuevaOperacionPascua.getArsvRutas2().remove(ruta);
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
//		nuevaRuta2.setSolicitud(nuevaOperacionPascua);		
//
//		List<ArsvRuta> detalles = nuevaOperacionPascua.getArsvRutas2();
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
//		nuevaOperacionPascua.setArsvRutas2(detalles);
//
//		nuevaRuta2 = new ArsvRuta();
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
//		nuevoDocumentoAdjunto.setSolicitud(nuevaOperacionPascua);
//		nuevoDocumentoAdjunto.setDescripcionDocumento(file.getFileName());
//		nuevoDocumentoAdjunto.setDocumento(file.getContents());
//		
//		MimetypesFileTypeMap mimeTypeMap = new MimetypesFileTypeMap();
//		
//		String mimeType = mimeTypeMap.getContentType(file.getFileName());
//		
//		nuevoDocumentoAdjunto.setMimeType(mimeType);
//		
//		List<DocumentoAdjunto> detalles = nuevaOperacionPascua.getDocumentosAdjuntos();
//
//		if (null == detalles) {
//			detalles = new ArrayList<DocumentoAdjunto>();
//		}
//		detalles.add(nuevoDocumentoAdjunto);
//		nuevaOperacionPascua.setDocumentosAdjuntos(detalles);
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
//		nuevoDocumentoAdjunto.setSolicitud(operacionPascua);
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
//		List<DocumentoAdjunto> documentos = new ArrayList<DocumentoAdjunto>(this.nuevaOperacionPascua.getDocumentosAdjuntos());
//
//		for (DocumentoAdjunto documento : documentos) {
//			if (documento.getIdDocumento().equals(id)) {
//				this.nuevaOperacionPascua.getDocumentosAdjuntos().remove(documento);
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
//		List<DocumentoAdjunto> documentos = new ArrayList<DocumentoAdjunto>(this.nuevaOperacionPascua.getDocumentosAdjuntos());
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
//	public void asignarArsvAroAmb() {
//		boolean asignar = true;
//		if (asignar) {
//			try {
//				
//				if (null == operacionPascua) {
//					operacionPascua = pascuaSessionLocal.seleccionarOperacion(idOperacionPascua);
//				}
//				
//				//carga el usuario y pass del usuario conectado
//				initBrmsClientUser();
//				
//				pascuaSessionLocal.aprobarSolicitudAroAMB(operacionPascua, idTask,usuario,pass);
//
//				
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
//	public void asignarJAC() {
//		boolean asignar = true;
//		if (asignar) {
//			try {
//				
//				if (null == operacionPascua) {
//					operacionPascua = pascuaSessionLocal.seleccionarOperacion(idOperacionPascua);
//				}
//				
//				//carga el usuario y pass del usuario conectado
//				initBrmsClientUser();
//				
//				pascuaSessionLocal.solicitarJAC(operacionPascua, idTask,usuario,pass);
//
//				
//				 
//				RequestContext.getCurrentInstance().addCallbackParam(
//						"showDialog", true);
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
//	public void cargarOACI() {
////		Long id = (Long)event.getComponent().getAttributes().get("value");
//		Long id = this.nuevaOperacionPascua.getPaisOrigen().getId();
//		if(id!=null ){
//			this.oacis = pascuaSessionLocal.getArsvOACI(id);
//			id = null;
//		}
//	}
//	
//	public String verificarAntecedentesSolicitados(){
//		if(operacionPascua.getAntecedentesSolicitados()!=null){
//			return "true";
//		}
//		else{
//			return "false";
//		}
//	}
//	
//	public String irSolicitudMasAntecedente(){
//		return "solicitarMasAntecedentesPascua?faces-redirect=true&includeViewParams=true";
//	}
//	
//	public List<ArsvUnidad> getArsvUnidad() {
//		lstArsv = pascuaSessionLocal.getArsvUnidad();
//		return lstArsv;
//	}
//	
//	
//	public List<ArsvObjetoVuelo> getArsvObjetoVuelo() {
//		return pascuaSessionLocal.getArsvObjetoVuelo();
//	}
//	
//    public List<ArsvUnidadPeso> getArsvUnidadPeso() {
//   	   return pascuaSessionLocal.getArsvUnidadPeso();
//    }
//
//	public List<ArsvPaisOrigen> getArsvPaisesOrigen() {
//		return pascuaSessionLocal.getArsvPaisesOrigen();
//	}
//
//	public List<ArsvClasificacion> getArsvClasificaciones() {
//		return pascuaSessionLocal.getArsvClasificaciones();
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
//	public SolicitudOperacionPascuaSessionLocal getPascuaSessionLocal() {
//		return pascuaSessionLocal;
//	}
//
//	public void setPascuaSessionLocal(
//			SolicitudOperacionPascuaSessionLocal pascuaSessionLocal) {
//		this.pascuaSessionLocal = pascuaSessionLocal;
//	}
//
//	public void setNuevaOperacionPascua(OperacionPascua nuevaOperacionPascua) {
//		this.nuevaOperacionPascua = nuevaOperacionPascua;
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
//	public SeguridadArsvSessionLocal getSeguridadServiceOperacionPascua() {
//		return seguridadServiceOperacionPascua;
//	}
//
//	public void setSeguridadServiceOperacionPascua(
//			SeguridadArsvSessionLocal seguridadServiceOperacionPascua) {
//		this.seguridadServiceOperacionPascua = seguridadServiceOperacionPascua;
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
//	public ArsvRuta getNuevaRuta2() {
//		return nuevaRuta2;
//	}
//
//	public void setNuevaRuta2(ArsvRuta nuevaRuta2) {
//		this.nuevaRuta2 = nuevaRuta2;
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
//	public String getTipoSolicitud() {
//		return tipoSolicitud;
//	}
//
//	public void setTipoSolicitud(String tipoSolicitud) {
//		this.tipoSolicitud = tipoSolicitud;
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
//	public Long getSolicitudId() {
//		return solicitudId;
//	}
//
//	public void setBrmsClientHandlerInter(
//			BrmsClientHandlerInter brmsClientHandlerInter) {
//		this.brmsClientHandlerInter = brmsClientHandlerInter;
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
//	public ResponderArsvSessionLocal getResponderService() {
//		return responderService;
//	}
//
//	public void setResponderService(ResponderArsvSessionLocal responderService) {
//		this.responderService = responderService;
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
//	public Long getIdOperacionPascua() {
//		return idOperacionPascua;
//	}
//
//	public void setIdOperacionPascua(Long idOperacionPascua) {
//		this.idOperacionPascua = idOperacionPascua;
//	}
//
//	public ArsvVentanaTiempo getNuevaVentanaTiempo() {
//		return nuevaVentanaTiempo;
//	}
//
//	public void setNuevaVentanaTiempo(ArsvVentanaTiempo nuevaVentanaTiempo) {
//		this.nuevaVentanaTiempo = nuevaVentanaTiempo;
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
//	public void setSolicitudId(Long solicitudId) {
//		this.solicitudId = solicitudId;
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
