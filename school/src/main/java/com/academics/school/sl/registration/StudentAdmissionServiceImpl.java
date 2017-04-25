package com.academics.school.sl.registration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.academics.school.dl.registration.student.StudentAdmissionDao;

@Service("studentAdmissionServiceImpl") 
public class StudentAdmissionServiceImpl implements StudentAdmissionService {
	
	@Autowired
	@Qualifier("studentAdmissionDaoImpl")
	StudentAdmissionDao studentAdmissionDao;
	

	public void teset(){
		
	}
}
