package com.academics.school.wl.configuration.security;

import java.util.ArrayList;
import java.util.Collection;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

@Component("UserDetailServiceImpl")
public class UserDetailServiceImpl implements UserDetailsService {

	public UserDetails loadUserByUsername(String username)
			throws UsernameNotFoundException {
		
		System.out.println("---"+ username);
		Collection<GrantedAuthorityImpl> granted = new ArrayList<GrantedAuthorityImpl>();
		GrantedAuthorityImpl g = new GrantedAuthorityImpl();
		granted.add(g);
		
		SecurityUser user = new SecurityUser("sa", "wwwq", true, true, true, true, granted);
		return user;
	}

}
