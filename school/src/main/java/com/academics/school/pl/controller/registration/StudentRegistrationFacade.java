package com.academics.school.pl.controller.registration;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;
import javax.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;
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
	private static final String IMAGE_CONTROLLER_URI = "/image/";

	@Autowired
	HttpServletRequest request;

	@Autowired
	@Qualifier("studentRegistrationServiceImpl")
	StudentRegistrationService studentRegistrationServiceImpl;
	
	public StudentRegistrationRecord createRegistrationStudentRecord(
			StudentRegistrationRecord registrationRecord) {
		registrationRecord = studentRegistrationServiceImpl.createRegistrationStudentRecord(registrationRecord);
		registrationRecord = buildRegistrationRecordByAddingImageAsResourceLocation(registrationRecord);
		return registrationRecord;
	}

	public  StudentRegistrationRecord updateStudentRegistrationRecord(
			StudentRegistrationRecord registrationRecord) {
		registrationRecord = studentRegistrationServiceImpl.updateRegistrationStudentRecord(registrationRecord);
		return buildRegistrationRecordByAddingImageAsResourceLocation(registrationRecord);
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
				return	getRegistrationRecordByRegistrationId(searchRegistrationRequestDTO.getRegistrationId());
		}
		return studentRegistrationServiceImpl.getRegistrationRecordBasedOnDiffParameter(searchRegistrationRequestDTO);
	}

	public List<StudentRegistrationRecord> changeStatusOfRegistrationRecords(
			List<StatusDTO> statusDTOList) {
		return studentRegistrationServiceImpl.changeStatusOfRegistrationRecords(statusDTOList);
	}

	private StudentRegistrationRecord buildRegistrationRecordByAddingImageAsResourceLocation(
			StudentRegistrationRecord registrationRecord) {
			
		 StringBuffer requestPathURL = new StringBuffer(request.getScheme())
		.append("://").append(request.getServerName()).append(":")
		.append(request.getServerPort())
		.append(request.getContextPath());

		StringBuffer IMAGE_RESOURCE_URI	= requestPathURL.append(IMAGE_CONTROLLER_URI);

		IMAGE_RESOURCE_URI = IMAGE_RESOURCE_URI.append(registrationRecord.getPersonalDetail().getCurrentClass().getC_Class()); 
		IMAGE_RESOURCE_URI = IMAGE_RESOURCE_URI.append("_").append(String.valueOf(registrationRecord.getRegistrationId())).append("_");
						
			String studentImageLocation = registrationRecord.getStudentImageLocation();
			if(studentImageLocation != null){
				String extension = getFileExtention(registrationRecord.getStudentImage().getOriginalFilename());
				registrationRecord.setStudentImageLocation(IMAGE_RESOURCE_URI + STUDENT_IMAGE_PREFIX +"." + extension);
			}
			
			String fatherImageLocation = registrationRecord.getFatherImageLocation();
			if(fatherImageLocation != null){
				String extension = getFileExtention(registrationRecord.getStudentImage().getOriginalFilename());
				registrationRecord.setFatherImageLocation(IMAGE_RESOURCE_URI + FATHER_IMAGE_PREFIX + "." + extension);
			}
			String motherImageLocation  = registrationRecord.getMotherImageLocation();
			if(motherImageLocation != null){
				String extension = getFileExtention(registrationRecord.getMotherImage().getOriginalFilename());
				registrationRecord.setMotherImageLocation(IMAGE_RESOURCE_URI + MOTHER_IMAGE_PREFIX + "." +extension);
			}
			
			String birthCertImageLocation = registrationRecord.getBirthCertificateLocation();
			if( birthCertImageLocation != null){
				String extension = getFileExtention(registrationRecord.getBirthCertificate().getOriginalFilename());
				registrationRecord.setBirthCertificateLocation(IMAGE_RESOURCE_URI + BIRTH_CERT_PREFIX + "." + extension);
			}
			
			String castCertImageLocation = registrationRecord.getCastCertificateLocation();
			if(castCertImageLocation !=null){
				String extension = getFileExtention(registrationRecord.getCastCertificate().getOriginalFilename());
				registrationRecord.setCastCertificateLocation(IMAGE_RESOURCE_URI + CAST_CERT_PREFIX + "."+ extension);
			}
			
			String disabilityCertificateLocation = registrationRecord.getDisabilityCertificateLocation();
			if(disabilityCertificateLocation != null){
				String extension = getFileExtention(registrationRecord.getDisabilityCertificate().getOriginalFilename());
				registrationRecord.setDisabilityCertificateLocation(IMAGE_RESOURCE_URI + DISABILITY_CERT_PREFIX +"."+ extension);
			}
			return registrationRecord;
  }

	private String getFileExtention(String studentImageLocation) {
		String[] strSpilt = studentImageLocation.split(Pattern.quote("."));
		return strSpilt[1] ;
	}
}
