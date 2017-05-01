package com.academics.school.wl.configuration.security;

import java.util.ArrayList;

import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.stereotype.Component;

@Component
public class MyAuthenticationProvider implements AuthenticationProvider {

	  public Authentication authenticate(Authentication authentication)
	      throws AuthenticationException {

	    // cast as it pass the support method
	    UsernamePasswordAuthenticationToken auth = (UsernamePasswordAuthenticationToken) authentication;
	    String principal = (String) auth.getPrincipal();
	    String credential = (String) auth.getCredentials();
	    System.out.println("-----------Prinicipal---"+ principal);
	    System.out.println("-----------Credential---"+ credential);
	    Object obj = auth.getDetails();
	    
	    Auth roleAuth = new Auth();
	    ArrayList<Auth> listAuth = new ArrayList<Auth>();
	    listAuth.add(roleAuth);
	    System.out.println(listAuth);
	    
	    UsernamePasswordAuthenticationToken result = new UsernamePasswordAuthenticationToken(principal, credential, listAuth);
	    return result;
	  }

	public boolean supports(Class<?> authentication) {
		// TODO Auto-generated method stub
		return true;
	}
}
class Auth implements GrantedAuthority {

	public String getAuthority() {
		// TODO Auto-generated method stub
		return "ROLE_SUPER";
	}
	
}