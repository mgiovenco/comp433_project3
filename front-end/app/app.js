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