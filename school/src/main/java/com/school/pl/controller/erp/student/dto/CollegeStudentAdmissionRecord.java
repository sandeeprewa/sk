package com.school.pl.controller.erp.student.dto;

import java.sql.Timestamp;

import org.springframework.web.multipart.MultipartFile;

public class CollegeStudentAdmissionRecord {

	/*
     * College Student specific detail
     */
	private MultipartFile studentImage;
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
	 * College Student acadmics details
	 */
	private String studentClass;
	private String studentSection;
	private String studentSubject;
	
	/*
	 * College Student academics previous details
	 */
	
	private String matricSchoolName;
	private String matricSchoolAddress;
	private String matricPercentage;
	private String matricyearOfPassing;    //last attended class
	private String intermediateSchoolName;
	private String intermediateSchoolAddress;
	private String intermediatePercentage;
	private String intermediateyearOfPassing;
	private String intermediateSchoolSubject;  //if aplicable
	private MultipartFile matricCertificate;
	private MultipartFile intermediateCertificate;
	private MultipartFile relivingertificate;
	
	/*
	 * College Student Family Details
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
	 * College Student current address detail
	 */
	private String currentHouseNo;
	private String currentVillage;
	private String currentCity;
	private State currentState;
	private String currentPinNo;
	private Nation currentCountry;
	private String currentAddressDetails;
	
	/*
	 * College Student permanent address detail
	 */
	private String permanentHouseNo;
	private String permanentVillage;
	private String permanentCity;
	private State permanentState;
	private String permanentPinNo;
	private Nation permanentCountry;
	private String permanentAddressDetails;
	
	/*
	 * College Student documents
	 */
    private MultipartFile birthCertificate;
    private MultipartFile migrationCertificate;
    private MultipartFile castCertificate;

    
    /*
     * Time stamp
     */
    private Timestamp timeStamp;


	public MultipartFile getStudentImage() {
		return studentImage;
	}


	public void setStudentImage(MultipartFile studentImage) {
		this.studentImage = studentImage;
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


	public String getStudentClass() {
		return studentClass;
	}


	public void setStudentClass(String studentClass) {
		this.studentClass = studentClass;
	}


	public String getStudentSection() {
		return studentSection;
	}


	public void setStudentSection(String studentSection) {
		this.studentSection = studentSection;
	}


	public String getStudentSubject() {
		return studentSubject;
	}


	public void setStudentSubject(String studentSubject) {
		this.studentSubject = studentSubject;
	}


	public String getMatricSchoolName() {
		return matricSchoolName;
	}


	public void setMatricSchoolName(String matricSchoolName) {
		this.matricSchoolName = matricSchoolName;
	}


	public String getMatricSchoolAddress() {
		return matricSchoolAddress;
	}


	public void setMatricSchoolAddress(String matricSchoolAddress) {
		this.matricSchoolAddress = matricSchoolAddress;
	}


	public String getMatricPercentage() {
		return matricPercentage;
	}


	public void setMatricPercentage(String matricPercentage) {
		this.matricPercentage = matricPercentage;
	}


	public String getMatricyearOfPassing() {
		return matricyearOfPassing;
	}


	public void setMatricyearOfPassing(String matricyearOfPassing) {
		this.matricyearOfPassing = matricyearOfPassing;
	}


	public String getIntermediateSchoolName() {
		return intermediateSchoolName;
	}


	public void setIntermediateSchoolName(String intermediateSchoolName) {
		this.intermediateSchoolName = intermediateSchoolName;
	}


	public String getIntermediateSchoolAddress() {
		return intermediateSchoolAddress;
	}


	public void setIntermediateSchoolAddress(String intermediateSchoolAddress) {
		this.intermediateSchoolAddress = intermediateSchoolAddress;
	}


	public String getIntermediatePercentage() {
		return intermediatePercentage;
	}


	public void setIntermediatePercentage(String intermediatePercentage) {
		this.intermediatePercentage = intermediatePercentage;
	}


	public String getIntermediateyearOfPassing() {
		return intermediateyearOfPassing;
	}


	public void setIntermediateyearOfPassing(String intermediateyearOfPassing) {
		this.intermediateyearOfPassing = intermediateyearOfPassing;
	}


	public String getIntermediateSchoolSubject() {
		return intermediateSchoolSubject;
	}


	public void setIntermediateSchoolSubject(String intermediateSchoolSubject) {
		this.intermediateSchoolSubject = intermediateSchoolSubject;
	}


	public MultipartFile getMatricCertificate() {
		return matricCertificate;
	}


	public void setMatricCertificate(MultipartFile matricCertificate) {
		this.matricCertificate = matricCertificate;
	}


	public MultipartFile getIntermediateCertificate() {
		return intermediateCertificate;
	}


	public void setIntermediateCertificate(MultipartFile intermediateCertificate) {
		this.intermediateCertificate = intermediateCertificate;
	}


	public MultipartFile getRelivingertificate() {
		return relivingertificate;
	}


	public void setRelivingertificate(MultipartFile relivingertificate) {
		this.relivingertificate = relivingertificate;
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


	public MultipartFile getMigrationCertificate() {
		return migrationCertificate;
	}


	public void setMigrationCertificate(MultipartFile migrationCertificate) {
		this.migrationCertificate = migrationCertificate;
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
