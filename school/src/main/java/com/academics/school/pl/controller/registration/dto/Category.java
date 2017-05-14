package com.academics.school.pl.controller.registration.dto;

import com.fasterxml.jackson.annotation.JsonCreator;

public enum Category {

	GEN("general"),
	OBC("obc"),
	SC("sc"),
	ST("st"),
	OTHER("other"),
	JUNK("junk");
	
	private String categoryValue ;
	Category(){}
	Category(String value){
		this.categoryValue = value;
	}
	
	@Override
	public String toString(){
		return this.categoryValue;
	}
	
	public String getName(){
		return this.categoryValue;
	}
	
	@JsonCreator
	public static Category getEnumFromTextCreator(String categoryValue1){
		for (Category categoryValue : Category.values()) {
			if(categoryValue.getName().equals(categoryValue1)){
				return categoryValue;
			}
		}
		return JUNK;
	}
	
	public static Category getEnumFromText(String categoryValue1){
		if(categoryValue1.equals(JUNK))
			throw new IllegalArgumentException();
		for (Category categoryValue : Category.values()) {
			if(categoryValue.getName().equals(categoryValue1)){
				return categoryValue;
			}
		}
		throw new IllegalArgumentException();
	}

}
