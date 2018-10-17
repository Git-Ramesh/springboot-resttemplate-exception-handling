package com.rs.app.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.BAD_REQUEST)
public class InvalidUserNameException extends RuntimeException {
	private static final long serialVersionUID = 5584787843273404169L;

	public InvalidUserNameException(String message) {
		super(message);
	}

	public InvalidUserNameException(String message, Throwable th) {
		super(message, th);
	}
}
