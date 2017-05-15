package com.academics.school.sl.credential.model;

import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import com.academics.school.sl.credential.Credential;

@Entity
@Table (name = "STUDENT_LOGIN_TABLE")
public class StudentLoginModel {
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "student_login_sequence")
	@SequenceGenerator(name = "student_login_sequence", sequenceName = "student_login_sequence_db",allocationSize=1, initialValue= 1)	
	Long id;
	
	@Column(name = "LAST_PASSWORD")
	String lastPassword;
	@Column (name = "LAST_SENT_TOKEN")
	String lastSentToken;
	@Column(name = "TOKEN_EXPIRE_TIME")
	String tokenExpireTime;
	@Column (name = "IS_LOGGED_IN")
	boolean isLoggedIn;
	@Column (name = "LAST_LOGIN_IP")
	String lastLogInIP;
	@Column (name = "REGISTRATION_ID")
	String registration_Id;

	@Embedded
	Credential<String, String> credential;
	
	public Credential<String, String> getCredential() {
		return credential;
	}

	public void setCredential(Credential<String, String> credential) {
		this.credential = credential;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getLastPassword() {
		return lastPassword;
	}

	public void setLastPassword(String lastPassword) {
		this.lastPassword = lastPassword;
	}

	public String getLastSentToken() {
		return lastSentToken;
	}

	public void setLastSentToken(String lastSentToken) {
		this.lastSentToken = lastSentToken;
	}

	public String getTokenExpireTime() {
		return tokenExpireTime;
	}

	public void setTokenExpireTime(String tokenExpireTime) {
		this.tokenExpireTime = tokenExpireTime;
	}

	public boolean isLoggedIn() {
		return isLoggedIn;
	}

	public void setLoggedIn(boolean isLoggedIn) {
		this.isLoggedIn = isLoggedIn;
	}

	public String getLastLogInIP() {
		return lastLogInIP;
	}

	public void setLastLogInIP(String lastLogInIP) {
		this.lastLogInIP = lastLogInIP;
	}

	public String getRegistration_Id() {
		return registration_Id;
	}

	public void setRegistration_Id(String registration_Id) {
		this.registration_Id = registration_Id;
	}
	
	
	
	
	
	
}
