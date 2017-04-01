package com.school.pl.controller.erp.student;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.school.pl.controller.erp.student.dto.StudentAdmissionRecord;
import com.school.pl.controller.erp.student.error.StudentAdmissionFailureExnception;
import com.school.pl.controller.erp.student.validation.StudentAdmissionValidator;


@RestController
@RequestMapping("/v1/student/")
public class StudentAdmissionController {

	@Autowired
	StudentAdmissionFacade studentAdmissionFacade;
	
	
	@InitBinder
    protected void initBinder(WebDataBinder binder) {
           binder.setValidator(new StudentAdmissionValidator());
    }

	
	@RequestMapping(method = RequestMethod.POST)
	public StudentAdmissionRecord admitNewStudent(@Validated @RequestBody StudentAdmissionRecord admissionRecord) 
			throws StudentAdmissionFailureExnception{
		return studentAdmissionFacade.admitNewStudent(admissionRecord);
	}
		
}
