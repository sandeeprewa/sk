package com.academics.school.pl.controller.registration.dto;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Id;

@Entity 
@Table(name = "CURRENT_CLASS")
public class CurrentClass {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "Current_Class_Id")
	private Long Id;
	private String c_Class;
	private String school;
	@OneToMany(mappedBy = "currentClass", cascade = CascadeType.ALL)
	private List<Subject> listOfSubject = new ArrayList<Subject>();
	
	@OneToOne
	@JoinColumn(name = "STUDENT_REGISTRATION_ID")
    StudentRegistrationRecord studentRegistrationRecord;

	
	public Long getId() {
		return Id;
	}
	public void setId(Long id) {
		Id = id;
	}
	public String getC_Class() {
		return c_Class;
	}
	public void setC_Class(String c_Class) {
		this.c_Class = c_Class;
	}
	public String getSchool() {
		return school;
	}
	public void setSchool(String school) {
		this.school = school;
	}
	public List<Subject> getListOfSubject() {
		return listOfSubject;
	}
	public void setListOfSubject(List<Subject> listOfSubject) {
		this.listOfSubject = listOfSubject;
	}
	
	public StudentRegistrationRecord getStudentRegistrationRecord() {
		return studentRegistrationRecord;
	}
	public void setStudentRegistrationRecord(
			StudentRegistrationRecord studentRegistrationRecord) {
		this.studentRegistrationRecord = studentRegistrationRecord;
	}

}
