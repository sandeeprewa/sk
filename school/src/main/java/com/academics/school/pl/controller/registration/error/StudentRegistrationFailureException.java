package com.academics.school.pl.controller.registration.error;

public class StudentRegistrationFailureException extends RuntimeException {
		    
	private static final long serialVersionUID = -2355862821330332881L;

	public StudentRegistrationFailureException(String exceptionMessage){
			super(exceptionMessage);
	}
}
