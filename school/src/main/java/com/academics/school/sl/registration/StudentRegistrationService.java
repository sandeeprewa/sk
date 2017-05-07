package com.academics.school.sl.registration;

import org.springframework.stereotype.Service;

import com.academics.school.pl.controller.registration.dto.StudentRegistrationRecord;

@Service 
public interface StudentRegistrationService {

	StudentRegistrationRecord createRegistrationStudentRecord(
			StudentRegistrationRecord admissionRecord);

	StudentRegistrationRecord updateRegistrationStudentRecord(
			StudentRegistrationRecord registrationRecord);

	StudentRegistrationRecord deleteStudentRegistrationRecordById(
			String studentRegisterRecordId);

	StudentRegistrationRecord getRegistrationRecordByRegistrationId(
			String studentRegistrationRecordId);

}
