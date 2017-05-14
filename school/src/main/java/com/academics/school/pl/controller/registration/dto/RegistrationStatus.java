package com.academics.school.pl.controller.registration.dto;

public enum RegistrationStatus {

	UNPAID_SUBMISSION("unpaidSubmission"),
	ACCEPTED("accepted"),
	SELECTED_FOR_TEST("selected_for_test"),
	PASS("pass"),
	FAIL("fail"),
	SELECTED_FOR_ADMISSION("selected_for_admission"),
	PAID_SUBMISSION("paidSubmission"),
	PAID_ADMISSION_FEE("paidForAdmission"),
	
	ADMITTED("admitted");

	RegistrationStatus(){}
	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	private String status;
	
	RegistrationStatus(String status){
		this.status = status;
	}
	
	public static RegistrationStatus getEnum(String status){
		for(RegistrationStatus enumInstance : values()){
			if(status.equals(enumInstance.toString())){
				return enumInstance;
			}
		}
		throw new IllegalArgumentException("input.invalid.status");
	}
	
	@Override
	public String toString(){
		return this.status;
	}
	
}
