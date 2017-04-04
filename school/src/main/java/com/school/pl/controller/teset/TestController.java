package com.school.pl.controller.teset;

import java.io.IOException;

import javax.validation.Valid;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

@RestController
public class TestController {

	
	@RequestMapping(value = "/test/post", method = RequestMethod.POST)
	public String handle(@RequestBody World world){
		System.out.println(world.getName());
		return "hi";
	}
	
	
	@RequestMapping(value="/submitFormData", method = RequestMethod.POST)
	public String handleForm(@RequestBody FormData form){
		System.out.println(form.getName());
		return "h1";
	}
	
	@RequestMapping(value ="/testOnlyData", method = RequestMethod.POST)
	public String teset(@RequestBody LoginData login){
		System.out.println(login.getPassword());
		return "hii";
	}
	
	@RequestMapping(value ="/imageAndText", method = RequestMethod.POST)
	public String tese1t(@Valid @ModelAttribute ImageAndText login){
		System.out.println(login.getName());
		return "hii";
	}
	
	
	@RequestMapping(value ="/submitImageAndComplexObject", method = RequestMethod.POST)
	public String tese1t(@Valid @ModelAttribute Pic login) throws JsonParseException, JsonMappingException, IOException{
		System.out.println(login.getName());
		ComplexObjectImage complexObject = new ObjectMapper().readValue(login.getName(), ComplexObjectImage.class);
		System.out.println(complexObject.getCountry().getCountryName());
		System.out.println(complexObject.getQuality().toString());
		return "hii";
	}
	
}
