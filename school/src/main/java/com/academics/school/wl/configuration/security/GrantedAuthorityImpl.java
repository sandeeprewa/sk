package com.academics.school.wl.configuration.security;

import org.springframework.security.core.GrantedAuthority;

public class GrantedAuthorityImpl implements GrantedAuthority {

	public String getAuthority() {
		// TODO Auto-generated method stub
		return "Role";
	}

}
