package com.academics.school.pl.controller.classallocation.error;

public class StudentSectionDoesNotExistException extends Exception{


	private static final long serialVersionUID = -262077200112384465L;

	StudentSectionDoesNotExistException(String msg){
		 super(msg);
	}
}
