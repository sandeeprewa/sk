package com.academics.school.pl.controller.classallocation.validation;

import java.util.ArrayList;
import java.util.List;

import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import com.academics.school.pl.controller.claaallocation.dto.SearchClassAllocationRequestDTO;
import com.academics.school.pl.controller.claaallocation.dto.SectionCreationDTO;
import com.academics.school.pl.controller.claaallocation.dto.StudentClassAllocationRecord;
import com.academics.school.pl.controller.classallocation.FakeStudentClassAllocationRecord;
import com.academics.school.pl.controller.classallocation.StudentClassAllocationRecordDTO;
import com.academics.school.pl.controller.classallocation.error.StudentClassAllocationFieldValidationException;
import com.academics.school.pl.controller.registration.error.StudentRegistrationFieldValidationException;
import com.academics.school.pl.controller.registration.validation.ValidationUtil;
import com.academics.school.pl.controller.registration.dto.Category;
import com.academics.school.pl.controller.registration.dto.CurrentClass;
import com.academics.school.pl.controller.registration.dto.Religion;
import com.academics.school.pl.controller.registration.dto.StudentClass;

public class StudentClassAllocationRecordValidator implements Validator{

	public boolean supports(Class<?> clazz) {
		// TODO Auto-generated method stub
		return false;
	}

	public void validate(Object target, Errors errors) {
		StudentClassAllocationRecord studentClassAllocationRecord = (StudentClassAllocationRecord)target;
		
	}
	
	public static void validate(SearchClassAllocationRequestDTO searchClassAllocationRequestDTO) throws StudentClassAllocationFieldValidationException{
		
		validateIsEmptyOrNullOrValidAlphanumericClass(searchClassAllocationRequestDTO.getStudentclass(), "classname");
						  	
	}
	
    public static void validate(StudentClassAllocationRecordDTO studentClassAllocationRecordDTO) throws StudentClassAllocationFieldValidationException{
		
		validateIsEmptyOrNullOrValidAlphanumericClass(studentClassAllocationRecordDTO.getStudentclass(), "classname");
		validateIsEmptyOrNullOrContainsOnlyAlphnumeric(studentClassAllocationRecordDTO.getSection(), "section");
						  	
	}
	
public static void validate( FakeStudentClassAllocationRecord  fakeStudentClassAllocationRecord) throws StudentClassAllocationFieldValidationException{
		
		validateIsEmptyOrNullOrValidAlphanumericClass(fakeStudentClassAllocationRecord.getStudentclass(), "classname");
		validateIsEmptyOrNullOrContainsOnlyAlphnumeric(fakeStudentClassAllocationRecord.getSection(), "classallocationsection");
						  	
	}
	
public static void validate(StudentClassAllocationRecord studentClassAllocationRecord) throws StudentClassAllocationFieldValidationException{
		List<String> listofStudentId=studentClassAllocationRecord.getStudentid();
		for (String list : listofStudentId) {
			validateIsEmptyOrNullOrContainsOnlyNumber(list, "classallocationadmisionid");
		}
	    
		validateIsEmptyOrNullOrContainsOnlyAlphnumeric(studentClassAllocationRecord.getSection(), "classallocationsection");
						  	
	}



public static void validate(SectionCreationDTO sectionCreationDTO, String input) throws StudentClassAllocationFieldValidationException, StudentClassAllocationFieldValidationException{
	
	if(input=="POST"){
	validateIsEmptyOrNullOrValidAlphanumericClass(sectionCreationDTO.getClassname(), "classname");
    validateIsEmptyOrNullOrContainsOnlyAlphnumeric(sectionCreationDTO.getSectionname(), "sectionname") ;
	}
    if(input=="UPT"){
    validateIsEmptyOrNullOrValidAlphanumericClass(sectionCreationDTO.getClassname(), "classname");
    validateIsEmptyOrNullOrContainsOnlyAlphnumeric(sectionCreationDTO.getSectionname(), "sectionname") ;
	validateIsEmptyOrNullOrContainsOnlyAlphnumeric(sectionCreationDTO.getUpdatesectionname(), "updatesectionname");
    }
    if(input=="GET")
    	validateIsEmptyOrNullOrValidAlphanumericClass(sectionCreationDTO.getClassname(), "classname");
        
    

}

public static void validate(List<StudentClassAllocationRecord> statusDTOList) {
	for (StudentClassAllocationRecord statusDTO : statusDTOList) {
		validateIsEmptyOrNullOrContainsOnlyNumber(String.valueOf(statusDTO.getStudentid()), "admissionid");
		validateIsEmptyOrNullOrContainsOnlyAlphnumeric(String.valueOf(statusDTO.getSection()), "section");
		   /*if(ValidationUtil.isEmptyOrNull(String.valueOf(statusDTO.getAdmissionid())))
			   throw new StudentRegistrationFieldValidationException("Registration Id", "input.admissionid.invalid");
		   if(ValidationUtil.isEmptyOrNull(String.valueOf(statusDTO.getSection())))
			   throw new StudentRegistrationFieldValidationException("Section", "input.section.invalid");*/
	}
}

private static void validateIsEmptyOrNullOrValidAlphanumericClass(String stringToBeValidated, String inputKey)throws StudentClassAllocationFieldValidationException {
	
		validateIsEmptyOrNull(stringToBeValidated, inputKey);
		
		validateClassStatus(stringToBeValidated);
		
	}

private static void validateClassStatus(String stringInput)throws StudentClassAllocationFieldValidationException{
	StudentClass currentClass = StudentClass.getEnumFromText(stringInput);
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
