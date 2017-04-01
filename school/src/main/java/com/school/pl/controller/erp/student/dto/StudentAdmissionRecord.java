package com.school.pl.controller.erp.student.dto;

import java.sql.Timestamp;

import org.springframework.web.multipart.MultipartFile;


public class StudentAdmissionRecord {

	private String firstName;
	private String lastName;  
	private String class_Stu;
	private String section;
	
	private String fatherName;
	private String motherName;
	private String fatherOccupation;
	private String motherOccupation;
	private String dateOfBirth;
	private String age;
	
	private String currentHouseNumber;
	private String currentVillage;
	private String currentCity;
	private String currentState;
	private String currentCountry;
	private String currentAddressDetail;
	
	private String permanentHouseNumber;
	private String permanentVillage;
	private String permanentCity;
	private String permanentState;
	private String permanentCountry;
	private String permanentAddressDetail;
	
	private MultipartFile studentImage;
    private	MultipartFile fathersImage;
    private MultipartFile mothersImage;
    
    private Timestamp timeStamp;
    
	public Timestamp getTimeStamp() {
		return timeStamp;
	}
	public void setTimeStamp(Timestamp timeStamp) {
		this.timeStamp = timeStamp;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getSection() {
		return section;
	}
	public void setSection(String section) {
		this.section = section;
	}
	public String getFatherName() {
		return fatherName;
	}
	public void setFatherName(String fatherName) {
		this.fatherName = fatherName;
	}
	public String getMotherName() {
		return motherName;
	}
	public void setMotherName(String motherName) {
		this.motherName = motherName;
	}
	public String getFatherOccupation() {
		return fatherOccupation;
	}
	public void setFatherOccupation(String fatherOccupation) {
		this.fatherOccupation = fatherOccupation;
	}
	public String getMotherOccupation() {
		return motherOccupation;
	}
	public void setMotherOccupation(String motherOccupation) {
		this.motherOccupation = motherOccupation;
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
	public String getCurrentHouseNumber() {
		return currentHouseNumber;
	}
	public void setCurrentHouseNumber(String currentHouseNumber) {
		this.currentHouseNumber = currentHouseNumber;
	}
	public String getCurrentVillage() {
		return currentVillage;
	}
	public void setCurrentVillage(String currentVillage) {
		this.currentVillage = currentVillage;
	}
	public String getCurrentCity() {
		return currentCity;
	}
	public void setCurrentCity(String currentCity) {
		this.currentCity = currentCity;
	}
	public String getCurrentState() {
		return currentState;
	}
	public void setCurrentState(String currentState) {
		this.currentState = currentState;
	}
	public String getCurrentCountry() {
		return currentCountry;
	}
	public void setCurrentCountry(String currentCountry) {
		this.currentCountry = currentCountry;
	}
	public String getCurrentAddressDetail() {
		return currentAddressDetail;
	}
	public void setCurrentAddressDetail(String currentAddressDetail) {
		this.currentAddressDetail = currentAddressDetail;
	}
	public String getPermanentHouseNumber() {
		return permanentHouseNumber;
	}
	public void setPermanentHouseNumber(String permanentHouseNumber) {
		this.permanentHouseNumber = permanentHouseNumber;
	}
	public String getPermanentVillage() {
		return permanentVillage;
	}
	public void setPermanentVillage(String permanentVillage) {
		this.permanentVillage = permanentVillage;
	}
	public String getPermanentCity() {
		return permanentCity;
	}
	public void setPermanentCity(String permanentCity) {
		this.permanentCity = permanentCity;
	}
	public String getPermanentState() {
		return permanentState;
	}
	public void setPermanentState(String permanentState) {
		this.permanentState = permanentState;
	}
	public String getPermanentCountry() {
		return permanentCountry;
	}
	public void setPermanentCountry(String permanentCountry) {
		this.permanentCountry = permanentCountry;
	}
	public String getPermanentAddressDetail() {
		return permanentAddressDetail;
	}
	public void setPermanentAddressDetail(String permanentAddressDetail) {
		this.permanentAddressDetail = permanentAddressDetail;
	}
	public MultipartFile getStudentImage() {
		return studentImage;
	}
	public void setStudentImage(MultipartFile studentImage) {
		this.studentImage = studentImage;
	}
	public MultipartFile getFathersImage() {
		return fathersImage;
	}public String getClass_Stu() {
		return class_Stu;
	}
	public void setClass_Stu(String class_Stu) {
		this.class_Stu = class_Stu;
	}
	public void setFathersImage(MultipartFile fathersImage) {
		this.fathersImage = fathersImage;
	}
	public MultipartFile getMothersImage() {
		return mothersImage;
	}
	public void setMothersImage(MultipartFile mothersImage) {
		this.mothersImage = mothersImage;
	}


}
