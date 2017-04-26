package com.academics.school.pl.controller.registration.error;

public class RegistrationRecordDoesNotExistException extends Exception {

	private static final long serialVersionUID = -44848021738565875L;

	RegistrationRecordDoesNotExistException(String msg){
		super(msg);
	}
}
