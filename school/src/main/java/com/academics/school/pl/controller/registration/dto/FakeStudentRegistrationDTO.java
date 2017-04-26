package com.academics.school.pl.controller.registration.dto;

import org.springframework.web.multipart.MultipartFile;

public class FakeStudentRegistrationDTO {
	
	private String registrationJson;
	private MultipartFile studentImage;
	private MultipartFile birthCertificate;
	private MultipartFile castCertificate;
	private MultipartFile disablityCertificate;

	
	public MultipartFile getStudentImage() {
		return studentImage;
	}
	public void setStudentImage(MultipartFile studentImage) {
		this.studentImage = studentImage;
	}
	public MultipartFile getBirthCertificate() {
		return birthCertificate;
	}
	public void setBirthCertificate(MultipartFile birthCertificate) {
		this.birthCertificate = birthCertificate;
	}
	public MultipartFile getCastCertificate() {
		return castCertificate;
	}
	public void setCastCertificate(MultipartFile castCertificate) {
		this.castCertificate = castCertificate;
	}
	public MultipartFile getDisablityCertificate() {
		return disablityCertificate;
	}
	public void setDisablityCertificate(MultipartFile disablityCertificate) {
		this.disablityCertificate = disablityCertificate;
	}
	
	public String getRegistrationJson() {
		return registrationJson;
	}
	public void setRegistrationJson(String registrationJson) {
		this.registrationJson = registrationJson;
	}
	
}
