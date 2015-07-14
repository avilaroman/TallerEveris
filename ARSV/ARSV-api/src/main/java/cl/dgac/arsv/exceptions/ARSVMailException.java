package cl.dgac.arsv.exceptions;

import javax.ejb.ApplicationException;

@ApplicationException(rollback = false)
public class ARSVMailException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = -1417689413008500683L;

	public ARSVMailException(String msg) {
		super(msg);
	}	
	
}
