package com.academics.mail.sender;

import org.springframework.stereotype.Service;

@Service
public interface MailSender {
		
	public boolean sendEmail(String to, String from, String messageBody, String Subject);
	public boolean sendEmail(String to, String from, String messageBody);
}
