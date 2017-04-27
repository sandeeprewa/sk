package com.academics.school.pl.controller.registration.validation;

import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import com.academics.school.pl.controller.registration.dto.Category;
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
		
		validateIsEmptyOrNullOrContainsOnlyAlphnumeric(studentRegistrationRecord.getPersonalDetail().getFirstName(), "fname");
		validateIsEmptyOrNullOrContainsOnlyAlphnumeric(studentRegistrationRecord.getPersonalDetail().getLastName(),"lname");
		validateIsEmptyOrNull(studentRegistrationRecord.getPersonalDetail().getGender().getName(), "gender");
		validateIsEmptyOrNullOrContainsOnlyNumber(studentRegistrationRecord.getPersonalDetail().getMobileNumber(), "mobileno");
		validateIsEmptyOrNullOrValidEmail(studentRegistrationRecord.getPersonalDetail().getEmail(), "email");
		validateIsEmptyOrNull(studentRegistrationRecord.getPersonalDetail().getDateOfBirth(), "dataofbirth");
		validateIsEmptyOrNullOrContainsOnlyNumber(studentRegistrationRecord.getPersonalDetail().getAge(), "age");
		validateIsEmptyOrNullOrContainsOnlyAlphnumeric(studentRegistrationRecord.getPersonalDetail().getCatagory().getName(), "category");
		validateIsEmptyOrNullOrValidEnum(studentRegistrationRecord.getPersonalDetail().getDisablity().getName(),"disability" );
				

		
		String studentNationality = studentRegistrationRecord.getPersonalDetail().getNationality().getName();
				if(!ValidationUtil.isEmptyOrNull(studentNationality))
					throw new StudentRegistrationFieldValidationException("nationality","input.nationality.invalid");
				else if(!ValidationUtil.containOnlyAlphnumericWords(studentNationality))
					   throw new StudentRegistrationFieldValidationException("nationalityword","input.nationalityword.invalid");

		String studentReligion = studentRegistrationRecord.getPersonalDetail().getReligion().getName();
				if(!ValidationUtil.isEmptyOrNull(studentReligion))
					throw new StudentRegistrationFieldValidationException("religion","input.religion.invalid");	
				else if(!ValidationUtil.containOnlyAlphnumericWords(studentReligion))
					   throw new StudentRegistrationFieldValidationException("religionword","input.religionword.invalid");
				
	   String studentBloodGroup = studentRegistrationRecord.getPersonalDetail().getBloodGroup();
				if(!ValidationUtil.isEmptyOrNull(studentBloodGroup))
					throw new StudentRegistrationFieldValidationException("bloodgroup","input.bloodgroup.invalid");	
		
	   String studentAadharCardNo = studentRegistrationRecord.getPersonalDetail().getAdhaarCardNo();
				if(!ValidationUtil.isEmptyOrNull(studentAadharCardNo))
					throw new StudentRegistrationFieldValidationException("aadharcardno","input.aadharcardno.invalid");	
				else if(!ValidationUtil.containOnlyNumbers(studentAadharCardNo))
					   throw new StudentRegistrationFieldValidationException("aadharcardnonumber","input.aadharcardnonumber.invalid");
				
       //Education Detials
	   String studentPreviousSchoolName= studentRegistrationRecord.getEducationDetail().getPreviousSchoolName();
				if(!ValidationUtil.isEmptyOrNull(studentPreviousSchoolName))
					throw new StudentRegistrationFieldValidationException("previousschoolname","input.previousschoolname.invalid");
				else if(!ValidationUtil.containOnlyAlphnumericWords(studentPreviousSchoolName))
					   throw new StudentRegistrationFieldValidationException("previousschoolnameword","input.previousschoolnameword.invalid");
	 
	  String studentPreviousSchoolAddress= studentRegistrationRecord.getEducationDetail().getPreviousSchoolAddress();
					if(!ValidationUtil.isEmptyOrNull(studentPreviousSchoolAddress))
						throw new StudentRegistrationFieldValidationException("previousschooladdress","input.previousschooladdress.invalid");
					else if(!ValidationUtil.containOnlyAlphnumericWords(studentPreviousSchoolAddress))
						   throw new StudentRegistrationFieldValidationException("previousschooladdressword","input.previousschooladdressword.invalid");

					
	  String studentPreviousSchoolClass= studentRegistrationRecord.getEducationDetail().getPreviousSchoolClass();
					if(!ValidationUtil.isEmptyOrNull(studentPreviousSchoolClass))
						throw new StudentRegistrationFieldValidationException("previousschoolclass","input.previousschoolclass.invalid");
					else if(!ValidationUtil.containOnlyNumbers(studentPreviousSchoolClass))
						   throw new StudentRegistrationFieldValidationException("previousschoolclassnumber","input.previousschoolclassnumber.invalid");
					
					  
	  String studentPreviousClassPercentage= studentRegistrationRecord.getEducationDetail().getPreviousClassPercentage();
					if(!ValidationUtil.isEmptyOrNull(studentPreviousClassPercentage))
						throw new StudentRegistrationFieldValidationException("previousschoolpercentage","input.previousschoolpercentage.invalid");
					else if(!ValidationUtil.containOnlyNumbers(studentPreviousClassPercentage))
						   throw new StudentRegistrationFieldValidationException("previousschoolpercentagenumber","input.previousschoolpercentagenumber.invalid");
		
		
	  //Parent Detials				
	  String studentFatherName= studentRegistrationRecord.getParentDetails().getFatherName();
				   if(!ValidationUtil.isEmptyOrNull(studentFatherName))
						throw new StudentRegistrationFieldValidationException("fathername","input.fathername.invalid");	
				   else if(!ValidationUtil.containOnlyAlphnumericWords(studentFatherName))
					   throw new StudentRegistrationFieldValidationException("fathernameword","input.fathernameword.invalid");

				   
	  String studentFatherMobileNumber= studentRegistrationRecord.getParentDetails().getFatherMobileNumber();
				   if(!ValidationUtil.isEmptyOrNull(studentFatherMobileNumber))
						throw new StudentRegistrationFieldValidationException("fathermobilenumber","input.fathermobilenumber.invalid");	
				   else if(!ValidationUtil.containOnlyNumbers(studentFatherMobileNumber))
					   throw new StudentRegistrationFieldValidationException("fathermobilenumbernumber","input.fathermobilenumbernumber.invalid");
		
	String studentFatherEmail= studentRegistrationRecord.getParentDetails().getFatherEmail();
				   if(!ValidationUtil.isEmptyOrNull(studentFatherEmail))
						throw new StudentRegistrationFieldValidationException("fatheremail","input.fatheremail.invalid");
				   else if(!ValidationUtil.isVaildEmail(studentFatherEmail))
						throw new StudentRegistrationFieldValidationException("incorrectfatheremail","input.incorrectfatheremail.invalid");

	String studentFatherOccupation= studentRegistrationRecord.getParentDetails().getFatherOccupation();
				   if(!ValidationUtil.isEmptyOrNull(studentFatherOccupation))
						throw new StudentRegistrationFieldValidationException("fatheroccupation","input.fatheroccupation.invalid");	
				   else if(!ValidationUtil.containOnlyAlphnumericWords(studentFatherOccupation))
					   throw new StudentRegistrationFieldValidationException("fatheroccupationword","input.fatheroccupationword.invalid");

	
	 String studentMotherName= studentRegistrationRecord.getParentDetails().getMotherName();
				   if(!ValidationUtil.isEmptyOrNull(studentMotherName))
						throw new StudentRegistrationFieldValidationException("mothername","input.mothername.invalid");	
				   else if(!ValidationUtil.containOnlyAlphnumericWords(studentMotherName))
					   throw new StudentRegistrationFieldValidationException("mothernameword","input.mothernameword.invalid");
				   
	  String studentMotherMobileNumber= studentRegistrationRecord.getParentDetails().getMotherMobileNumber();
				   if(!ValidationUtil.isEmptyOrNull(studentMotherMobileNumber))
						throw new StudentRegistrationFieldValidationException("mothermobilenumber","input.mothermobilenumber.invalid");
				   else if(!ValidationUtil.containOnlyNumbers(studentMotherMobileNumber))
					   throw new StudentRegistrationFieldValidationException("mothermobilenumbernumber","input.mothermobilenumbernumber.invalid");
	
		
	String studentMotherEmail= studentRegistrationRecord.getParentDetails().getMotherEmail();
				   if(!ValidationUtil.isEmptyOrNull(studentMotherEmail))
						throw new StudentRegistrationFieldValidationException("motheremail","input.motheremail.invalid");
				   else if(!ValidationUtil.isVaildEmail(studentMotherEmail))
						throw new StudentRegistrationFieldValidationException("incorrectmotheremail","input.incorrectmotheremail.invalid");
				   
	String studentMotherOccupation= studentRegistrationRecord.getParentDetails().getMotherOccupation();
				   if(!ValidationUtil.isEmptyOrNull(studentMotherOccupation))
						throw new StudentRegistrationFieldValidationException("motheroccupation","input.motheroccupation.invalid");	
				   else if(!ValidationUtil.containOnlyAlphnumericWords(studentMotherOccupation))
					   throw new StudentRegistrationFieldValidationException("motheroccupationword","input.motheroccupationword.invalid");
				   			   
				   
	 //Present Address			   
	  String studentCurrentHouseNumber= studentRegistrationRecord.getCurrentAddress().getHouseNumber();
				   if(!ValidationUtil.isEmptyOrNull(studentCurrentHouseNumber))
						throw new StudentRegistrationFieldValidationException("currenthousenumber","input.currenthousenumber.invalid");	
				   
	 
	String studentCurrentVillage= studentRegistrationRecord.getCurrentAddress().getVillage();
				   if(!ValidationUtil.isEmptyOrNull(studentCurrentVillage))
						throw new StudentRegistrationFieldValidationException("currentvillage","input.currentvillage.invalid");	
				   else if(!ValidationUtil.containOnlyAlphnumericWords(studentCurrentVillage))
					   throw new StudentRegistrationFieldValidationException("currentvillageword","input.currentvillageword.invalid");

	String studentCurrentCity= studentRegistrationRecord.getCurrentAddress().getCity();
					if(!ValidationUtil.isEmptyOrNull(studentCurrentCity))
						throw new StudentRegistrationFieldValidationException("currentcity","input.currentcity.invalid");
					 else if(!ValidationUtil.containOnlyAlphnumericWords(studentCurrentVillage))
						   throw new StudentRegistrationFieldValidationException("currentvillageword","input.currentvillageword.invalid");

				   
      String studentCurrentState= studentRegistrationRecord.getCurrentAddress().getState().getName();
					if(!ValidationUtil.isEmptyOrNull(studentCurrentState))
						throw new StudentRegistrationFieldValidationException("currentstate","input.currentstate.invalid");
					 else if(!ValidationUtil.containOnlyAlphnumericWords(studentCurrentState))
						   throw new StudentRegistrationFieldValidationException("currentstateword","input.currentstateword.invalid");
				   
      String studentCurrentPinNumber= studentRegistrationRecord.getCurrentAddress().getPinNumber();
					if(!ValidationUtil.isEmptyOrNull(studentCurrentPinNumber))
						throw new StudentRegistrationFieldValidationException("currentpinnumber","input.currentpinnumber.invalid");	
					else if(!ValidationUtil.containOnlyNumbers(studentCurrentPinNumber))
						   throw new StudentRegistrationFieldValidationException("currentpinnumbernumber","input.currentpinnumbernumber.invalid");
	
	 String studentCurrentCountry= studentRegistrationRecord.getCurrentAddress().getCountry().getName();
						if(!ValidationUtil.isEmptyOrNull(studentCurrentCountry))
							throw new StudentRegistrationFieldValidationException("currentcountry","input.currentcountry.invalid");
						else if(!ValidationUtil.containOnlyAlphnumericWords(studentCurrentCountry))
							   throw new StudentRegistrationFieldValidationException("currentcountryword","input.currentcountryword.invalid");
					  
								   		   
	String studentCurrentAddressDetails= studentRegistrationRecord.getCurrentAddress().getAddressDetails();
						if(!ValidationUtil.isEmptyOrNull(studentCurrentAddressDetails))
							throw new StudentRegistrationFieldValidationException("currentaddressdetails","input.currentaddressdetails.invalid");
						else if(!ValidationUtil.containOnlyAlphnumericWords(studentCurrentAddressDetails))
							   throw new StudentRegistrationFieldValidationException("currentaddressdetailsword","input.currentaddressdetailsword.invalid");
					  
						
	
	 //Permanent Address
						
			String studentPermanentHouseNumber= studentRegistrationRecord.getPermanentAddress().getHouseNumber();
						   if(!ValidationUtil.isEmptyOrNull(studentPermanentHouseNumber))
								throw new StudentRegistrationFieldValidationException("permanenthousenumber","input.currenthousenumber.invalid");
						   else if(!ValidationUtil.containOnlyNumbers(studentPermanentHouseNumber))
							   throw new StudentRegistrationFieldValidationException("permanenthousenumbernumber","input.permanenthousenumbernumber.invalid");
		
			 
			String studentPermanentVillage= studentRegistrationRecord.getPermanentAddress().getVillage();
						   if(!ValidationUtil.isEmptyOrNull(studentCurrentVillage))
								throw new StudentRegistrationFieldValidationException("permanentvillage","input.permanentvillage.invalid");	
						   else if(!ValidationUtil.containOnlyAlphnumericWords(studentCurrentVillage))
							   throw new StudentRegistrationFieldValidationException("permanentvillageword","input.permanentvillageword.invalid");
					  

			String studentPermanentCity= studentRegistrationRecord.getPermanentAddress().getCity();
							if(!ValidationUtil.isEmptyOrNull(studentCurrentCity))
								throw new StudentRegistrationFieldValidationException("permanentcity","input.permanentcity.invalid");
							 else if(!ValidationUtil.containOnlyAlphnumericWords(studentCurrentCity))
								   throw new StudentRegistrationFieldValidationException("permanentcityword","input.permanentcityword.invalid");
						  
						   
		      String studentPermanentState= studentRegistrationRecord.getPermanentAddress().getState().getName();
							if(!ValidationUtil.isEmptyOrNull(studentCurrentState))
								throw new StudentRegistrationFieldValidationException("permanentstate","input.permanentstate.invalid");	
							else if(!ValidationUtil.containOnlyAlphnumericWords(studentCurrentState))
								   throw new StudentRegistrationFieldValidationException("permanentstateword","input.permanentstateword.invalid");
						  
		      String studentPermanentPinNumber= studentRegistrationRecord.getPermanentAddress().getPinNumber();
							if(!ValidationUtil.isEmptyOrNull(studentCurrentPinNumber))
								throw new StudentRegistrationFieldValidationException("permanentpinnumber","input.permanentpinnumber.invalid");	
							else if(!ValidationUtil.containOnlyNumbers(studentCurrentPinNumber))
								   throw new StudentRegistrationFieldValidationException("permanentpinnumbernumber","input.permanentpinnumbernumber.invalid");
			
			
			 String studentPermanentCountry= studentRegistrationRecord.getPermanentAddress().getCountry().getName();
								if(!ValidationUtil.isEmptyOrNull(studentCurrentCountry))
									throw new StudentRegistrationFieldValidationException("permanentcountry","input.permanentcountry.invalid");	
								else if(!ValidationUtil.containOnlyAlphnumericWords(studentCurrentCountry))
									   throw new StudentRegistrationFieldValidationException("permanentcountryword","input.permanentcountryword.invalid");
							  
										   		   
			String studentPermanentAddressDetails= studentRegistrationRecord.getPermanentAddress().getAddressDetails();
						if(!ValidationUtil.isEmptyOrNull(studentCurrentAddressDetails))
									throw new StudentRegistrationFieldValidationException("permanentaddressdetails","input.permanentaddressdetails.invalid");
						else if(!ValidationUtil.containOnlyAlphnumericWords(studentCurrentAddressDetails))
									   throw new StudentRegistrationFieldValidationException("permanentaddressdetailsword","input.permanentaddressdetailsword.invalid");
							  
		
	}
	
	private static void validateIsEmptyOrNullOrValidEnum(String stringToBeValidated, String inputKey) {
		validateIsEmptyOrNull(stringToBeValidated, inputKey);
		try{
		Category category = Category.getCategoryFromText(stringToBeValidated);
		}catch(Exception e){
			throw new StudentRegistrationFieldValidationException(inputKey,"input."+ inputKey +".invalid");
		}
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
}
