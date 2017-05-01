package com.academics.school.pl.controller.admission;


import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import com.academics.school.pl.controller.registration.dto.RegistrationRecordStatusTrackerDTO;
import com.academics.school.pl.controller.registration.dto.SearchRegistrationRequestDTO;
import com.academics.school.pl.controller.registration.dto.StudentRegistrationRecord;

@Component
public class StudentAdmissionFacade {
			
/*	@Autowired
	@Qualifier("studentAdmissionServiceImpl")
	StudentAdmissionService studentAdmissionService;
*/
	public StudentRegistrationRecord createRegistrationStudentRecord(
			StudentRegistrationRecord admissionRecord) {
		// TODO Auto-generated method stub
		return null;
	}

	public  StudentRegistrationRecord updateStudentRegistrationRecord(
			StudentRegistrationRecord admissionRecord) {
		// TODO Auto-generated method stub
		return null;
	}

	public StudentRegistrationRecord getRegistrationRecordByRegistrationId(String studentId) {
		// TODO Auto-generated method stub
		return null;
	}

	public StudentRegistrationRecord deleteStudentRegistrationRecordById(
			String studentId) {
		// TODO Auto-generated method stub
		return null;
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
