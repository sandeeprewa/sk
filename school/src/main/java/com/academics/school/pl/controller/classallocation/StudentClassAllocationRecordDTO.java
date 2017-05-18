package com.academics.school.pl.controller.classallocation;

import java.util.List;

import com.academics.school.pl.controller.claaallocation.dto.StudentClassAllocationRecord;

public class StudentClassAllocationRecordDTO {
	
	List<StudentClassAllocationRecord> listOfStudent;
	String studentclass;
	String section;

	public List<StudentClassAllocationRecord> getListOfStudent() {
		return listOfStudent;
	}

	public void setListOfStudent(List<StudentClassAllocationRecord> listOfStudent) {
		this.listOfStudent = listOfStudent;
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
