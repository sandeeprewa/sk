package com.academics.school.pl.controller.erp.employee.validation;

import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import com.academics.school.pl.controller.erp.employee.dto.EmployeeRecord;

public class EmployeeAdmissionValidator implements Validator {

	public boolean supports(Class<?> clazz) {
		// TODO Auto-generated method stub
		return EmployeeRecord.class.equals(clazz);
	}

	public void validate(Object target, Errors errors) {
		EmployeeRecord record = (EmployeeRecord)target;
		//validation
	}

}
