package com.academics.school.pl.controller.registration.dto;

import javax.persistence.Embeddable;
import javax.persistence.Entity;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonCreator;

public enum Gender {
	
	M("male"),
	F("female"),
	X("transgender"),
	U("unknown");
	
	private String genderValue ;
	
	Gender(){}
	
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
	public static Gender getEnumFromText(String genderValue1){
		for (Gender genderValue : Gender.values()) {
			if(genderValue.getName().equals(genderValue1)){
				return genderValue;
			}
		}
		throw new IllegalArgumentException();
	}
}
