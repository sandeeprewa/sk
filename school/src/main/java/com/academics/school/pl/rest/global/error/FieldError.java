package com.academics.school.pl.rest.global.error;

public class FieldError {
		
	private String field ;
	private String message;
	
	public FieldError(String field, String message){
		this.field = field;
		this.message = message;
	}
	
	public void setField(String field){
		this.field = field;
	}
	
	public String getField(){
		return this.field;
	}
	
	public void setMessage(String message){
		this.message = message;
	}
	
	public String getMessage(){
		return this.message;
	}
}
