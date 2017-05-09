package com.academics.school.sl.registration;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.academics.school.dl.registration.StudentRegistrationDao;
import com.academics.school.pl.controller.registration.dto.SearchRegistrationRequestDTO;
import com.academics.school.pl.controller.registration.dto.StatusDTO;
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
		return studentRegistrationDaoImpl.getRegistrationRecordBasedOnDiffParameter(searchRegistrationRequestDTO);
	}

	public List<StudentRegistrationRecord> changeStatusOfRegistrationRecords(
			List<StatusDTO> statusDTOList) {
		return studentRegistrationDaoImpl.updateStatusOfRegistrationRecords(statusDTOList);
	}

	public List<StudentRegistrationRecord> getRegistrationRecordsByClass(
			String stu_Class) {
		// TODO Auto-generated method stub
		return studentRegistrationDaoImpl.getRegistrationRecordsByClass(stu_Class);
	}

}
