package com.academics.school.sl.erp.student;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.academics.school.dl.erp.student.StudentAdmissionDao;

@Service("studentAdmissionServiceImpl") 
public class StudentAdmissionServiceImpl implements StudentAdmissionService {
	
	@Autowired
	@Qualifier("studentAdmissionDaoImpl")
	StudentAdmissionDao studentAdmissionDao;
	

	public void teset(){
		
	}
}
