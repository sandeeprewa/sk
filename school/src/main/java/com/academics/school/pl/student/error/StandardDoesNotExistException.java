package com.academics.school.pl.student.error;

public class StandardDoesNotExistException extends RuntimeException {
	
	StandardDoesNotExistException(String msg){
		super(msg);
	}
}
