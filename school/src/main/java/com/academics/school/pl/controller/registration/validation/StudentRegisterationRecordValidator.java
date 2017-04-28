package com.academics.school.pl.controller.registration.validation;

import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import com.academics.school.pl.controller.registration.dto.Category;
import com.academics.school.pl.controller.registration.dto.Disablity;
import com.academics.school.pl.controller.registration.dto.Gender;
import com.academics.school.pl.controller.registration.dto.Nation;
import com.academics.school.pl.controller.registration.dto.Religion;
import com.academics.school.pl.controller.registration.dto.State;
import com.academics.school.pl.controller.registration.dto.StudentRegistrationRecord;
import com.academics.school.pl.controller.registration.error.StudentRegistrationFieldValidationException;

public class StudentRegisterationRecordValidator implements Validator{

	public boolean supports(Class<?> clazz) {
		return StudentRegistrationRecord.class.equals(clazz);
	}

	public void validate(Object target, Errors errors) {
		StudentRegistrationRecord studentAdmissionRecord = (StudentRegistrationRecord)target;
	}
	
	/*
	 * Manual validation
	 */
	public static void validate(StudentRegistrationRecord studentRegistrationRecord) throws StudentRegistrationFieldValidationException{
		
		//Student Personal Details
		
		validateIsEmptyOrNullOrContainsOnlyAlphnumeric(studentRegistrationRecord.getPersonalDetail().getFirstName(), "fname");
		validateIsEmptyOrNullOrContainsOnlyAlphnumeric(studentRegistrationRecord.getPersonalDetail().getLastName(),"lname");
		validateIsEmptyOrNullOrValidAlphanumericGender(studentRegistrationRecord.getPersonalDetail().getGender().getName(), "gender");
		validateIsEmptyOrNullOrContainsOnlyNumber(studentRegistrationRecord.getPersonalDetail().getMobileNumber(), "mobileno");
		validateIsEmptyOrNullOrValidEmail(studentRegistrationRecord.getPersonalDetail().getEmail(), "email");
		validateIsEmptyOrNull(studentRegistrationRecord.getPersonalDetail().getDateOfBirth(), "dataofbirth");
		validateIsEmptyOrNullOrContainsOnlyNumber(studentRegistrationRecord.getPersonalDetail().getAge(), "age");
		validateIsEmptyOrNullOrValidAlphanumericCategory(studentRegistrationRecord.getPersonalDetail().getCatagory().getName(), "category");
		validateIsEmptyOrNullOrValidAlphanumericDisablity(studentRegistrationRecord.getPersonalDetail().getDisablity().getName(),"disability" );
		validateIsEmptyOrNullOrValidAlphanumericNation(studentRegistrationRecord.getPersonalDetail().getDisablity().getName(),"nationality" );
		validateIsEmptyOrNullOrValidAlphanumericReligion(studentRegistrationRecord.getPersonalDetail().getReligion().getName(),"religion" );
		validateIsEmptyOrNullOrContainsOnlyAlphnumeric(studentRegistrationRecord.getPersonalDetail().getBloodGroup(), "bloodgroup");
		validateIsEmptyOrNullOrContainsOnlyAlphnumeric(studentRegistrationRecord.getPersonalDetail().getAdhaarCardNo(), "aadharcardno");
				
       //Education Details
		validateIsEmptyOrNullOrContainsOnlyAlphnumeric(studentRegistrationRecord.getEducationDetail().getPreviousSchoolName(), "previousschoolname");
		validateIsEmptyOrNullOrContainsOnlyAlphnumeric(studentRegistrationRecord.getEducationDetail().getPreviousSchoolAddress(), "previousschooladdress");
		validateIsEmptyOrNullOrContainsOnlyNumber(studentRegistrationRecord.getEducationDetail().getPreviousSchoolClass(), "previousschoolclass");
		validateIsEmptyOrNullOrContainsOnlyNumber(studentRegistrationRecord.getEducationDetail().getPreviousClassPercentage(), "previousschoolpercentage");
	  
	  //Parent Details				
		validateIsEmptyOrNullOrContainsOnlyAlphnumeric(studentRegistrationRecord.getParentDetails().getFatherName(), "fathername");
		validateIsEmptyOrNullOrContainsOnlyNumber(studentRegistrationRecord.getParentDetails().getFatherMobileNumber(), "fathermobilenumber");
		validateIsEmptyOrNullOrValidEmail(studentRegistrationRecord.getParentDetails().getFatherEmail(), "fatheremail");
		validateIsEmptyOrNullOrContainsOnlyNumber(studentRegistrationRecord.getParentDetails().getFatherOccupation(), "fatheroccupation");
	
		validateIsEmptyOrNullOrContainsOnlyAlphnumeric(studentRegistrationRecord.getParentDetails().getMotherName(), "mothername");
		validateIsEmptyOrNullOrContainsOnlyNumber(studentRegistrationRecord.getParentDetails().getMotherMobileNumber(), "mothermobilenumber");
		validateIsEmptyOrNullOrValidEmail(studentRegistrationRecord.getParentDetails().getMotherEmail(), "motheremail");
		validateIsEmptyOrNullOrContainsOnlyNumber(studentRegistrationRecord.getParentDetails().getMotherOccupation(), "motheroccupation");		   			   
				   
	 //Present Address			   
		validateIsEmptyOrNullOrContainsOnlyNumber(studentRegistrationRecord.getCurrentAddress().getHouseNumber(), "currenthousenumber");
		validateIsEmptyOrNullOrContainsOnlyAlphnumeric(studentRegistrationRecord.getCurrentAddress().getVillage(), "currentvillage");
		validateIsEmptyOrNullOrContainsOnlyAlphnumeric(studentRegistrationRecord.getCurrentAddress().getCity(), "currentcity");
		validateIsEmptyOrNullOrValidAlphanumericState(studentRegistrationRecord.getCurrentAddress().getState().getName(), "currentstate");
		validateIsEmptyOrNullOrContainsOnlyNumber(studentRegistrationRecord.getCurrentAddress().getPinNumber(), "currentpinnumber");
		validateIsEmptyOrNullOrValidAlphanumericNation(studentRegistrationRecord.getCurrentAddress().getCountry().getName(), "currentcountry");
		validateIsEmptyOrNullOrContainsOnlyAlphnumeric(studentRegistrationRecord.getCurrentAddress().getAddressDetails(), "currentaddressdetails");
	  		   
	//Permanent Address
		validateIsEmptyOrNullOrContainsOnlyNumber(studentRegistrationRecord.getCurrentAddress().getHouseNumber(), "permanenthousenumber");
		validateIsEmptyOrNullOrContainsOnlyAlphnumeric(studentRegistrationRecord.getCurrentAddress().getVillage(), "permanentvillage");
		validateIsEmptyOrNullOrContainsOnlyAlphnumeric(studentRegistrationRecord.getCurrentAddress().getCity(), "permanentcity");
		validateIsEmptyOrNullOrValidAlphanumericState(studentRegistrationRecord.getCurrentAddress().getState().getName(), "permanentstate");
		validateIsEmptyOrNullOrContainsOnlyNumber(studentRegistrationRecord.getCurrentAddress().getPinNumber(), "permanentpinnumber");
		validateIsEmptyOrNullOrValidAlphanumericNation(studentRegistrationRecord.getCurrentAddress().getCountry().getName(), "permanentcountry");
		validateIsEmptyOrNullOrContainsOnlyAlphnumeric(studentRegistrationRecord.getCurrentAddress().getAddressDetails(), "permanentaddressdetails");
					  
		
	}
	
	
	private static void validateIsEmptyOrNullOrValidEmail(String stringToBeValidated, String inputKey){
		validateIsEmptyOrNull(stringToBeValidated, inputKey);
		validatesValidEmail(stringToBeValidated, inputKey);
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
		if(!ValidationUtil.isEmptyOrNull(stringToBeValidated))
			throw new StudentRegistrationFieldValidationException(inputKey,"input."+ inputKey +".invalid");
	}
	
	private static void validateContainsOnlyNumber(String stringToBeValidated, String inputKey){
		if(!ValidationUtil.containOnlyNumbers(stringToBeValidated))
			throw new StudentRegistrationFieldValidationException(inputKey,"input."+ inputKey +".invalid");
	}
	
	private static void validatesValidEmail(String stringToBeValidated, String inputKey){
		if(!ValidationUtil.isVaildEmail(stringToBeValidated))
			throw new StudentRegistrationFieldValidationException(inputKey,"input."+ inputKey +".invalid");
	}
	
	
	private static void validateCategoryStatus(String stringInput){
		Category category = Category.getEnumFromText(stringInput);
	}
	
	
    private static void validateIsEmptyOrNullOrValidAlphanumericCategory(String stringToBeValidated, String inputKey) {
		
		validateIsEmptyOrNullOrContainsOnlyAlphnumeric(stringToBeValidated, inputKey);
		validateCategoryStatus(stringToBeValidated);
	}

  private static void validateReligionStatus(String stringInput){
	  Religion religion = Religion.getEnumFromText(stringInput);
	}

	private static void validateIsEmptyOrNullOrValidAlphanumericReligion(String stringToBeValidated, String inputKey) {
		
		validateIsEmptyOrNullOrContainsOnlyAlphnumeric(stringToBeValidated, inputKey);
		validateReligionStatus(stringToBeValidated);
	}
	
	 private static void validateDisablityStatus(String stringInput){
		 Disablity disability = Disablity.getEnumFromText(stringInput);
		}

		private static void validateIsEmptyOrNullOrValidAlphanumericDisablity(String stringToBeValidated, String inputKey) {
			
			validateIsEmptyOrNullOrContainsOnlyAlphnumeric(stringToBeValidated, inputKey);
			validateDisablityStatus(stringToBeValidated);
		}
	
	
		 private static void validateGenderStatus(String stringInput){
			 Gender gender = Gender.getEnumFromText(stringInput);
			}

			private static void validateIsEmptyOrNullOrValidAlphanumericGender(String stringToBeValidated, String inputKey) {
				
				validateIsEmptyOrNullOrContainsOnlyAlphnumeric(stringToBeValidated, inputKey);
				validateGenderStatus(stringToBeValidated);
			}
	
			 private static void validateNationStatus(String stringInput){
				 Nation nation = Nation.getEnumFromText(stringInput);
				}

				private static void validateIsEmptyOrNullOrValidAlphanumericNation(String stringToBeValidated, String inputKey) {
					
					validateIsEmptyOrNullOrContainsOnlyAlphnumeric(stringToBeValidated, inputKey);
					validateNationStatus(stringToBeValidated);
				}
	
		private static void validateStateStatus(String stringInput){
					 State state = State.getEnumFromText(stringInput);
					}

	private static void validateIsEmptyOrNullOrValidAlphanumericState(String stringToBeValidated, String inputKey) {
						
						validateIsEmptyOrNullOrContainsOnlyAlphnumeric(stringToBeValidated, inputKey);
						validateStateStatus(stringToBeValidated);
					}

	
}
