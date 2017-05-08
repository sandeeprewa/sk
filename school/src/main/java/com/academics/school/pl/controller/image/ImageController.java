package com.academics.school.pl.controller.image;

import java.io.File;
import java.io.IOException;

import javax.servlet.ServletContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.support.ServletContextResource;

@RestController
public class ImageController {

	private static final String IMAGE_PATH = "/WEB-INF/upload/";
	
	@Autowired
	ServletContext servletContext;
	
	/*
	 * Expected input type = 1_1_StudentImage.
	 */
	@ResponseBody
	@RequestMapping(value = "/image/{imageString}", method = RequestMethod.GET)
	public Resource getImagetest(@PathVariable String imageString) throws IOException {
		String stu_class = getStudentClass(imageString);
		String stu_registrationId = getStudentRegistrationId(imageString);
		String stu_prefix = getImagePrefix(imageString);
		String systemFilePath =  servletContext.getRealPath(IMAGE_PATH);
		
		String pathToGetImage = IMAGE_PATH + File.separator +stu_class+ File.separator + stu_registrationId + File.separator;
		
		File file = new File(systemFilePath + File.separator +stu_class+ File.separator + stu_registrationId);
		File[] files = file.listFiles();
		for(File f : files){
			if(f.getName().startsWith(stu_prefix)){
				pathToGetImage = pathToGetImage + f.getName();
			}
		}
	   return new ServletContextResource(servletContext, pathToGetImage);
	}

	
	
	private String getImagePrefix(String imageString) {
		String[] image = imageString.split("_");
		return image[2];
	}

	private String getStudentRegistrationId(String imageString) {
		String[] image = imageString.split("_");
		return image[1];
	}

	private String getStudentClass(String imageString) {
		String[] image = imageString.split("_");
		return image[0];
	}

}
