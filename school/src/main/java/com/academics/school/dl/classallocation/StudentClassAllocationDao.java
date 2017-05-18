package com.academics.school.dl.classallocation;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.academics.school.pl.controller.claaallocation.dto.SectionCreationDTO;
import com.academics.school.pl.controller.claaallocation.dto.StudentClassAllocationRecord;
import com.academics.school.pl.controller.classallocation.StudentClassAllocationRecordDTO;
import com.academics.school.pl.controller.registration.dto.Student;

@Repository
public interface StudentClassAllocationDao {

	public List<Student> getClassAllocationRecordBasedOnClass(String studentclass);

	public SectionCreationDTO createSection(SectionCreationDTO sectionCreationDTO);

	public StudentClassAllocationRecord updateAdmissionRecord(StudentClassAllocationRecordDTO studentClassAllocationDTO);
}
