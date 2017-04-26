package com.academics.school.dl.registration.student;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.academics.school.dl.utility.SimpleHibernateTemplate;

@Repository("studentAdmissionDaoImpl")
public class StudentAdmissionDaoImpl implements StudentAdmissionDao {
	
	private SimpleHibernateTemplate<StudentAdmissionDaoImpl> simpleHibernateTemplate;
	
	@Autowired
	public StudentAdmissionDaoImpl(SessionFactory sessionFactory) {
		this.simpleHibernateTemplate = new SimpleHibernateTemplate<StudentAdmissionDaoImpl>(sessionFactory);
	}
	
	public void test(){
		
	}
}
