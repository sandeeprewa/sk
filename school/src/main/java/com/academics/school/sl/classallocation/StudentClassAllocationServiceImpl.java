package com.academics.school.sl.classallocation;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.academics.school.dl.classallocation.StudentClassAllocationDao;
import com.academics.school.dl.standardfixture.StandardFixture;
import com.academics.school.pl.controller.claaallocation.dto.SearchClassAllocationRequestDTO;
import com.academics.school.pl.controller.claaallocation.dto.SectionCreationDTO;
import com.academics.school.pl.controller.claaallocation.dto.StudentClassAllocationRecord;
import com.academics.school.pl.controller.classallocation.StudentClassAllocationRecordDTO;
import com.academics.school.pl.controller.registration.dto.Student;

@Service("studentClassAllocationServiceImpl") 
public class StudentClassAllocationServiceImpl implements StudentClassAllocationService{

	@Autowired
	@Qualifier("studentClassAllocationDaoImpl")
	StudentClassAllocationDao studentClassAllocationDaoImpl;

	public List<Student> getClassAllocationRecordBasedOnClass(SearchClassAllocationRequestDTO searchClassAllocationRequestDTO ) {
		
		 return studentClassAllocationDaoImpl.getClassAllocationRecordBasedOnClass(searchClassAllocationRequestDTO);
	}

	public StandardFixture createSection(SectionCreationDTO sectionCreationDTO) {
		
		return studentClassAllocationDaoImpl.createSection(sectionCreationDTO);
	}

	public StandardFixture updateSection(SectionCreationDTO sectionCreationDTO) {
		
		return studentClassAllocationDaoImpl.updateSection(sectionCreationDTO);
	}
	
  public StandardFixture getSection(SectionCreationDTO sectionCreationDTO) {
		
		return studentClassAllocationDaoImpl.getSection(sectionCreationDTO);
	}
	
  public StudentClassAllocationRecord allocateSection( StudentClassAllocationRecord studentClassAllocationRecord) {
		
		return studentClassAllocationDaoImpl.allocateSection(studentClassAllocationRecord);
	}
	
	

}
