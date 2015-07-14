package cl.dgac.arsv.dao.impl;

import java.util.List;

import javax.ejb.Stateless;
import javax.inject.Named;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import cl.dgac.arsv.dao.ArsvUsuarioDAO;
import cl.dgac.arsv.filters.FiltroArsvUsuario;
import cl.dgac.arsv.model.ArsvUsuario;
import cl.dgac.arsv.model.ArsvUsuario_;

@Stateless
@Named(value = "arsvUsuarioDAO")
public class ArsvUsuarioDAOImpl extends
		BaseDAOImpl<ArsvUsuario, Long, FiltroArsvUsuario> implements
		ArsvUsuarioDAO {

	public ArsvUsuarioDAOImpl() {
		super(ArsvUsuario.class);
	}

	@Override
	public List<ArsvUsuario> findUsuarios(FiltroArsvUsuario filtro) {
		return super.findByCriteria(filtro);
	}

	@Override
	protected CriteriaQuery<ArsvUsuario> createFilter(FiltroArsvUsuario filtro) {
		CriteriaBuilder cb = entityManager.getCriteriaBuilder();
		Predicate restricciones = null, condicion = null;

		CriteriaQuery<ArsvUsuario> cq = cb.createQuery(ArsvUsuario.class);
		Root<ArsvUsuario> usuario = cq.from(ArsvUsuario.class);
		cq.select(usuario);

		// Condiciones
		if ((filtro.getUsuario() != null)) {
			condicion = cb.equal(usuario.get(ArsvUsuario_.usuaUser),
					filtro.getUsuario());
			restricciones = condicion;
		}

		if ((filtro.getClave() != null)) {
			condicion = cb.equal(usuario.get(ArsvUsuario_.usuaClaveUser),
					filtro.getClave());

			if (restricciones == null)
				restricciones = condicion;
			else
				restricciones = cb.and(restricciones, condicion);
		}

		if (restricciones != null)
			cq.where(restricciones);

		return cq;
	}

}
