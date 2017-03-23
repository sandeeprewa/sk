package com.school.sl.erp.student;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.school.dl.erp.student.StudentAdmissionDao;

@Service("studentAdmissionServiceImpl")
public class StudentAdmissionServiceImpl implements StudentAdmissionService {
	
	@Autowired
	@Qualifier("studentAdmissionDaoImpl")
	StudentAdmissionDao studentAdmissionDao;
}
