package com.academics.school.pl.controller.registration.dto;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Table(name = "ADDRESS_TABLE")
@Entity
public class Address {
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "address_sequence")
	@SequenceGenerator(name = "address_sequence", sequenceName = "address_sequence_db",allocationSize=1, initialValue= 1)	
	@Column(name = "ADDRESS_ID")
	private Long addressId;
	@Column(name = "HOUSE_NUMBER")
	private String houseNumber;
	@Column(name = "VILLAGE")
	private String village;
	@Column(name = "CITY")
	private String city;
	@Column(name = "STATE")
	private State state;
	@Column(name = "PIN_NUMBER")
	private String pinNumber;
	@Column(name = "COUNTRY")
	private Nation country;
	@Column(name = "ADDRESS_DETAILS")
	private String addressDetails;

	@OneToOne	
	@JoinColumn(name = "REGISTRATION_ID")
	StudentRegistrationRecord studentRegistrationRecord;
	
	public Long getAddressId() {
		return addressId;
	}
	public void setAddressId(Long addressId) {
		this.addressId = addressId;
	}
	public StudentRegistrationRecord getStudentRegistrationRecord() {
		return studentRegistrationRecord;
	}
	public void setStudentRegistrationRecord(
			StudentRegistrationRecord studentRegistrationRecord) {
		this.studentRegistrationRecord = studentRegistrationRecord;
	}
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
	@Enumerated(EnumType.STRING)
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
