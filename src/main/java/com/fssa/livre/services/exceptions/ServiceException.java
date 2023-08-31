package com.fssa.livre.services.exceptions;

public class ServiceException extends Exception {
       /**
	 * 
	 */
	private static final long serialVersionUID = 7946960957884390430L;
	public ServiceException(String msg) {
    	   super(msg);
       }
       public ServiceException(Throwable ex) {
    	   super(ex);
       }

}
 