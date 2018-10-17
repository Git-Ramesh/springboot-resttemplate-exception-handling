package com.rs.app.exception.handler;

import java.util.Date;

import javax.servlet.http.HttpServletRequest;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.rs.app.exception.UserNotFoundException;
import com.rs.app.model.ErrorResponse;

/**
 * 
 * @author ramesh
 */
@ControllerAdvice
@RequestMapping(produces = "application/vnd.error+json")
public class ApplicationExceptionHandler extends ResponseEntityExceptionHandler {

	@ExceptionHandler(UserNotFoundException.class)
	public ResponseEntity<ErrorResponse> handleUserNotFoundException(UserNotFoundException unfe,
			HttpServletRequest httpReq) {
		ErrorResponse errorResponse = new ErrorResponse();
		errorResponse.setTimestamp(new Date().getTime());
		errorResponse.setMessage(unfe.getMessage());
		errorResponse.setError("Not Found");
		errorResponse.setPath(httpReq.getRequestURI());
		return new ResponseEntity<>(errorResponse, HttpStatus.NOT_FOUND);
	}
}
