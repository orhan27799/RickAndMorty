'use strict';

var myapp = angular.module('reportApp', ['ngAnimate','ui.router','ngSanitize','ui.bootstrap']);


myapp.config(['$stateProvider','$urlRouterProvider',
	  function($stateProvider,$urlRouterProvider) {
	 var context=_contextPath;
    $urlRouterProvider.otherwise("/list")
	    $stateProvider
	    .state("list", {
	        url:'/list',
	        templateUrl: context+'/view/report/html/list.html',
	        controller: 'ReportController',
	      })
	  }
	]);


myapp.controller('ReportController', ['$scope','$http','$location', function($scope,$http,$location) {
	  var token = $("meta[name='_csrf']").attr("content");
	  var context=_contextPath;
	 
	    $scope.getEndPoint = function () {
    	    $http.get(context+"/report/get", {}).success(function (response) {
            $scope.endPoints=response;
            }).error(function (error) {
                 toaster.pop('error', error);
            });
    };
 
    $scope.getEndPoint();
    
  

    

}]);
