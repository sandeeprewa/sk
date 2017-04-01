package com.school.pl.controller.erp.student;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.school.pl.controller.erp.student.dto.StudentAdmissionRecord;
import com.school.pl.controller.erp.student.error.StudentAdmissionFieldValidationException;
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
	public StudentAdmissionRecord admitNewStudent(@Validated @RequestBody StudentAdmissionRecord admissionRecord){
		return null;
	}
	
	@ResponseBody
	@RequestMapping(method = RequestMethod.GET ,value ="/test" )	
	public String test(){
		return "testing";
	}
	
	@ResponseBody
	@RequestMapping(method = RequestMethod.GET ,value ="/exceptionTest" )	
	public String testEx(){
		if(true)
		throw new StudentAdmissionFieldValidationException("firstName","name.invalid.message");
		return "testing";
	}
	
	@ResponseBody
	@RequestMapping(method = RequestMethod.GET )	
	public String test11(){
		return "testing";
	}
	
}
