package com.academics.school.pl.controller.claaallocation.dto;

public class SectionCreationDTO {
	
	String classname;
	String sectionname;
	String updatesectionname;
	
	public String getUpdatesectionname() {
		return updatesectionname;
	}
	public void setUpdatesectionname(String updatesectionname) {
		this.updatesectionname = updatesectionname;
	}
	public String getClassname() {
		return classname;
	}
	public void setClassname(String classname) {
		this.classname = classname;
	}
	public String getSectionname() {
		return sectionname;
	}
	public void setSectionname(String section) {
		this.sectionname = section;
	}

}
