package com.academics.school.pl.controller.registration.dto;

import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Id;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;

import org.springframework.web.multipart.MultipartFile;

@Entity
@Table(name = "STUDENT_REGISTRATION_RECORD")
public class StudentRegistrationRecord {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "registration_sequence")
	@SequenceGenerator(name = "registration_sequence", sequenceName = "registration_sequence_db",allocationSize=1, initialValue= 1)	
	@Column(name = "REGISTRATION_ID")
	Long registrationId;

	@OneToOne(mappedBy = "studentRegistrationRecord", cascade = CascadeType.ALL)    
	private PersonalDetail personalDetail;
	
	@OneToOne(mappedBy = "studentRegistrationRecord", cascade = CascadeType.ALL)
	private EducationDetail previousEducationDetail;

	@OneToOne(mappedBy = "studentRegistrationRecord", cascade = CascadeType.ALL)
	private CurrentClass currentClass;
	
	@OneToOne(mappedBy = "studentRegistrationRecord", cascade = CascadeType.ALL)
	private ParentDetail parentDetails;
	
	@OneToOne(mappedBy = "studentRegistrationRecord", cascade = CascadeType.ALL)
	private Address currentAddress;
	
	@OneToOne(mappedBy = "studentRegistrationRecord", cascade = CascadeType.ALL)
	private Address permanentAddress;
	
	@Temporal(TemporalType.DATE)
    private Date timeStamp;
	
	@Column(name = "STUDENT_IMAGE_LOCATION")
	private String studentImageLocation;
	
	@Column(name = "FATHER_IMAGE_LOCATION")
	private String fatherImageLocation;
	
	@Column(name = "MOTHER_IMAGE_LOCATION")
	private String motherImageLocation;
	
	@Transient
	private MultipartFile studentImage;
	@Transient
	private MultipartFile fatherImage;
	@Transient
	private MultipartFile motherImage;
	@Transient
	private MultipartFile birthCertificate;
	@Transient
	private MultipartFile castCertificate;
	@Transient
	private MultipartFile disablityCertificate;

	@Column(name = "STATUS")
	@Enumerated(EnumType.STRING)
	private RegistrationStatus registrationStatus = RegistrationStatus.UNPAID_SUBMISSION;

	public RegistrationStatus getRegistrationStatus() {
		return registrationStatus;
	}

	public void setRegistrationStatus(RegistrationStatus registrationStatus) {
		this.registrationStatus = registrationStatus;
	}

	public EducationDetail getPreviousEducationDetail() {
		return previousEducationDetail;
	}

	public void setPreviousEducationDetail(EducationDetail previousEducationDetail) {
		this.previousEducationDetail = previousEducationDetail;
		previousEducationDetail.setStudentRegistrationRecord(this);
	}

	public CurrentClass getCurrentClass() {
		return currentClass;
	}

	public void setCurrentClass(CurrentClass currentClass) {
		this.currentClass = currentClass;
		currentClass.setStudentRegistrationRecord(this);

	}

	public String getStudentImageLocation() {
		return studentImageLocation;
	}

	public void setStudentImageLocation(String studentImageLocation) {
		this.studentImageLocation = studentImageLocation;
	}

	public String getFatherImageLocation() {
		return fatherImageLocation;
	}

	public void setFatherImageLocation(String fatherImageLocation) {
		this.fatherImageLocation = fatherImageLocation;
	}

	public String getMotherImageLocation() {
		return motherImageLocation;
	}

	public void setMotherImageLocation(String motherImageLocation) {
		this.motherImageLocation = motherImageLocation;
	}

	public Long getRegistrationId() {
		return registrationId;
	}

	public void setRegistrationId(Long registrationId) {
		this.registrationId = registrationId;
	}

	public MultipartFile getFatherImage() {
		return fatherImage;
	}

	public void setFatherImage(MultipartFile fatherImage) {
		this.fatherImage = fatherImage;
	}

	public MultipartFile getMotherImage() {
		return motherImage;
	}

	public void setMotherImage(MultipartFile motherImage) {
		this.motherImage = motherImage;
	}

	public MultipartFile getDisablityCertificate() {
		return disablityCertificate;
	}

	public void setDisablityCertificate(MultipartFile disablityCertificate) {
		this.disablityCertificate = disablityCertificate;
	}

	public MultipartFile getStudentImage() {
		return studentImage;
	}

	public MultipartFile getBirthCertificate() {
		return birthCertificate;
	}

	public MultipartFile getCastCertificate() {
		return castCertificate;
	}

	public PersonalDetail getPersonalDetail() {
		return personalDetail;
	}

	public void setPersonalDetail(PersonalDetail personalDetail) {
		this.personalDetail = personalDetail;
		personalDetail.setStudentRegistrationRecord(this);
	}

	public EducationDetail getEducationDetail() {
		return this.previousEducationDetail;
	}
	public void setEducationDetail(EducationDetail educationDetail) {
		this.previousEducationDetail = educationDetail;
		previousEducationDetail.setStudentRegistrationRecord(this);
	}
	public ParentDetail getParentDetails() {
		return parentDetails;
	}
	public void setParentDetails(ParentDetail parentDetails) {
		this.parentDetails = parentDetails;
		parentDetails.setStudentRegistrationRecord(this);
	}

	public Address getCurrentAddress() {
		return currentAddress;
	}

	public void setCurrentAddress(Address currentAddress) {
		this.currentAddress = currentAddress;
		currentAddress.setStudentRegistrationRecord(this);
	}

	public Address getPermanentAddress() {
		return permanentAddress;
	}

	public void setPermanentAddress(Address permanentAddress) {
		this.permanentAddress = permanentAddress;
		permanentAddress.setStudentRegistrationRecord(this);
	}

	public Date getTimeStamp() {
		return timeStamp;
	}

	public void setTimeStamp(Date timeStamp) {
		this.timeStamp = timeStamp;
	}

	public void setStudentImage(MultipartFile studentImage) {
		this.studentImage = studentImage;
	}

	public void setBirthCertificate(MultipartFile birthCertificate) {
		this.birthCertificate  = birthCertificate;
	}

	public void setCastCertificate(MultipartFile castCertificate) {
		this.castCertificate = castCertificate;
	}
	
}
