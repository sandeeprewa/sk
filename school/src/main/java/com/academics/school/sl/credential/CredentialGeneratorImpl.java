package com.academics.school.sl.credential;

import javax.transaction.Transactional;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.academics.school.dl.utility.SimpleHibernateTemplate;

@Service("credentialGeneratorImpl")
public class CredentialGeneratorImpl implements CredentialGenerator {

	SimpleHibernateTemplate<Credential> simpleHibernateTemplate;
	
	@Autowired
	public CredentialGeneratorImpl(SessionFactory sessionFactory){
		simpleHibernateTemplate = new SimpleHibernateTemplate<Credential>(sessionFactory);
	}
	
	@Transactional
	public Credential createCredential(String registrationId) {
		
		return null;
	}
	
	public Credential createCredentialAndShareWithEmail(String registrationId) {
		return null;
	}
	
}
