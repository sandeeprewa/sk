package com.school.pl.controller.teset;

import org.springframework.core.MethodParameter;
import org.springframework.web.bind.support.WebDataBinderFactory;
import org.springframework.web.context.request.NativeWebRequest;
import org.springframework.web.method.support.HandlerMethodArgumentResolver;
import org.springframework.web.method.support.ModelAndViewContainer;

public final class TestConvertor implements HandlerMethodArgumentResolver {
		 
	    public boolean supportsParameter(MethodParameter methodParameter) {
	        return methodParameter.getParameterType().equals(TestConvertor.class);
	    }
	 
	    public Object resolveArgument(MethodParameter methodParameter,
	                                  ModelAndViewContainer modelAndViewContainer,
	                                  NativeWebRequest nativeWebRequest,
	                                  WebDataBinderFactory webDataBinderFactory) throws Exception {
	        String name = nativeWebRequest.getParameter("name");
	        String country= nativeWebRequest.getParameter("country");	 
	        return null;
	    }	 
}
