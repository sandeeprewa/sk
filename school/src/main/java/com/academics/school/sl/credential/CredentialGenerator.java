package com.academics.school.sl.credential;

import org.springframework.stereotype.Service;

@Service
public interface CredentialGenerator {
		
	 public Credential createCredential(String registrationId);
	 public Credential createCredentialAndShareWithEmail(String registrationId);
}
