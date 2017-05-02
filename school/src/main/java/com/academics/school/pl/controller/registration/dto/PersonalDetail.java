package com.academics.school.pl.controller.registration.dto;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Id;

@Entity
@Table(name = "PERSONAL_DETAIL")
public class PersonalDetail {

	@Id
	@Column(name = "PERSONAL_DETAIL_ID")
	private Long personalDetailId;
	@Column(name = "FIRST_NAME")
	private String firstName;
	@Column(name = "MIDDLE_NAME")
    private String middleName;
	@Column(name = "LAST_NAME")
	private String lastName;  
	@Column(name = "GENDER")
	private Gender gender;
	
	private String mobileNumber;
	private String email;
	private String dateOfBirth;
	private String age;
	private Category category;   
	private Disablity disability;
	private Nation nationality;
	private Religion religion;
    private String bloodGroup;
    private String adhaarCardNo;
    
    @OneToOne
    StudentRegistrationRecord studentRegistrationRecord;
    
    
	
}
