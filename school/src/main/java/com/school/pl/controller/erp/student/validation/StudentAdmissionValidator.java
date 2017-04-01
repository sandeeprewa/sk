package com.school.pl.controller.erp.student.validation;

import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import com.school.pl.controller.erp.student.dto.StudentAdmissionRecord;
import com.school.pl.controller.erp.student.error.StudentAdmissionFieldValidationException;

public class StudentAdmissionValidator implements Validator{

	public boolean supports(Class<?> clazz) {
		// TODO Auto-generated method stub
		return false;
	}

	public void validate(Object target, Errors errors) {
		// TODO Auto-generated method stub
		StudentAdmissionRecord studentAdmissionRecord = (StudentAdmissionRecord)target;
		//custome validation for each validation
		validateFirstName(studentAdmissionRecord.getFirstName());
//		validateLastName();
//		validatePhoneNumber();
		
	}
	
	private void validateFirstName(String firstName){
			if(!(firstName == null || firstName == "")){
				//that's fine
			}else{
				throw new StudentAdmissionFieldValidationException("firstName","name.invalid.message");
			}
	}
}
