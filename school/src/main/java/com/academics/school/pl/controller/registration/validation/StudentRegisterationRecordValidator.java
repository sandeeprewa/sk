package com.academics.school.pl.controller.registration.validation;

import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import com.academics.school.pl.controller.registration.dto.StudentRegistrationRecord;
import com.academics.school.pl.controller.registration.error.StudentRegistrationFieldValidationException;

public class StudentRegisterationRecordValidator implements Validator{

	public boolean supports(Class<?> clazz) {
		return StudentRegistrationRecord.class.equals(clazz);
	}

	public void validate(Object target, Errors errors) {
		StudentRegistrationRecord studentAdmissionRecord = (StudentRegistrationRecord)target;
	}
	
	/*
	 * Manual validation
	 */
	public static void validate(StudentRegistrationRecord studentRegistrationRecord) throws StudentRegistrationFieldValidationException{
		
		String studentFirstName = studentRegistrationRecord.getPersonalDetail().getFirstName();
		
		if(!ValidationUtil.isEmptyOrNull(studentFirstName))
			throw new StudentRegistrationFieldValidationException("fname","input.fname.invalid");
		String email = studentRegistrationRecord.getPersonalDetail().getEmail();
		
		if(!ValidationUtil.isVaildEmail(email))
			throw new StudentRegistrationFieldValidationException("email","input.email.invalid");
		
		
	}
}
