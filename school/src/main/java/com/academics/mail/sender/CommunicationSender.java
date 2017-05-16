package com.academics.mail.sender;

import java.util.Properties;

import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
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
	
	public  boolean sendCommunicion(String to, String message, SendBy sender) {
		
		  String username = "sp.sendmail@gmail.com";
		  String password = "hariom@1234";
		  mailSenderImpl.setHost("smtp.gmail.com");
		  mailSenderImpl.setPort(587);
		  mailSenderImpl.setUsername(username);
		  mailSenderImpl.setPassword(password);
		  Properties properties = new Properties();
		  properties.setProperty("mail.smtp.auth", "true");
		  properties.setProperty("mail.smtp.starttls.enable", "true");
		  mailSenderImpl.setJavaMailProperties(properties);

		  Properties properties1 = new Properties();
		  properties1.setProperty("mail.smtp.host", "localhost");
		  properties1.setProperty("mail.smtp.port", "9090");		  
		     
		  Session session = Session.getDefaultInstance(properties1, 
          new Authenticator(){
	             protected PasswordAuthentication getPasswordAuthentication() {
	                 return new PasswordAuthentication("sp.sendmail@gmail.com", "hariom@1234");
	              }});
             
		  MimeMessage mimeMessage = new MimeMessage(session);
		  try {
				mimeMessage.setFrom(new InternetAddress("sp.sendmail@gmail.com"));
				mimeMessage.addRecipient(Message.RecipientType.TO, new InternetAddress("91anu.sandeep@gmail.com"));
				mimeMessage.setContent("<h1 style='color:red'>Your ID IS"+ message + "</h1>", "text/html");
			} catch (Exception e) {
				e.printStackTrace();
			}

			SimpleMailMessage simpleMailMessage = new SimpleMailMessage();
			simpleMailMessage.setFrom("sp.sendmail@gmaiil.com");
			simpleMailMessage.setTo(to);
			simpleMailMessage.setSubject("SchoolCommunication");
			simpleMailMessage.setText(message);
			mailSenderImpl.send(simpleMailMessage);
			try {
				Transport.send(mimeMessage);
			} catch (MessagingException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		return true;
	} 
	
}
