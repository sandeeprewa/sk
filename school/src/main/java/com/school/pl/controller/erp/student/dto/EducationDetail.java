package com.school.pl.controller.erp.student.dto;

import org.springframework.web.multipart.MultipartFile;

public class EducationDetail {

	private String studentClass;
	private String studentSection;
	private String studentSubject;
	private String lastSchoolName;
	private String lastSchoolAddress;
	private String lastSchoolClass;    //last attended class
	private String lastSchoolSubject;  //if aplicable
	private String lastSchoolPercentage;
	
	public String getStudentClass() {
		return studentClass;
	}
	public void setStudentClass(String studentClass) {
		this.studentClass = studentClass;
	}
	public String getStudentSection() {
		return studentSection;
	}
	public void setStudentSection(String studentSection) {
		this.studentSection = studentSection;
	}
	public String getStudentSubject() {
		return studentSubject;
	}
	public void setStudentSubject(String studentSubject) {
		this.studentSubject = studentSubject;
	}
	public String getLastSchoolName() {
		return lastSchoolName;
	}
	public void setLastSchoolName(String lastSchoolName) {
		this.lastSchoolName = lastSchoolName;
	}
	public String getLastSchoolAddress() {
		return lastSchoolAddress;
	}
	public void setLastSchoolAddress(String lastSchoolAddress) {
		this.lastSchoolAddress = lastSchoolAddress;
	}
	public String getLastSchoolClass() {
		return lastSchoolClass;
	}
	public void setLastSchoolClass(String lastSchoolClass) {
		this.lastSchoolClass = lastSchoolClass;
	}
	public String getLastSchoolSubject() {
		return lastSchoolSubject;
	}
	public void setLastSchoolSubject(String lastSchoolSubject) {
		this.lastSchoolSubject = lastSchoolSubject;
	}
	public String getLastSchoolPercentage() {
		return lastSchoolPercentage;
	}
	public void setLastSchoolPercentage(String lastSchoolPercentage) {
		this.lastSchoolPercentage = lastSchoolPercentage;
	}
	
}
