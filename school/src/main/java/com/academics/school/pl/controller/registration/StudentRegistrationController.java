package com.academics.school.pl.controller.registration;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.ModelAttribute;
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
import com.academics.school.pl.controller.registration.validation.RegistrationRecordStatusDTOValidator;
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

	/*
	 * Create New Registration Record 
	 */
	
	@RequestMapping(method = RequestMethod.POST)
	@RequiredPrivilage({PrivilageEnum.PUBLIC_USER})
	public StudentRegistrationRecord createNewStudentRegistrationRecord(@ModelAttribute FakeStudentRegistrationDTO fakeRegistrationRecord) 
			throws StudentRegistrationFieldValidationException, StudentAlreadyRegisteredException, JsonParseException, JsonMappingException, IOException, StudentRegistrationFieldValidationException {
		StudentRegistrationRecord studentRegistrationRecord = buildStudentRegistrationRecordDTO(fakeRegistrationRecord);
		validate(studentRegistrationRecord);
		return studentRegistrationFacade.createRegistrationStudentRecord(studentRegistrationRecord);
	}
	
	/*
	 * Getting registration record by registrationID
	 */
	@RequestMapping(value = "{registrationId}", method = RequestMethod.GET)
	@RequiredPrivilage({PrivilageEnum.PUBLIC_USER})
	public StudentRegistrationRecord getStudentAdmissionRecord(@Valid @NotNull @PathVariable String registrationId) 
			throws StudentIdDoesNotExistException {
		return studentRegistrationFacade.getRegistrationRecordByRegistrationId(registrationId);
	}
	
	/*
	 * Updating Existing Registration Record
	 */
	@RequestMapping(value = "{registrationId}" ,method = RequestMethod.PUT)
	@RequiredPrivilage({PrivilageEnum.END_USER, PrivilageEnum.EDITOR})
	public StudentRegistrationRecord updateAdmissionStudentRecord(@PathVariable String registrationId, 
			@Validated @RequestBody StudentRegistrationRecord admissionRecord)
	throws StudentIDEditException{
		return studentRegistrationFacade.updateStudentRegistrationRecord(admissionRecord);
	}

	/*
	 * Deletion of Registration Record
	 */
	@RequiredPrivilage({PrivilageEnum.EDITOR})
	@RequestMapping(value = "{registrationId}", method = RequestMethod.DELETE)
	public StudentRegistrationRecord deleteAdmissionStudentRecord(@PathVariable String registrationId){
		return studentRegistrationFacade.deleteStudentRegistrationRecordById(registrationId);
	}
	
	/*
	 * Search of Registration Record based on Diff Parameter
	 */
	@RequiredPrivilage({PrivilageEnum.PUBLIC_USER})
	@RequestMapping(value = "/search", method = RequestMethod.POST)
	public List<StudentRegistrationRecord> getStudentAdmissionRecordByStudentName(@RequestBody SearchRegistrationRequestDTO searchRegistrationRequestDTO) 
			throws RegistrationRecordDoesNotExistException {
		return studentRegistrationFacade.getRegistrationRecordBasedOnDiffParameter(searchRegistrationRequestDTO);
	}
	
	/*
	 * Paying Fee
	 */
	@RequiredPrivilage({PrivilageEnum.PUBLIC_USER})
	@RequestMapping(value = "/{registrationId}/fee", method = RequestMethod.POST)
	public String payFee(@PathVariable String registrationId){
		return "Fees Paid ! Testing";
	}
	
	/*
	 * Admin Facility - Changing Status of Registration Record
	 */
	@RequestMapping(value = "/status/", method = RequestMethod.PUT)
	@RequiredPrivilage({PrivilageEnum.EDITOR})
	public List<StudentRegistrationRecord> changeRegistrationRecordStatus(@RequestBody RegistrationRecordStatusTrackerDTO[] inputStatusDTO){
		ArrayList<RegistrationRecordStatusTrackerDTO> statusDTOList = new ArrayList<RegistrationRecordStatusTrackerDTO>(Arrays.asList(inputStatusDTO));
		validateListOfRegistrationRecordStatusTrackerDTO(statusDTOList);
		List<StudentRegistrationRecord> registeredRecord = studentRegistrationFacade.changeStatusOfRegistrationRecord(statusDTOList);
		return registeredRecord;
	}
	
	/*
	 * Collecting Fee
	 */
	@RequestMapping(value = "/collect/{registrationId}/fee")
	@RequiredPrivilage({PrivilageEnum.EDITOR})
	public String collectFee(@PathVariable String registrationId){
		return "collected";	
	}
	
	private void validateListOfRegistrationRecordStatusTrackerDTO(ArrayList<RegistrationRecordStatusTrackerDTO> statusDTOList) {
		RegistrationRecordStatusDTOValidator.validate(statusDTOList);
	}

	private StudentRegistrationRecord buildStudentRegistrationRecordDTO(FakeStudentRegistrationDTO
			   fakeRegistrationRecord) throws JsonParseException, JsonMappingException, IOException {
			StudentRegistrationRecord studentRegistrationRecord = (StudentRegistrationRecord)new ObjectMapper()
							.readValue(fakeRegistrationRecord.getRegistrationJson(),StudentRegistrationRecord.class);
			studentRegistrationRecord.setStudentImage(fakeRegistrationRecord.getStudentImage());
			studentRegistrationRecord.setFatherImage(fakeRegistrationRecord.getFatherImage());
			studentRegistrationRecord.setMotherImage(fakeRegistrationRecord.getMotherImage());
			studentRegistrationRecord.setBirthCertificate(fakeRegistrationRecord.getBirthCertificate());
			studentRegistrationRecord.setCastCertificate(fakeRegistrationRecord.getCastCertificate());
			return studentRegistrationRecord;
	}

	private void validate(StudentRegistrationRecord studentRegistrationRecord) throws StudentRegistrationFieldValidationException {
		StudentRegisterationRecordValidator.validate(studentRegistrationRecord);
	}
}