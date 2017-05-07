package com.academics.school.pl.controller.registration.dto;

import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Id;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;

import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;
import org.springframework.context.annotation.Lazy;
import org.springframework.web.multipart.MultipartFile;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "STUDENT_REGISTRATION_RECORD")
public class StudentRegistrationRecord {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "registration_sequence")
	@SequenceGenerator(name = "registration_sequence", sequenceName = "registration_sequence_db",allocationSize=1, initialValue= 1)	
	@Column(name = "REGISTRATION_ID")
	Long registrationId;

	@OneToOne(mappedBy = "studentRegistrationRecord", fetch = FetchType.EAGER)
	@Cascade({org.hibernate.annotations.CascadeType.SAVE_UPDATE, 
		org.hibernate.annotations.CascadeType.MERGE, org.hibernate.annotations.CascadeType.DELETE})
	private Student personalDetail;
	
	@Temporal(TemporalType.DATE)
    private Date timeStamp = getTimeStamp();
	
	@Column(name = "STUDENT_IMAGE_LOCATION")
	private String studentImageLocation;
	
	@Column(name = "FATHER_IMAGE_LOCATION")
	private String fatherImageLocation;
	
	@Column(name = "MOTHER_IMAGE_LOCATION")
	private String motherImageLocation;

	@Column(name = "BIRTHCert_IMAGE_LOCATION")
	private String birthCertificateLocation;
	@Column(name = "CASTCert_IMAGE_LOCATION")
	private String castCertificateLocation;
	@Column(name = "DISABC_IMAGE_LOCATION")
	private String disabilityCertificateLocation;

	public Student getPersonalDetail() {
		return personalDetail;
	}


	public void setPersonalDetail(Student personalDetail) {
		this.personalDetail = personalDetail;
		personalDetail.setStudentRegistrationRecord(this);
	}

	public String getBirthCertificateLocation() {
		return birthCertificateLocation;
	}

	public void setBirthCertificateLocation(String birthCertificateLocation) {
		this.birthCertificateLocation = birthCertificateLocation;
	}

	public String getCastCertificateLocation() {
		return castCertificateLocation;
	}

	public void setCastCertificateLocation(String castCertificateLocation) {
		this.castCertificateLocation = castCertificateLocation;
	}

	public String getDisabilityCertificateLocation() {
		return disabilityCertificateLocation;
	}

	public void setDisabilityCertificateLocation(
			String disabilityCertificateLocation) {
		this.disabilityCertificateLocation = disabilityCertificateLocation;
	}

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
	private MultipartFile disabilityCertificate;

	@Column(name = "STATUS")
	@Enumerated(EnumType.STRING)
	private RegistrationStatus registrationStatus = RegistrationStatus.UNPAID_SUBMISSION;

	public RegistrationStatus getRegistrationStatus() {
		return registrationStatus;
	}

	public void setRegistrationStatus(RegistrationStatus registrationStatus) {
		this.registrationStatus = registrationStatus;
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


	public void setFatherImage(MultipartFile fatherImage) {
		this.fatherImage = fatherImage;
	}

	public void setMotherImage(MultipartFile motherImage) {
		this.motherImage = motherImage;
	}

	public MultipartFile getDisabilityCertificate() {
		return disabilityCertificate;
	}

	public void setDisabilityCertificate(MultipartFile disabilityCertificate) {
		this.disabilityCertificate = disabilityCertificate;
	}
	
	@JsonIgnore
	public MultipartFile getFatherImage() {
		return fatherImage;
	}

	@JsonIgnore
	public MultipartFile getMotherImage() {
		return motherImage;
	}

	@JsonIgnore
	public MultipartFile getStudentImage() {
		return studentImage;
	}
	@JsonIgnore
	public MultipartFile getBirthCertificate() {
		return birthCertificate;
	}
	@JsonIgnore
	public MultipartFile getCastCertificate() {
		return castCertificate;
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