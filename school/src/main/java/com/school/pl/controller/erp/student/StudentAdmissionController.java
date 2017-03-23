package com.school.pl.controller.erp.student;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.school.pl.controller.erp.student.dto.StudentAdmissionRecord;


@RestController
@RequestMapping("/student/")
public class StudentAdmissionController {

	@Autowired
	StudentAdmissionFacade studentAdmissionFacade;
	
	@RequestMapping(method = RequestMethod.POST)
	public StudentAdmissionRecord admitNewStudent(@RequestBody StudentAdmissionRecord admissionRecord){
		return null;
	}
}
