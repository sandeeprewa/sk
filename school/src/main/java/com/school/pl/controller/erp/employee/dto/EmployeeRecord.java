package com.school.pl.controller.erp.employee.dto;

import org.springframework.web.multipart.MultipartFile;

public class EmployeeRecord {

	private String employeeName;
	private MultipartFile file1;
	
	public String getEmployeeName() {
		return employeeName;
	}
	public void setEmployeeName(String employeeName) {
		this.employeeName = employeeName;
	}
	public MultipartFile getFile1() {
		return file1;
	}
	public void setFile1(MultipartFile file1) {
		this.file1 = file1;
	}
	
}
