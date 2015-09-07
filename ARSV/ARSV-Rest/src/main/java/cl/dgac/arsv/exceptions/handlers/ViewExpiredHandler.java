//package cl.dgac.arsv.exceptions.handlers;
//
//import javax.faces.application.ViewExpiredException;
//import javax.faces.context.ExternalContext;
//import javax.faces.context.FacesContext;
//import javax.inject.Inject;
//import javax.servlet.http.HttpServletRequest;
//
//import org.jboss.solder.exception.control.CaughtException;
//import org.jboss.solder.exception.control.Handles;
//import org.jboss.solder.exception.control.HandlesExceptions;
//import org.jboss.solder.logging.Logger;
//
//@HandlesExceptions
//public class ViewExpiredHandler {
//    
//	@Inject
//    private Logger log;
//	
//	public void onViewExpiredException(
//            @Handles CaughtException<ViewExpiredException> evt,  HttpServletRequest httpServletRequest) {
//        log.error("ViewExpiredException!\n" + evt.getException().getMessage());
//        evt.handled();
//        
//       try {
//        	httpServletRequest.getRequestURL().toString();
//        	String dirEntero=httpServletRequest.getRequestURL().toString();
//        	String dir= dirEntero.substring(0, dirEntero.lastIndexOf("/"));
//	        ExternalContext context = FacesContext.getCurrentInstance().getExternalContext();
//	        context.invalidateSession();
//	        context.redirect(dir + "/error.jsf");
//        }catch (Exception e) {
//            log.error(e);
//        }
//    }
//}