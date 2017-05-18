package com.academics.school.sl.standardfixture;

import javax.transaction.Transactional;
import javax.transaction.Transactional.TxType;

import org.hibernate.Criteria;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.academics.school.dl.standardfixture.StandardFixture;
import com.academics.school.dl.utility.SimpleHibernateTemplate;
import com.academics.school.pl.standardfixture.dto.StudentStandardFixtureDTO;

@Service
public class StandardFixtureServiceImp {
	
	SimpleHibernateTemplate<StandardFixture> simpleHibernateTemplate;

	@Autowired
	public StandardFixtureServiceImp(SessionFactory sessionFactory){
		this.simpleHibernateTemplate = new SimpleHibernateTemplate<StandardFixture>(sessionFactory);
	}
	

	@Transactional
	public  StandardFixture addDefaultFixture(StudentStandardFixtureDTO studentStandardFixtureDTO){
		
		
		Criteria criteria = simpleHibernateTemplate.createCriteria(StandardFixture.class);
		StandardFixture record = simpleHibernateTemplate.saveAndGet(studentStandardFixtureDTO);
	
	
		//criteria.add(Restrictions.eq("id",Long.parseLong(studentId)));
		//Student student = (Student) criteria.uniqueResult();
		if(record == null){
			//thorow Student NOdi Foud 
		}
		return  record;
		}
		


}
