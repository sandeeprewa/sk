package com.school.pl.controller.erp.student.dto;

import com.fasterxml.jackson.annotation.JsonCreator;

public enum Religion {

	H("hindu"),
	M("muslim"),
	S("sikh"),
	I("isai"),
	OTHER("other");
	
	private String religionValue ;
	
	Religion(String value){
		this.religionValue = value;
	}
	
	@Override
	public String toString(){
		return this.religionValue;
	}
	
	public String getName(){
		return this.religionValue;
	}
	
	@JsonCreator
	public static Religion getReligionFromText(String religionValue1){
		for (Religion religionValue : Religion.values()) {
			if(religionValue.getName().equals(religionValue1)){
				return religionValue;
			}
		}
		throw new IllegalArgumentException();
	}

}
