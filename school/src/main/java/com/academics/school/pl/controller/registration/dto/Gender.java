package com.academics.school.pl.controller.registration.dto;

import com.fasterxml.jackson.annotation.JsonCreator;

public enum Gender {
	M("male"),
	F("female"),
	X("transgender"),
	U("unknown");
	
	private String genderValue ;
	
	Gender(String value){
		this.genderValue = value;
	}
	
	@Override
	public String toString(){
		return this.genderValue;
	}
	
	public String getName(){
		return this.genderValue;
	}
	
	@JsonCreator
	public static Gender getGenderFromText(String genderValue1){
		for (Gender genderValue : Gender.values()) {
			if(genderValue.getName().equals(genderValue1)){
				return genderValue;
			}
		}
		throw new IllegalArgumentException();
	}
}
