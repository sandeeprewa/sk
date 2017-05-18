package com.academics.school.pl.controller.classallocation.error;

public class StudentAlreadyAllocatedException extends Exception {


	private static final long serialVersionUID = 7525020715740080687L;

	StudentAlreadyAllocatedException(String msg){
		 super(msg);
	}
}
