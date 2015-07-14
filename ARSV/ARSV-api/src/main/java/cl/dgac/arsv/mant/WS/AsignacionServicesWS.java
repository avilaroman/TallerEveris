package cl.dgac.arsv.mant.WS;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import cl.dgac.arsv.exceptions.ARSVBusinessException;
import cl.dgac.arsv.model.ArsvAsignacion;

@Path("asignacionServices")
public interface AsignacionServicesWS {
	
	@POST
	@Path("/guardarAsignacion")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public ArsvAsignacion guardarAsignacion(ArsvAsignacion arsvAsignacion) throws ARSVBusinessException;
	
	public ArsvAsignacion actualizarAsignacion(ArsvAsignacion arsvAsignacion) throws ARSVBusinessException;
	
	public ArsvAsignacion buscarAsignacion(Long idArsvAsignacion) throws ARSVBusinessException;
	
	public void eliminarAsignacion(ArsvAsignacion arsvAsignacion) throws ARSVBusinessException;

	public List<ArsvAsignacion> buscarAsignacion() throws ARSVBusinessException;
	
}
