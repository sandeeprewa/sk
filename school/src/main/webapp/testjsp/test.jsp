<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
			<script src="../includes/js/jquery-1.8.2.min.js"></script>
			<script src="../testingJs/testing.js"></script>

</head>
<body>

 <form id="realForm">
	<input type= "text" name= "registrationJson" id ="registrationJsonId" />
	Student Image :<input type= "file" name="studentImage" id="studentImageId"/>
	Father image <input type = "file" name = "fatherImage" id = "fatherImageId"/>
	Mother Image <input type= "file" name = "motherImage" id = "motherImageId"/>
	birth Certificate :<input type= "file" name="birthCertificate" id="birthCertificateId"/>
	cast Certificate <input type = "file" name = "castCertificate" id = "castCertificateId"/>
	Disability Certificate <input type= "file" name = "disabilityCertificate" id = "disabilityCertificateId"/>
</form>

<%--  
	<form id="testForm">
	<input type= "text" name="name" id ="inputText" />	
	File :<input type= "file" name="file1" id="imageFileId"/>
	</form>
--%>	
 	<input type="button" id="formData" value ="Submit form data"/>
	<input type="button" id="imageAndText" value = 'Submit Image and Text'/>
	<input type="button" id="complexObject" value='Complex Object' />
	<input type="button" id="complexObjectAndImage" value ='ComplexOBject and Image'/>	
	<input type="button" id="getRequestId" value ="Secure throgh Basic Header"/>
	<input type="button" id="registerRecordId" value ="Register Record Id"/>
	<input type="button" id="updateRecordId" value= "Update Record Id" >
		<input type="button" id="getRecordId" value= "GET Record Id" >
		<input type="button" id="deleteRecordId" value= "DELETE Record Id" >
	<input type="button" id ="searchRecordId" value= "Seach Record">
</body>
</html>