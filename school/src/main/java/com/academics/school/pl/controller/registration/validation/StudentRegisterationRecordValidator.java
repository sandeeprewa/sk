package com.academics.school.pl.controller.registration.validation;

import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import com.academics.school.pl.controller.registration.dto.Category;
import com.academics.school.pl.controller.registration.dto.Disability;
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
		validateIsEmptyOrNullOrValidAlphanumericCategory(studentRegistrationRecord.getPersonalDetail().getCategory().getName(), "category");
		validateIsEmptyOrNullOrValidAlphanumericDisablity(studentRegistrationRecord.getPersonalDetail().getDisability().getName(),"disability" );
		validateIsEmptyOrNullOrValidAlphanumericNation(studentRegistrationRecord.getPersonalDetail().getNationality().getName(),"nationality" );
		validateIsEmptyOrNullOrValidAlphanumericReligion(studentRegistrationRecord.getPersonalDetail().getReligion().getName(),"religion" );
		validateIsEmptyOrNullOrContainsOnlyAlphnumeric(studentRegistrationRecord.getPersonalDetail().getBloodGroup(), "bloodgroup");
		validateIsEmptyOrNullOrContainsOnlyAlphnumeric(studentRegistrationRecord.getPersonalDetail().getAdhaarCardNumber(), "aadharcardno");
       //Education Details
		validateIsEmptyOrNullOrContainsOnlyAlphnumeric(studentRegistrationRecord.getPersonalDetail().getPreviousEducationDetail().getPreviousSchoolName(), "previousschoolname");
		validateIsEmptyOrNullOrContainsOnlyAlphnumeric(studentRegistrationRecord.getPersonalDetail().getPreviousEducationDetail().getPreviousSchoolAddress(), "previousschooladdress");
		validateIsEmptyOrNullOrContainsOnlyNumber(studentRegistrationRecord.getPersonalDetail().getPreviousEducationDetail().getPreviousSchoolClass(), "previousschoolclass");
		validateIsEmptyOrNullOrContainsOnlyNumber(studentRegistrationRecord.getPersonalDetail().getPreviousEducationDetail().getPreviousClassPercentage(), "previousschoolpercentage");
	  //Parent Details				
		validateIsEmptyOrNullOrContainsOnlyAlphnumeric(studentRegistrationRecord.getPersonalDetail().getParentDetails().getFatherName(), "fathername");
		validateIsEmptyOrNullOrContainsOnlyNumber(studentRegistrationRecord.getPersonalDetail().getParentDetails().getFatherMobileNumber(), "fathermobilenumber");
		validateIsEmptyOrNullOrValidEmail(studentRegistrationRecord.getPersonalDetail().getParentDetails().getFatherEmail(), "fatheremail");
		validateIsEmptyOrNull(studentRegistrationRecord.getPersonalDetail().getParentDetails().getFatherOccupation(), "fatheroccupation");
		validateIsEmptyOrNullOrContainsOnlyAlphnumeric(studentRegistrationRecord.getPersonalDetail().getParentDetails().getMotherName(), "mothername");
		validateIsEmptyOrNullOrContainsOnlyNumber(studentRegistrationRecord.getPersonalDetail().getParentDetails().getMotherMobileNumber(), "mothermobilenumber");
		validateIsEmptyOrNullOrValidEmail(studentRegistrationRecord.getPersonalDetail().getParentDetails().getMotherEmail(), "motheremail");
		validateIsEmptyOrNull(studentRegistrationRecord.getPersonalDetail().getParentDetails().getMotherOccupation(), "motheroccupation");		   			   
	 //Present Address			   
		validateIsEmptyOrNull(studentRegistrationRecord.getPersonalDetail().getAddress().get(1).getHouseNumber(), "currenthousenumber");
		validateIsEmptyOrNull(studentRegistrationRecord.getPersonalDetail().getAddress().get(1).getVillage(), "currentvillage");
		validateIsEmptyOrNull(studentRegistrationRecord.getPersonalDetail().getAddress().get(1).getCity(), "currentcity");
		validateIsEmptyOrNullOrValidAlphanumericState(studentRegistrationRecord.getPersonalDetail().getAddress().get(1).getState().getName(), "currentstate");
		validateIsEmptyOrNullOrContainsOnlyNumber(studentRegistrationRecord.getPersonalDetail().getAddress().get(1).getPinNumber(), "currentpinnumber");
		validateIsEmptyOrNullOrValidAlphanumericNation(studentRegistrationRecord.getPersonalDetail().getAddress().get(1).getCountry().getName(), "currentcountry");
		validateIsEmptyOrNull(studentRegistrationRecord.getPersonalDetail().getAddress().get(1).getAddressDetails(), "currentaddressdetails");
	//Permanent Address
		validateIsEmptyOrNull(studentRegistrationRecord.getPersonalDetail().getAddress().get(0).getHouseNumber(), "permanenthousenumber");
		validateIsEmptyOrNull(studentRegistrationRecord.getPersonalDetail().getAddress().get(0).getVillage(), "permanentvillage");
		validateIsEmptyOrNull(studentRegistrationRecord.getPersonalDetail().getAddress().get(0).getCity(), "permanentcity");
		validateIsEmptyOrNullOrValidAlphanumericState(studentRegistrationRecord.getPersonalDetail().getAddress().get(0).getState().getName(), "permanentstate");
		validateIsEmptyOrNullOrContainsOnlyNumber(studentRegistrationRecord.getPersonalDetail().getAddress().get(0).getPinNumber(), "permanentpinnumber");
		validateIsEmptyOrNullOrValidAlphanumericNation(studentRegistrationRecord.getPersonalDetail().getAddress().get(0).getCountry().getName(), "permanentcountry");
		validateIsEmptyOrNull(studentRegistrationRecord.getPersonalDetail().getAddress().get(0).getAddressDetails(), "permanentaddressdetails");
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
  //  	validateContainsOnlyAlphnumeric(stringToBeValidated, inputKey);
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
		 Disability disability = Disability.getEnumFromText(stringInput);
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
