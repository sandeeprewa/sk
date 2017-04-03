package com.school.pl.controller.erp.student.dto;

import java.sql.Timestamp;

import org.springframework.web.multipart.MultipartFile;


public class StudentAdmissionRecord {

    
	private String firstName;
    private String middleName;
	private String lastName;  
	private String class_Stu;
	private String section;
	private String subject;
	private String gender;
	private String mobileNo;
	private String email;
	private String dob;
	private String age;
	private String catagary;   //sc/st/obc/gen
	private String disable;
	private String natanality;
	private String religion;
	
	private String lastSchoolName;
	private String lastSchoolAddress;
	private String lastSchoolClass;    //last attended class
	private String lastSchoolSubject;  //if aplicable
	private String percentage;
	private MultipartFile certificate;
	private MultipartFile relivingertificate;
	
	private String fatherName;
	private String fmobileNo;
	private String femail;
	private String fOccupation;
	private String motherName;
	private String mmobileNo;
	private String memail;
	private String mOccupation;
	
	private String currentHouseNo;
	private String currentVillage;
	private String currentCity;
	private String currentState;
	private String currentPinNo;
	private String currentCountry;
	private String currentAddressDetails;
	
	private String permanentHouseNo;
	private String permanentVillage;
	private String permanentCity;
	private String permanentState;
	private String permanentPinNo;
	private String permanentCountry;
	private String permanentAddressDetails;
	
	private MultipartFile studentImage;
    private	MultipartFile fathersImage;
    private MultipartFile mothersImage;
    
    private Timestamp timeStamp;
    
    private MultipartFile birthCertificate;
    private MultipartFile migrationCertificate;
    private MultipartFile castCertificate;
    private String boodGroup;
    private String adhaarCardNo;
    
    
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
	public String getClass_Stu() {
		return class_Stu;
	}
	public void setClass_Stu(String class_Stu) {
		this.class_Stu = class_Stu;
	}
	public String getSection() {
		return section;
	}
	public void setSection(String section) {
		this.section = section;
	}
	public String getSubject() {
		return subject;
	}
	public void setSubject(String subject) {
		this.subject = subject;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public String getMobileNo() {
		return mobileNo;
	}
	public void setMobileNo(String mobileNo) {
		this.mobileNo = mobileNo;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getDob() {
		return dob;
	}
	public void setDob(String dob) {
		this.dob = dob;
	}
	public String getAge() {
		return age;
	}
	public void setAge(String age) {
		this.age = age;
	}
	public String getCatagary() {
		return catagary;
	}
	public void setCatagary(String catagary) {
		this.catagary = catagary;
	}
	public String getDisable() {
		return disable;
	}
	public void setDisable(String disable) {
		this.disable = disable;
	}
	public String getNatanality() {
		return natanality;
	}
	public void setNatanality(String natanality) {
		this.natanality = natanality;
	}
	public String getReligion() {
		return religion;
	}
	public void setReligion(String religion) {
		this.religion = religion;
	}
	public String getLastSchoolName() {
		return lastSchoolName;
	}
	public void setLastSchoolName(String lastSchoolName) {
		this.lastSchoolName = lastSchoolName;
	}
	public String getLastSchoolAddress() {
		return lastSchoolAddress;
	}
	public void setLastSchoolAddress(String lastSchoolAddress) {
		this.lastSchoolAddress = lastSchoolAddress;
	}
	public String getLastSchoolClass() {
		return lastSchoolClass;
	}
	public void setLastSchoolClass(String lastSchoolClass) {
		this.lastSchoolClass = lastSchoolClass;
	}
	public String getLastSchoolSubject() {
		return lastSchoolSubject;
	}
	public void setLastSchoolSubject(String lastSchoolSubject) {
		this.lastSchoolSubject = lastSchoolSubject;
	}
	public String getPercentage() {
		return percentage;
	}
	public void setPercentage(String percentage) {
		this.percentage = percentage;
	}
	public MultipartFile getCertificate() {
		return certificate;
	}
	public void setCertificate(MultipartFile certificate) {
		this.certificate = certificate;
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
	public String getFmobileNo() {
		return fmobileNo;
	}
	public void setFmobileNo(String fmobileNo) {
		this.fmobileNo = fmobileNo;
	}
	public String getFemail() {
		return femail;
	}
	public void setFemail(String femail) {
		this.femail = femail;
	}
	public String getfOccupation() {
		return fOccupation;
	}
	public void setfOccupation(String fOccupation) {
		this.fOccupation = fOccupation;
	}
	public String getMotherName() {
		return motherName;
	}
	public void setMotherName(String motherName) {
		this.motherName = motherName;
	}
	public String getMmobileNo() {
		return mmobileNo;
	}
	public void setMmobileNo(String mmobileNo) {
		this.mmobileNo = mmobileNo;
	}
	public String getMemail() {
		return memail;
	}
	public void setMemail(String memail) {
		this.memail = memail;
	}
	public String getmOccupation() {
		return mOccupation;
	}
	public void setmOccupation(String mOccupation) {
		this.mOccupation = mOccupation;
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
	public String getCurrentState() {
		return currentState;
	}
	public void setCurrentState(String currentState) {
		this.currentState = currentState;
	}
	public String getCurrentPinNo() {
		return currentPinNo;
	}
	public void setCurrentPinNo(String currentPinNo) {
		this.currentPinNo = currentPinNo;
	}
	public String getCurrentCountry() {
		return currentCountry;
	}
	public void setCurrentCountry(String currentCountry) {
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
	public String getPermanentState() {
		return permanentState;
	}
	public void setPermanentState(String permanentState) {
		this.permanentState = permanentState;
	}
	public String getPermanentPinNo() {
		return permanentPinNo;
	}
	public void setPermanentPinNo(String permanentPinNo) {
		this.permanentPinNo = permanentPinNo;
	}
	public String getPermanentCountry() {
		return permanentCountry;
	}
	public void setPermanentCountry(String permanentCountry) {
		this.permanentCountry = permanentCountry;
	}
	public String getPermanentAddressDetails() {
		return permanentAddressDetails;
	}
	public void setPermanentAddressDetails(String permanentAddressDetails) {
		this.permanentAddressDetails = permanentAddressDetails;
	}
	public MultipartFile getStudentImage() {
		return studentImage;
	}
	public void setStudentImage(MultipartFile studentImage) {
		this.studentImage = studentImage;
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
	public Timestamp getTimeStamp() {
		return timeStamp;
	}
	public void setTimeStamp(Timestamp timeStamp) {
		this.timeStamp = timeStamp;
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
    
    
    
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
    	

}
