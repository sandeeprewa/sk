package com.academics.school.pl.controller.registration.dto;

import java.sql.Timestamp;
import org.springframework.web.multipart.MultipartFile;

public class StudentAdmissionRecord {

	private PersonalDetail personalDetail;
	private EducationDetail educationDetail;
	private ParentDetail parentDetails;
    private Address currentAddress;
    private Address permanentAddress;

    private MultipartFile birthCertificate;
    private MultipartFile migrationCertificate;
    private MultipartFile castCertificate;
    private MultipartFile aadharCard;
    private MultipartFile disablityCertificate;
    
    private	MultipartFile fathersImage;
    private MultipartFile mothersImage;
	private MultipartFile studentImage;

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

	public MultipartFile getBirthCertificate() {
		return birthCertificate;
	}

	public void setBirthCertificate(MultipartFile birthCertificate) {
		this.birthCertificate = birthCertificate;
	}

	public MultipartFile getMigrationCertificate() {
		return migrationCertificate;
	}

	public void setMigrationCertificate(MultipartFile migrationCertificate) {
		this.migrationCertificate = migrationCertificate;
	}

	public MultipartFile getCastCertificate() {
		return castCertificate;
	}

	public void setCastCertificate(MultipartFile castCertificate) {
		this.castCertificate = castCertificate;
	}

	public MultipartFile getAadharCard() {
		return aadharCard;
	}

	public void setAadharCard(MultipartFile aadharCard) {
		this.aadharCard = aadharCard;
	}

	public MultipartFile getDisablityCertificate() {
		return disablityCertificate;
	}

	public void setDisablityCertificate(MultipartFile disablityCertificate) {
		this.disablityCertificate = disablityCertificate;
	}

	public MultipartFile getFathersImage() {
		return fathersImage;
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

	public MultipartFile getStudentImage() {
		return studentImage;
	}

	public void setStudentImage(MultipartFile studentImage) {
		this.studentImage = studentImage;
	}

	public Timestamp getTimeStamp() {
		return timeStamp;
	}

	public void setTimeStamp(Timestamp timeStamp) {
		this.timeStamp = timeStamp;
	}
}
