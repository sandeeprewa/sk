package com.academics.school.pl.controller.erp.student.dto.convertor;

import org.springframework.core.MethodParameter;
import org.springframework.web.bind.support.WebDataBinderFactory;
import org.springframework.web.context.request.NativeWebRequest;
import org.springframework.web.method.support.HandlerMethodArgumentResolver;
import org.springframework.web.method.support.ModelAndViewContainer;

public final class StudentDTOConverter implements HandlerMethodArgumentResolver {
		 
	    public boolean supportsParameter(MethodParameter methodParameter) {
	        return methodParameter.getParameterType().equals(StudentDTOConverter.class);
	    }
	 
	    public Object resolveArgument(MethodParameter methodParameter,
	                                  ModelAndViewContainer modelAndViewContainer,
	                                  NativeWebRequest nativeWebRequest,
	                                  WebDataBinderFactory webDataBinderFactory) throws Exception {
	        String bar = nativeWebRequest.getParameter("bar");
	        String foo = nativeWebRequest.getParameter("foo");	 
	        return null;
	    }	 
}
