package com.academics.school.pl.controller.registration.dto;

public enum TestStatus {
	
	ATTEMPTED("attempted"),
	NOT_ATTEMPTED("not_attempted"),
	PASS("pass"),
	FAIL("fail");
	
	private String status;
	
	TestStatus(String status){
		this.status = status;
	}
}
