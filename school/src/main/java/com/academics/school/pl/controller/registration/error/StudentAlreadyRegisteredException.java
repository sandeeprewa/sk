package com.academics.school.pl.controller.registration.error;

public class StudentAlreadyRegisteredException extends RuntimeException {
	
	private static final long serialVersionUID = 2760617494147468782L;

	public StudentAlreadyRegisteredException(String msg){
		 super(msg);
	}

}
