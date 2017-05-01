package com.academics.school.pl.controller.registration.dto;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Table(name = "ADDRESS_TABLE")
@Entity
public class Address {
	
	@Id
	@Column(name = "addressId")
	private Long addressId;

	private String houseNumber;
	private String village;
	private String city;
	private State state;
	private String pinNumber;
	private Nation country;
	private String addressDetails;

	@OneToOne
	StudentRegistrationRecord studentRegistrationRecord;
	
	public String getHouseNumber() {
		return houseNumber;
	}
	public void setHouseNumber(String houseNumber) {
		this.houseNumber = houseNumber;
	}
	public String getVillage() {
		return village;
	}
	public void setVillage(String village) {
		this.village = village;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public State getState() {
		return state;
	}
	public void setState(State state) {
		this.state = state;
	}
	public String getPinNumber() {
		return pinNumber;
	}
	public void setPinNumber(String pinNumber) {
		this.pinNumber = pinNumber;
	}
	public Nation getCountry() {
		return country;
	}
	public void setCountry(Nation country) {
		this.country = country;
	}
	public String getAddressDetails() {
		return addressDetails;
	}
	public void setAddressDetails(String addressDetails) {
		this.addressDetails = addressDetails;
	}
	
}
