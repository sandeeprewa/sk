package com.school.pl.controller.teset;

import java.io.Serializable;

import org.springframework.web.multipart.MultipartFile;

public class ComplexObjectImage implements Serializable{
		
	private static final long serialVersionUID = 21L;

	String name;
	MultipartFile file1;
	Country country;
	Quality quality;
	
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
	public Country getCountry() {
		return country;
	}
	public void setCountry(Country country) {
		this.country = country;
	}
	public Quality getQuality() {
		return quality;
	}
	public void setQuality(Quality quality) {
		this.quality = quality;
	}
	
}
