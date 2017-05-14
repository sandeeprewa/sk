package com.academics.school.pl.controller.registration;

import java.io.IOException;
import java.util.List;
import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import com.academics.school.pl.controller.registration.dto.FakeStudentRegistrationDTO;
import com.academics.school.pl.controller.registration.dto.RegistrationRecordStatusTrackerDTO;
import com.academics.school.pl.controller.registration.dto.SearchRegistrationRequestDTO;
import com.academics.school.pl.controller.registration.dto.StatusDTO;
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
import static com.academics.school.pl.utility.RegistrationRecordDTOBuilder.*;
/*
 * @author sandeep
 */
@RestController
@RequestMapping("/rest/register/")
public class StudentRegistrationController {

	@Autowired
	StudentRegistrationFacade studentRegistrationFacade;
	@Autowired
	ServletContext servletContext;

	/*
	 * Getting registration record by registrationID
	 */
	@RequestMapping(value = "{registrationId}", method = RequestMethod.GET)
	@RequiredPrivilage({PrivilageEnum.PUBLIC_USER})
	@ResponseStatus(code = HttpStatus.OK)
	public StudentRegistrationRecord getStudentAdmissionRecord(@Valid @NotNull @PathVariable String registrationId) 
			throws StudentIdDoesNotExistException {
		return studentRegistrationFacade.getRegistrationRecordByRegistrationId(registrationId);
	}
	
	/*
	 * Create New Registration Record 
	 */
	@RequestMapping(method = RequestMethod.POST)
	@RequiredPrivilage({PrivilageEnum.PUBLIC_USER})
	@ResponseStatus(code = HttpStatus.OK)
	public StudentRegistrationRecord createNewStudentRegistrationRecord(@ModelAttribute FakeStudentRegistrationDTO fakeRegistrationRecord) 
		throws StudentRegistrationFieldValidationException, StudentAlreadyRegisteredException, JsonParseException, JsonMappingException, IOException, StudentRegistrationFieldValidationException {
		StudentRegistrationRecord studentRegistrationRecord = buildStudentRegistrationRecordDTO(fakeRegistrationRecord);
		validate(studentRegistrationRecord);
		return studentRegistrationFacade.createRegistrationStudentRecord(studentRegistrationRecord);
	}
	
	/*
	 * Updating Existing Registration Record
	 */
	@RequestMapping(value = "{registrationId}" ,method = RequestMethod.POST)
	@RequiredPrivilage({PrivilageEnum.END_USER, PrivilageEnum.EDITOR})
	@ResponseStatus(code = HttpStatus.OK)
	public StudentRegistrationRecord updateAdmissionStudentRecord(@PathVariable String registrationId, 
			@ModelAttribute FakeStudentRegistrationDTO fakeRegistrationRecord, HttpServletRequest request)
	throws StudentIDEditException, StudentIdDoesNotExistException, JsonParseException, JsonMappingException, IOException {
		StudentRegistrationRecord studentRegistrationRecord = buildStudentRegistrationRecordDTO(fakeRegistrationRecord);
		studentRegistrationRecord.setRegistrationId(Long.parseLong(registrationId));
		return studentRegistrationFacade.updateStudentRegistrationRecord(studentRegistrationRecord);
	}

	/*
	 * Deletion of Registration Record
	 */
	@RequiredPrivilage({PrivilageEnum.EDITOR})
	@RequestMapping(value = "{registrationId}", method = RequestMethod.DELETE)
	@ResponseStatus(code = HttpStatus.OK)
	public StudentRegistrationRecord deleteAdmissionStudentRecord(@PathVariable String registrationId){
		return studentRegistrationFacade.deleteStudentRegistrationRecordById(registrationId);
	}
	
	/*
	 * Search of Registration Record based on Diff Parameter
	 */
	@RequiredPrivilage({PrivilageEnum.PUBLIC_USER})
	@RequestMapping(value = "/search", method = RequestMethod.POST, consumes = "application/json", produces = "application/json")
	public StudentRegistrationRecord getStudentAdmissionRecordByStudentName(@RequestBody SearchRegistrationRequestDTO searchRegistrationRequestDTO) 
			throws RegistrationRecordDoesNotExistException {
		return studentRegistrationFacade.getRegistrationRecordBasedOnDiffParameter(searchRegistrationRequestDTO);
	}

	/*
	 * Admin Facility - Changing Status of Registration Record
	 */
	@RequestMapping(value = "/status", method = RequestMethod.POST, consumes = "application/json", produces = "application/json" )
	@RequiredPrivilage({PrivilageEnum.EDITOR})
	public List<StudentRegistrationRecord> changeRegistrationRecordStatus(@RequestBody RegistrationRecordStatusTrackerDTO inputStatusDTO){
		List<StatusDTO> statusDTOList = inputStatusDTO.getStatusDTO();
		validateListOfStatusDTO(statusDTOList);
		List<StudentRegistrationRecord> registeredRecord = studentRegistrationFacade.changeStatusOfRegistrationRecords(statusDTOList);
		return registeredRecord;
	}
	
	
	@RequestMapping(value = "/class/{stu_Class}",method = RequestMethod.GET)
	@RequiredPrivilage({PrivilageEnum.EDITOR})
	public List<StudentRegistrationRecord> getStudentRegistrationRecordByClass(@PathVariable String stu_Class){
		return studentRegistrationFacade.getRegistrationRecordsByClass(stu_Class);
	}
	
	/* * Yet to be implement - Fee Part	 */
	/*
	 * Paying Fee
	 */
	@RequiredPrivilage({PrivilageEnum.PUBLIC_USER})
	@RequestMapping(value = "/{registrationId}/fee", method = RequestMethod.POST)
	public String payFee(@PathVariable String registrationId){
		return "Fees Paid ! Testing";
	}
	
	/*
	 * Collecting Fee
	 */
	@RequestMapping(value = "/collect/{registrationId}/fee")
	@RequiredPrivilage({PrivilageEnum.EDITOR})
	public String collectFee(@PathVariable String registrationId){
		return "collected";	
	}
	
	private void validateListOfStatusDTO(List<StatusDTO> statusDTOList) {
		RegistrationRecordStatusDTOValidator.validate(statusDTOList);
	}
	
	private void validate(StudentRegistrationRecord studentRegistrationRecord) throws StudentRegistrationFieldValidationException {
		StudentRegisterationRecordValidator.validate(studentRegistrationRecord);
	}
}