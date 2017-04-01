package com.school.pl.controller.erp.employee.error.handler;

import java.util.Locale;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import com.school.pl.controller.erp.employee.error.EmployeeAlreadyRegistered;
import com.school.pl.controller.erp.employee.error.EmployeeNotFoundException;
import com.school.pl.controller.erp.employee.error.EmployeeValidationFailure;
import com.school.pl.rest.global.error.Code;
import com.school.pl.rest.global.error.FieldError;
import com.school.pl.rest.global.error.RestError;
import com.school.pl.rest.global.error.RestErrorMessage;

@ControllerAdvice
public class EmployeeExceptionHandler {
		
	private RestError restError = null;
	@Autowired
	MessageSource messageSource;
	
	@ResponseBody
	@ResponseStatus(code = HttpStatus.CONFLICT)
	@ExceptionHandler(value = EmployeeAlreadyRegistered.class)
	public RestError handleEmployeeAlreadyRegisteredException(EmployeeAlreadyRegistered exception){
		restError.setHttpStatus(messageSource.getMessage(HttpStatus.CONFLICT.toString(),null, Locale.US));
		restError.setCode(Code.FEES_NOT_PAID.toString());
		restError.setMessage(messageSource.getMessage(RestErrorMessage.ALREADY_REGISTERED, null, Locale.US));
		return restError;
	}
	
	@ResponseBody
	@ResponseStatus(code = HttpStatus.NOT_FOUND)
	@ExceptionHandler(value = EmployeeNotFoundException.class)
	public RestError handleEmployeeNotFoundException(EmployeeNotFoundException exception){
		restError.setHttpStatus(messageSource.getMessage(HttpStatus.NOT_FOUND.toString(),null, Locale.US));
		restError.setCode(Code.FEES_NOT_PAID.toString());
		restError.setMessage(messageSource.getMessage(RestErrorMessage.ALREADY_REGISTERED, null, Locale.US));
		return restError;
	}
	
	
	@ResponseStatus(code = HttpStatus.BAD_REQUEST)
	@ResponseBody
	@ExceptionHandler(value = EmployeeValidationFailure.class)
	public RestError handleEmployeeValidationFailureException(EmployeeValidationFailure exception){
		restError = new RestError();
		restError.setHttpStatus(HttpStatus.BAD_REQUEST.toString());
		restError.setCode(Code.FEES_NOT_PAID.toString());
		restError.setMessage(messageSource.getMessage(RestErrorMessage.VALIDATION_FAILURE,null,Locale.US));
		restError.setFieldError(new FieldError(
				 messageSource.getMessage(exception.getKey(),null,Locale.US)
				,messageSource.getMessage(exception.getMessage(),null, Locale.US)));
		return restError;
	}

	
}
