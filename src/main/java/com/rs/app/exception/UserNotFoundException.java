package com.rs.app.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * 
 * @author ramesh
 */
@ResponseStatus(code = HttpStatus.NOT_FOUND)
public class UserNotFoundException extends RuntimeException {
	private static final long serialVersionUID = 8435694854792262820L;

	public UserNotFoundException(String message) {
		super(message);
	}

	public UserNotFoundException(String message, Throwable th) {
		super(message, th);
	}
}
