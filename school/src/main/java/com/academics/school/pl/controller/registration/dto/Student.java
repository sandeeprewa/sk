package com.academics.school.pl.controller.registration.dto;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Id;
import javax.persistence.Transient;

@Entity
@Table(name = "STUDENT_DETAIL_TABLE")
public class Student {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "student_sequence")
	@SequenceGenerator(name = "student_sequence", sequenceName = "student_sequence_db",allocationSize=1, initialValue= 1)	
	@Column(name = "STUDENT_DETAIL_ID")
	Long id;
	
	@OneToOne(mappedBy = "student", cascade = CascadeType.ALL)
	private EducationDetail previousEducationDetail;

	@OneToOne(mappedBy = "student", cascade = CascadeType.ALL)
	private CurrentClass currentClass;
	
	@OneToOne(mappedBy = "student", cascade = CascadeType.ALL)
	private ParentDetail parentDetails;
	
	@OneToMany(mappedBy = "student", cascade = CascadeType.ALL)
	private List<Address> address;
	

	@Column(name = "FIRST_NAME")
	private String firstName;
	@Column(name = "MIDDLE_NAME")
    private String middleName;	
	@Column(name = "LAST_NAME")
	private String lastName;	
	@Column(name = "GENDER")
	@Enumerated(EnumType.STRING)
	private Gender gender;
	@Column(name = "MOBILE_NUMBER")
	private String mobileNumber;
	@Column(name = "EMAIL")
	private String email;
	@Column(name = "DATE_OF_BIRTH")
	private String dateOfBirth;
	@Column(name = "AGE")
	private String age;
	@Enumerated(EnumType.STRING)
	private Category category;   
	@Enumerated(EnumType.STRING)
	private Disability disability;
	@Enumerated(EnumType.STRING)
	private Nation nationality;
	@Enumerated(EnumType.STRING)
	private Religion religion;
    private String bloodGroup;
    private String adhaarCardNumber;
    
	@OneToOne
	@JoinColumn(name = "REGISTRATION_ID")
    StudentRegistrationRecord studentRegistrationRecord;

	
	
	public EducationDetail getPreviousEducationDetail() {
		return previousEducationDetail;
	}
	public void setPreviousEducationDetail(EducationDetail previousEducationDetail) {
		this.previousEducationDetail = previousEducationDetail;
		previousEducationDetail.setStudent(this);
	}
	public CurrentClass getCurrentClass() {
		return currentClass;
	}
	public void setCurrentClass(CurrentClass currentClass) {
		this.currentClass = currentClass;
		currentClass.setStudent(this);
	}
	public ParentDetail getParentDetails() {
		return parentDetails;
	}
	public void setParentDetails(ParentDetail parentDetails) {
		this.parentDetails = parentDetails;
		parentDetails.setStudent(this);
	}
	public List<Address> getAddress() {
		return address;
	}
	public void setAddress(List<Address> address) {
		this.address = address;
		for (Address address2 : address) {
			address2.setStudent(this);
		}
	}

    
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
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

	public Category getCategory() {
		return category;
	}

	public void setCategory(Category category) {
		this.category = category;
	}

	public Disability getDisability() {
		return disability;
	}

	public void setDisability(Disability disability) {
		this.disability = disability;
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

	public String getBloodGroup() {
		return bloodGroup;
	}

	public void setBloodGroup(String bloodGroup) {
		this.bloodGroup = bloodGroup;
	}

	public String getAdhaarCardNumber() {
		return adhaarCardNumber;
	}

	public void setAdhaarCardNumber(String adhaarCardNumber) {
		this.adhaarCardNumber = adhaarCardNumber;
	}

	public StudentRegistrationRecord getStudentRegistrationRecord() {
		return studentRegistrationRecord;
	}

	public void setStudentRegistrationRecord(
			StudentRegistrationRecord studentRegistrationRecord) {
		this.studentRegistrationRecord = studentRegistrationRecord;
	}

}
