package com.academics.school.dl.registration;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.academics.school.pl.controller.registration.dto.SearchRegistrationRequestDTO;
import com.academics.school.pl.controller.registration.dto.StatusDTO;
import com.academics.school.pl.controller.registration.dto.StudentRegistrationRecord;
import com.academics.school.pl.controller.registration.error.RegistrationRecordDoesNotExistException;

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

	StudentRegistrationRecord getRegistrationRecordBasedOnDiffParameter(
			SearchRegistrationRequestDTO searchRegistrationRequestDTO) throws RegistrationRecordDoesNotExistException;

	List<StudentRegistrationRecord> updateStatusOfRegistrationRecords(
			List<StatusDTO> statusDTOList);

	List<StudentRegistrationRecord> getRegistrationRecordsByClass(
			String stu_Class);

}
