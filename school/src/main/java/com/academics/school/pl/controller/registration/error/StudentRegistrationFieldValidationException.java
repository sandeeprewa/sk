package com.academics.school.pl.controller.registration.error;


public class StudentRegistrationFieldValidationException extends RuntimeException {
		
	private static final long serialVersionUID = 1L;
	
	private String key;
	private String msg;
	
	public StudentRegistrationFieldValidationException(String key, String msg){
		super(msg);
		this.key = key;
		this.msg = msg;
	}

	public String getMsg() {
		return this.msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}

	public void setKey(String key) {
		this.key = key;
	}

	public String getKey() {
		return this.key;
	}
	
}
