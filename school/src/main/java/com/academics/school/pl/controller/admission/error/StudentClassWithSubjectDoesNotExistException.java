package com.academics.school.pl.controller.admission.error;

public class StudentClassWithSubjectDoesNotExistException extends Exception {


	private static final long serialVersionUID = -6862915326631475118L;

	StudentClassWithSubjectDoesNotExistException(String msg){
		super(msg);
	}
}
