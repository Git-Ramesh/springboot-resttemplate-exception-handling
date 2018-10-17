package com.rs.app.exception.handler;

import java.io.IOException;

import org.springframework.http.HttpStatus;
import org.springframework.http.client.ClientHttpResponse;
import org.springframework.stereotype.Component;
import org.springframework.web.client.ResponseErrorHandler;

import com.rs.app.exception.UserNotFoundException;
/**
 * 
 * @author ramesh
 */
//@Component
public class CustomResonseErrorHandler implements ResponseErrorHandler {

	@Override
	public boolean hasError(ClientHttpResponse response) throws IOException {
		System.out.println("CustomResonseErrorHandler#hasError");
		return (response.getStatusCode() == HttpStatus.NOT_FOUND) ? true : false;
	}

	@Override
	public void handleError(ClientHttpResponse response) throws IOException {
		System.out.println("CustomResonseErrorHandler#handleError");
		if (response.getStatusCode() == HttpStatus.NOT_FOUND) {
			throw new UserNotFoundException("Unable to find requested user");
		}
	}

}
