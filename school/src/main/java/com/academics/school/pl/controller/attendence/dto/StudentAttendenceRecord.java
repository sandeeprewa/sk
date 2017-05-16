package com.academics.school.pl.controller.attendence.dto;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "STUDENT_ATTENDENCE_RECORD")
public class StudentAttendenceRecord {
		
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "attendence_sequence")
	@SequenceGenerator(name = "attendence_sequence", sequenceName = "attendence_sequence_db",allocationSize=1, initialValue= 1)	
	@Column(name = "ATTENDENCE_ID")
	Long attendenceId;
	
	@Enumerated(EnumType.STRING)
	@Column(name = "ATTENDENCE_STATUS")
	AttendenceStatus attendenceStatus;
	
	@Temporal(TemporalType.DATE)
	Date timestamp;
	
	@Column(name = "STUDENT_ID")
	Long studentId;

	public Long getAttendenceId() {
		return attendenceId;
	}

	public void setAttendenceId(Long attendenceId) {
		this.attendenceId = attendenceId;
	}

	public AttendenceStatus getAttendenceStatus() {
		return attendenceStatus;
	}

	public void setAttendenceStatus(AttendenceStatus attendenceStatus) {
		this.attendenceStatus = attendenceStatus;
	}

	public Date getTimestamp() {
		return timestamp;
	}

	public void setTimestamp(Date timestamp) {
		this.timestamp = timestamp;
	}

	public Long getStudentId() {
		return studentId;
	}

	public void setStudentId(Long studentId) {
		this.studentId = studentId;
	}
	
	
}
