package com.academics.school.pl.controller.erp.student.dto;

import com.fasterxml.jackson.annotation.JsonCreator;

public enum Disablity {
	
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
	
      Disablity(String value){
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
	public static Disablity getDisablityFromText(String disablityValue1){
		for (Disablity disablityValue : Disablity.values()) {
			if(disablityValue.getName().equals(disablityValue1)){
				return disablityValue;
			}
		}
		throw new IllegalArgumentException();
	}


}
