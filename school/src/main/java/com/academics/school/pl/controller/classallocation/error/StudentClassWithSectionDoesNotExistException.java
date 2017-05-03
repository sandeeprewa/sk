package com.academics.school.pl.controller.classallocation.error;

public class StudentClassWithSectionDoesNotExistException extends Exception{


	
	private static final long serialVersionUID = 7524111740196814065L;

	StudentClassWithSectionDoesNotExistException(String msg){
		 super(msg);
	}
}
