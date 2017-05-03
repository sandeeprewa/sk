package com.academics.school.pl.controller.classallocation.error;

public class StudentClassAllocationFieldValidationException extends Exception {
	
	private static final long serialVersionUID = -159250513752888972L;
	private String key;
	private String msg;
	
	public StudentClassAllocationFieldValidationException(String key, String msg){
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
