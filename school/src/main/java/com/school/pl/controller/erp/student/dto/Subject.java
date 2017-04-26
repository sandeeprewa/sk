package com.school.pl.controller.erp.student.dto;

import com.fasterxml.jackson.annotation.JsonCreator;

public enum Subject {

	Math("Math"),
	Phy("Physics"),
	chem("Chemistry"),
	Bio("Biology"),
	
	OTHER("other");
	
	private String subjectValue ;
	
	Subject(String value){
		this.subjectValue = value;
	}
	
	@Override
	public String toString(){
		return this.subjectValue;
	}
	
	public String getName(){
		return this.subjectValue;
	}
	
	@JsonCreator
	public static Subject getSubjectFromText(String subjectValue1){
		for (Subject subjectValue : Subject.values()) {
			if(subjectValue.getName().equals(subjectValue1)){
				return subjectValue;
			}
		}
		throw new IllegalArgumentException();
	}

}
