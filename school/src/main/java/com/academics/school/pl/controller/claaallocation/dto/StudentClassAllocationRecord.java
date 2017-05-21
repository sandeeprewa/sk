package com.academics.school.pl.controller.claaallocation.dto;

import java.util.List;

import org.springframework.stereotype.Component;
@Component
public class StudentClassAllocationRecord {
	
   public StudentClassAllocationRecord(){
		
	}	
   
	List<String> studentid;   //1,2,3
	String section;           //A
	String studentclass;
	
	public List<String> getStudentid() {
		return studentid;
	}
	public void setStudentid(List<String> studentid) {
		this.studentid = studentid;
	}
	public String getSection() {
		return section;
	}
	public void setSection(String section) {
		this.section = section;
	}
	public String getStudentclass() {
		return studentclass;
	}
	public void setStudentclass(String studentclass) {
		this.studentclass = studentclass;
	}
	
	
}
