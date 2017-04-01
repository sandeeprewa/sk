package com.school.pl.controller.erp.student.error;

public class StudentDoesNotExistException extends Exception {

	private static final long serialVersionUID = -44848021738565875L;

	StudentDoesNotExistException(String msg){
		super(msg);
	}
}
