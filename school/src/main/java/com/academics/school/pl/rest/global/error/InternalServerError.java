package com.academics.school.pl.rest.global.error;

public class InternalServerError extends RuntimeException {
	
	public InternalServerError(String msg){
		super(msg);
	}

}
