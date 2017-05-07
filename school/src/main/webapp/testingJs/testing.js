/**
 *  Sample script to upload text,image
 */

$(document).ready(function (){
	
	alert("I'm ready");
	
	
	$("#formData").click(function(){
		 makeCall();
//		 submitFormData();
	});
	
	$("#imageAndText").click(function(){
		 submitImageAndText();
	});
	
	$("#complexObject").click(function(){
		 submitComplexObject();
	});
	$("#complexObjectAndImage").click(function(){
		 submitComplexObjectAndImage();
	});
	$("#getRequestId").click(function(){
		secureViaBasicAuth();
	});
	
	$("#registerRecordId").click(function (){
		submitStudentRecord();
	});
	
	$("#updateRecordId").click(function (){
		submitStudentRecordForUpdate();
	});

	$("#searchRecordId").click(function(){
		submitStudentRecordForSearch();
	});
});

function getInputData(){
	return 	{  
		  "personalDetail":{  
		    "firstName":"sa",
		    "middleName":"middleName",
		    "lastName":"sas",
		    "gender":"male",
		    "mobileNumber":"8101346",
		    "email":"ema@gmail.com",
		    "dateOfBirth":"25/06/1993",
		    "age":"12",
		    "category":"sa",
		    "disability":"Autism",
		    "nationality":"indian",
		    "religion":"hindu",
		    "bloodGroup":"bloodGroup",
		    "adhaarCardNumber":"1234567" ,
		    "currentClass":{  
		    		"c_Class":"1",
		    			"school":"Name",
		    "listOfSubject":[  
		    	{"subject":"subject1"},
		    	{"subject":"subject2"}
		    ]
		  },
		  "previousEducationDetail":{  
		    "previousSchoolName":"previousSchoolName",
		    "previousSchoolAddress":"previousSchoolAddress",
		    "previousSchoolClass":"1",
		    "previousClassPercentage":"12"
		  },
		  "parentDetails":{  
		    "fatherName":"fatherName",
		    "fatherMobileNumber":"7828101341",
		    "fatherEmail":"fatherEmail@gmail.com",
		    "fatherOccupation":"fatherOccupation",
		    "motherName":"motherName",
		    "motherMobileNumber":"7828101341",
		    "motherEmail":"motherEmail@gmail.com",
		    "motherOccupation":"motherOccupation"
		  },
		  "address":[
		  {  
		    "houseNumber":"sa",
		    "village":"as",
		    "city":"currentVillage",
		    "state":"MadhyaPradesh",
		    "pinNumber":"123456",
		    "country":"indian",
		    "addressDetails":"currentAddressDetails",
		    "isPermanent":"true",
		  },
		  {  
		    "houseNumber":"sa",
		    "village":"sa",
		    "city":"currentVillage",
		    "state":"MadhyaPradesh",
		    "pinNumber":"123456",
		    "country":"indian",
		    "addressDetails":"currentAddressDetails"
		  }]
		 }
		};
}

	function submitStudentRecord(){
	
	var markers = getInputData();
	$('input[name="registrationJson"]').val(JSON.stringify(markers));

	var d = new FormData();
	d.append("studentImage", $("#studentImageId").val());
	d.append("fatherImage", $("#fatherImageId").val());
	d.append("motherImage", $("#motherImageId").val());
	d.append("birthCertificate", $("#birthCertificateId").val());
	d.append("castCertificate", $("#castCertificateId").val());
	d.append("disabilityCertficate", $("#disabilityCertificateId").val());
	d.append("registrationJson", JSON.stringify(markers));
	
	console.log(JSON.stringify(markers));
	
	$.ajax({
         url: '../rest/register/',
         type: "POST",
         data: new FormData(document.getElementById('realForm')),
         enctype: 'multipart/form-data',
         processData: false,
         contentType: false,
/*			beforeSend: function(xhr) {
				xhr.setRequestHeader("Accept", "application/json");
				xhr.setRequestHeader("Content-Type", "application/json");
				xhr.setRequestHeader ("Authorization", "Basic " + btoa("sa" + ":" + "hariom"))
			}
*/
    }) 
}//

	function getInputDataForUpdate(){
		return 	{
			"registrationId":1,
			"personalDetail":{
			"id":1,
			"previousEducationDetail":{
			"educationDetailId":1,
			"previousSchoolName":"previousSchoolName",
			"previousSchoolAddress":"previousSchoolAddress",
			"previousSchoolClass":"1",
			"previousClassPercentage":"99"
			},
			"currentClass":{
			"c_Class":"11",
			"school":"Name",
			"listOfSubject":[
			{
			"id":1,
			"subject":"subject1",
			"currentClass":null
			},
			{
			"id":2,
			"subject":"subject2",
			"currentClass":null
			}
			],
			"id":1
			},
			"parentDetails":{
			"parentDetailId":1,
			"fatherName":"fatherName",
			"fatherMobileNumber":"7828101341",
			"fatherEmail":"fatherEmail@gmail.com",
			"fatherOccupation":"fatherOccupation",
			"motherName":"motherName",
			"motherMobileNumber":"7828101341",
			"motherEmail":"motherEmail@gmail.com",
			"motherOccupation":"motherOccupation"
			},
			"address":[
			{
			"addressId":1,
			"houseNumber":"sa",
			"village":"as",
			"city":"currentVillage",
			"state":"MadhyaPradesh",
			"pinNumber":"123456",
			"country":"indian",
			"addressDetails":"currentAddressDetails",
			"isPermanent":true
			},
			{
			"addressId":2,
			"houseNumber":"sa",
			"village":"sa",
			"city":"currentVillage",
			"state":"MadhyaPradesh",
			"pinNumber":"123456",
			"country":"indian",
			"addressDetails":"currentAddressDetails",
			"isPermanent":false
			}
			],
			"firstName":"Hariom",
			"middleName":"OmHari",
			"lastName":"AS",
			"gender":"female",
			"mobileNumber":"8101346",
			"email":"ema@gmail.com",
			"dateOfBirth":"25/06/1993",
			"age":"12",
			"category":"general",
			"disability":"Autism",
			"nationality":"indian",
			"religion":"hindu",
			"bloodGroup":"bloodGroup",
			"adhaarCardNumber":"1234567"
			},
			"timeStamp":null,
			"studentImageLocation":"C:\\Tomcat 8\\1\\1\\StudentImage_",
			"fatherImageLocation":"C:\\Tomcat 8\\1\\1\\FatherImage_",
			"motherImageLocation":"C:\\Tomcat 8\\1\\1\\MotherImage_",
			"birthCertificateLocation":"C:\\Tomcat 8\\1\\1\\Birth Certificate Image_",
			"castCertificateLocation":"C:\\Tomcat 8\\1\\1\\Cast Certificate Image_",
			"disabilityCertificateLocation":null,
			"disabilityCertificate":null,
			"registrationStatus":"UNPAID_SUBMISSION"
			};
		
	}

	
	function submitStudentRecordForUpdate(){
		
		var markers = getInputDataForUpdate();
	
		$('input[name="registrationJson"]').val(JSON.stringify(markers));
		
		$.ajax({
	         url: '../rest/register/1',
	         type: "POST",
	         data: new FormData(document.getElementById('realForm')),
	         enctype: 'multipart/form-data',
	         processData: false,
	         contentType: false,
	    }) 
	    
}

	

	function submitStudentRecordForSearch(){

		var markers = {
				"registrationId":"1"
		};
		
		jQuery.ajax(
			{    
				type: "POST",
				url: "../rest/register/search",
				data: JSON.stringify(markers),
				
				beforeSend: function(xhr) {
					xhr.setRequestHeader("Accept", "application/json");
					xhr.setRequestHeader("Content-Type", "application/json");
				},
				success: function(data){
					alert(data);
				},
				failure: function(errMsg) {
					alert(errMsg);
				}			
		});
	
	}	
	
function makeCall(){
	var markers = { "userName": "42.5978231292517", "password": "-3" };
	
	jQuery.ajax(
		{    
			type: "POST",
			url: "../testOnlyData",
			data: JSON.stringify(markers),
			
			beforeSend: function(xhr) {
				xhr.setRequestHeader("Accept", "application/json");
				xhr.setRequestHeader("Content-Type", "application/json");
			},
			success: function(data){
				alert(data);
			},
			failure: function(errMsg) {
				alert(errMsg);
			}			
	});
}

function submitFormData(){
	
	 $.ajax({
         url: '../submitFormData',
         type: "POST",
         data: new FormData(document.getElementById('testForm')),
         enctype: 'multipart/form-data',
         processData: false,
         contentType: false,
    }) 
    
}

function submitImageAndText(){
	//imageAndText
	
	
		 $.ajax({
	         url: '../imageAndText',
	         type: "POST",
	         data: new FormData(document.getElementById('testForm')),
	         enctype: 'multipart/form-data',
	         processData: false,
	         contentType: false,
	    }) 
}

function submitComplexObject(){
	var markers = { 
			"name": "42.5978231292517", 
			"country":{
				"countryName":"india"
			},
			"quality" : "GOOD"
	};
	
	jQuery.ajax(
			{    
				type: "POST",
				url: "../test/post",
				data: JSON.stringify(markers),
				
				beforeSend: function(xhr) {
					xhr.setRequestHeader("Accept", "application/json");
					xhr.setRequestHeader("Content-Type", "application/json");
				},
				success: function(data){
					alert(data);
				},
				failure: function(errMsg) {
					alert(errMsg);
				}			
		});
	
}

function submitComplexObjectAndImage(){
	var markers = { 
			"name":"as",
			"country":{
				"countryName":"india"
			},
			"quality" : "GOOD"
	}
	 
	   $('input[name="name"]').val(markers);
		$("#inputText").val(JSON.stringify(markers));
	console.log($("#inputText").val());
	$.ajax({
         url: '../submitImageAndComplexObject',
         type: "POST",
         data: new FormData(document.getElementById('testForm')),
         enctype: 'multipart/form-data',
         processData: false,
         contentType:false,
    }) 
}

function secureViaBasicAuth(){

	jQuery.ajax(
			{    
				type: "GET",
				url: "../tesetget",				
				beforeSend: function(xhr) {
					xhr.setRequestHeader("Accept", "application/json");
					xhr.setRequestHeader("Content-Type", "application/json");
					xhr.setRequestHeader ("Authorization", "Basic " + btoa("sa" + ":" + "hariom"))
				},
				success: function(data){
					alert(data);
				},
				failure: function(errMsg) {
					alert(errMsg);
				}			
		});
}