package com.academics.school.dl.registration;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

import javax.servlet.ServletContext;
import javax.transaction.Transactional;
import javax.transaction.Transactional.TxType;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import static com.academics.school.dl.utility.FileUploader.*;

import com.academics.school.dl.utility.SimpleHibernateTemplate;
import com.academics.school.pl.controller.registration.dto.RegistrationStatus;
import com.academics.school.pl.controller.registration.dto.SearchRegistrationRequestDTO;
import com.academics.school.pl.controller.registration.dto.StatusDTO;
import com.academics.school.pl.controller.registration.dto.Student;
import com.academics.school.pl.controller.registration.dto.StudentRegistrationRecord;
import com.academics.school.pl.controller.registration.error.RegistrationIDDoesNotExitException;
import com.academics.school.pl.controller.registration.error.RegistrationRecordDoesNotExistException;
import com.academics.school.pl.controller.registration.error.StudentAlreadyRegisteredException;
import com.academics.school.pl.controller.registration.error.StudentIDEditException;
import com.academics.school.pl.controller.registration.error.StudentIdDoesNotExistException;

@Repository("studentRegistrationDaoImpl")
public class StudentRegistrationDaoImpl implements StudentRegistrationDao {
	
	private static final String REGISTRATION_ID = "registrationId";
	private static final String STUDENT_IMAGE_PREFIX = "StudentImage";
	private static final String FATHER_IMAGE_PREFIX = "FatherImage";
	private static final String MOTHER_IMAGE_PREFIX = "MotherImage";
	private static final String BIRTH_CERT_PREFIX = "Birth_Certificate_Image";
	private static final String CAST_CERT_PREFIX = "Cast_Certificate_Image";
	private static final String DISABILITY_CERT_PREFIX = "Disablity_Certificate_Image";

	private SimpleHibernateTemplate<StudentRegistrationRecord> simpleHibernateTemplate;
	
	@Autowired
	ServletContext servletContext;
	
	@Autowired
	public StudentRegistrationDaoImpl(SessionFactory sessionFactory) {
		this.simpleHibernateTemplate = new SimpleHibernateTemplate<StudentRegistrationRecord>(sessionFactory);
	}
	
	@Transactional
	public StudentRegistrationRecord getRegistrationRecordBasedOnDiffParameter(
			SearchRegistrationRequestDTO searchRegistrationRequestDTO) throws RegistrationRecordDoesNotExistException {

		Criteria criteria = simpleHibernateTemplate.createCriteria(Student.class);
		criteria.add(Restrictions.eq("firstName", searchRegistrationRequestDTO.getStudentFirstName()));
		criteria.add(Restrictions.eq("lastName", searchRegistrationRequestDTO.getStudentLastName()));
		criteria.add(Restrictions.eq("dateOfBirth", searchRegistrationRequestDTO.getDateOfBirth()));
		criteria.add(Restrictions.eq("mobileNumber", searchRegistrationRequestDTO.getStudentMobileNumber()));
		criteria.add(Restrictions.eq("email", searchRegistrationRequestDTO.getStudentEmail()));
		Student retrivedStudent = (Student)criteria.uniqueResult();
		if(retrivedStudent == null){
			throw new RegistrationRecordDoesNotExistException("input.student.notfound");
		}
		return retrivedStudent.getStudentRegistrationRecord();
	}

	
	@Transactional(value = TxType.MANDATORY)
	public Student getIfExist(StudentRegistrationRecord record) {
		Criteria criteria = simpleHibernateTemplate.createCriteria(Student.class);
		criteria.add(Restrictions.eq("firstName", record.getPersonalDetail().getFirstName()));
		criteria.add(Restrictions.eq("lastName", record.getPersonalDetail().getLastName()));
		criteria.add(Restrictions.eq("dateOfBirth",record.getPersonalDetail().getDateOfBirth()));
		criteria.add(Restrictions.eq("email",record.getPersonalDetail().getEmail()));
		criteria.add(Restrictions.eq("mobileNumber",record.getPersonalDetail().getMobileNumber()));
		Student retrivedStudent =(Student)criteria.uniqueResult();
		return retrivedStudent==null ? null: retrivedStudent;
	}
	
	@Transactional
	public StudentRegistrationRecord getStudentRegisterRecordByRegistrationId(Long registrationId){
		StudentRegistrationRecord record = simpleHibernateTemplate
				.getObjectBasedOnId(StudentRegistrationRecord.class, registrationId, REGISTRATION_ID);
		return record == null ? null : record;
	}

	@Transactional
	public StudentRegistrationRecord getRegistrationRecordByRegistrationId(
			String studentRegistrationRecordId) {
		StudentRegistrationRecord record = 
				getStudentRegisterRecordByRegistrationId(Long.parseLong(studentRegistrationRecordId));
		if(record == null){
			throw new StudentIdDoesNotExistException("input.id.invalid");
		}
		return record;
	}


	@Transactional
	public StudentRegistrationRecord saveRegistrationStudentRecord(StudentRegistrationRecord registrationRecord){
		StudentRegistrationRecord record = simpleHibernateTemplate.saveAndGet(registrationRecord);
		saveImagesInFileSystemAndUpdateInDB(record);
		return record;
	}

	@Transactional
	public StudentRegistrationRecord deleteStudentRegistrationRecordById(String registrationId){
		StudentRegistrationRecord record = getStudentRegisterRecordByRegistrationId(Long.parseLong(registrationId));
		if(record == null){
			throw new StudentIdDoesNotExistException("input.id.invalid");
		}
		simpleHibernateTemplate.delete(record);
		return record;
	}
	
	@Transactional
	public StudentRegistrationRecord saveRegistrationRecordIfDoesNotExist(StudentRegistrationRecord record){
		if(getIfExist(record)==null){
			return saveRegistrationStudentRecord(record);
		}
		throw new StudentAlreadyRegisteredException("input.registered.already");
	}
	
	
	@Transactional
	public StudentRegistrationRecord updateRegistrationRecordIfExist(StudentRegistrationRecord record){
		if(!isRecordExist(record)){
			throw new StudentIdDoesNotExistException("input.id.invalid");
		}
		simpleHibernateTemplate.merge(record);
		return record;
	}

	@Transactional
	public boolean isRecordExist(StudentRegistrationRecord record){
		StudentRegistrationRecord registeredRecord = simpleHibernateTemplate
				.get(StudentRegistrationRecord.class, record.getRegistrationId());
			if(registeredRecord == null){
				return false;
			}
			return true;
	}
	
	
	private void saveImagesInFileSystemAndUpdateInDB(StudentRegistrationRecord registrationRecord) {
		
		if(registrationRecord.getStudentImage()!= null)
		registrationRecord.setStudentImageLocation(saveFileIntoFileSystem(registrationRecord.getStudentImage(),
				registrationRecord.getPersonalDetail().getCurrentClass().getC_Class(),
				String.valueOf(registrationRecord.getRegistrationId()), STUDENT_IMAGE_PREFIX ));

		if(registrationRecord.getFatherImage()!= null)
		registrationRecord.setFatherImageLocation(saveFileIntoFileSystem(registrationRecord.getFatherImage(),
						registrationRecord.getPersonalDetail().getCurrentClass().getC_Class(), 
						String.valueOf(registrationRecord.getRegistrationId()), FATHER_IMAGE_PREFIX ));
	
		if(registrationRecord.getMotherImage() != null)
		registrationRecord.setMotherImageLocation(saveFileIntoFileSystem(registrationRecord.getMotherImage(),
						registrationRecord.getPersonalDetail().getCurrentClass().getC_Class(), 
						String.valueOf(registrationRecord.getRegistrationId()), MOTHER_IMAGE_PREFIX ));

		if(registrationRecord.getBirthCertificate()!= null)
		registrationRecord.setBirthCertificateLocation(saveFileIntoFileSystem(registrationRecord.getBirthCertificate(),
						registrationRecord.getPersonalDetail().getCurrentClass().getC_Class(), 
						String.valueOf(registrationRecord.getRegistrationId()), BIRTH_CERT_PREFIX ));
		
		if(registrationRecord.getCastCertificate()!=null)
		registrationRecord.setCastCertificateLocation(saveFileIntoFileSystem(registrationRecord.getCastCertificate(),
						registrationRecord.getPersonalDetail().getCurrentClass().getC_Class(),
						String.valueOf(registrationRecord.getRegistrationId()), CAST_CERT_PREFIX ));
		
		if(registrationRecord.getDisabilityCertificate()!=null)
		registrationRecord.setDisabilityCertificateLocation(saveFileIntoFileSystem(registrationRecord.getDisabilityCertificate(),
						registrationRecord.getPersonalDetail().getCurrentClass().getC_Class(), 
						String.valueOf(registrationRecord.getRegistrationId()), DISABILITY_CERT_PREFIX ));
	}

	@Transactional
	public List<StudentRegistrationRecord> updateStatusOfRegistrationRecords(
			List<StatusDTO> statusDTOList) {
		List<StudentRegistrationRecord> listOfRegistrationRecords = new ArrayList<StudentRegistrationRecord>();
		
		
		for (StatusDTO statusDTO : statusDTOList) {
			StudentRegistrationRecord record =	simpleHibernateTemplate.get(StudentRegistrationRecord.class, statusDTO.getRegistrationId());
			if(record == null){
				throw new StudentIdDoesNotExistException("input.id.invalid");
			}
			record.setRegistrationStatus(RegistrationStatus.getEnum(statusDTO.getStatus()));
			listOfRegistrationRecords.add(record);
			simpleHibernateTemplate.flush();
		}  
		
		return listOfRegistrationRecords;
	}


	
	
}
