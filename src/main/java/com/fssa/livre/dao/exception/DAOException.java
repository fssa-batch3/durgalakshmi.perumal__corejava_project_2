package com.fssa.livre.dao.exception;

public class DAOException extends Exception{

		 /**
	 * 
	 */
	private static final long serialVersionUID = 893082008256472663L;

		public DAOException(String msg) {
		        super(msg);
		    }
		 
		 public DAOException(Throwable ex) {
		        super(ex);
		    }

	}


