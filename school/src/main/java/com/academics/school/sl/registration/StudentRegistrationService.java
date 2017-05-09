package com.academics.school.sl.registration;

import java.util.List;

import org.springframework.stereotype.Service;

import com.academics.school.pl.controller.registration.dto.SearchRegistrationRequestDTO;
import com.academics.school.pl.controller.registration.dto.StatusDTO;
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

	StudentRegistrationRecord getRegistrationRecordBasedOnDiffParameter(
			SearchRegistrationRequestDTO searchRegistrationRequestDTO);

	List<StudentRegistrationRecord> changeStatusOfRegistrationRecords(
			List<StatusDTO> statusDTOList);

	List<StudentRegistrationRecord> getRegistrationRecordsByClass(
			String stu_Class);

}
