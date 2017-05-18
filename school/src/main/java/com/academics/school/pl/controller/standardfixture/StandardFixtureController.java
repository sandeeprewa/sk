package com.academics.school.pl.controller.standardfixture;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.academics.school.dl.standardfixture.StandardFixture;
import com.academics.school.pl.standardfixture.dto.StudentStandardFixtureDTO;
import com.academics.school.sl.standardfixture.StandardFixtureServiceImp;


@RestController
@RequestMapping(value = "/standardfixture")
public class StandardFixtureController {

		
		@Autowired
		StandardFixtureServiceImp standardFixtureServiceImp;
		
		
		@RequestMapping(value = "/setdetails", method= RequestMethod.POST, consumes= "application/json", produces = "application/json")
		public StandardFixture getStudentBasedOnStudentId(@RequestBody StandardFixture studentStandardFixtureDTO){
			
			return standardFixtureServiceImp.addDefaultFixture(studentStandardFixtureDTO);
		}
	}
