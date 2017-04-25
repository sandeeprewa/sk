package com.academics.school.wl.security.configuration;

import java.io.Serializable;


public class User implements Serializable {
	String name;
	String message;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
}
