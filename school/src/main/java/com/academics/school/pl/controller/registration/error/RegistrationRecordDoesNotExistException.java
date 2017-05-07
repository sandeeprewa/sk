package com.academics.school.pl.controller.registration.error;

public class RegistrationRecordDoesNotExistException extends RuntimeException {

	private static final long serialVersionUID = -44848021738565875L;

	public RegistrationRecordDoesNotExistException(String msg){
		super(msg);
	}
}
