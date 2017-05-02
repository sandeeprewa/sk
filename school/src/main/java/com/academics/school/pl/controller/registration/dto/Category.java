package com.academics.school.pl.controller.registration.dto;

import javax.persistence.Embeddable;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonCreator;

@Embeddable
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
	public static Category getEnumFromText(String categoryValue1){
		for (Category categoryValue : Category.values()) {
			if(categoryValue.getName().equals(categoryValue1)){
				return categoryValue;
			}
		}
		throw new IllegalArgumentException();
	}

}
