package com.academics.school.wl.security.configuration;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.AuthenticationEntryPoint;
import org.springframework.stereotype.Component;

import com.fasterxml.jackson.databind.ObjectMapper;

@Component("authenticationEntryPoin")
public class HttpAuthenticationEntryPoint implements AuthenticationEntryPoint {
    
    ObjectMapper mapper;
    MappingJackson2HttpMessageConverter messageConverter;
	
    public HttpAuthenticationEntryPoint(MappingJackson2HttpMessageConverter converter) {
    	this.messageConverter = converter;
    }

    public HttpAuthenticationEntryPoint(){}
    
	public void commence(HttpServletRequest request, HttpServletResponse response,
            AuthenticationException authException) throws IOException {
    	System.out.println("-----HttpAuthenticationEntryPoint------");
        response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
        mapper = messageConverter.getObjectMapper();

        User user = new User();
        user.name = "hariom";
        user.message = "Please login!";
        PrintWriter writer = response.getWriter();
        mapper.writeValue(writer, user);
        writer.flush();

//        response.sendError(HttpServletResponse.SC_UNAUTHORIZED, authException.getMessage());
    }
}