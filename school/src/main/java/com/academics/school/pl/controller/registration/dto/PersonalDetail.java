package com.academics.school.pl.controller.registration.dto;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Id;

@Entity
@Table(name = "PERSONAL_DETAIL")
public class PersonalDetail {

	@Id
	@Column(name = "PERSONAL_DETAIL_ID")
	private Long personalDetailId;
	@Column(name = "FIRST_NAME")
	private String firstName;
	@Column(name = "MIDDLE_NAME")
    private String middleName;
	@Column(name = "LAST_NAME")
	private String lastName;  
	@Column(name = "GENDER")
	private Gender gender;
	
	private String mobileNumber;
	private String email;
	private String dateOfBirth;
	private String age;
	private Category category;   
	private Disablity disability;
	private Nation nationality;
	private Religion religion;
    private String bloodGroup;
    private String adhaarCardNo;
    
    @OneToOne
    StudentRegistrationRecord studentRegistrationRecord;
    
    
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
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getMiddleName() {
		return middleName;
	}
	public void setMiddleName(String middleName) {
		this.middleName = middleName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public Gender getGender() {
		return gender;
	}
	public void setGender(Gender gender) {
		this.gender = gender;
	}
	public String getMobileNumber() {
		return mobileNumber;
	}
	public void setMobileNumber(String mobileNumber) {
		this.mobileNumber = mobileNumber;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getDateOfBirth() {
		return dateOfBirth;
	}
	public void setDateOfBirth(String dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}
	public String getAge() {
		return age;
	}
	public void setAge(String age) {
		this.age = age;
	}
	public Category getCatagory() {
		return category;
	}
	public void setCatagory(Category catagory) {
		this.category = catagory;
	}
	public Disablity getDisablity() {
		return disability;
	}
	public void setDisablity(Disablity disablity) {
		this.disability = disablity;
	}
	public Nation getNationality() {
		return nationality;
	}
	public void setNationality(Nation nationality) {
		this.nationality = nationality;
	}
	public Religion getReligion() {
		return religion;
	}
	public void setReligion(Religion religion) {
		this.religion = religion;
	}
	public String getBloodGroup() {
		return bloodGroup;
	}
	public void setBloodGroup(String bloodGroup) {
		this.bloodGroup = bloodGroup;
	}
	public String getAdhaarCardNo() {
		return adhaarCardNo;
	}
	public void setAdhaarCardNo(String adhaarCardNo) {
		this.adhaarCardNo = adhaarCardNo;
	}
	
}
