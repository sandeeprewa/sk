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

@Table
@Entity(name = "PREVIOUS_EDUCATION_DETAIL")
public class EducationDetail {
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "education_sequence")
	@SequenceGenerator(name = "education_sequence", sequenceName = "education_sequence_db",allocationSize=1, initialValue= 1)	
	@Column(name = "EDUCATION_DETAIL_ID")
	private Long   educationDetailId;
	@Column(name = "PREVIOUS_SCHOOL_NAME")
	private String previousSchoolName;
	@Column(name = "PREVIOUS_SCHOOL_ADDRESS")
	private String previousSchoolAddress;
	@Column(name = "PREVIOUS_SCHOOL_CLASS")
	private String previousSchoolClass;
	@Column(name = "PREVIOUS_CLASS_PERCENTAGE")
	private String previousClassPercentage;

	@OneToOne	@JoinColumn(name = "STUDENT_ID")
    Student student;

	public Long getEducationDetailId() {
		return educationDetailId;
	}
	public void setEducationDetailId(Long educationDetailId) {
		this.educationDetailId = educationDetailId;
	}
	public Student getStudent() {
		return student;
	}
	public void setStudent(Student student) {
		this.student = student;
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
