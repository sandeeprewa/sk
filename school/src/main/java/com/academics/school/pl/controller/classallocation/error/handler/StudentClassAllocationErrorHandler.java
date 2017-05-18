package com.academics.school.pl.controller.classallocation.error.handler;

import java.util.Locale;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import com.academics.school.pl.controller.classallocation.error.StudentClassWithSubjectDoesNotExistException;
import com.academics.school.pl.controller.classallocation.error.SectionAlredyExistException;
import com.academics.school.pl.controller.classallocation.error.StudentAlreadyAllocatedException;
import com.academics.school.pl.controller.classallocation.error.StudentClassAllocationFieldValidationException;
import com.academics.school.pl.controller.classallocation.error.StudentClassWithSectionDoesNotExistException;
import com.academics.school.pl.controller.classallocation.error.StudentSectionWithClassRequireException;
import com.academics.school.pl.rest.global.error.Code;
import com.academics.school.pl.rest.global.error.FieldError;
import com.academics.school.pl.rest.global.error.RestError;
import com.academics.school.pl.rest.global.error.RestErrorMessage;

@ControllerAdvice
public class StudentClassAllocationErrorHandler {
	
	private RestError restError = null;

	@Autowired
	MessageSource messageSource;
	
	@ResponseBody
	@ExceptionHandler(value = StudentClassAllocationFieldValidationException.class)
	@ResponseStatus(code = HttpStatus.BAD_REQUEST)
	public RestError handleStudentClassAllocationFieldValidationException(StudentClassAllocationFieldValidationException exception){
		restError = new RestError();
		restError.setHttpStatus(HttpStatus.BAD_REQUEST.toString());
		restError.setCode(Code.FEES_NOT_PAID.toString());
		restError.setMessage(messageSource.getMessage(RestErrorMessage.VALIDATION_FAILURE,null, Locale.US));
//		restError.setFieldError(new FieldError(exception.getKey(),messageSource.getMessage(exception.getMsg(),null, Locale.US)));
		return restError;	
	}
	
	@ResponseBody
	@ExceptionHandler(value = StudentAlreadyAllocatedException.class)
	@ResponseStatus
	public RestError handleStudentAlreadyAllocatedException(StudentAlreadyAllocatedException exception){
		restError = new RestError();
		restError.setHttpStatus(HttpStatus.CONFLICT.toString());
		restError.setCode(Code.FEES_NOT_PAID.toString());
		restError.setMessage(messageSource.getMessage(RestErrorMessage.ALREADY_ALLOCATED, null, Locale.US));
		return restError;
	}
	
	//SectionAlredyExistException
	
	@ResponseBody
	@ExceptionHandler(value = SectionAlredyExistException.class)
	@ResponseStatus
	public RestError handleSectionAlredyExistException(SectionAlredyExistException exception){
		restError = new RestError();
		restError.setHttpStatus(HttpStatus.CONFLICT.toString());
		restError.setCode(Code.FEES_NOT_PAID.toString());
		restError.setMessage(messageSource.getMessage(RestErrorMessage.SECTION_ALREADY_EXIST, null, Locale.US));
		return restError;
	}
	
	@ResponseBody
	@ExceptionHandler(value = StudentClassWithSectionDoesNotExistException.class)
	@ResponseStatus
	public RestError handleClassWithSectionDoesNotExistException(StudentClassWithSectionDoesNotExistException exception){
		restError = new RestError();
		restError.setHttpStatus(HttpStatus.CONFLICT.toString());
		restError.setCode(Code.FEES_NOT_PAID.toString());
		restError.setMessage(messageSource.getMessage(RestErrorMessage.CLASSWITHSECTION_DOES_NOT_EXIST, null, Locale.US));
		return restError;
	}
		
	@ResponseBody
	@ExceptionHandler(value = StudentClassWithSubjectDoesNotExistException.class)
	@ResponseStatus(code = HttpStatus.NOT_FOUND)
	public RestError handleStudentClassWithSubjectDoesNotExistException(StudentClassWithSubjectDoesNotExistException exception){
		restError = new RestError();
		restError.setHttpStatus(HttpStatus.NOT_FOUND.toString());
		restError.setCode(Code.FEES_NOT_PAID.toString());
		restError.setMessage(messageSource.getMessage(RestErrorMessage.CLASSWITHSUBJECT_DOES_NOT_EXIST, null, Locale.US));
		return restError;
	}
	
	@ResponseBody
	@ExceptionHandler(value = StudentSectionWithClassRequireException.class)
	@ResponseStatus(code = HttpStatus.NOT_FOUND)
	public RestError handleSectionWithClassRequireException(StudentSectionWithClassRequireException exception){
		restError = new RestError();
		restError.setHttpStatus(HttpStatus.NOT_FOUND.toString());
		restError.setCode(Code.FEES_NOT_PAID.toString());
		restError.setMessage(messageSource.getMessage(RestErrorMessage.SECTIONWITHCLASS_REQUIRE, null, Locale.US));
		return restError;
	}
}

