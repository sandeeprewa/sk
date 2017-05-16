package com.academics.school.pl.timetable.dto;

import java.util.ArrayList;
import java.util.List;

public class Standard {
	
	private String standard;
	private String section;
	private List<SubjectAndTeacher> listOfSubject = new ArrayList<SubjectAndTeacher>();
	
	public String getSection(){
		return section;
	}
	public void setSection(String section){
	    this.section = section;
	}
	public String getStandard() {
		return standard;
	}
	public void setStandard(String standard) {
		this.standard = standard;
	}
	public List<SubjectAndTeacher> getListOfSubject() {
		return listOfSubject;
	}
	public void setListOfSubject(List<SubjectAndTeacher> listOfSubject) {
		this.listOfSubject = listOfSubject;
	}
	
}
