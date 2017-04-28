package com.academics.school.pl.controller.admission.error;

public class StudentAlredyAdmittedException extends Exception{

	private static final long serialVersionUID = 9128833243342984880L;

	StudentAlredyAdmittedException(String msg){
		super(msg);
	}
}
