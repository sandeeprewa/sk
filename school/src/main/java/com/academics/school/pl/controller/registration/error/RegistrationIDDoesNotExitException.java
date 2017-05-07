package com.academics.school.pl.controller.registration.error;

public class RegistrationIDDoesNotExitException extends RuntimeException {
	public RegistrationIDDoesNotExitException(String msg){
		super(msg);
	}
}
