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

	// Product Search
	$scope.productSearchResult = '';
    $scope.productSearch = function(){
    	if($scope.productId){
            var res = $http({
                method: 'GET',
                url: 'http://localhost:8081/productservice/products/' + $scope.productId
            })
            .then(function (response) {
            	$scope.productSearchResult = response.data;
            	console.log('complete: ' + $scope.productSearchResult);
            });
    	}
    	else {
    		$scope.productSearchResult = '';
    	}
    }
    
    // Order Search
	$scope.orderSearchResult = '';
    $scope.orderSearch = function(){
    	if($scope.orderId){
            var res = $http({
                method: 'GET',
                url: 'http://localhost:8081/orderservice/orders/' + $scope.orderId
            })
            .then(function (response) {
            	$scope.orderSearchResult = response.data;
            	console.log('complete: ' + $scope.orderSearchResult);
            });
    	}
    	else {
    		$scope.orderSearchResult = '';
    	}
    }
    
    // Customer Search
	$scope.customerSearchResult = '';
    $scope.customerSearch = function(){
    	if($scope.custId){
            var res = $http({
                method: 'GET',
                url: 'http://localhost:8081/orderservice/customers/' + $scope.custId
            })
            .then(function (response) {
            	$scope.customerSearchResult = response.data;
            	console.log('complete: ' + $scope.customerSearchResult);
            });
    	}
    	else {
    		$scope.customerSearchResult = '';
    	}
    }
    
    // Partner Search
	$scope.partnerSearchResult = '';
    $scope.partnerSearch = function(){
    	if($scope.partnerId){
            var res = $http({
                method: 'GET',
                url: 'http://localhost:8081/partnerservice/partners/' + $scope.partnerId
            })
            .then(function (response) {
            	$scope.partnerSearchResult = response.data;
            	console.log('complete: ' + $scope.partnerSearchResult);
            });
    	}
    	else {
    		$scope.partnerSearchResult = '';
    	}
    }
    
    // All Partner Search
	$scope.allPartnersResults = '';
    $scope.allPartners = function(){
    	console.log('inside');
        var res = $http({
            method: 'GET',
            url: 'http://localhost:8081/partnerservice/allPartners/'
        })
        .then(function (response) {
        	$scope.allPartnersResults = response.data;
        	console.log('complete: ' + $scope.allPartnersResults);
        });
    }
    
    // Order Creation/Purchase
    $scope.purchase = function(path, action, prodId, price){
    	console.log('inside');
    	console.log(path);
    	console.log(prodId);
    	console.log(price);
    	
        var data = {"orderTotal" : price, "orderStatus" : "Received", "trackingId" : 111, "customerId" : 1, "billingInfoId" : 1, "shippingInfoId" : 1};
    
        var config = {
            headers : {
                'Content-Type': 'application/json;'
            }
        }

        console.log('before');
        $http.post(path, data, config)
        .success(function (data, status, headers, config) {
            $scope.orderCreatedResult = data;
            console.log('after, result: ' + $scope.orderCreatedResult);
        })
        .error(function (data, status, header, config) {
            $scope.ResponseDetails = "Data: " + data +
                "<hr />status: " + status +
                "<hr />headers: " + header +
                "<hr />config: " + config;
        });
        
    }
    
    // Order Check Status
    $scope.checkStatus = function(path, action, orderId){
    	console.log('inside');
    	console.log('path: ' + path);
    	console.log('orderId: ' + orderId);
    	if(orderId){
            var res = $http({
                method: action,
                url: path
            })
            .then(function (response) {
            	$scope.orderStatus = response.data;
            	console.log('complete: ' + $scope.orderStatus);
            });
    	}
    	console.log('complete');
    }
    
    // Order Cancel
    $scope.cancel = function(path, action, orderId){
    	console.log('inside');
    	console.log('path: ' + path);
    	console.log('orderId: ' + orderId);
    	if(orderId){
            var res = $http({
                method: action,
                url: path
            })
            .then(function (response) {
            	$scope.cancelResult = response.data;
            	console.log('complete: ' + $scope.cancelResult);
            });
    	}
    	console.log('complete');
    }
   
});
