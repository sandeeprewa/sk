package com.academics.school.pl.student;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import com.academics.school.pl.controller.registration.dto.Student;
import com.academics.school.pl.student.dto.StudentSearchRequestDTO;
import com.academics.school.sl.student.StudentSerachService;

@Component
public class StudentSearchFacade {

	@Autowired
	@Qualifier("studentSearchServiceImpl")
	StudentSerachService studentSearchServiceImpl;

	public Student getStudentBasedOnStudentId(String studentId) {
		return studentSearchServiceImpl.getStudentBasedOnStudentId(studentId);
	}

	public List<Student> getStudentBasedOnParameters(StudentSearchRequestDTO searchDTO) {
		return studentSearchServiceImpl.getStudentBasedOnParameters(searchDTO);
	}

}
