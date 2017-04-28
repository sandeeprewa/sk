package com.academics.school.pl.controller.admission.error;

public class StudentAdmissionFieldValidationException extends RuntimeException{
	
private static final long serialVersionUID = 1L;
	
	private String key;
	private String msg;
	
	public StudentAdmissionFieldValidationException(String key, String msg){
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
