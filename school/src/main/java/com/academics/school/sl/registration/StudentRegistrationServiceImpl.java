package com.academics.school.sl.registration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.academics.school.dl.registration.StudentRegistrationDao;
import com.academics.school.pl.controller.registration.dto.SearchRegistrationRequestDTO;
import com.academics.school.pl.controller.registration.dto.StudentRegistrationRecord;

@Service("studentRegistrationServiceImpl") 
public class StudentRegistrationServiceImpl implements StudentRegistrationService {
	
	@Autowired
	@Qualifier("studentRegistrationDaoImpl")
	StudentRegistrationDao studentRegistrationDaoImpl;
	
	public StudentRegistrationRecord createRegistrationStudentRecord(StudentRegistrationRecord registrationRecord){
		return studentRegistrationDaoImpl.saveRegistrationRecordIfDoesNotExist(registrationRecord);
	}

	public StudentRegistrationRecord updateRegistrationStudentRecord(
			StudentRegistrationRecord registrationRecord) {
		return studentRegistrationDaoImpl.updateRegistrationRecordIfExist(registrationRecord);
	}

	public StudentRegistrationRecord deleteStudentRegistrationRecordById(
			String studentRegisterRecordId) {
		return studentRegistrationDaoImpl.deleteStudentRegistrationRecordById(studentRegisterRecordId);
	}

	public StudentRegistrationRecord getRegistrationRecordByRegistrationId(
			String studentRegistrationRecordId) {
		return studentRegistrationDaoImpl.getRegistrationRecordByRegistrationId(studentRegistrationRecordId);
	}

	public StudentRegistrationRecord getRegistrationRecordBasedOnDiffParameter(
			SearchRegistrationRequestDTO searchRegistrationRequestDTO) {
		// TODO Auto-generated method stub
		return studentRegistrationDaoImpl.getRegistrationRecordBasedOnDiffParameter(searchRegistrationRequestDTO);
	}

}
