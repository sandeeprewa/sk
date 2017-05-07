package com.academics.school.pl.controller.registration;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import com.academics.school.pl.controller.registration.dto.RegistrationRecordStatusTrackerDTO;
import com.academics.school.pl.controller.registration.dto.SearchRegistrationRequestDTO;
import com.academics.school.pl.controller.registration.dto.StudentRegistrationRecord;
import com.academics.school.sl.registration.StudentRegistrationService;

@Component
public class StudentRegistrationFacade {

	@Autowired
	@Qualifier("studentRegistrationServiceImpl")
	StudentRegistrationService studentRegistrationServiceImpl;
	
	public StudentRegistrationRecord createRegistrationStudentRecord(
			StudentRegistrationRecord registrationRecord) {
		// TODO Auto-generated method stub
		return studentRegistrationServiceImpl.createRegistrationStudentRecord(registrationRecord);
	}

	public  StudentRegistrationRecord updateStudentRegistrationRecord(
			StudentRegistrationRecord registrationRecord) {
		// TODO Auto-generated method stub
		return studentRegistrationServiceImpl.updateRegistrationStudentRecord(registrationRecord);
	}

	public StudentRegistrationRecord getRegistrationRecordByRegistrationId(String studentRegistrationRecordId) {
		// TODO Auto-generated method stub
		return studentRegistrationServiceImpl.getRegistrationRecordByRegistrationId(studentRegistrationRecordId);
	}

	public StudentRegistrationRecord deleteStudentRegistrationRecordById(
			String studentRegisterRecordId) {
		// TODO Auto-generated method stub
		return studentRegistrationServiceImpl.deleteStudentRegistrationRecordById(studentRegisterRecordId);
	}

	public List<StudentRegistrationRecord> getAdmissionRecordByStudentLastName(
			String studentName) {
		// TODO Auto-generated method stub
		return null;
	}

	public List<StudentRegistrationRecord> getAdmissionRecordByStudentFirstName(
			String studentName) {
		// TODO Auto-generated method stub
		return null;
	}

	public List<StudentRegistrationRecord> getAdmissionRecordByStudentDateOfBirth(
			String dateOfBirth) {
		// TODO Auto-generated method stub
		return null;
	}

	public List<StudentRegistrationRecord> getRegistrationRecordBasedOnDiffParameter(
			SearchRegistrationRequestDTO searchRegistrationRequestDTO) {
		// TODO Auto-generated method stub
		return null;
	}

	public List<StudentRegistrationRecord> changeStatusOfRegistrationRecord(
			ArrayList<RegistrationRecordStatusTrackerDTO> statusDTOList) {
		// TODO Auto-generated method stub
		return null;
	}

}
