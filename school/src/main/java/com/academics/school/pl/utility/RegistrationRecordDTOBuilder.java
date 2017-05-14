package com.academics.school.pl.utility;

import java.io.IOException;

import com.academics.school.pl.controller.registration.dto.FakeStudentRegistrationDTO;
import com.academics.school.pl.controller.registration.dto.StudentRegistrationRecord;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class RegistrationRecordDTOBuilder {
		

	public static StudentRegistrationRecord buildStudentRegistrationRecordDTO(FakeStudentRegistrationDTO
			   fakeRegistrationRecord) throws JsonParseException, JsonMappingException, IOException {

		StudentRegistrationRecord studentRegistrationRecord = (StudentRegistrationRecord)new ObjectMapper()
							.readValue(fakeRegistrationRecord.getRegistrationJson(),StudentRegistrationRecord.class);
			studentRegistrationRecord.setStudentImage(fakeRegistrationRecord.getStudentImage());
			studentRegistrationRecord.setFatherImage(fakeRegistrationRecord.getFatherImage());
			studentRegistrationRecord.setMotherImage(fakeRegistrationRecord.getMotherImage());
			studentRegistrationRecord.setBirthCertificate(fakeRegistrationRecord.getBirthCertificate());
			studentRegistrationRecord.setCastCertificate(fakeRegistrationRecord.getCastCertificate());
			studentRegistrationRecord.setDisabilityCertificate(fakeRegistrationRecord.getDisabilityCertificate());
			return studentRegistrationRecord;
	}

}
