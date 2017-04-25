package com.academics.school.dl.registration.student;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.academics.school.dl.utility.SimpleHibernateTemplate;
import com.academics.school.pl.controller.registration.dto.StudentAdmissionRecord;

@Repository("studentAdmissionDaoImpl")
public class StudentAdmissionDaoImpl implements StudentAdmissionDao {
	
	private SimpleHibernateTemplate<StudentAdmissionRecord> simpleHibernateTemplate;
	
	@Autowired
	public StudentAdmissionDaoImpl(SessionFactory sessionFactory) {
		this.simpleHibernateTemplate = new SimpleHibernateTemplate<StudentAdmissionRecord>(sessionFactory);
	}
	
	public void test(){
		
	}
}
