package com.academics.school.pl.controller.admission.validation;

import org.springframework.validation.Errors;
import org.springframework.validation.Validator;
import com.academics.school.pl.controller.registration.dto.StudentRegistrationRecord;
import com.academics.school.pl.controller.registration.error.StudentRegistrationFieldValidationException;

public class StudentAdmissionRecordValidator implements Validator{

	public boolean supports(Class<?> clazz) {
		return StudentRegistrationRecord.class.equals(clazz);
	}

	public void validate(Object target, Errors errors) {
		StudentRegistrationRecord studentRegistrationRecord = (StudentRegistrationRecord)target;
	}
	
	/*
	 * Manual validation
	 */
	public static void validate(StudentRegistrationRecord studentRegistrationRecord) throws StudentRegistrationFieldValidationException{
		
		String studentRegistrationId = studentRegistrationRecord.getPersonalDetail().getAdhaarCardNo();
		if(!com.academics.school.pl.controller.registration.validation.ValidationUtil.isEmptyOrNull(studentRegistrationId))
			throw new StudentRegistrationFieldValidationException("rid","input.rid.invalid");
		else if(!com.academics.school.pl.controller.registration.validation.ValidationUtil.containOnlyNumbers(studentRegistrationId))
		   throw new StudentRegistrationFieldValidationException("ridword","input.ridword.invalid");
		
		
											  
		
								
			
					

						
						
						
						
				   
				   
				   
				   
				   
				   
				   
				   
				   
				   
				   
				   
				   
				   
	}
}

