package com.academics.school.pl.controller.admission.error;

import javassist.SerialVersionUID;

public class SutdentAdmissionIdDoesNotExistException extends RuntimeException{

	private static final long serialVersionUID = 5285749417890968261L;

	SutdentAdmissionIdDoesNotExistException(String msg) {
		super(msg);
	}
}
