package com.academics.school.pl.controller.classallocation;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import com.academics.school.pl.controller.claaallocation.dto.SearchClassAllocationRequestDTO;
import com.academics.school.pl.controller.claaallocation.dto.SectionCreationDTO;
import com.academics.school.pl.controller.claaallocation.dto.StudentClassAllocationRecord;
import com.academics.school.pl.controller.registration.dto.Student;
import com.academics.school.pl.controller.registration.dto.StudentRegistrationRecord;
import com.academics.school.sl.classallocation.StudentClassAllocationService;
import com.academics.school.sl.classallocation.StudentClassAllocationServiceImpl;
import com.academics.school.sl.registration.StudentRegistrationService;

@Component
public class StudentClassAllocationFacade {
	
	@Autowired
	HttpServletRequest request;

	@Autowired
	StudentClassAllocationServiceImpl studentClassAllocationServiceImpl;
	
	public List<Student> getClassAllocationRecordBasedOnClass(SearchClassAllocationRequestDTO searchClassAllocationRequestDTO){
		return studentClassAllocationServiceImpl.getClassAllocationRecordBasedOnClass(searchClassAllocationRequestDTO.getStudentclass());
	}
	
	public SectionCreationDTO createSection(SectionCreationDTO sectionCreationDTO){
		return studentClassAllocationServiceImpl.createSection(sectionCreationDTO);
	}
   
	public StudentClassAllocationRecord updateAdmissionRecord(StudentClassAllocationRecordDTO studentClassAllocationDTO){
		
		return studentClassAllocationServiceImpl.updateAdmissionRecord(studentClassAllocationDTO);
	}
	
	
	
	public SectionCreationDTO deleteSection(SectionCreationDTO sectionCreationDTO){
		return null;
	}
	
	public List<SectionCreationDTO> getSection(SectionCreationDTO searchClassAllocationRequestDTO){
		return null;
	}
}
