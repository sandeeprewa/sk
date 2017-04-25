package com.academics.school.pl.controller.erp.employee.error;

public class EmployeeAlreadyRegistered extends RuntimeException {
		
	public EmployeeAlreadyRegistered(String msg) {
		super(msg);
	}
}
