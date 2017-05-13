package com.academics.school.pl.controller.claaallocation.dto;

public class StudentClassAllocationRecord {
	
	StudentClassAllocationRecord(){
		
	}
	
	String admissionid;
	String section;
	//String allocated;
	
	
	public String getAdmissionid() {
			return admissionid;
		}

	public void setAdmissionid(String admissionid) {
			this.admissionid = admissionid;
		}

	
	public String getSection() {
		return section;
	}

	public void setSection(String section) {
		this.section = section;
	}

}
