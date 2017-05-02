package com.academics.school.pl.controller.registration.dto;

import javax.persistence.Embeddable;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonCreator;

@Embeddable
public enum Disability {
	
	Autism("Autism"),
	DeafBlindness("DeafBlindness"),
	Deafness("Deafness"),
	DevelopmentalDelay("DevelopmentalDelay"),
	EmotionalDisturbance("EmotionalDisturbance"),
	HearingImpairment("HearingImpairment"),
	IntellectualDisability("IntellectualDisability"),
	MultipleDisabilities("MultipleDisabilities"),
	OrthopedicImpairment("OrthopedicImpairment"),
	OtherHealthImpairment("OtherHealthImpairment"),
	SpecificLearningDisability("SpecificLearningDisability"),
	LanguageImpairment("LanguageImpairment"),
	TraumaticBrainInjury("TraumaticBrainInjury"),
	VisualImpairmentIncludingBlindness("VisualImpairmentIncludingBlindness"),
	
	OTHER("other");

	private String disablityValue ;
	Disability(){}
    Disability(String value){
		this.disablityValue = value;
	}
	
	@Override
	public String toString(){
		return this.disablityValue;
	}
	
	public String getName(){
		return this.disablityValue;
	}
	
	@JsonCreator
	public static Disability getEnumFromText(String disablityValue1){
		for (Disability disablityValue : Disability.values()) {
			if(disablityValue.getName().equals(disablityValue1)){
				return disablityValue;
			}
		}
		throw new IllegalArgumentException();
	}


}
