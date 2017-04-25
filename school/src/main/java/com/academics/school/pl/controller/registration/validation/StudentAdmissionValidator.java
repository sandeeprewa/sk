package com.academics.school.pl.controller.registration.validation;

import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import com.academics.school.pl.controller.registration.dto.StudentAdmissionRecord;
import com.academics.school.pl.controller.registration.error.StudentAdmissionFieldValidationException;

public class StudentAdmissionValidator implements Validator{

	public boolean supports(Class<?> clazz) {
		return StudentAdmissionRecord.class.equals(clazz);
	}

	public void validate(Object target, Errors errors) {
		StudentAdmissionRecord studentAdmissionRecord = (StudentAdmissionRecord)target;
//		validateFirstName(studentAdmissionRecord.getFirstName());
//		validateLastName(studentAdmissionRecord.getLastName());
		//further can be implemented
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