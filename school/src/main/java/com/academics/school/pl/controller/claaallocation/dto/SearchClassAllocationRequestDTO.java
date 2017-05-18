package com.academics.school.pl.controller.claaallocation.dto;

public class SearchClassAllocationRequestDTO {
   
	String studentclass;
	String subject;
	String section;
	String percentage;
	//String allocated;
	
	/*public String getAllocated() {
		return allocated;
	}
	public void setAllocated(String allocated) {
		this.allocated = allocated;
	}*/
	public String getStudentclass() {
		return studentclass;
	}
	public void setStudentclass(String studentclass) {
		this.studentclass = studentclass;
	}
	public String getSubject() {
		return subject;
	}
	public void setSubject(String subject) {
		this.subject = subject;
	}
	public String getSection() {
		return section;
	}
	public void setSection(String section) {
		this.section = section;
	}
	public String getPercentage() {
		return percentage;
	}
	public void setPercentage(String percentage) {
		this.percentage = percentage;
	}
	
	}
