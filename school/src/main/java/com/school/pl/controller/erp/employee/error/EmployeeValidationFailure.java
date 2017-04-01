package com.school.pl.controller.erp.employee.error;

public class EmployeeValidationFailure extends RuntimeException {

	private static final long serialVersionUID = 6805155095581620648L;
	private String key;
	private String message;
	

	public EmployeeValidationFailure(String msg) {
		super(msg);
	}
	
	public String getKey() {
		return key;
	}

	public void setKey(String key) {
		this.key = key;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

}
