package com.academics.school.pl.controller.registration;

import java.io.IOException;
import java.util.List;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.academics.school.pl.controller.registration.dto.FakeStudentRegistrationDTO;
import com.academics.school.pl.controller.registration.dto.RegistrationRecordStatusTrackerDTO;
import com.academics.school.pl.controller.registration.dto.SearchRegistrationRequestDTO;
import com.academics.school.pl.controller.registration.dto.StudentRegistrationRecord;
import com.academics.school.pl.controller.registration.error.RegistrationRecordDoesNotExistException;
import com.academics.school.pl.controller.registration.error.StudentAlreadyRegisteredException;
import com.academics.school.pl.controller.registration.error.StudentIDEditException;
import com.academics.school.pl.controller.registration.error.StudentIdDoesNotExistException;
import com.academics.school.pl.controller.registration.error.StudentRegistrationFieldValidationException;
import com.academics.school.pl.controller.registration.validation.StudentRegisterationRecordValidator;
import com.academics.school.pl.rest.security.PrivilageEnum;
import com.academics.school.pl.rest.security.RequiredPrivilage;
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
	
	@RequestMapping(value = "{registrationId}", method = RequestMethod.GET)
	@RequiredPrivilage({PrivilageEnum.PUBLIC_USER})
	public StudentRegistrationRecord getStudentAdmissionRecord(@Valid @NotNull @PathVariable String registrationId) 
			throws StudentIdDoesNotExistException {
		return studentRegistrationFacade.getRegistrationRecordByRegistrationId(registrationId);
	}
	
	@RequestMapping(method = RequestMethod.POST)
	@RequiredPrivilage({PrivilageEnum.PUBLIC_USER})
	public StudentRegistrationRecord createNewStudentRegistrationRecord(@RequestBody FakeStudentRegistrationDTO fakeRegistrationRecord) 
			throws StudentRegistrationFieldValidationException, StudentAlreadyRegisteredException, JsonParseException, JsonMappingException, IOException, StudentRegistrationFieldValidationException {
		StudentRegistrationRecord studentRegistrationRecord = buildStudentRegistrationRecordDTO(fakeRegistrationRecord);
		validate(studentRegistrationRecord);
		return studentRegistrationFacade.createRegistrationStudentRecord(studentRegistrationRecord);
	}
	
	@RequestMapping(value = "{registrationId}" ,method = RequestMethod.PUT)
	@RequiredPrivilage({PrivilageEnum.END_USER, PrivilageEnum.EDITOR})
	public StudentRegistrationRecord updateAdmissionStudentRecord(@PathVariable String registrationId, 
			@Validated @RequestBody StudentRegistrationRecord admissionRecord)
	throws StudentIDEditException{
		return studentRegistrationFacade.updateStudentRegistrationRecord(admissionRecord);
	}

	@RequiredPrivilage({PrivilageEnum.EDITOR})
	@RequestMapping(value = "{registrationId}", method = RequestMethod.DELETE)
	public StudentRegistrationRecord deleteAdmissionStudentRecord(@PathVariable String registrationId){
		return studentRegistrationFacade.deleteStudentRegistrationRecordById(registrationId);
	}
	
	@RequiredPrivilage({PrivilageEnum.PUBLIC_USER})
	@RequestMapping(value = "/search", method = RequestMethod.POST)
	public List<StudentRegistrationRecord> getStudentAdmissionRecordByStudentName(@RequestBody SearchRegistrationRequestDTO searchRegistrationRequestDTO) 
			throws RegistrationRecordDoesNotExistException {
		return studentRegistrationFacade.getRegistrationRecordBasedOnDiffParameter(searchRegistrationRequestDTO);
	}
	
	@RequiredPrivilage({PrivilageEnum.PUBLIC_USER})
	@RequestMapping(value = "/{registrationId}/fee", method = RequestMethod.POST)
	public String payFee(@PathVariable String registrationId){
		return "Fees Paid ! Testing";
	}
	
	/*
	 * Admin Facility
	 */
	@RequestMapping(value = "/status/", method = RequestMethod.PUT)
	@RequiredPrivilage({PrivilageEnum.EDITOR})
	public String changeRegistrationRecordStatus(@RequestBody RegistrationRecordStatusTrackerDTO statusDTO){
		return "";
	}
	
	private StudentRegistrationRecord buildStudentRegistrationRecordDTO(FakeStudentRegistrationDTO
			   fakeRegistrationRecord) throws JsonParseException, JsonMappingException, IOException {
			StudentRegistrationRecord studentRegistrationRecord = (StudentRegistrationRecord)new ObjectMapper()
							.readValue(fakeRegistrationRecord.getRegistrationJson(),StudentRegistrationRecord.class);
			studentRegistrationRecord.setStudentImage(fakeRegistrationRecord.getStudentImage());
			studentRegistrationRecord.setBirthCertificate(fakeRegistrationRecord.getBirthCertificate());
			studentRegistrationRecord.setCastCertificate(fakeRegistrationRecord.getCastCertificate());
			return studentRegistrationRecord;
	}

	private void validate(StudentRegistrationRecord studentRegistrationRecord) throws StudentRegistrationFieldValidationException {
		StudentRegisterationRecordValidator.validate(studentRegistrationRecord);
	}
}