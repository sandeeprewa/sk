package com.academics.school.dl.registration;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.academics.school.dl.utility.SimpleHibernateTemplate;
import com.academics.school.pl.controller.registration.dto.StudentRegistrationRecord;

@Repository("studentRegistrationDaoImpl")
public class StudentRegistrationDaoImpl implements StudentRegistrationDao {
	
	private SimpleHibernateTemplate<StudentRegistrationRecord> simpleHibernateTemplate;
	
	@Autowired
	public StudentRegistrationDaoImpl(SessionFactory sessionFactory) {
		this.simpleHibernateTemplate = new SimpleHibernateTemplate<StudentRegistrationRecord>(sessionFactory);
	}
	
	public StudentRegistrationRecord saveRegistrationStudentRecord(StudentRegistrationRecord admissionRecord){
		simpleHibernateTemplate.save(admissionRecord);
		return new StudentRegistrationRecord();
	}
	
}
