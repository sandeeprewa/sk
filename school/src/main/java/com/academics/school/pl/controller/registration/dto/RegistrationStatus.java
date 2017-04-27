package com.academics.school.pl.controller.registration.dto;

public enum RegistrationStatus {
	
	SUBMITTED("submitted"),
	NEED_UPDATE("need_update"),
	UPDATED("updated"),
	ACCEPTED("accepted"),
	WAITING("waiting"),
	SELECTED_FOR_TEST("selected_for_test"),
	SELECTED_FOR_ADMISSION("selected_for_admission"),
	PAID("paid"),
	UNPAID("unpaid"),
	ATTEMPTED("attempted"),
	NOT_ATTEMPTED("not_attempted"),
	PASS("pass"),
	FAIL("fail");
	
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
