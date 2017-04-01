package com.school.pl.controller.erp.student.error.errorhandler;

import java.util.Locale;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cglib.core.Local;
import org.springframework.context.MessageSource;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import com.school.pl.controller.erp.student.error.StudentAdmissionFieldValidationException;
import com.school.pl.rest.global.error.Code;
import com.school.pl.rest.global.error.FieldError;
import com.school.pl.rest.global.error.RestError;
import com.school.pl.rest.global.error.RestErrorMessage;

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
		restError.setMessage(messageSource.getMessage(RestErrorMessage.VALIDATION_FAILURE,null,Locale.US));
		restError.setFieldError(new FieldError(
				 messageSource.getMessage(exception.getKey(),null,Locale.US)
				,messageSource.getMessage(exception.getMsg(),null, Locale.US)));
		return restError;	
	}
	

}
