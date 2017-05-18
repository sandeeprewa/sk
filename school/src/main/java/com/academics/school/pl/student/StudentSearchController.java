package com.academics.school.pl.student;

import java.util.List;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.academics.school.pl.controller.registration.dto.Student;
import com.academics.school.pl.student.dto.StudentSearchRequestDTO;
import com.academics.school.pl.student.error.StandardDoesNotExistException;
import com.academics.school.pl.student.validator.StudentSearchRequestDTOValidator;

/*
 *student/{studId}   Student - Exception STudent NotFound ex : /student/1
 *student/name/{Name} Student - List<Student>
 *studnet/search - POST 
 *student/standard/{standardName}  ListOfStudent  , standardName ex : /student/standard/1
 *student/standard/{standardName}/section/{section} ex: /student/standard/2/section/B GET ListOfStudent
 *student/standard/{standardName}/stream/{stream} ex: /student/standard/12/stream/Math ListOfStudent
 *student/standard/{standName}/stream/{stream}/section/{section} ex: 
*/

@RestController
@RequestMapping(value = "/student")
public class StudentSearchController {
	
	@Autowired
	StudentSearchFacade studentSearchFacde;

	@RequestMapping(value = "/{studentId}", method= RequestMethod.GET)
	public Student getStudentBasedOnStudentId(@Valid @NotNull @NotEmpty @PathVariable("studentId") String studentId){
		return studentSearchFacde.getStudentBasedOnStudentId(studentId);
	}

	@RequestMapping(value = "/search", method = RequestMethod.POST)
	public List<Student> getStudentBasedOnParameters(@ModelAttribute StudentSearchRequestDTO searchDTO)  {
		validate(searchDTO);
		return studentSearchFacde.getStudentBasedOnParameters(searchDTO);
	}
		
	private void validate(StudentSearchRequestDTO searchDTO) {
		StudentSearchRequestDTOValidator.validate(searchDTO);
	}
	
}
