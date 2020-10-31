'use strict';

var myapp = angular.module('episodeApp', ['ngAnimate','ui.router','ngSanitize','ui.bootstrap']);


myapp.config(['$stateProvider','$urlRouterProvider',
	  function($stateProvider,$urlRouterProvider) {
	 var context=_contextPath;
    $urlRouterProvider.otherwise("/list")
	    $stateProvider
	    .state("list", {
	        url:'/list',
	        templateUrl: context+'/view/episode/html/list.html',
	        controller: 'EpisodeController',
	      })
	   
	    .state("details", {
	        url:'/details/:id',
	        templateUrl: context+'/view/episode/html/detail.html',
	        controller: 'EpisodeDetailController',
	      });
	  }
	]);




myapp.controller('EpisodeController', ['$scope','$http','$location', function($scope,$http,$location) {
	  var token = $("meta[name='_csrf']").attr("content");
	  var context=_contextPath;
	 
	   $scope.currentPage = 1;
	  
      $scope.getEpisodeList = function (page,sortBy) {
    	   
    	    var url=context+"/episode/list";
    	    if(page) {
    	    	url+="?page="+page;
    	    }
    	    if(sortBy) {
    	    	url+="?sortBy="+sortBy;
    	    }
    	    
        	  
    	    $http.get(url, {}).success(function (response) {
            	$scope.response=response;
            	
                $scope.viewby = $scope.response.info.pages;
                $scope.totalItems = $scope.response.info.count;
             
                $scope.itemsPerPage = 20;
                $scope.maxSize = 5;

             
            	

            }).error(function (error) {
                 toaster.pop('error', error);
            });
        

    };
    
    $scope.getEpisodeList();
    
    $scope.numberOfPages=function(){
        return Math.ceil( $scope.response.info.count/$scope.viewby);
    }
        
    $scope.setPage = function (pageNo) {
        $scope.currentPage = pageNo;
    };

    $scope.pageChanged = function() {
    	 $scope.getEpisodeList( $scope.currentPage,null);
        console.log('Page changed to: ' + $scope.currentPage);
    };

    $scope.setItemsPerPage = function(num) {
        $scope.itemsPerPage = num;
        $scope.currentPage = 1; //reset to first page
    }
    
    
    $scope.filter=function() {
    	 $scope.getEpisodeList(null, $scope.sortBy);
    }

    

}]).controller('EpisodeDetailController', ['$scope','$http','$location','$stateParams', function($scope,$http,$location,$stateParams) {
	   $scope.edit=true;
	    var token = $("meta[name='_csrf']").attr("content");
	    var context=_contextPath;
       $scope.getEpisode = function () {
    	   var url=context+"/episode/detail";
	   	    if($stateParams.id) {
	   	    	url+="?id="+$stateParams.id;
	   	    }
   	  
    	    $http.get(url, {}).success(function (response) {
            $scope.episode=response;
            }).error(function (error) {
                 toaster.pop('error', error);
            });
    };
 
    $scope.getEpisode();
    
 

}]);
