package com.academics.school.pl.controller.classallocation.error;

public class StudentClassWithSubjectDoesNotExistException extends Exception{


	private static final long serialVersionUID = -7139263159079381047L;

	StudentClassWithSubjectDoesNotExistException(String msg){
		 super(msg);
	}
}
