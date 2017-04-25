package com.academics.school.pl.controller.erp.student.dto;

import com.fasterxml.jackson.annotation.JsonCreator;

public enum Category {


	GEN("general"),
	OBC("obc"),
	SC("sc"),
	ST("st"),
	OTHER("other");
	
	private String categoryValue ;
	
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
	public static Category getCategoryFromText(String categoryValue1){
		for (Category categoryValue : Category.values()) {
			if(categoryValue.getName().equals(categoryValue1)){
				return categoryValue;
			}
		}
		throw new IllegalArgumentException();
	}

}
