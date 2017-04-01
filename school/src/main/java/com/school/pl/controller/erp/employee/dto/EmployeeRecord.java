package com.school.pl.controller.erp.employee.dto;

import org.springframework.web.multipart.MultipartFile;

public class EmployeeRecord {
	
	private String employeeId;
	private String employeeName;
	
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
	
	private MultipartFile employeeImage;
	
	public MultipartFile getEmployeeImage() {
		return employeeImage;
	}
	public void setEmployeeImage(MultipartFile employeeImage) {
		this.employeeImage = employeeImage;
	}
	public String getEmployeeId() {
		return employeeId;
	}
	public void setEmployeeId(String employeeId) {
		this.employeeId = employeeId;
	}
	public String getEmployeeName() {
		return employeeName;
	}
	public void setEmployeeName(String employeeName) {
		this.employeeName = employeeName;
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

}
