package com.school.wl.security.configuration;

import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
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
	    UsernamePasswordAuthenticationToken result = new UsernamePasswordAuthenticationToken(principal, credential);
	    return result;
	  }

	public boolean supports(Class<?> authentication) {
		// TODO Auto-generated method stub
		return true;
	}
}