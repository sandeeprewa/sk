package com.school.pl.controller.erp.student.error;

public class StudentAlreadyRegisteredException extends RuntimeException {
	
	private static final long serialVersionUID = 2760617494147468782L;

	StudentAlreadyRegisteredException(String msg){
		 super(msg);
	}

}
