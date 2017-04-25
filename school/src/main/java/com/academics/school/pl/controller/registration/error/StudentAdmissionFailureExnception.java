package com.academics.school.pl.controller.registration.error;

public class StudentAdmissionFailureExnception extends RuntimeException {
		    
	private static final long serialVersionUID = -2355862821330332881L;

	public StudentAdmissionFailureExnception(String exceptionMessage){
			super(exceptionMessage);
	}
}
