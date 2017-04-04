package com.school.pl.controller.teset;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

@RestController
public class TestController {

	@Autowired
	HttpServletRequest  request;
	
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
		MultipartFile multipartFile = login.getFile1();
		transfer(multipartFile);
		ComplexObjectImage complexObject = new ObjectMapper().readValue(login.getName(), ComplexObjectImage.class);
		System.out.println(complexObject.getCountry().getCountryName());
		System.out.println(complexObject.getQuality().toString());
		return "hii";
	}
	
/*	@SuppressWarnings("unused")
	private String saveIntoLocalServerDirectory(MultipartFile multipartFile) throws IOException{
		String ROOT_PATH = System.getProperty("catalina.home");
		byte[] bytes = multipartFile.getBytes();
		
		String name = multipartFile.getName();
		System.out.println( name);
	
		// Create the file on server
		File serverFile = new File(dir.getAbsolutePath()+ File.separator + name);
		BufferedOutputStream stream = new BufferedOutputStream(new FileOutputStream(serverFile));
		stream.write(bytes);
		stream.close();
		return serverFile.getAbsolutePath();
	}
*/
	private void transfer(MultipartFile multipartFile){
		String ROOT_PATH = System.getProperty("catalina.home");
		File dir = new File(ROOT_PATH + File.separator + "uploads");
		if (!dir.exists())
		     dir.mkdirs();

		try {
			 String uploadsDir = "/upload/";
             String realPathtoUploads =  request.getServletContext().getRealPath(dir.getName());
             System.out.println(realPathtoUploads);
             System.out.println(request.getServletContext().getRealPath(uploadsDir));
             if(! new File(realPathtoUploads).exists())
             {
                 new File(realPathtoUploads).mkdir();
             }

             String orgName = multipartFile.getOriginalFilename();
             String filePath = realPathtoUploads + orgName;
             File dest = new File(filePath);
             multipartFile.transferTo(dest);
		}catch(Exception e){
			
		}
		
	}
	
	
	
}
