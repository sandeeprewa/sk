/**
 * 
 */
var myApp = angular.module("myModule",[]);
myApp.controller("myController", function($scope){
	$scope.message = "HI How r you";
	var employee ={
			name : "AS",
			class : "BE"
	};
	$scope.employee = employee;
	
});
myApp.controller("myController1", function($scope){
	$scope.message = "HI How r you1";
});