package com.academics.school.pl.controller.attendence.dto;

import java.sql.Timestamp;
import java.util.Date;

import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.fasterxml.jackson.annotation.JsonFormat;

public class AttendenceRequestDTO {

	String studentId;
	private Date startTime;
	private Date lastTime;
	
	public void setStudentId(String studentId) {
		this.studentId = studentId;
	}

	AttendenceRequestDTO(){}

	public Date getStartTime() {
		return startTime;
	}

	public void setStartTime(Date startTime) {
		this.startTime = startTime;
	}

	public Date getLastTime() {
		return lastTime;
	}

	public void setLastTime(Date lastTime) {
		this.lastTime = lastTime;
	}

	public String getStudentId() {
		return studentId;
	}

	
	
	
}
