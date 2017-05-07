package com.academics.school.pl.controller.registration.dto;

import java.util.List;

public class RegistrationRecordStatusTrackerDTO {
	
	String name;
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	private List<StatusDTO> statusDTO;

	public List<StatusDTO> getStatusDTO() {
		return statusDTO;
	}

	public void setStatusDTO(List<StatusDTO> statusDTO) {
		this.statusDTO = statusDTO;
	}
	
}
