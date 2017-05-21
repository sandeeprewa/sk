package com.academics.school.pl.controller.classallocation;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import com.academics.school.dl.standardfixture.StandardFixture;
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
		return studentClassAllocationServiceImpl.getClassAllocationRecordBasedOnClass(searchClassAllocationRequestDTO);
	}
	
	public StandardFixture createSection(SectionCreationDTO sectionCreationDTO){
		return studentClassAllocationServiceImpl.createSection(sectionCreationDTO);
	}
   
	public StandardFixture getSection(SectionCreationDTO searchClassAllocationRequestDTO){
		return studentClassAllocationServiceImpl.getSection(searchClassAllocationRequestDTO);
	}
	public SectionCreationDTO deleteSection(SectionCreationDTO sectionCreationDTO){
		return null;
	}
	
	public StandardFixture updateSection(SectionCreationDTO sectionCreationDTO) {
		return studentClassAllocationServiceImpl.updateSection(sectionCreationDTO);
		
	}

	public StudentClassAllocationRecord allocateSection(StudentClassAllocationRecord studentClassAllocationRecord) {
		return studentClassAllocationServiceImpl.allocateSection(studentClassAllocationRecord);
	}
}
