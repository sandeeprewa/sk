package com.school.pl.controller.erp.employee.dto;

import com.fasterxml.jackson.annotation.JsonCreator;

public enum Graduation {

	BSCIT("BSC(IT)"),
	BSCCS("BSC(CS)"),
	BSCPCM("BSC(PCM)"),
	OTHER("other");
	
	private String degreeValue ;
	
	Graduation(String value){
		this.degreeValue = value;
	}
	
	@Override
	public String toString(){
		return this.degreeValue;
	}
	
	public String getName(){
		return this.degreeValue;
	}
	
	@JsonCreator
	public static Graduation getGraduationFromText(String degreeValue1){
		for (Graduation degreeValue : Graduation.values()) {
			if(degreeValue.getName().equals(degreeValue1)){
				return degreeValue;
			}
		}
		throw new IllegalArgumentException();
	}

}
