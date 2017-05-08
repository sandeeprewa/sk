package com.academics.school.dl.utility;

import java.io.File;
import java.io.IOException;

import javax.servlet.http.HttpServletRequest;

import org.springframework.web.multipart.MultipartFile;

public class FileUploader {
	
	public static String ROOT_PATH = "";
	
	public 	FileUploader(String rootPath){
			ROOT_PATH = rootPath;
		    if(! new File(ROOT_PATH).exists())
                	new File(ROOT_PATH).mkdir();
	}
	
	public static String transfer(MultipartFile multipartFile, String className, String registationId, String namePrefix) throws RuntimeException, IOException{

			 String orgName = namePrefix +"_"+ multipartFile.getOriginalFilename();
			 File d1 = new File(ROOT_PATH + File.separator + className + File.separator + registationId);
             if(!d1.isDirectory())
            	 		d1.mkdirs();

             String filePath = d1.getPath() + File.separator + orgName;
             File dest = new File(filePath);
             multipartFile.transferTo(dest);
             return dest.toString();
	}

	public static String saveFileIntoFileSystem(MultipartFile multipartFile, String className, String registationId, String prefix) {
		// TODO Auto-generated method stub
		try {
			return transfer(multipartFile, className, registationId, prefix);
		}  catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
	}

}
