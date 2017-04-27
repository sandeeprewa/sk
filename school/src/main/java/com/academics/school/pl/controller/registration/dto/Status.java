package com.academics.school.pl.controller.registration.dto;

public class Status {
		
	RegistrationStatus registrationStatus;
	PaidStatus paidStatus;
	TestStatus testStatus;
	
	public RegistrationStatus getRegistrationStatus() {
		return registrationStatus;
	}
	public void setRegistrationStatus(RegistrationStatus registrationStatus) {
		this.registrationStatus = registrationStatus;
	}
	public PaidStatus getPaidStatus() {
		return paidStatus;
	}
	public void setPaidStatus(PaidStatus paidStatus) {
		this.paidStatus = paidStatus;
	}
	public TestStatus getTestStatus() {
		return testStatus;
	}
	public void setTestStatus(TestStatus testStatus) {
		this.testStatus = testStatus;
	}
	
}
