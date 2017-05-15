package com.academics.school.sl.credential;

import java.util.UUID;

import javax.transaction.Transactional;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.academics.mail.sender.CommunicationSender;
import com.academics.mail.sender.SendBy;
import com.academics.school.dl.utility.SimpleHibernateTemplate;
import com.academics.school.pl.controller.registration.dto.Student;
import com.academics.school.sl.credential.model.StudentLoginModel;

@Service("credentialGeneratorImpl")
public class CredentialGeneratorImpl implements CredentialGenerator {
	
	SimpleHibernateTemplate<StudentLoginModel> simpleHibernateTemplate;
	
	@Autowired
	public CredentialGeneratorImpl(SessionFactory sessionFactory){
		simpleHibernateTemplate = new SimpleHibernateTemplate<StudentLoginModel>(sessionFactory);
	}
	
	public Credential<String, String> createCredential(String registrationId) { 
		String userName = registrationId;
		String password = genrateUniqueString(registrationId);
		Credential<String, String> credential = new Credential<String, String>(userName, password);
		return credential;
	}
	
	private String genrateUniqueString(String registrationId) {
		return UUID.randomUUID().toString();
	}

	@Transactional
	public StudentLoginModel createCredentialAndShareWithEmail(String registrationId, String email) {
		StudentLoginModel loginModel = saveCredential(createCredential(registrationId));
		shareCredentialWithStudentWithEmail(loginModel, email);
		return loginModel;
	}
	
	@Transactional
	public StudentLoginModel createCredentialAndShareWithMessage(String registrationId, String phoneNumber) {
		StudentLoginModel loginModel = saveCredential(createCredential(registrationId));
		shareCredentialWithStudentWithMessage(loginModel, phoneNumber);
		return loginModel;
	}

	@Transactional
	public StudentLoginModel saveCredential(Credential cred){
		StudentLoginModel studentLoginModel = getDefaultStudentLoginModel();
		studentLoginModel.setCredential(cred);
		return simpleHibernateTemplate.saveAndGet(studentLoginModel);
	}

	private StudentLoginModel getDefaultStudentLoginModel() {
		StudentLoginModel loginModel = new StudentLoginModel();
		return loginModel;
	}

	
	private boolean shareCredentialWithStudentWithEmail(StudentLoginModel loginModel, String email) {
		StringBuffer message = new StringBuffer();
		message.append(loginModel.getCredential().getUserName());
		message.append("_");
		message.append(loginModel.getCredential().getUserPassword());
		return CommunicationSender.getInstance().sendCommunicion(email, message.toString(), SendBy.EMAIL);
	}

	private boolean shareCredentialWithStudentWithMessage(StudentLoginModel loginModel, String phoneNumber) {
		StringBuffer message = new StringBuffer();
		message.append(loginModel.getCredential().getUserName());
		message.append("_");
		message.append(loginModel.getCredential().getUserPassword());
		return CommunicationSender.getInstance().sendCommunicion(phoneNumber, message.toString(), SendBy.MESSAGE);
	}

}
