$(document).ready(function (){
	
	$("#dd").click(function (){
			 $.ajax({
		         url: 'v1/employee',
		         type: "POST",
		         data: new FormData(document.getElementById('test')),
		         enctype: 'multipart/form-data',
		         processData: false,
		         contentType: false,
		    }) 
	});
	
	
});