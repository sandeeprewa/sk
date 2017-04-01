package com.school.pl.controller.erp.employee;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.school.pl.controller.erp.employee.dto.EmployeeRecord;

@RestController 
@RequestMapping("/v1/employee")
public class EmployeeController {
	 public static	String ROOT_PATH = System.getProperty("catalina.home");
	
	
	@RequestMapping("/test")
	public String test(){
		return "HItest";
	}
	@RequestMapping(method = RequestMethod.POST)
	public EmployeeRecord createEmployee(@RequestBody EmployeeRecord employeeRecord){
		MultipartFile file = employeeRecord.getFile1();
		try {
			saveIntoLocalServerDirectory(file);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return employeeRecord;
	}


	@SuppressWarnings("unused")
	private String saveIntoLocalServerDirectory(MultipartFile multipartFile) throws IOException{
		System.out.println(ROOT_PATH);
		byte[] bytes = multipartFile.getBytes();
		String name = multipartFile.getName();
		System.out.println( name);
		File dir = new File(ROOT_PATH + File.separator + "tmpFilesOK");
		if (!dir.exists())
		     dir.mkdirs();
	
		// Create the file on server
		File serverFile = new File(dir.getAbsolutePath()+ File.separator + name);
		BufferedOutputStream stream = new BufferedOutputStream(new FileOutputStream(serverFile));
		stream.write(bytes);
		stream.close();
		return serverFile.getAbsolutePath();
	}
	
}
