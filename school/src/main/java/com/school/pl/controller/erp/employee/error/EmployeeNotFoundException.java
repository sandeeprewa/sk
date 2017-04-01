package com.school.pl.controller.erp.employee.error;

public class EmployeeNotFoundException extends RuntimeException {
		
	public EmployeeNotFoundException(String msg) {
		super(msg);
	}
}
