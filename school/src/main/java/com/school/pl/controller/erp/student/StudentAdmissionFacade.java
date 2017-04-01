package com.school.pl.controller.erp.student;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import com.school.sl.erp.student.StudentAdmissionService;

@Component
public class StudentAdmissionFacade {
			
	@Autowired
	@Qualifier("studentAdmissionServiceImpl")
	StudentAdmissionService studentAdmissionService;

}
