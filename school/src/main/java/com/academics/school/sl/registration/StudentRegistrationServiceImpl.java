package com.academics.school.sl.registration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.academics.school.dl.registration.StudentRegistrationDao;
import com.academics.school.pl.controller.registration.dto.StudentRegistrationRecord;

@Service("studentRegistrationServiceImpl") 
public class StudentRegistrationServiceImpl implements StudentRegistrationService {
	
	@Autowired
	@Qualifier("studentRegistrationDaoImpl")
	StudentRegistrationDao studentRegistrationDaoImpl;
	
	public StudentRegistrationRecord createRegistrationStudentRecord(StudentRegistrationRecord admissionRecord){
		return studentRegistrationDaoImpl.saveRegistrationStudentRecord(admissionRecord);
	}

}
