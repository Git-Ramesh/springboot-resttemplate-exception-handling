package com.rs.app.model;

import java.io.Serializable;

public class User implements Serializable {
	private static final long serialVersionUID = -4375737291842665877L;
	private String username;
	private String email;

	public User() {
	}

	public User(String username, String email) {
		super();
		this.username = username;
		this.email = email;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
}
