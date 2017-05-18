package com.academics.school.pl.controller.claaallocation.dto;

public class StudentClassAllocationRecord {
	
	public StudentClassAllocationRecord(){
		
	}
	
	String admissionid="101";
	String studentclass="01";
	String subject=null;
	String section=null;
	String percentage="75%";
	
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

	public String getPercentage() {
		return percentage;
	}

	public void setPercentage(String percentage) {
		this.percentage = percentage;
	}

	
	
	public String getAdmissionid() {
			return admissionid;
		}

	public void setAdmissionid(String admissionid) {
			this.admissionid = admissionid;
		}

	
	public String getSection() {
		return section;
	}

	public void setSection(String section) {
		this.section = section;
	}

}
