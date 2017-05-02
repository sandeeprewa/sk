package com.academics.school.pl.controller.registration.dto;

import javax.persistence.Embeddable;

import com.fasterxml.jackson.annotation.JsonCreator;

public enum Nation {

	I("indian"),
	S("shreeLankan"),
	B("bangladeshi"),
	N("Nepali"),
	Other("other");
	
	private String nationValue ;

	Nation() {
		System.out.println("Hi");
	}

	Nation(String value){
		this.nationValue = value;
	}
	
	@Override
	public String toString(){
		return this.nationValue;
	}
	
	public String getName(){
		return this.nationValue;
	}
	
	@JsonCreator
	public static Nation getEnumFromText(String nationValue1){
		for (Nation nationValue : Nation.values()) {
			if(nationValue.getName().equals(nationValue1)){
				return nationValue;
			}
		}
		throw new IllegalArgumentException();
	}
}
