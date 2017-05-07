package com.academics.school.pl.controller.registration.validation;

import java.util.ArrayList;
import java.util.List;

import com.academics.school.pl.controller.registration.dto.RegistrationRecordStatusTrackerDTO;
import com.academics.school.pl.controller.registration.dto.RegistrationStatus;
import com.academics.school.pl.controller.registration.dto.StatusDTO;
import com.academics.school.pl.controller.registration.error.StudentRegistrationFieldValidationException;

public class RegistrationRecordStatusDTOValidator {

	public static void validate(List<StatusDTO> statusDTOList) {
		for (StatusDTO statusDTO : statusDTOList) {
			   if(ValidationUtil.isEmpty(String.valueOf(statusDTO.getRegistrationId())))
				   throw new StudentRegistrationFieldValidationException("Registration Id",
						   "input.registrationid.invalid");
			   if(!isValidStatus(statusDTO.getStatus()))
				   throw new StudentRegistrationFieldValidationException("Status", 
						   "input.status.invalid");
		}
	}

	public static boolean isValidStatus(String status){
		try{
			RegistrationStatus registrationStatus = RegistrationStatus.getEnum(status);
			return true;
		}catch(Exception e){
			return false;
		}
	}
}
