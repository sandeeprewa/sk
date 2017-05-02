package com.academics.school.pl.controller.registration.dto;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Table( name = "PERSONAL_DETAIL")
@Entity
public class ParentDetail {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "personalDetailId")
	private Long personalDetailId;
	private String fatherName;
	private String fatherMobileNumber;
	private String fatherEmail;
	private String fatherOccupation;
	private String motherName;
	private String motherMobileNumber;
	private String motherEmail;
	private String motherOccupation;
	
	@OneToOne
	private StudentRegistrationRecord studentRegistrationRecord;

	public Long getPersonalDetailId() {
		return personalDetailId;
	}
	public void setPersonalDetailId(Long personalDetailId) {
		this.personalDetailId = personalDetailId;
	}
	public StudentRegistrationRecord getStudentRegistrationRecord() {
		return studentRegistrationRecord;
	}
	public void setStudentRegistrationRecord(
			StudentRegistrationRecord studentRegistrationRecord) {
		this.studentRegistrationRecord = studentRegistrationRecord;
	}

	public String getFatherName() {
		return fatherName;
	}
	public void setFatherName(String fatherName) {
		this.fatherName = fatherName;
	}
	public String getFatherMobileNumber() {
		return fatherMobileNumber;
	}
	public void setFatherMobileNumber(String fatherMobileNumber) {
		this.fatherMobileNumber = fatherMobileNumber;
	}
	public String getFatherEmail() {
		return fatherEmail;
	}
	public void setFatherEmail(String fatherEmail) {
		this.fatherEmail = fatherEmail;
	}
	public String getFatherOccupation() {
		return fatherOccupation;
	}
	public void setFatherOccupation(String fatherOccupation) {
		this.fatherOccupation = fatherOccupation;
	}
	public String getMotherName() {
		return motherName;
	}
	public void setMotherName(String motherName) {
		this.motherName = motherName;
	}
	public String getMotherMobileNumber() {
		return motherMobileNumber;
	}
	public void setMotherMobileNumber(String motherMobileNumber) {
		this.motherMobileNumber = motherMobileNumber;
	}
	public String getMotherEmail() {
		return motherEmail;
	}
	public void setMotherEmail(String motherEmail) {
		this.motherEmail = motherEmail;
	}
	public String getMotherOccupation() {
		return motherOccupation;
	}
	public void setMotherOccupation(String motherOccupation) {
		this.motherOccupation = motherOccupation;
	}

	
}
