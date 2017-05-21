package com.academics.school.dl.standardfixture;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table( name = "STANDARD_FIXTURE_TABLE")
public class StandardFixture {
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "student_sequence_fix")
	@SequenceGenerator(name = "student_sequence_fix", sequenceName = "student_sequence_fix_db",allocationSize=1, initialValue= 1)	
	@Column(name = "STANDARD_FIXTURE_TABLE_ID")
	Long id;
	
	@Column (name = "STANDARD")
	String standard;
	
	@Column(name="SECTION")
	String section;
	
	@Column(name="SUBJECT1")
	String subject1;
	@Column(name="SUBJECT2")
	String subject2;
	@Column(name="SUBJECT3")
	String subject3;
	@Column(name="SUBJECT4")
	String subject4;
	@Column(name="SUBJECT5")
	String subject5;
	@Column(name="SUBJECT6")
	String subject6;
	@Column(name="SUBJECT7")
	String subject7;
	@Column(name="SUBJECT8")
	String subject8;
	@Column(name="SUBJECT9")
	String subject9;
	@Column(name="SUBJECT10")
	String subject10;

	
	
	
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
	
	public String getSubject1() {
		return subject1;
	}
	public void setSubject1(String subject1) {
		this.subject1 = subject1;
	}
	public String getSubject2() {
		return subject2;
	}
	public void setSubject2(String subject2) {
		this.subject2 = subject2;
	}
	public String getSubject3() {
		return subject3;
	}
	public void setSubject3(String subject3) {
		this.subject3 = subject3;
	}
	public String getSubject4() {
		return subject4;
	}
	public void setSubject4(String subject4) {
		this.subject4 = subject4;
	}
	public String getSubject5() {
		return subject5;
	}
	public void setSubject5(String subject5) {
		this.subject5 = subject5;
	}
	public String getSubject6() {
		return subject6;
	}
	public void setSubject6(String subject6) {
		this.subject6 = subject6;
	}
	public String getSubject7() {
		return subject7;
	}
	public void setSubject7(String subject7) {
		this.subject7 = subject7;
	}
	public String getSubject8() {
		return subject8;
	}
	public void setSubject8(String subject8) {
		this.subject8 = subject8;
	}
	public String getSubject9() {
		return subject9;
	}
	public void setSubject9(String subject9) {
		this.subject9 = subject9;
	}
	public String getSubject10() {
		return subject10;
	}
	public void setSubject10(String subject10) {
		this.subject10 = subject10;
	}
	

}
