<html ng-app = "myModule">
<head>
	<script type="text/javascript" src="../jslib/angular/angular.min.js"></script>
	<script type="text/javascript" src="../jslib/angular/angular-route.min.js"></script>
	<script type="text/javascript" src="../examjs/exam.js"></script>
	
</head>
<body>
	<div ng-controller = "myController">
		{{message}}
		{{employee.name + employee.class}}
		{{employee.class}}
	</div>
		<div ng-controller = "myController1">
		{{message}}
	</div>
	
</body>
</html>
