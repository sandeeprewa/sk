package com.academics.school.sl.credential;

import org.springframework.stereotype.Service;

import com.academics.school.sl.credential.model.StudentLoginModel;

@Service
public interface CredentialGenerator {
		
	 public StudentLoginModel createCredentialAndShareWithEmail(String registrationId, String email);
	 public StudentLoginModel createCredentialAndShareWithMessage(String registrationId, String phoneNumber);
}
