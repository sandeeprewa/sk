package com.academics.school.sl.classallocation;

import java.util.List;

import org.springframework.stereotype.Service;

import com.academics.school.pl.controller.claaallocation.dto.StudentClassAllocationRecord;
import com.academics.school.pl.controller.registration.dto.Student;
import com.academics.school.pl.controller.registration.dto.StudentRegistrationRecord;

@Service
public interface StudentClassAllocationService {

	List<Student> getClassAllocationRecordBasedOnClass(String studentclass);
}
