package com.academics.school.pl.rest.global.error;

import java.util.List;

import org.springframework.http.HttpStatus;

public class RestError {
	
	private String httpStatus;
	private String  code;
	private String message;
	private FieldError fieldError;
	
	public FieldError getFieldError() {
		return fieldError;
	}
	public void setFieldError(FieldError fieldError) {
		this.fieldError = fieldError;
	}
	public String getHttpStatus() {
		return httpStatus;
	}
	public void setHttpStatus(String httpStatus) {
		this.httpStatus = httpStatus;
	}
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
}
