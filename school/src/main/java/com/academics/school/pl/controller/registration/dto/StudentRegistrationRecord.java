package com.academics.school.pl.controller.registration.dto;

import java.sql.Timestamp;

public class StudentRegistrationRecord {

	private PersonalDetail personalDetail;
	private EducationDetail educationDetail;
	private ParentDetail parentDetails;
    private Address currentAddress;
    private Address permanentAddress;
    private Timestamp timeStamp;

	public PersonalDetail getPersonalDetail() {
		return personalDetail;
	}

	public void setPersonalDetail(PersonalDetail personalDetail) {
		this.personalDetail = personalDetail;
	}

	public EducationDetail getEducationDetail() {
		return educationDetail;
	}

	public void setEducationDetail(EducationDetail educationDetail) {
		this.educationDetail = educationDetail;
	}

	public ParentDetail getParentDetails() {
		return parentDetails;
	}

	public void setParentDetails(ParentDetail parentDetails) {
		this.parentDetails = parentDetails;
	}

	public Address getCurrentAddress() {
		return currentAddress;
	}

	public void setCurrentAddress(Address currentAddress) {
		this.currentAddress = currentAddress;
	}

	public Address getPermanentAddress() {
		return permanentAddress;
	}

	public void setPermanentAddress(Address permanentAddress) {
		this.permanentAddress = permanentAddress;
	}

	public Timestamp getTimeStamp() {
		return timeStamp;
	}

	public void setTimeStamp(Timestamp timeStamp) {
		this.timeStamp = timeStamp;
	}
}
