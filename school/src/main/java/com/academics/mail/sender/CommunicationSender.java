package com.academics.mail.sender;

import java.util.Properties;

import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.mail.MailSender;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.mail.javamail.MimeMailMessage;
import org.springframework.stereotype.Component;

@Component
public class CommunicationSender {
	
	  JavaMailSenderImpl mailSenderImpl = new JavaMailSenderImpl();
	
	static CommunicationSender COMMUNICATION_SENDER_INSTANCE = new CommunicationSender();
	
	public static CommunicationSender getInstance(){
		return COMMUNICATION_SENDER_INSTANCE;
		
	}
	
	public  boolean sendCommunicion(String to, String message, SendBy sender) throws AddressException, MessagingException{
		
		  mailSenderImpl.setHost("smtp.gmail.com");
		  mailSenderImpl.setPort(587);
		  mailSenderImpl.setUsername("sp.sendmail@gmail.com");
		  mailSenderImpl.setPassword("hariom@1234");
		  Properties properties = new Properties();
		  properties.setProperty("mail.smtp.auth", "true");
		  properties.setProperty("mail.smtp.starttls.enable", "true");
		  mailSenderImpl.setJavaMailProperties(properties);

		  Properties properties1 = new Properties();
		  properties1.setProperty("mail.smtp.host", "localhost");
		  Session session = Session.getDefaultInstance(properties1);
		  
		  MimeMessage mimeMessage = new MimeMessage(session);
		  mimeMessage.setFrom(new InternetAddress("sp.sendmail@gmail.com"));
		  mimeMessage.setContent("<h1 style='color:red'>Your ID IS"+ message + "</h1>", "text/html");
		  
			SimpleMailMessage simpleMailMessage = new SimpleMailMessage();
			simpleMailMessage.setFrom("sp.sendmail@gmaiil.com");
			simpleMailMessage.setTo(to);
			simpleMailMessage.setSubject("SchoolCommunication");
			simpleMailMessage.setText(message);
			mailSenderImpl.send(simpleMailMessage);
			
		return true;
	} 
	
}
