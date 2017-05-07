package com.academics.school.wl.configuration;

import javax.servlet.Filter;
import javax.servlet.ServletContext;

import org.springframework.web.filter.HttpPutFormContentFilter;
import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

/**
 * @author sandeep
 *
 */
public class ApplicationInitializer extends AbstractAnnotationConfigDispatcherServletInitializer{
	
	@Override
	protected Class<?>[] getRootConfigClasses() {
		return new Class[] { RootApplicationConfiguration.class };
	}

	@Override
	protected Class<?>[] getServletConfigClasses() {
		return null;
	}

	@Override
	protected String[] getServletMappings() {
		return new String[] { "/" };
	}
	
	@Override
	protected void registerContextLoaderListener(ServletContext context){
		super.registerContextLoaderListener(context);
	}
	
	@Override
     protected Filter[] getServletFilters() {
	       return new Filter[]{new HttpPutFormContentFilter()};
	}
}
