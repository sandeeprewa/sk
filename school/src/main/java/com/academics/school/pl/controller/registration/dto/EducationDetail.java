package com.academics.school.pl.controller.registration.dto;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Table
@Entity(name = "PREVIOUS_EDUCATION_DETAIL")
public class EducationDetail {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long   educationDetailId;
	private String previousSchoolName;
	private String previousSchoolAddress;
	private String previousSchoolClass;
	private String previousClassPercentage;

	@OneToOne	@JoinColumn(name = "STUDENT_REGISTRATION_ID")
    StudentRegistrationRecord studentRegistrationRecord;

	public StudentRegistrationRecord getStudentRegistrationRecord() {
		return studentRegistrationRecord;
	}
	public void setStudentRegistrationRecord(
			StudentRegistrationRecord studentRegistrationRecord) {
		this.studentRegistrationRecord = studentRegistrationRecord;
	}
	public String getPreviousSchoolName() {
		return previousSchoolName;
	}
	public void setPreviousSchoolName(String previousSchoolName) {
		this.previousSchoolName = previousSchoolName;
	}
	public String getPreviousSchoolAddress() {
		return previousSchoolAddress;
	}
	public void setPreviousSchoolAddress(String previousSchoolAddress) {
		this.previousSchoolAddress = previousSchoolAddress;
	}
	public String getPreviousSchoolClass() {
		return previousSchoolClass;
	}
	public void setPreviousSchoolClass(String previousSchoolClass) {
		this.previousSchoolClass = previousSchoolClass;
	}
	public String getPreviousClassPercentage() {
		return previousClassPercentage;
	}
	public void setPreviousClassPercentage(String previousClassPercentage) {
		this.previousClassPercentage = previousClassPercentage;
	}
	
	
}
