package cl.seis.generic.filters;

import java.io.Serializable;
import java.util.List;

import javax.persistence.criteria.Order;

public abstract class GenericFilter<E> implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 380158356296251789L;

	protected List<Order> orderBy;
	
	public GenericFilter() {
		super();
		
		this.orderBy = null;
	}

	public abstract void clean();

	public List<Order> getOrderBy() {
		return orderBy;
	}

	public void setOrderBy(List<Order> orderBy) {
		this.orderBy = orderBy;
	}
	
}
