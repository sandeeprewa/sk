package com.school.pl.controller.erp.student.dto;

import java.sql.Timestamp;
import org.springframework.web.multipart.MultipartFile;

public class StudentAdmissionRecord {

	private PersonalDetail personalDetail;
	private EducationDetail educationDetail;
	private ParentDetail parentDetails;
    private Address currentAddress;
    private Address permanentAddress;

    private MultipartFile birthCertificate;
    private MultipartFile migrationCertificate;
    private MultipartFile castCertificate;
    
    private	MultipartFile fathersImage;
    private MultipartFile mothersImage;
	private MultipartFile studentImage;

    private Timestamp timeStamp;


    

}
