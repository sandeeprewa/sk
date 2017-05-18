package com.academics.school.sl.student;

import java.util.List;

import org.springframework.stereotype.Service;

import com.academics.school.pl.controller.registration.dto.Student;
import com.academics.school.pl.student.dto.StudentSearchRequestDTO;

@Service
public interface StudentSerachService {

	public Student getStudentBasedOnStudentId(String studentId);

	public List<Student> getStudentBasedOnParameters(
			StudentSearchRequestDTO searchDTO);

}
