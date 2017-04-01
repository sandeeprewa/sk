package com.school.pl.controller.erp.student;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.school.pl.controller.erp.student.dto.StudentAdmissionRecord;
import com.school.pl.controller.erp.student.error.StudentAdmissionFailureExnception;
import com.school.pl.controller.erp.student.error.StudentAlreadyRegisteredException;
import com.school.pl.controller.erp.student.error.StudentDoesNotExistException;
import com.school.pl.controller.erp.student.error.StudentIDEditException;
import com.school.pl.controller.erp.student.error.StudentIdDoesNotExistException;
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


	@RequestMapping(value = "{studentId}", method = RequestMethod.GET)
	public StudentAdmissionRecord getStudentAdmissionRecord(@PathVariable String studentId) throws StudentIdDoesNotExistException {
		return studentAdmissionFacade.getAdmissionRecordByStudentId(studentId);
	}
	
	@RequestMapping(value = "fname/{studentFirstName}", method = RequestMethod.GET)
	public List<StudentAdmissionRecord> getStudentAdmissionRecordByStudentName(@PathVariable String studentFirstName) throws StudentDoesNotExistException {
		return studentAdmissionFacade.getAdmissionRecordByStudentFirstName(studentFirstName);
	}
	
	@RequestMapping(value = "lname/{studentLastName}", method = RequestMethod.GET)
	public List<StudentAdmissionRecord> getStudentAdmissionRecordByStudentLastName(@PathVariable String studentLastName)throws StudentDoesNotExistException {
		return studentAdmissionFacade.getAdmissionRecordByStudentLastName(studentLastName);
	}
	
	@RequestMapping(method = RequestMethod.POST)
	public StudentAdmissionRecord admitNewStudent(@Validated @RequestBody StudentAdmissionRecord admissionRecord) 
			throws StudentAdmissionFailureExnception, StudentAlreadyRegisteredException{
		return studentAdmissionFacade.admitNewStudent(admissionRecord);
	}
	
	@RequestMapping(value = "{studentId}" ,method = RequestMethod.PUT)
	public StudentAdmissionRecord updateAdmissionStudentRecord(@PathVariable String studentId, @Validated @RequestBody StudentAdmissionRecord admissionRecord)
	throws StudentIDEditException{
		return studentAdmissionFacade.updateStudentAdmissionRecord(admissionRecord);
	}

	@RequestMapping(value = "{studentId}", method = RequestMethod.DELETE)
	public StudentAdmissionRecord deleteAdmissionStudentRecord(@PathVariable String studentId){
		return studentAdmissionFacade.deleteStudentAdmissionRecordById(studentId);
	}
	
}
