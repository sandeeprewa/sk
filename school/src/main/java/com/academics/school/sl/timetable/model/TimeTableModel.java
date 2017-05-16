package com.academics.school.sl.timetable.model;

import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "STUDENT_TIME_TABLE")
public class TimeTableModel {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column ( name = "TIME_TABLE_ID")
	private Long id;
	@Column ( name = "STANDARD")
	private String standard;
	@Column ( name = "SECTION")
	private String section;
	@Column ( name = "SUBJECT")
	private String subject;
	@Column (name = "TEACHER")
	private String teacher;
	@Column (name = "CURRENT_DATE")
	private Date currentDate = new Date();
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getStandard() {
		return standard;
	}
	public void setStandard(String standard) {
		this.standard = standard;
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
	public String getTeacher() {
		return teacher;
	}
	public void setTeacher(String teacher) {
		this.teacher = teacher;
	}
	public Date getCurrentDate() {
		return currentDate;
	}
	public void setCurrentDate(Date currentDate) {
		this.currentDate = currentDate;
	}
}
