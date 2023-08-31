package com.fssa.livre.validation.exceptions;

public class InvalidBooksException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public InvalidBooksException(String msg) {
		super(msg);
	}
	
	public InvalidBooksException(Throwable ex) {
		super(ex);
	}
	
	
}
