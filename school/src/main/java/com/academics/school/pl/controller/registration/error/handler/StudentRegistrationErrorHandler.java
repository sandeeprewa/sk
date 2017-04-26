package com.academics.school.pl.controller.registration.error.handler;

import java.util.Locale;

import javax.validation.ConstraintViolationException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import com.academics.school.pl.controller.registration.error.StudentAdmissionFieldValidationException;
import com.academics.school.pl.controller.registration.error.StudentAlreadyRegisteredException;
import com.academics.school.pl.controller.registration.error.StudentDoesNotExistException;
import com.academics.school.pl.controller.registration.error.StudentIDEditException;
import com.academics.school.pl.controller.registration.error.StudentIdDoesNotExistException;
import com.academics.school.pl.rest.global.error.Code;
import com.academics.school.pl.rest.global.error.FieldError;
import com.academics.school.pl.rest.global.error.RestError;
import com.academics.school.pl.rest.global.error.RestErrorMessage;

@ControllerAdvice
public class StudentRegistrationErrorHandler {
	
	private RestError restError = null;

	@Autowired
	MessageSource messageSource;
	
	@ResponseBody
	@ExceptionHandler(value = StudentAdmissionFieldValidationException.class)
	@ResponseStatus(code = HttpStatus.BAD_REQUEST)
	public RestError handleStudentAdmissionFieldValidationException(StudentAdmissionFieldValidationException exception){
		restError = new RestError();
		restError.setHttpStatus(HttpStatus.BAD_REQUEST.toString());
		restError.setCode(Code.FEES_NOT_PAID.toString());
		restError.setMessage(messageSource.getMessage(RestErrorMessage.VALIDATION_FAILURE,null,Locale.US));
		restError.setFieldError(new FieldError(
				 messageSource.getMessage(exception.getKey(),null,Locale.US)
				,messageSource.getMessage(exception.getMsg(),null, Locale.US)));
		return restError;	
	}
	
	@ResponseBody
	@ExceptionHandler(value = StudentAdmissionFieldValidationException.class)
	@ResponseStatus(code = HttpStatus.BAD_REQUEST)
	public RestError handleStudentAdmissionFailureExnception(StudentAdmissionFieldValidationException exception){
		restError = new RestError();
		restError.setHttpStatus(HttpStatus.BAD_REQUEST.toString());
		restError.setCode(Code.FEES_NOT_PAID.toString());
		restError.setMessage(messageSource.getMessage(RestErrorMessage.ADMISSION_FAILURE, null, Locale.US));
		return restError;
	}
	
	@ResponseBody
	@ExceptionHandler(value = StudentAlreadyRegisteredException.class)
	@ResponseStatus
	public RestError handleStudentAlreadyRegisteredException(StudentAlreadyRegisteredException exception){
		restError = new RestError();
		restError.setHttpStatus(HttpStatus.CONFLICT.toString());
		restError.setCode(Code.FEES_NOT_PAID.toString());
		restError.setMessage(messageSource.getMessage(RestErrorMessage.ALREADY_REGISTERED, null, Locale.US));
		return restError;
	}
	
	@ResponseBody
	@ExceptionHandler(value = StudentIDEditException.class)
	@ResponseStatus(code=HttpStatus.BAD_REQUEST)
	public RestError handleStudentIDEditException(StudentIDEditException exception) {
		restError = new RestError();
		restError.setHttpStatus(HttpStatus.BAD_REQUEST.toString());
		restError.setCode(Code.FEES_NOT_PAID.toString());
		restError.setMessage(messageSource.getMessage(RestErrorMessage.UNEDITABLE_FIELD, null, Locale.US));
		return restError;
	}
	
	@ResponseBody
	@ExceptionHandler(value = StudentIdDoesNotExistException.class)
	@ResponseStatus(code = HttpStatus.NOT_FOUND)
	public RestError handleStudentIdDoesNotExistException(StudentIdDoesNotExistException exception){
		restError = new RestError();
		restError.setHttpStatus(HttpStatus.NOT_FOUND.toString());
		restError.setCode(Code.FEES_NOT_PAID.toString());
		restError.setMessage(messageSource.getMessage(RestErrorMessage.STUDENT_DOES_NOT_EXIST, null, Locale.US));
		return restError;
	}
	
	@ResponseBody
	@ExceptionHandler(value = StudentDoesNotExistException.class)
	@ResponseStatus(code = HttpStatus.NOT_FOUND)
	public RestError handleStudentDoesNotExistException(StudentDoesNotExistException exception){
		restError = new RestError();
		restError.setHttpStatus(HttpStatus.NOT_FOUND.toString());
		restError.setCode(Code.FEES_NOT_PAID.toString());
		restError.setMessage(messageSource.getMessage(RestErrorMessage.STUDENT_DOES_NOT_EXIST, null, Locale.US));
		return restError;
	}

	@ResponseBody
	@ExceptionHandler(value = ConstraintViolationException.class)
	@ResponseStatus(code = HttpStatus.BAD_REQUEST)
	public RestError handleConstraintViloationException(ConstraintViolationException e){
		restError = new RestError();
		restError.setHttpStatus(HttpStatus.BAD_REQUEST.toString());
		restError.setCode(Code.FEES_NOT_PAID.toString());
		restError.setMessage(messageSource.getMessage(RestErrorMessage.INPUT_IS_INVALID, null, Locale.US));
		return restError;
	}
}
