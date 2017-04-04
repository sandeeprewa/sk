package com.school.pl.controller.teset;

import java.io.Serializable;

import org.springframework.web.multipart.MultipartFile;

public class ComplexObjectImage {
		
	String name;
	Country country;
	Quality quality;
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
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
