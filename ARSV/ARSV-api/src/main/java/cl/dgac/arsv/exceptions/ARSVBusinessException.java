package cl.dgac.arsv.exceptions;

import javax.ejb.ApplicationException;

@ApplicationException(rollback=true)
public class ARSVBusinessException extends Exception {
	/**
	 * 
	 */
	private static final long serialVersionUID = 2092255202329450828L;

	public ARSVBusinessException(String msg){
		super(msg);
	}
}
