package com.academics.school.pl.controller.erp.employee.dto;

import java.sql.Timestamp;

import org.springframework.web.multipart.MultipartFile;

import com.academics.school.pl.controller.erp.student.dto.Category;
import com.academics.school.pl.controller.erp.student.dto.Disablity;
import com.academics.school.pl.controller.erp.student.dto.Gender;
import com.academics.school.pl.controller.erp.student.dto.Nation;
import com.academics.school.pl.controller.erp.student.dto.Religion;
import com.academics.school.pl.controller.erp.student.dto.State;

public class EmployeeRecord {
	
	//Employee Basic Information
	//private String employeeId;
	private MultipartFile employeeImage;
	private String firstName;
    private String middleName;
	private String lastName;
	private Gender gender;
	private String mobileNumber;
	private String email;
	private String dateOfBirth;
	private String age;
	private Category catagory;   
	private Disablity disablity;
	private Nation nationality;
	private Religion religion;
    private String boodGroup;
    private String adhaarCardNo;
	
    /*
   	 * Employee acadmics details
   	 */
    private MasterDegree masterDegreeName;
    private String masterDegreeCollegeNmae;
    private String masterDegreeUniversityName;
    private String masterDegreePercentage;
    private State masterDegreeStageName;
    private String masterDegreeCityName;
    private Graduation graduationName;
    private String graduationCollegeNmae;
    private String graduationUniversityName;
    private String graduationPercentage;
    private State degreeStageName;
    private String degreeCityName;
    /*
	 * Student academics previous details
	 */
	private String lastOrgnizationName;
	private String lastOrgnizationAddress;
	private String lastOrgnizationDesignation;    //last attended class
	private String lastOrgnizationTeachingSubject;
	private State organizationStateName;                     //if aplicable
	private String organizationCityName;
	private String previusExperiance;
	private MultipartFile experianceCertificate;
	private MultipartFile relivingCertificate;
    
	/*
	 * Student Family Details
	 */
	private String fatherName;
	private String fatherMobileNumber;
	private String fatherEmail;
	private String fatherOccupation;
	private String motherName;
	private String motherMobileNumber;
	private String motherEmail;
	private String motherOccupation;
    private	MultipartFile fathersImage;
    private MultipartFile mothersImage;
	
    /*
	 * Employee current address detail
	 */
	private String currentHouseNo;
	private String currentVillage;
	private String currentCity;
	private State currentState;
	private String currentPinNo;
	private Nation currentCountry;
	private String currentAddressDetails;
	
	/*
	 * Employee permanent address detail
	 */
	private String permanentHouseNo;
	private String permanentVillage;
	private String permanentCity;
	private State permanentState;
	private String permanentPinNo;
	private Nation permanentCountry;
	private String permanentAddressDetails;
	/*
	 * Employee documents
	 */
    private MultipartFile birthCertificate;
    private MultipartFile castCertificate;

    
    /*
     * Time stamp
     */
    private Timestamp timeStamp;


	public MultipartFile getEmployeeImage() {
		return employeeImage;
	}


	public void setEmployeeImage(MultipartFile employeeImage) {
		this.employeeImage = employeeImage;
	}


	public String getFirstName() {
		return firstName;
	}


	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}


	public String getMiddleName() {
		return middleName;
	}


	public void setMiddleName(String middleName) {
		this.middleName = middleName;
	}


	public String getLastName() {
		return lastName;
	}


	public void setLastName(String lastName) {
		this.lastName = lastName;
	}


	public Gender getGender() {
		return gender;
	}


	public void setGender(Gender gender) {
		this.gender = gender;
	}


	public String getMobileNumber() {
		return mobileNumber;
	}


	public void setMobileNumber(String mobileNumber) {
		this.mobileNumber = mobileNumber;
	}


	public String getEmail() {
		return email;
	}


	public void setEmail(String email) {
		this.email = email;
	}


	public String getDateOfBirth() {
		return dateOfBirth;
	}


	public void setDateOfBirth(String dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}


	public String getAge() {
		return age;
	}


	public void setAge(String age) {
		this.age = age;
	}


	public Category getCatagory() {
		return catagory;
	}


	public void setCatagory(Category catagory) {
		this.catagory = catagory;
	}


	public Disablity getDisablity() {
		return disablity;
	}


	public void setDisablity(Disablity disablity) {
		this.disablity = disablity;
	}


	public Nation getNationality() {
		return nationality;
	}


	public void setNationality(Nation nationality) {
		this.nationality = nationality;
	}


	public Religion getReligion() {
		return religion;
	}


	public void setReligion(Religion religion) {
		this.religion = religion;
	}


	public String getBoodGroup() {
		return boodGroup;
	}


	public void setBoodGroup(String boodGroup) {
		this.boodGroup = boodGroup;
	}


	public String getAdhaarCardNo() {
		return adhaarCardNo;
	}


	public void setAdhaarCardNo(String adhaarCardNo) {
		this.adhaarCardNo = adhaarCardNo;
	}


	public MasterDegree getMasterDegreeName() {
		return masterDegreeName;
	}


	public void setMasterDegreeName(MasterDegree masterDegreeName) {
		this.masterDegreeName = masterDegreeName;
	}


	public String getMasterDegreeCollegeNmae() {
		return masterDegreeCollegeNmae;
	}


	public void setMasterDegreeCollegeNmae(String masterDegreeCollegeNmae) {
		this.masterDegreeCollegeNmae = masterDegreeCollegeNmae;
	}


	public String getMasterDegreeUniversityName() {
		return masterDegreeUniversityName;
	}


	public void setMasterDegreeUniversityName(String masterDegreeUniversityName) {
		this.masterDegreeUniversityName = masterDegreeUniversityName;
	}


	public String getMasterDegreePercentage() {
		return masterDegreePercentage;
	}


	public void setMasterDegreePercentage(String masterDegreePercentage) {
		this.masterDegreePercentage = masterDegreePercentage;
	}


	public State getMasterDegreeStageName() {
		return masterDegreeStageName;
	}


	public void setMasterDegreeStageName(State masterDegreeStageName) {
		this.masterDegreeStageName = masterDegreeStageName;
	}


	public String getMasterDegreeCityName() {
		return masterDegreeCityName;
	}


	public void setMasterDegreeCityName(String masterDegreeCityName) {
		this.masterDegreeCityName = masterDegreeCityName;
	}


	public Graduation getGraduationName() {
		return graduationName;
	}


	public void setGraduationName(Graduation graduationName) {
		this.graduationName = graduationName;
	}


	public String getGraduationCollegeNmae() {
		return graduationCollegeNmae;
	}


	public void setGraduationCollegeNmae(String graduationCollegeNmae) {
		this.graduationCollegeNmae = graduationCollegeNmae;
	}


	public String getGraduationUniversityName() {
		return graduationUniversityName;
	}


	public void setGraduationUniversityName(String graduationUniversityName) {
		this.graduationUniversityName = graduationUniversityName;
	}


	public String getGraduationPercentage() {
		return graduationPercentage;
	}


	public void setGraduationPercentage(String graduationPercentage) {
		this.graduationPercentage = graduationPercentage;
	}


	public State getDegreeStageName() {
		return degreeStageName;
	}


	public void setDegreeStageName(State degreeStageName) {
		this.degreeStageName = degreeStageName;
	}


	public String getDegreeCityName() {
		return degreeCityName;
	}


	public void setDegreeCityName(String degreeCityName) {
		this.degreeCityName = degreeCityName;
	}


	public String getLastOrgnizationName() {
		return lastOrgnizationName;
	}


	public void setLastOrgnizationName(String lastOrgnizationName) {
		this.lastOrgnizationName = lastOrgnizationName;
	}


	public String getLastOrgnizationAddress() {
		return lastOrgnizationAddress;
	}


	public void setLastOrgnizationAddress(String lastOrgnizationAddress) {
		this.lastOrgnizationAddress = lastOrgnizationAddress;
	}


	public String getLastOrgnizationDesignation() {
		return lastOrgnizationDesignation;
	}


	public void setLastOrgnizationDesignation(String lastOrgnizationDesignation) {
		this.lastOrgnizationDesignation = lastOrgnizationDesignation;
	}


	public String getLastOrgnizationTeachingSubject() {
		return lastOrgnizationTeachingSubject;
	}


	public void setLastOrgnizationTeachingSubject(
			String lastOrgnizationTeachingSubject) {
		this.lastOrgnizationTeachingSubject = lastOrgnizationTeachingSubject;
	}


	public State getOrganizationStateName() {
		return organizationStateName;
	}


	public void setOrganizationStateName(State organizationStateName) {
		this.organizationStateName = organizationStateName;
	}


	public String getOrganizationCityName() {
		return organizationCityName;
	}


	public void setOrganizationCityName(String organizationCityName) {
		this.organizationCityName = organizationCityName;
	}


	public String getPreviusExperiance() {
		return previusExperiance;
	}


	public void setPreviusExperiance(String previusExperiance) {
		this.previusExperiance = previusExperiance;
	}


	public MultipartFile getExperianceCertificate() {
		return experianceCertificate;
	}


	public void setExperianceCertificate(MultipartFile experianceCertificate) {
		this.experianceCertificate = experianceCertificate;
	}


	public MultipartFile getRelivingCertificate() {
		return relivingCertificate;
	}


	public void setRelivingCertificate(MultipartFile relivingCertificate) {
		this.relivingCertificate = relivingCertificate;
	}


	public String getFatherName() {
		return fatherName;
	}


	public void setFatherName(String fatherName) {
		this.fatherName = fatherName;
	}


	public String getFatherMobileNumber() {
		return fatherMobileNumber;
	}


	public void setFatherMobileNumber(String fatherMobileNumber) {
		this.fatherMobileNumber = fatherMobileNumber;
	}


	public String getFatherEmail() {
		return fatherEmail;
	}


	public void setFatherEmail(String fatherEmail) {
		this.fatherEmail = fatherEmail;
	}


	public String getFatherOccupation() {
		return fatherOccupation;
	}


	public void setFatherOccupation(String fatherOccupation) {
		this.fatherOccupation = fatherOccupation;
	}


	public String getMotherName() {
		return motherName;
	}


	public void setMotherName(String motherName) {
		this.motherName = motherName;
	}


	public String getMotherMobileNumber() {
		return motherMobileNumber;
	}


	public void setMotherMobileNumber(String motherMobileNumber) {
		this.motherMobileNumber = motherMobileNumber;
	}


	public String getMotherEmail() {
		return motherEmail;
	}


	public void setMotherEmail(String motherEmail) {
		this.motherEmail = motherEmail;
	}


	public String getMotherOccupation() {
		return motherOccupation;
	}


	public void setMotherOccupation(String motherOccupation) {
		this.motherOccupation = motherOccupation;
	}


	public MultipartFile getFathersImage() {
		return fathersImage;
	}


	public void setFathersImage(MultipartFile fathersImage) {
		this.fathersImage = fathersImage;
	}


	public MultipartFile getMothersImage() {
		return mothersImage;
	}


	public void setMothersImage(MultipartFile mothersImage) {
		this.mothersImage = mothersImage;
	}


	public String getCurrentHouseNo() {
		return currentHouseNo;
	}


	public void setCurrentHouseNo(String currentHouseNo) {
		this.currentHouseNo = currentHouseNo;
	}


	public String getCurrentVillage() {
		return currentVillage;
	}


	public void setCurrentVillage(String currentVillage) {
		this.currentVillage = currentVillage;
	}


	public String getCurrentCity() {
		return currentCity;
	}


	public void setCurrentCity(String currentCity) {
		this.currentCity = currentCity;
	}


	public State getCurrentState() {
		return currentState;
	}


	public void setCurrentState(State currentState) {
		this.currentState = currentState;
	}


	public String getCurrentPinNo() {
		return currentPinNo;
	}


	public void setCurrentPinNo(String currentPinNo) {
		this.currentPinNo = currentPinNo;
	}


	public Nation getCurrentCountry() {
		return currentCountry;
	}


	public void setCurrentCountry(Nation currentCountry) {
		this.currentCountry = currentCountry;
	}


	public String getCurrentAddressDetails() {
		return currentAddressDetails;
	}


	public void setCurrentAddressDetails(String currentAddressDetails) {
		this.currentAddressDetails = currentAddressDetails;
	}


	public String getPermanentHouseNo() {
		return permanentHouseNo;
	}


	public void setPermanentHouseNo(String permanentHouseNo) {
		this.permanentHouseNo = permanentHouseNo;
	}


	public String getPermanentVillage() {
		return permanentVillage;
	}


	public void setPermanentVillage(String permanentVillage) {
		this.permanentVillage = permanentVillage;
	}


	public String getPermanentCity() {
		return permanentCity;
	}


	public void setPermanentCity(String permanentCity) {
		this.permanentCity = permanentCity;
	}


	public State getPermanentState() {
		return permanentState;
	}


	public void setPermanentState(State permanentState) {
		this.permanentState = permanentState;
	}


	public String getPermanentPinNo() {
		return permanentPinNo;
	}


	public void setPermanentPinNo(String permanentPinNo) {
		this.permanentPinNo = permanentPinNo;
	}


	public Nation getPermanentCountry() {
		return permanentCountry;
	}


	public void setPermanentCountry(Nation permanentCountry) {
		this.permanentCountry = permanentCountry;
	}


	public String getPermanentAddressDetails() {
		return permanentAddressDetails;
	}


	public void setPermanentAddressDetails(String permanentAddressDetails) {
		this.permanentAddressDetails = permanentAddressDetails;
	}


	public MultipartFile getBirthCertificate() {
		return birthCertificate;
	}


	public void setBirthCertificate(MultipartFile birthCertificate) {
		this.birthCertificate = birthCertificate;
	}


	public MultipartFile getCastCertificate() {
		return castCertificate;
	}


	public void setCastCertificate(MultipartFile castCertificate) {
		this.castCertificate = castCertificate;
	}


	public Timestamp getTimeStamp() {
		return timeStamp;
	}


	public void setTimeStamp(Timestamp timeStamp) {
		this.timeStamp = timeStamp;
	}

	
	
}
