package com.academics.school.pl.controller.registration;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import com.academics.school.pl.controller.registration.dto.RegistrationRecordStatusTrackerDTO;
import com.academics.school.pl.controller.registration.dto.SearchRegistrationRequestDTO;
import com.academics.school.pl.controller.registration.dto.StatusDTO;
import com.academics.school.pl.controller.registration.dto.StudentRegistrationRecord;
import com.academics.school.sl.registration.StudentRegistrationService;

@Component
public class StudentRegistrationFacade {
	
	private static final String STUDENT_IMAGE_PREFIX = "StudentImage";
	private static final String FATHER_IMAGE_PREFIX = "FatherImage";
	private static final String MOTHER_IMAGE_PREFIX = "MotherImage";
	private static final String BIRTH_CERT_PREFIX = "Birth_Certificate_Image";
	private static final String CAST_CERT_PREFIX = "Cast_Certificate_Image";
	private static final String DISABILITY_CERT_PREFIX = "Disablity_Certificate_Image";


	@Autowired
	@Qualifier("studentRegistrationServiceImpl")
	StudentRegistrationService studentRegistrationServiceImpl;
	
	public StudentRegistrationRecord createRegistrationStudentRecord(
			StudentRegistrationRecord registrationRecord) {
//		registrationRecord = studentRegistrationServiceImpl.createRegistrationStudentRecord(registrationRecord);
//		registrationRecord = buildRegistrationRecordByAddingImageAsResourceLocation(registrationRecord);
		return studentRegistrationServiceImpl.createRegistrationStudentRecord(registrationRecord);
	}


	public  StudentRegistrationRecord updateStudentRegistrationRecord(
			StudentRegistrationRecord registrationRecord) {
		return studentRegistrationServiceImpl.updateRegistrationStudentRecord(registrationRecord);
	}

	public StudentRegistrationRecord getRegistrationRecordByRegistrationId(String studentRegistrationRecordId) {
		return studentRegistrationServiceImpl.getRegistrationRecordByRegistrationId(studentRegistrationRecordId);
	}

	public StudentRegistrationRecord deleteStudentRegistrationRecordById(
			String studentRegisterRecordId) {
		return studentRegistrationServiceImpl.deleteStudentRegistrationRecordById(studentRegisterRecordId);
	}

	public StudentRegistrationRecord getRegistrationRecordBasedOnDiffParameter(
			SearchRegistrationRequestDTO searchRegistrationRequestDTO) {
		if(searchRegistrationRequestDTO.getRegistrationId()!= null){
		return	studentRegistrationServiceImpl.getRegistrationRecordByRegistrationId(searchRegistrationRequestDTO.getRegistrationId());
		}
		return studentRegistrationServiceImpl.getRegistrationRecordBasedOnDiffParameter(searchRegistrationRequestDTO);
	}

	public List<StudentRegistrationRecord> changeStatusOfRegistrationRecords(
			List<StatusDTO> statusDTOList) {
		// TODO Auto-generated method stub
		return studentRegistrationServiceImpl.changeStatusOfRegistrationRecords(statusDTOList);
	}

	private StudentRegistrationRecord buildRegistrationRecordByAddingImageAsResourceLocation(
			StudentRegistrationRecord registrationRecord) {
			String imageLoc = registrationRecord.getPersonalDetail().getCurrentClass().getC_Class(); 
			imageLoc = imageLoc + "_" + String.valueOf(registrationRecord.getRegistrationId()) +"_";
			
			String studentImageLoc = imageLoc + STUDENT_IMAGE_PREFIX;
			String fatherImageLoc = imageLoc + FATHER_IMAGE_PREFIX;
			String motherImageLoc  = imageLoc + MOTHER_IMAGE_PREFIX;
			String birthCertImageLoc = imageLoc + BIRTH_CERT_PREFIX;
			String castCertImageLoc = imageLoc + CAST_CERT_PREFIX;
			String disabilityImageLoc = imageLoc + DISABILITY_CERT_PREFIX;
			
			String studentImageLocation = registrationRecord.getStudentImageLocation();
			System.out.println(registrationRecord.getStudentImage().getOriginalFilename());
			System.out.println(registrationRecord.getStudentImage().getContentType());
			
			if(studentImageLocation != null){
				String extension = registrationRecord.getStudentImage().getOriginalFilename();
				registrationRecord.setStudentImageLocation(studentImageLoc + extension);
			}
			
			String fatherImageLocation = registrationRecord.getFatherImageLocation();
			if(fatherImageLocation != null){
				String extension = getFileExtention(fatherImageLocation);
				registrationRecord.setFatherImageLocation(fatherImageLoc + "." + extension);
			}
			String motherImageLocation  = registrationRecord.getMotherImageLocation();
			if(motherImageLocation != null){
				String extension = getFileExtention(motherImageLocation);
				registrationRecord.setMotherImageLocation(motherImageLoc + "." +extension);
			}
			
			String birthCertImageLocation = registrationRecord.getBirthCertificateLocation();
			if( birthCertImageLocation != null){
				String extension = getFileExtention(birthCertImageLocation);
				registrationRecord.setBirthCertificateLocation(birthCertImageLoc + "." + extension);
			}
			
			String castCertImageLocation = registrationRecord.getCastCertificateLocation();
			if(castCertImageLocation !=null){
				String extension = getFileExtention(castCertImageLocation);
				registrationRecord.setCastCertificateLocation(castCertImageLoc + "."+ extension);
			}
			
			String disabilityCertificateLocation = registrationRecord.getDisabilityCertificateLocation();
			if(disabilityCertificateLocation != null){
				String extension = getFileExtention(disabilityCertificateLocation);
				registrationRecord.setDisabilityCertificateLocation(disabilityImageLoc +"."+ extension);
			}
			return registrationRecord;
  }


	private String getFileExtention(String studentImageLocation) {
		String[] strSpilt = studentImageLocation.split(".");
		return "jpg" ;
	}

}
