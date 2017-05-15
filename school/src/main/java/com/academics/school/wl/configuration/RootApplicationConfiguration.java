package com.academics.school.wl.configuration;

import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.support.ResourceBundleMessageSource;
import org.springframework.core.env.Environment;
import org.springframework.http.MediaType;
import org.springframework.http.converter.ByteArrayHttpMessageConverter;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.mail.MailSender;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.filter.HttpPutFormContentFilter;
import org.springframework.web.multipart.commons.CommonsMultipartResolver;
import org.springframework.web.servlet.config.annotation.ContentNegotiationConfigurer;
import org.springframework.web.servlet.config.annotation.DefaultServletHandlerConfigurer;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

import com.academics.school.dl.utility.FileUploader;
import com.academics.school.wl.configuration.security.WebSecurityConfig;

@Configuration
@EnableWebMvc
@ComponentScan(basePackages = {"com.academics.school.*"})
@PropertySource(value = {"classpath:application.properties"})
//@Import(value = {com.academics.school.wl.configuration.security.WebSecurityConfig.class})
public class RootApplicationConfiguration extends WebMvcConfigurerAdapter {


	@Autowired
	private Environment environment;
	
	@Autowired
	private ServletContext servletContext;

	/**
       It tells Spring to use the container's default servlet for certain requests, like for static resources.
	 */
	@Override
    public void configureDefaultServletHandling(DefaultServletHandlerConfigurer configurer) {
        configurer.enable();
    }
	

	@Bean(name = "multipartResolver")
	public CommonsMultipartResolver createMultipartResolver() {
	    CommonsMultipartResolver resolver=new CommonsMultipartResolver();
	    resolver.setDefaultEncoding("utf-8");
	    return resolver;
	}

	@Override
	public void addResourceHandlers(final ResourceHandlerRegistry registry) {
	    registry.addResourceHandler("/resources/js/**").addResourceLocations("/resources/js/");
	    registry.addResourceHandler("/resources/css/**").addResourceLocations("/resources/css/");
	}
	
    @Override
    public void configureContentNegotiation(ContentNegotiationConfigurer configurer) {
      configurer.defaultContentType(MediaType.APPLICATION_JSON)
        .mediaType("json", MediaType.APPLICATION_JSON)
        .mediaType("xml", MediaType.APPLICATION_XML);
    }
    
	/*
	 * View Configuration
	 */
	@Bean(name = "viewResolver")
    public InternalResourceViewResolver getViewResolver() {
        InternalResourceViewResolver viewResolver = new InternalResourceViewResolver();
        viewResolver.setPrefix("/WEB-INF/views/");
        viewResolver.setSuffix(".jsp");
        return viewResolver;
    }

	    @Bean
	 public MessageSource messageSource() {
	        ResourceBundleMessageSource source = new ResourceBundleMessageSource();
	        source.setBasename("error_messages");
	        source.setUseCodeAsDefaultMessage(true);
	        return source;
	 }
	    
	  @Bean
	  public FileUploader initUploader(HttpServletRequest request){
		  String path =  servletContext.getRealPath("/WEB-INF/upload");
		  return new FileUploader(path);
	  }
	  
	  @Bean(name = "mailSender")
	  public MailSender mailSender(){
		  JavaMailSenderImpl mailSenderImpl = new JavaMailSenderImpl();
		  mailSenderImpl.setHost("smtp.gmail.com");
		  mailSenderImpl.setPort(587);
		  mailSenderImpl.setUsername("username");
		  mailSenderImpl.setPassword("password");
		  Properties properties = new Properties();
		  properties.setProperty("mail.smtp.auth", "true");
		  properties.setProperty("mail.smtp.starttls.enable", "true");
		  mailSenderImpl.setJavaMailProperties(properties);
		  return mailSenderImpl;
	  }
	  
	  
/*	  @Override
	  public void configureMessageConverters(List<HttpMessageConverter<?>> converters) {
	  converters.add(byteArrayHttpMessageConverter());
	  }
	  
	  @Bean
	  public ByteArrayHttpMessageConverter byteArrayHttpMessageConverter() {
	  ByteArrayHttpMessageConverter arrayHttpMessageConverter = new ByteArrayHttpMessageConverter();
	  arrayHttpMessageConverter.setSupportedMediaTypes(getSupportedMediaTypes());
	  return arrayHttpMessageConverter;
	  }
	  
	  private List<MediaType> getSupportedMediaTypes() {
		  List<MediaType> list = new ArrayList<MediaType>();
		  list.add(MediaType.IMAGE_JPEG);
		  list.add(MediaType.IMAGE_PNG);
		  list.add(MediaType.APPLICATION_OCTET_STREAM);
	  return list;
	  }
*/}
