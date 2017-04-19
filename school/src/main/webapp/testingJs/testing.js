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
});

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
	var d = new FormData();
	d.append("file1", $("#imageFileId").val());
	d.append("name", JSON.stringify(markers));
	$("#inputText").val(JSON.stringify(markers));
	console.log($("#inputText").val());
	$.ajax({
         url: '../submitImageAndComplexObject',
         type: "POST",
         data: new FormData(document.getElementById('testForm')),
         enctype: 'multipart/form-data',
         processData: false,
         contentType: false,
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