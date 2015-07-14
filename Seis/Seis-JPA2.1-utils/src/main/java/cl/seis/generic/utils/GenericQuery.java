package cl.seis.generic.utils;

import java.io.Serializable;
import java.util.List;

import javax.persistence.criteria.Order;
import javax.persistence.criteria.Predicate;

public class GenericQuery implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -9138859961176098271L;

	private Predicate conditions;
	private List<Order> orderBy;

	public GenericQuery() {
		super();
	}

	public Predicate getConditions() {
		return conditions;
	}

	public void setConditions(Predicate conditions) {
		this.conditions = conditions;
	}

	public List<Order> getOrderBy() {
		return orderBy;
	}

	public void setOrderBy(List<Order> orderBy) {
		this.orderBy = orderBy;
	}

}
