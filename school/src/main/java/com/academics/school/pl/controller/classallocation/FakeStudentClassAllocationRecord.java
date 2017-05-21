package com.academics.school.pl.controller.classallocation;

import java.util.List;

import com.academics.school.pl.controller.claaallocation.dto.StudentClassAllocationRecord;

public class FakeStudentClassAllocationRecord {
	
	List<String> studentid;
	String section;
	String studentclass;
	


	public List<String> getStudentid() {
		return studentid;
	}

	public void setStudentid(List<String> studentid) {
		this.studentid = studentid;
	}

	public String getStudentclass() {
		return studentclass;
	}

	public void setStudentclass(String studentclass) {
		this.studentclass = studentclass;
	}

	public String getSection() {
		return section;
	}

	public void setSection(String section) {
		this.section = section;
	}
	

}
