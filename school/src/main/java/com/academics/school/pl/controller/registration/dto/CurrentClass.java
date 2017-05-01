package com.academics.school.pl.controller.registration.dto;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Id;

@Table(name = "CURRENT_CLASS")
@Entity 
public class CurrentClass {

	@Id
	private Long Id;
	private String c_Class;
	private String school;
	private List<Subject> listOfSubject;

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
	
}
