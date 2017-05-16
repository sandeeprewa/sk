package com.academics.school.pl.controller.registration.error;

public class StudentIdDoesNotFoundException extends RuntimeException {
	
	public StudentIdDoesNotFoundException(String msg){
		super(msg);
	}
}
