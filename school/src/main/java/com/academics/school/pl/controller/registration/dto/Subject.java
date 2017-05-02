package com.academics.school.pl.controller.registration.dto;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "SUBJECT_TABLE")
public class Subject {
	

	@Id
	Long id;
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}
		String subject;
		
		@ManyToOne
		@JoinColumn(name = "Current_Class_Id")
		CurrentClass currentClass;
		
		public CurrentClass getCurrentClass() {
			return currentClass;
		}

		public void setCurrentClass(CurrentClass currentClass) {
			this.currentClass = currentClass;
		}

		public String getSubject() {
			return subject;
		}

		public void setSubject(String subject) {
			this.subject = subject;
		}
}
