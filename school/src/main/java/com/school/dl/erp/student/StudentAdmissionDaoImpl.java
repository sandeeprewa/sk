package com.school.dl.erp.student;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.school.dl.utility.SimpleHibernateTemplate;
import com.school.pl.controller.erp.student.dto.StudentAdmissionRecord;

@Repository("studentAdmissionDaoImpl")
public class StudentAdmissionDaoImpl implements StudentAdmissionDao {
	
	private SimpleHibernateTemplate<StudentAdmissionRecord> simpleHibernateTemplate;
	
	@Autowired
	public StudentAdmissionDaoImpl(SessionFactory sessionFactory) {
		this.simpleHibernateTemplate = new SimpleHibernateTemplate<StudentAdmissionRecord>(sessionFactory);
	}
	
	
}
