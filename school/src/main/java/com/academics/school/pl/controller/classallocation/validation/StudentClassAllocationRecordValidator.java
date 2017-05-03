package com.academics.school.pl.controller.classallocation.validation;

import java.util.ArrayList;

import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import com.academics.school.pl.controller.claaallocation.dto.SectionCreationDTO;
import com.academics.school.pl.controller.claaallocation.dto.StudentClassAllocationRecord;
import com.academics.school.pl.controller.classallocation.error.StudentClassAllocationFieldValidationException;
import com.academics.school.pl.controller.registration.error.StudentRegistrationFieldValidationException;
import com.academics.school.pl.controller.registration.validation.ValidationUtil;
import com.academics.school.pl.controller.registration.dto.Religion;
import com.academics.school.pl.controller.registration.dto.StudentClass;;

public class StudentClassAllocationRecordValidator implements Validator{

	public boolean supports(Class<?> clazz) {
		// TODO Auto-generated method stub
		return false;
	}

	public void validate(Object target, Errors errors) {
		StudentClassAllocationRecord studentClassAllocationRecord = (StudentClassAllocationRecord)target;
		
	}
	
	
public static void validate(StudentClassAllocationRecord studentClassAllocationRecord) throws StudentClassAllocationFieldValidationException{
		
	    validateIsEmptyOrNullOrContainsOnlyNumber(studentClassAllocationRecord.getAdmissionid(), "classallocationadmisionid");
		validateIsEmptyOrNullOrContainsOnlyAlphnumeric(studentClassAllocationRecord.getSection(), "classallocationsection");
						  	
	}

public static void validate(SectionCreationDTO sectionCreationDTO, String input) throws StudentClassAllocationFieldValidationException{
	
	validateIsEmptyOrNullOrValidAlphanumericClass(sectionCreationDTO.getClassname(), "classname");
    validateIsEmptyOrNullOrContainsOnlyAlphnumeric(sectionCreationDTO.getSectionname(), "sectionname") ;
    if(input=="UPT")
	validateIsEmptyOrNullOrContainsOnlyAlphnumeric(sectionCreationDTO.getUpdatesectionname(), "updatesectionname");

}

public static void validate(ArrayList<StudentClassAllocationRecord> statusDTOList) {
	for (StudentClassAllocationRecord statusDTO : statusDTOList) {
		   if(ValidationUtil.isEmptyOrNull(String.valueOf(statusDTO.getAdmissionid())))
			   throw new StudentRegistrationFieldValidationException("Registration Id", "input.admissionid.invalid");
		   if(ValidationUtil.isEmptyOrNull(String.valueOf(statusDTO.getSection())))
			   throw new StudentRegistrationFieldValidationException("Section", "input.section.invalid");
	}
}

private static void validateIsEmptyOrNullOrValidAlphanumericClass(String stringToBeValidated, String inputKey) {
	
		validateIsEmptyOrNullOrContainsOnlyAlphnumeric(stringToBeValidated, inputKey);
		validateClassStatus(stringToBeValidated);
	}

private static void validateClassStatus(String stringInput){
	  StudentClass religion = StudentClass.getEnumFromText(stringInput);
	}



private static void validateIsEmptyOrNullOrContainsOnlyNumber(String stringToBeValidated, String inputKey) {
	validateIsEmptyOrNull(stringToBeValidated, inputKey);
	validateContainsOnlyNumber(stringToBeValidated, inputKey);
}

private static void validateIsEmptyOrNullOrContainsOnlyAlphnumeric(String stringToBeValidated, String inputKey) {
	validateIsEmptyOrNull(stringToBeValidated, inputKey);
  	validateContainsOnlyAlphnumeric(stringToBeValidated, inputKey);
}

private static void validateContainsOnlyAlphnumeric(String stringToBeValidated, String inputKey){
	 if(!ValidationUtil.containOnlyAlphnumericWords(stringToBeValidated))
		   throw new StudentRegistrationFieldValidationException(inputKey + "word","input."+ inputKey + "word" +".invalid");
}

private static void validateIsEmptyOrNull(String stringToBeValidated, String inputKey) {
	if(ValidationUtil.isEmptyOrNull(stringToBeValidated))
		throw new StudentRegistrationFieldValidationException(inputKey,"input."+ inputKey +".invalid");
}

private static void validateContainsOnlyNumber(String stringToBeValidated, String inputKey){
	if(!ValidationUtil.containOnlyNumbers(stringToBeValidated))
		throw new StudentRegistrationFieldValidationException(inputKey,"input."+ inputKey +".invalid");
}



}
