package com.academics.school.dl.registration;

import javax.transaction.Transactional;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.academics.school.dl.utility.FileUploader;
import com.academics.school.dl.utility.SimpleHibernateTemplate;
import com.academics.school.pl.controller.registration.dto.StudentRegistrationRecord;

@Repository("studentRegistrationDaoImpl")
public class StudentRegistrationDaoImpl implements StudentRegistrationDao {
	
	private SimpleHibernateTemplate<StudentRegistrationRecord> simpleHibernateTemplate;
	
	@Autowired
	public StudentRegistrationDaoImpl(SessionFactory sessionFactory) {
		this.simpleHibernateTemplate = new SimpleHibernateTemplate<StudentRegistrationRecord>(sessionFactory);
	}
	
	@Transactional
	public StudentRegistrationRecord saveRegistrationStudentRecord(StudentRegistrationRecord admissionRecord){
		
		StudentRegistrationRecord record = simpleHibernateTemplate.saveAndGet(admissionRecord);
		String fileLocationOfBirthCertificate = 
				FileUploader.saveFileIntoFileSystem(admissionRecord.getMotherImage(),
				admissionRecord.getPersonalDetail().getCurrentClass().getC_Class(), String.valueOf(record.getRegistrationId()), "MotherImage" );
		admissionRecord.setMotherImageLocation(fileLocationOfBirthCertificate);
		return new StudentRegistrationRecord();
	}
	
}
