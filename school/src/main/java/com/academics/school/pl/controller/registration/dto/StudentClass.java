package com.academics.school.pl.controller.registration.dto;

import com.fasterxml.jackson.annotation.JsonCreator;

public enum StudentClass {
	

    	KG1("KG1"),
    	KG2("KG2"),
    	FIRST("1"),
    	SECOND("2"),
    	THIRED("3"),
    	FOURTH("4"),
    	FIFTH("5"),
    	SIXTH("6"),
    	SEVENTH("7"),
    	EIGHTH("8"),
    	NINTH("9"),
    	TENTH("10"),
    	ELEVENTH("11"),
    	TWELFTH("12");
    	
		private String classValue ;
		StudentClass(){}
		StudentClass(String value){
			this.classValue = value;
		}
		
		@Override
		public String toString(){
			return this.classValue;
		}
		
		public String getName(){
			return this.classValue;
		}
		
		@JsonCreator
		public static StudentClass getEnumFromText(String classValue1){
			for (StudentClass classValue : StudentClass.values()) {
				if(classValue.getName().equals(classValue1)){
					return classValue;
				}
			}
			throw new IllegalArgumentException();
		}


}
