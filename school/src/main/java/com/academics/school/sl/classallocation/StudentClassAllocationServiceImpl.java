package com.academics.school.sl.classallocation;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.academics.school.dl.classallocation.StudentClassAllocationDao;
import com.academics.school.pl.controller.claaallocation.dto.SectionCreationDTO;
import com.academics.school.pl.controller.claaallocation.dto.StudentClassAllocationRecord;
import com.academics.school.pl.controller.classallocation.StudentClassAllocationRecordDTO;
import com.academics.school.pl.controller.registration.dto.Student;

@Service("studentClassAllocationServiceImpl") 
public class StudentClassAllocationServiceImpl implements StudentClassAllocationService{

	@Autowired
	@Qualifier("studentClassAllocationDaoImpl")
	StudentClassAllocationDao studentClassAllocationDaoImpl;

	public List<Student> getClassAllocationRecordBasedOnClass(String studentclass) {
		
		 return studentClassAllocationDaoImpl.getClassAllocationRecordBasedOnClass(studentclass);
	}

	public SectionCreationDTO createSection(SectionCreationDTO sectionCreationDTO) {
		
		return studentClassAllocationDaoImpl.createSection(sectionCreationDTO);
	}

	public StudentClassAllocationRecord updateAdmissionRecord(StudentClassAllocationRecordDTO studentClassAllocationDTO) {
		
		return studentClassAllocationDaoImpl.updateAdmissionRecord(studentClassAllocationDTO);
	}
	
	
	
	

}
