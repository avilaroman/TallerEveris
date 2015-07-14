package cl.dgac.arsv.dao;

import java.util.List;

import cl.dgac.arsv.filters.FiltroArsvMotivoExtension;
import cl.dgac.arsv.model.ArsvMotivoExtension;
import cl.seis.generic.dao.GenericDAO;


public interface ArsvMotivoExtensionDAO extends GenericDAO<ArsvMotivoExtension, Long, FiltroArsvMotivoExtension> {
	public List<ArsvMotivoExtension> findMotivosExtension(FiltroArsvMotivoExtension filtro);
}
