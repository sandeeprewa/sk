package com.academics.school.pl.controller.registration.dto;

import org.springframework.web.multipart.MultipartFile;

public class FakeStudentRegistrationDTO {
	
	private String registrationJson;
	private MultipartFile[] multipartFile;
	
	
	public String getRegistrationJson() {
		return registrationJson;
	}
	public void setRegistrationJson(String registrationJson) {
		this.registrationJson = registrationJson;
	}
	public MultipartFile[] getMultipartFile() {
		return multipartFile;
	}
	public void setMultipartFile(MultipartFile[] multipartFile) {
		this.multipartFile = multipartFile;
	}
	
	
}
