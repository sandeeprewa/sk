package com.academics.school.pl.controller.admission.error.handler;

import java.util.Locale;

import javax.validation.ConstraintViolationException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import com.academics.school.pl.controller.admission.error.StudentAlredyAdmittedException;

import com.academics.school.pl.controller.admission.error.StudentAdmissionRecordDoesNotExistException;
import com.academics.school.pl.controller.admission.error.StudentAlredyAdmittedException;
import com.academics.school.pl.controller.admission.error.StudentAdmissionIDEditException;
import com.academics.school.pl.controller.admission.error.SutdentAdmissionIdDoesNotExistException;
import com.academics.school.pl.controller.admission.error.StudentAdmissionFieldValidationException;
import com.academics.school.pl.rest.global.error.Code;
import com.academics.school.pl.rest.global.error.FieldError;
import com.academics.school.pl.rest.global.error.RestError;
import com.academics.school.pl.rest.global.error.RestErrorMessage;

@ControllerAdvice
public class StudentAdmissionErrorHandler {
	
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
		restError.setMessage(messageSource.getMessage(RestErrorMessage.VALIDATION_FAILURE,null, Locale.US));
		restError.setFieldError(new FieldError(exception.getKey(),messageSource.getMessage(exception.getMsg(),null, Locale.US)));
		return restError;	
	}
	
	/**
	 * @param exception
	 * @return
	 */
	@ResponseBody
	@ExceptionHandler(value = StudentAlredyAdmittedException.class)
	@ResponseStatus
	public RestError handleStudentAlreadyAdmittedException(StudentAlredyAdmittedException exception){
		restError = new RestError();
		restError.setHttpStatus(HttpStatus.CONFLICT.toString());
		restError.setCode(Code.FEES_NOT_PAID.toString());
		restError.setMessage(messageSource.getMessage(RestErrorMessage.ALREADY_ADMITTED, null, Locale.US));
		return restError;
	}
	
	@ResponseBody
	@ExceptionHandler(value = StudentAdmissionIDEditException.class)
	@ResponseStatus(code=HttpStatus.BAD_REQUEST)
	public RestError handleStudentIDEditException(StudentAdmissionIDEditException exception) {
		restError = new RestError();
		restError.setHttpStatus(HttpStatus.BAD_REQUEST.toString());
		restError.setCode(Code.FEES_NOT_PAID.toString());
		restError.setMessage(messageSource.getMessage(RestErrorMessage.UNEDITABLE_FIELD, null, Locale.US));
		return restError;
	}
	
	@ResponseBody
	@ExceptionHandler(value = SutdentAdmissionIdDoesNotExistException.class)
	@ResponseStatus(code = HttpStatus.NOT_FOUND)
	public RestError handleStudentIdDoesNotExistException(SutdentAdmissionIdDoesNotExistException exception){
		restError = new RestError();
		restError.setHttpStatus(HttpStatus.NOT_FOUND.toString());
		restError.setCode(Code.FEES_NOT_PAID.toString());
		restError.setMessage(messageSource.getMessage(RestErrorMessage.STUDENT_DOES_NOT_EXIST, null, Locale.US));
		return restError;
	}
	
	@ResponseBody
	@ExceptionHandler(value = StudentAdmissionRecordDoesNotExistException.class)
	@ResponseStatus(code = HttpStatus.NOT_FOUND)
	public RestError handleStudentDoesNotExistException(StudentAdmissionRecordDoesNotExistException exception){
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
