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
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "student_sequence")
	@SequenceGenerator(name = "student_sequence", sequenceName = "student_sequence_db",allocationSize=1, initialValue= 1)	
	@Column(name = "STANDARD_FIXTURE_TABLE_ID")
	Long id;
	
	@Column (name = "STANDARD")
	String standard;
	
	@Column(name="SECTION1")
	String section1;
	@Column(name="SECTION2")
	String section2;
	@Column(name="SECTION3")
	String section3;
	@Column(name="SECTION4")
	String section4;
	@Column(name="SECTION5")
	String section5;
	@Column(name="SECTION6")
	String section6;
	@Column(name="SECTION7")
	String section7;
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
	public String getSection1() {
		return section1;
	}
	public void setSection1(String section1) {
		this.section1 = section1;
	}
	public String getSection2() {
		return section2;
	}
	public void setSection2(String section2) {
		this.section2 = section2;
	}
	public String getSection3() {
		return section3;
	}
	public void setSection3(String section3) {
		this.section3 = section3;
	}
	public String getSection4() {
		return section4;
	}
	public void setSection4(String section4) {
		this.section4 = section4;
	}
	public String getSection5() {
		return section5;
	}
	public void setSection5(String section5) {
		this.section5 = section5;
	}
	
	public String getSection6() {
		return section6;
	}
	public void setSection6(String section6) {
		this.section6 = section6;
	}
	public String getSection7() {
		return section7;
	}
	public void setSection7(String section7) {
		this.section7 = section7;
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
