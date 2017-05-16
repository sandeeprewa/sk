package com.academics.school.pl.controller.attendence.dto;

/*
 * @author Sandeep
 */
public class AttendenceRequestDTO {

	private String studentId;
	private String startTime;
	private String lastTime;
	
	public void setStudentId(String studentId) {
		this.studentId = studentId;
	}

	public String getStartTime() {
		return startTime;
	}

	public void setStartTime(String startTime) {
		this.startTime = startTime;
	}

	public String getLastTime() {
		return lastTime;
	}

	public void setLastTime(String lastTime) {
		this.lastTime = lastTime;
	}

	public String getStudentId() {
		return studentId;
	}

	
	
	
}
