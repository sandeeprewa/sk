package com.school.pl.controller.erp.student;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import com.school.pl.controller.erp.student.dto.StudentAdmissionRecord;
import com.school.sl.erp.student.StudentAdmissionService;

@Component
public class StudentAdmissionFacade {
			
/*	@Autowired
	@Qualifier("studentAdmissionServiceImpl")
	StudentAdmissionService studentAdmissionService;
*/
	public StudentAdmissionRecord admitNewStudent(
			StudentAdmissionRecord admissionRecord) {
		// TODO Auto-generated method stub
		return null;
	}

	public  StudentAdmissionRecord updateStudentAdmissionRecord(
			StudentAdmissionRecord admissionRecord) {
		// TODO Auto-generated method stub
		return null;
	}

	public StudentAdmissionRecord getAdmissionRecordByStudentId(String studentId) {
		// TODO Auto-generated method stub
		return null;
	}

	public StudentAdmissionRecord deleteStudentAdmissionRecordById(
			String studentId) {
		// TODO Auto-generated method stub
		return null;
	}

	public List<StudentAdmissionRecord> getAdmissionRecordByStudentLastName(
			String studentName) {
		// TODO Auto-generated method stub
		return null;
	}

	public List<StudentAdmissionRecord> getAdmissionRecordByStudentFirstName(
			String studentName) {
		// TODO Auto-generated method stub
		return null;
	}

	public List<StudentAdmissionRecord> getAdmissionRecordByStudentDateOfBirth(
			String dateOfBirth) {
		// TODO Auto-generated method stub
		return null;
	}

}
