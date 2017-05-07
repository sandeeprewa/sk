package com.academics.school.dl.registration;

import org.springframework.stereotype.Repository;

import com.academics.school.pl.controller.registration.dto.StudentRegistrationRecord;

@Repository
public interface StudentRegistrationDao {

	StudentRegistrationRecord saveRegistrationStudentRecord(StudentRegistrationRecord admissionRecord);

	StudentRegistrationRecord saveRegistrationRecordIfDoesNotExist(
			StudentRegistrationRecord admissionRecord);

	StudentRegistrationRecord updateRegistrationRecordIfExist(
			StudentRegistrationRecord registrationRecord);

	StudentRegistrationRecord deleteStudentRegistrationRecordById(
			String studentRegisterRecordId);

	StudentRegistrationRecord getRegistrationRecordByRegistrationId(
			String studentRegistrationRecordId);

}
