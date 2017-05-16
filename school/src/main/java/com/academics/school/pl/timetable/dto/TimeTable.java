package com.academics.school.pl.timetable.dto;

import java.util.ArrayList;
import java.util.List;

public class TimeTable {
	
	List<Standard> listOfStandard = new ArrayList<Standard>();

	public List<Standard> getListOfStandard() {
		return listOfStandard;
	}

	public void setListOfStandard(List<Standard> listOfStandard) {
		this.listOfStandard = listOfStandard;
	}
	
}
