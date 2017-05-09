package com.academics.school.pl.controller.registration;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import com.academics.school.pl.controller.registration.dto.SearchRegistrationRequestDTO;
import com.academics.school.pl.controller.registration.dto.StatusDTO;
import com.academics.school.pl.controller.registration.dto.StudentRegistrationRecord;
import com.academics.school.sl.registration.StudentRegistrationService;

@Component
public class StudentRegistrationFacade {
	
	@Autowired
	HttpServletRequest request;

	@Autowired
	@Qualifier("studentRegistrationServiceImpl")
	StudentRegistrationService studentRegistrationServiceImpl;
	
	public StudentRegistrationRecord createRegistrationStudentRecord(
			StudentRegistrationRecord registrationRecord) {
		registrationRecord = studentRegistrationServiceImpl.createRegistrationStudentRecord(registrationRecord);
		return registrationRecord;
	}

	public  StudentRegistrationRecord updateStudentRegistrationRecord(
			StudentRegistrationRecord registrationRecord) {
		registrationRecord = studentRegistrationServiceImpl.updateRegistrationStudentRecord(registrationRecord);
		return registrationRecord;
	}

	public StudentRegistrationRecord getRegistrationRecordByRegistrationId(String studentRegistrationRecordId) {
		return studentRegistrationServiceImpl.getRegistrationRecordByRegistrationId(studentRegistrationRecordId);
	}

	public StudentRegistrationRecord deleteStudentRegistrationRecordById(
			String studentRegisterRecordId) {
		return studentRegistrationServiceImpl.deleteStudentRegistrationRecordById(studentRegisterRecordId);
	}

	public StudentRegistrationRecord getRegistrationRecordBasedOnDiffParameter(
		SearchRegistrationRequestDTO searchRegistrationRequestDTO) {
		if(searchRegistrationRequestDTO.getRegistrationId()!= null){
				return	getRegistrationRecordByRegistrationId(searchRegistrationRequestDTO.getRegistrationId());
		}
		return studentRegistrationServiceImpl.getRegistrationRecordBasedOnDiffParameter(searchRegistrationRequestDTO);
	}

	public List<StudentRegistrationRecord> changeStatusOfRegistrationRecords(
			List<StatusDTO> statusDTOList) {
		return studentRegistrationServiceImpl.changeStatusOfRegistrationRecords(statusDTOList);
	}

	public List<StudentRegistrationRecord> getRegistrationRecordsByClass(
			String stu_Class) {
		// TODO Auto-generated method stub
		return studentRegistrationServiceImpl.getRegistrationRecordsByClass(stu_Class);
	}

}
