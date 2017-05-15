package com.academics.school.sl.credential;

import javax.persistence.Embeddable;

@Embeddable
public class Credential<E, T> {
		
	private E userName;
	private T userPassword;
	
	
	public Credential(){}
	
	public Credential(E userName, T userPassword){
		this.userName = userName ;
		this.userPassword = userPassword;
	}
	
	public E getUserName() {
		return userName;
	}
	public void setUserName(E userName) {
		this.userName = userName;
	}
	public T getUserPassword() {
		return userPassword;
	}
	public void setUserPassword(T userPassword) {
		this.userPassword = userPassword;
	}
	
	
}
