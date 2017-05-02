package com.academics.school.pl.controller.registration.dto;

import javax.persistence.Embeddable;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonCreator;

@Embeddable
public enum State {

	AP("AndhraPradesh"),
	ARP("ArunachalPradesh"),
	Assam("Assam"),
	Bihar("Bihar"),
	Chhattisgarh("Chhattisgarh"),
	Goa("Goa"),
	Gujarat("Gujarat"),
	Haryana("Haryana"),
	HP("Himachal Pradesh"),
	JK("JammuAndKashmir"),
	Jharkhand("Jharkhand"),
	Karnataka("Karnataka"),
	Kerala("Kerala"),
	MP("MadhyaPradesh"),
	Maharashtra("Maharashtra"),
	Manipur("Manipur"),
	Meghalaya("Meghalaya"),
	Mizoram("Mizoram"),
	Nagaland("Nagaland"),
	Odisha("Odisha"),
	Punjab("Punjab"),
	Rajasthan("Rajasthan"),
	Sikkim("Sikkim"),
	TN("TamilNadu"),
	Telangana("Telangana"),
	Tripura("Tripura"),
	UP("UttarPradesh"),
	Uttarakhand("Uttarakhand"),
	WB("WestBengal"),
	Delhi("Delhi"),
	OTHER("other");
	
	private String stateValue ;

	State(){}
	State(String value){
		this.stateValue = value;
	}
	
	@Override
	public String toString(){
		return this.stateValue;
	}
	
	public String getName(){
		return this.stateValue;
	}
	
	@JsonCreator
	public static State getEnumFromText(String stateValue1){
		for (State stateValue : State.values()) {
			if(stateValue.getName().equals(stateValue1)){
				return stateValue;
			}
		}
		throw new IllegalArgumentException();
	}

}
