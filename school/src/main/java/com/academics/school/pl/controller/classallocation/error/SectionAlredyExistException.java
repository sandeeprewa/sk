package com.academics.school.pl.controller.classallocation.error;

public class SectionAlredyExistException extends Exception{


	private static final long serialVersionUID = 5056412333819079911L;

	SectionAlredyExistException(String msg){
		 super(msg);
	}
}
