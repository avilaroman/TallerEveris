package cl.dgac.arsv.dao;

import java.util.List;

import cl.dgac.arsv.filters.FiltroSolicitudArriboSobrevuelo;
import cl.dgac.arsv.model.SolicitudArriboSobrevuelo;
import cl.seis.generic.dao.GenericDAO;



public interface ArsvSolicitudArriboSobrevueloDAO extends GenericDAO<SolicitudArriboSobrevuelo, Long, FiltroSolicitudArriboSobrevuelo> {
	public List<SolicitudArriboSobrevuelo> findSolicitudArriboSobrevuelo(FiltroSolicitudArriboSobrevuelo filtro);
}
