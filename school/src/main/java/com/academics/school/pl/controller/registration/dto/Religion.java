package com.academics.school.pl.controller.registration.dto;

import javax.persistence.Embeddable;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonCreator;

public enum Religion {

	H("hindu"),
	M("muslim"),
	S("sikh"),
	I("isai"),
	JUNK("junk"),
	OTHER("other");
	
	private String religionValue ;
	Religion(){}
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
	public static Religion getEnumFromTextCreator(String religionValue1){
		for (Religion religionValue : Religion.values()) {
			if(religionValue.getName().equals(religionValue1)){
				return religionValue;
			}
		}
		return JUNK;
	}

	
	public static Religion getEnumFromText(String religionValue1){
		if(religionValue1.equals(JUNK)){
			throw new IllegalArgumentException();
		}
		for (Religion religionValue : Religion.values()) {
			if(religionValue.getName().equals(religionValue1)){
				return religionValue;
			}
		}
		throw new IllegalArgumentException();
	}

}
