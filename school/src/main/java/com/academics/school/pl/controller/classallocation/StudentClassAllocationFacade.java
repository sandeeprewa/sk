package com.academics.school.pl.controller.classallocation;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import com.academics.school.pl.controller.claaallocation.dto.SearchClassAllocationRequestDTO;
import com.academics.school.pl.controller.claaallocation.dto.SectionCreationDTO;
import com.academics.school.pl.controller.claaallocation.dto.StudentClassAllocationRecord;

@Component
public class StudentClassAllocationFacade {
	
	public List<StudentClassAllocationRecord> getAdmissionRecordBasedOnDiffParameter(SearchClassAllocationRequestDTO searchClassAllocationRequestDTO){
		return null;
	}
   
	public StudentClassAllocationRecord updateAdmissionRecord(ArrayList<StudentClassAllocationRecord> studentClassAllocationRecord){
		return null;
	}
	
	public SectionCreationDTO createSection(SectionCreationDTO sectionCreationDTO){
		return null;
	}
	
	public SectionCreationDTO deleteSection(SectionCreationDTO sectionCreationDTO){
		return null;
	}
	
	public List<SectionCreationDTO> getSection(SectionCreationDTO searchClassAllocationRequestDTO){
		return null;
	}
}
