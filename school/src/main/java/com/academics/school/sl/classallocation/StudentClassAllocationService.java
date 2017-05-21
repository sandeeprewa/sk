package com.academics.school.sl.classallocation;

import java.util.List;

import org.springframework.stereotype.Service;

import com.academics.school.dl.standardfixture.StandardFixture;
import com.academics.school.pl.controller.claaallocation.dto.SearchClassAllocationRequestDTO;
import com.academics.school.pl.controller.claaallocation.dto.SectionCreationDTO;
import com.academics.school.pl.controller.claaallocation.dto.StudentClassAllocationRecord;
import com.academics.school.pl.controller.classallocation.StudentClassAllocationRecordDTO;
import com.academics.school.pl.controller.registration.dto.Student;
import com.academics.school.pl.controller.registration.dto.StudentRegistrationRecord;

@Service
public interface StudentClassAllocationService {

	List<Student> getClassAllocationRecordBasedOnClass(SearchClassAllocationRequestDTO searchClassAllocationRequestDTO);
	
    public StandardFixture createSection(SectionCreationDTO sectionCreationDTO);
	
	public StandardFixture updateSection(SectionCreationDTO sectionCreationDTO);
	
	public StandardFixture getSection(SectionCreationDTO sectionCreationDTO);
	
	public StudentClassAllocationRecord allocateSection( StudentClassAllocationRecord studentClassAllocationRecord);
		
}
