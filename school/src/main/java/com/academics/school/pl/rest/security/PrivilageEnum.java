package com.academics.school.pl.rest.security;

public enum PrivilageEnum {
		
	PUBLIC_USER("public_user"),
	READ_ONLY("read_only"),
	EDITOR("editor"),
	SUPER_USER("super_user"),
	SUPER_DUPER_USER("super_duper_user"), 
	END_USER("end_user");
	
	private String name;

	PrivilageEnum(String name){
		this.name = name;
	}
	
	public PrivilageEnum getEnum(String privilageName){
		for(PrivilageEnum privilage : values()){
			if(privilageName.equals(privilage.toString())){
				return privilage;
			}
		}
		throw new IllegalArgumentException("Unknown Privilage"+ privilageName);
	}
	
	@Override
	public String toString(){
		return this.name;
	}
}
