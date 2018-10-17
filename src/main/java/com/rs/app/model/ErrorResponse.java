package com.rs.app.model;

import java.io.Serializable;

/**
 * 
 * @author ramesh
 */
public class ErrorResponse implements Serializable {
	private static final long serialVersionUID = 6510233923422837788L;
	private long timestamp;
	private String message;
	private String error;
	private String path;

	public long getTimestamp() {
		return timestamp;
	}

	public void setTimestamp(long timestamp) {
		this.timestamp = timestamp;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public String getError() {
		return error;
	}

	public void setError(String error) {
		this.error = error;
	}

	public String getPath() {
		return path;
	}

	public void setPath(String path) {
		this.path = path;
	}
}
