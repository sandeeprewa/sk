package com.academics.school.pl.controller.teset;

import org.springframework.web.multipart.MultipartFile;

public class FormData {

	private String name;
	private MultipartFile file1;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public MultipartFile getFile1() {
		return file1;
	}
	public void setFile1(MultipartFile file1) {
		this.file1 = file1;
	}
	
	
}
