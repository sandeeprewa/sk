package com.academics.school.pl.controller.attendence;

import java.util.List;

import javax.servlet.ServletContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.academics.school.pl.controller.attendence.dto.AttendenceRequestDTO;
import com.academics.school.pl.controller.attendence.dto.StudentAttendenceRecord;
import com.academics.school.pl.controller.attendence.validation.AttendenceRequestDTOValidator;
import com.academics.school.pl.controller.registration.dto.SearchRegistrationRequestDTO;
import com.academics.school.pl.controller.registration.dto.StudentRegistrationRecord;
import com.academics.school.pl.controller.registration.error.RegistrationRecordDoesNotExistException;

/*
 * @author Sandeep
 */
@RestController
@RequestMapping("/rest/attendence/")
public class AttendenceController {

	@Autowired
	StudentAttendenceFacade studentAttendenceFacade;
	@Autowired
	ServletContext servletContext;
	
	@RequestMapping(value = "{registrationId}", method = RequestMethod.POST, consumes = "application/json", produces = "application/json")
	public List<StudentAttendenceRecord> getStudentAttendenceRecordByDate(@RequestBody AttendenceRequestDTO attendenceRequestDTO) 
			throws RegistrationRecordDoesNotExistException {
		validate(attendenceRequestDTO);
		return studentAttendenceFacade.getAttendenceRecordBasedOnDiffParameter(attendenceRequestDTO);
	}

	private void validate(AttendenceRequestDTO attendenceRequestDTO) {
		AttendenceRequestDTOValidator.validate(attendenceRequestDTO);
	}				

}
