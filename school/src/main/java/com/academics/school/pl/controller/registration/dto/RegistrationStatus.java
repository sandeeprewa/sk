package com.academics.school.pl.controller.registration.dto;

public enum RegistrationStatus {
	
	SUBMITTED("submitted"),
	NEED_UPDATE("need_update"),
	UPDATED("updated"),
	ACCEPTED("accepted"),
	WAITING("waiting"),
	SELECTEDFORTEST("selectedfortest"),
	SELECTEDFORADMISSION("selectedforadmission");

	private String status;
	
	 RegistrationStatus(String status){
		this.status = status;
	}
	
}
