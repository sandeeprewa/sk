package com.school.pl.rest.global.error;
// will have variables code application specifi
public enum Code{
	FEES_NOT_PAID(1000);
	int value;
	Code(int value){
		this.value = value;
	}
	
	@Override
	public String toString(){
		return Integer.toString(value);
	}
}