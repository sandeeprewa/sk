package com.academics.school.pl.controller.registration;

import java.io.IOException;
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
import com.academics.school.pl.controller.registration.dto.FakeStudentRegistrationDTO;
import com.academics.school.pl.controller.registration.dto.StudentRegistrationRecord;
import com.academics.school.pl.controller.registration.error.StudentAdmissionFieldValidationException;
import com.academics.school.pl.controller.registration.error.StudentAlreadyRegisteredException;
import com.academics.school.pl.controller.registration.error.StudentDoesNotExistException;
import com.academics.school.pl.controller.registration.error.StudentIDEditException;
import com.academics.school.pl.controller.registration.error.StudentIdDoesNotExistException;
import com.academics.school.pl.controller.registration.validation.StudentRegisterationRecordValidator;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

/*
 * @author sandeep
 */
@RestController
@RequestMapping("/rest/register/")
public class StudentRegistrationController {

	@Autowired
	StudentRegistrationFacade studentRegistrationFacade;
	
	@InitBinder
    protected void initBinder(WebDataBinder binder) {
           binder.setValidator(new StudentRegisterationRecordValidator());
    }

	@RequestMapping(value = "{registrationId}", method = RequestMethod.GET)
	public StudentRegistrationRecord getStudentAdmissionRecord(@PathVariable String registrationId) 
			throws StudentIdDoesNotExistException {
		return studentRegistrationFacade.getRegistrationRecordByRegistrationId(registrationId);
	}
	
	@RequestMapping(method = RequestMethod.POST)
	public StudentRegistrationRecord createNewStudentRegistrationRecord(@RequestBody FakeStudentRegistrationDTO fakeRegistrationRecord) 
			throws StudentAdmissionFieldValidationException, StudentAlreadyRegisteredException, JsonParseException, JsonMappingException, IOException{
		StudentRegistrationRecord studentRegistrationRecord = buildStudentRegistrationRecord(fakeRegistrationRecord);
		return studentRegistrationFacade.createRegistrationStudentRecord(studentRegistrationRecord);
	}
	
	@RequestMapping(value = "{registrationId}" ,method = RequestMethod.PUT)
	public StudentRegistrationRecord updateAdmissionStudentRecord(@PathVariable String registrationId, 
			@Validated @RequestBody StudentRegistrationRecord admissionRecord)
	throws StudentIDEditException{
		return studentRegistrationFacade.updateStudentRegistrationRecord(admissionRecord);
	}

	@RequestMapping(value = "{registrationId}", method = RequestMethod.DELETE)
	public StudentRegistrationRecord deleteAdmissionStudentRecord(@PathVariable String registrationId){
		return studentRegistrationFacade.deleteStudentRegistrationRecordById(registrationId);
	}
	
	/*
	 * Filter purpose
	 * Better way it can be implemented
	 */
	@RequestMapping(value = "/search", method = RequestMethod.POST)
	public List<StudentRegistrationRecord> getStudentAdmissionRecordByStudentName(@PathVariable String studentFirstName) 
			throws StudentDoesNotExistException {
		return studentRegistrationFacade.getAdmissionRecordByStudentFirstName(studentFirstName);
	}
	
	private StudentRegistrationRecord buildStudentRegistrationRecord(FakeStudentRegistrationDTO
			   fakeRegistrationRecord) throws JsonParseException, JsonMappingException, IOException {
			return (StudentRegistrationRecord)new ObjectMapper().readValue(fakeRegistrationRecord.getRegistrationJson(), StudentRegistrationRecord.class);
		}

	private StudentRegisterationRecordValidator getStudentRegistrationRecordValidator(){
		return new StudentRegisterationRecordValidator();
	}
}
