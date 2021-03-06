package com.academics.school.pl.controller.registration.dto;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Table( name = "PARENT_DETAIL_TABLE")
@Entity
public class ParentDetail {
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "parentDetail_sequence")
	@SequenceGenerator(name = "parentDetail_sequence", sequenceName = "parentDetail_sequence_db",allocationSize=1, initialValue= 1)	
	@Column(name = "PARENT_DETAIL_ID")
	private Long parentDetailId;
	private String fatherName;
	private String fatherMobileNumber;
	private String fatherEmail;
	private String fatherOccupation;
	private String motherName;
	private String motherMobileNumber;
	private String motherEmail;
	private String motherOccupation;
	
	@OneToOne 	@JoinColumn(name = "STUDENT_ID")
	@JsonIgnore
	private Student student;

	
	public Student getStudent() {
		return student;
	}
	public void setStudent(Student student) {
		this.student = student;
	}
	public Long getParentDetailId() {
		return parentDetailId;
	}
	public void setParentDetailId(Long parentDetailId) {
		this.parentDetailId = parentDetailId;
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
