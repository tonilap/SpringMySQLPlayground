package com.toni.playground.dao.exception;

/**
 * @author tonilap
 *
 * Exception thrown when the entity to save already exists
 */
@SuppressWarnings("serial")
public class AlreadyExistsDAOException extends Exception {

	public AlreadyExistsDAOException() {
		super();
		// TODO Auto-generated constructor stub
	}

	public AlreadyExistsDAOException(String message, Throwable cause,
			boolean enableSuppression, boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
		// TODO Auto-generated constructor stub
	}

	public AlreadyExistsDAOException(String message, Throwable cause) {
		super(message, cause);
		// TODO Auto-generated constructor stub
	}

	public AlreadyExistsDAOException(String message) {
		super(message);
		// TODO Auto-generated constructor stub
	}

	public AlreadyExistsDAOException(Throwable cause) {
		super(cause);
		// TODO Auto-generated constructor stub
	}
}
