package com.toni.playground.dao.exception;

/**
 * @author tonilap
 *
 * Exception thrown when an attempt to create a new data entity produces an unexpected data access error
 */
@SuppressWarnings("serial")
public class CreateDAOException extends Exception {

	public CreateDAOException() {
		super();
		// TODO Auto-generated constructor stub
	}

	public CreateDAOException(String message, Throwable cause,
			boolean enableSuppression, boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
		// TODO Auto-generated constructor stub
	}

	public CreateDAOException(String message, Throwable cause) {
		super(message, cause);
		// TODO Auto-generated constructor stub
	}

	public CreateDAOException(String message) {
		super(message);
		// TODO Auto-generated constructor stub
	}

	public CreateDAOException(Throwable cause) {
		super(cause);
		// TODO Auto-generated constructor stub
	}
}
