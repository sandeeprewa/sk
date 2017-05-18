package com.academics.school.pl.controller.registration.dto;



import com.fasterxml.jackson.annotation.JsonCreator;

public enum StudentClass {

	KG1("KG1"),
	KG2("KG2"),
	FIRST("1"),
	SECOND("2"),
	THIRD("3"),
	FOURHT("4"),
	FIFTH("5"),
	SISTH("6"),
	SEVENTH("7"),
	EIGHTH("8"),
	NINTH("9"),
	TENTH("10"),
	ELEVENTH("11"),
	TWELFTH("12"),
	
	OTHER("other"),
	JUNK("junk");
	
	private String studentclassValue ;
	StudentClass(){}
	StudentClass(String value){
		this.studentclassValue = value;
	}
	
	@Override
	public String toString(){
		return this.studentclassValue;
	}
	
	public String getName(){
		return this.studentclassValue;
	}
	
	@JsonCreator
	public static StudentClass getEnumFromTextCreator(String studentclassValue1){
		for (StudentClass studentclassValue : StudentClass.values()) {
			if(studentclassValue.getName().equals(studentclassValue1)){
				return studentclassValue;
			}
		}
		return JUNK;
	}
	
	public static StudentClass getEnumFromText(String categoryValue1){
		if(categoryValue1.equals(JUNK))
			throw new IllegalArgumentException();
		for (StudentClass categoryValue : StudentClass.values()) {
			if(categoryValue.getName().equals(categoryValue1)){
				return categoryValue;
			}
		}
		throw new IllegalArgumentException();
	}

}
