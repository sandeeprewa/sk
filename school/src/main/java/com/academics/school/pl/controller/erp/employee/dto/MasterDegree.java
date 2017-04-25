package com.academics.school.pl.controller.erp.employee.dto;

import com.fasterxml.jackson.annotation.JsonCreator;


public enum MasterDegree {
	
	MSCIT("MSC(IT)"),
	MSCCS("MSC(CS)"),
	MSCPCM("MSC(PCM)"),
	OTHER("other");
	
	private String masterDegreeValue ;
	
	MasterDegree(String value){
		this.masterDegreeValue = value;
	}
	
	@Override
	public String toString(){
		return this.masterDegreeValue;
	}
	
	public String getName(){
		return this.masterDegreeValue;
	}
	
	@JsonCreator
	public static MasterDegree getMasterDegreeFromText(String masterDegreeValue1){
		for (MasterDegree masterDegreeValue : MasterDegree.values()) {
			if(masterDegreeValue.getName().equals(masterDegreeValue1)){
				return masterDegreeValue;
			}
		}
		throw new IllegalArgumentException();
	}


}
