package com.school.pl.controller.erp.student.dto;

import com.fasterxml.jackson.annotation.JsonCreator;

public enum Semester {


	Sem1("Semester1"),
	Sem2("Semester2"),
	Sem3("Semester3"),
	Sem4("Semester4"),
	Sem5("Semester5"),
	Sem6("Semester6"),
	Sem7("Semester7"),
	Sem8("Semester8"),
	OTHER("other");
	
	private String semesterValue ;
	
	Semester(String value){
		this.semesterValue = value;
	}
	
	@Override
	public String toString(){
		return this.semesterValue;
	}
	
	public String getName(){
		return this.semesterValue;
	}
	
	@JsonCreator
	public static Semester getSemesterFromText(String semesterValue1){
		for (Semester semesterValue : Semester.values()) {
			if(semesterValue.getName().equals(semesterValue1)){
				return semesterValue;
			}
		}
		throw new IllegalArgumentException();
	}

}
