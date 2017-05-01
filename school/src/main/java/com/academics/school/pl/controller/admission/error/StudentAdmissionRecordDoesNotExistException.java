package com.academics.school.pl.controller.admission.error;

public class StudentAdmissionRecordDoesNotExistException extends Exception{

	private static final long serialVersionUID = -1162193307499708345L;

	StudentAdmissionRecordDoesNotExistException(String msg){
		super(msg);
	}
}
