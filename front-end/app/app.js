'use strict';

// Declare app level module which depends on views, and components
var app = angular.module('myApp', [
  'ngRoute',
  'myApp.view1',
  'myApp.view2',
  'myApp.version'
]).
config(['$locationProvider', '$routeProvider', function($locationProvider, $routeProvider) {
  $locationProvider.hashPrefix('!');

  $routeProvider.otherwise({redirectTo: '/view1'});
}]);

app.controller('booksCtrl', function($scope, $http) {

	  $http.get("https://whispering-woodland-9020.herokuapp.com/getAllBooks")
	    .then(function(response) {
	      $scope.data = response.data;
	    });
});

app.controller('productsCtrl', function($scope, $http) {

	  $http.get("http://localhost:8081/productservice/products")
	    .then(function(response) {
	      $scope.data = response.data;
	    });	 
});



app.controller("myController", function ($scope, $http) {
	console.log('inside');
		
    $scope.search = function(){
    	console.log($scope.Reference);
        var res = $http({
            method: 'GET',
            url: 'http://localhost:8081/productservice/products/' + $scope.Reference
        })
        .then(function (response) {
        	console.log('complete: ' + response.data);
        	$scope.data = response.data;
            console.log('scope data: ' + $scope.data);
        });
    }
    

    
});
