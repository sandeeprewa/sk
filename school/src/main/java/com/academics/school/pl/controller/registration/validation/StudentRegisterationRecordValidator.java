package com.academics.school.pl.controller.registration.validation;

import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import com.academics.school.pl.controller.registration.dto.StudentRegistrationRecord;
import com.academics.school.pl.controller.registration.error.StudentAdmissionFieldValidationException;

public class StudentRegisterationRecordValidator implements Validator{

	public boolean supports(Class<?> clazz) {
		return StudentRegistrationRecord.class.equals(clazz);
	}

	public void validate(Object target, Errors errors) {
		StudentRegistrationRecord studentAdmissionRecord = (StudentRegistrationRecord)target;
	}
	
	private void validateFirstName(String firstName){
		if(ValidationUtil.isEmpty(firstName))
		throw new StudentAdmissionFieldValidationException("firstName","firstname.invalid.message");
	}
	
	private void validateLastName(String lastName){
		if(ValidationUtil.isEmpty(lastName))
			throw new StudentAdmissionFieldValidationException("lastName","lastname.invalid.message");			
	}
}
