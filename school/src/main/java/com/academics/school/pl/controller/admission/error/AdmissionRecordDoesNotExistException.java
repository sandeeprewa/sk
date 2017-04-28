package com.academics.school.pl.controller.admission.error;

public class AdmissionRecordDoesNotExistException extends Exception{

	private static final long serialVersionUID = -1162193307499708345L;

	AdmissionRecordDoesNotExistException(String msg){
		super(msg);
	}
}
