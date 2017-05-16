package com.academics.school.pl.controller.attendence.dto;

public enum AttendenceStatus {
		
	PRESENT("present"),
	ABSENT("absent");
	
	private String val ;
	
	AttendenceStatus(String msg){
		this.val = msg;
	}
	
	public String getValue(){
		return this.val;
	}
	
}
