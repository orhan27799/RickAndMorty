'use strict';

var myapp = angular.module('characterApp', ['ngAnimate','ui.router','ngSanitize','ui.bootstrap']);


myapp.config(['$stateProvider','$urlRouterProvider',
	  function($stateProvider,$urlRouterProvider) {
	 var context=_contextPath;
    $urlRouterProvider.otherwise("/list")
	    $stateProvider
	    .state("list", {
	        url:'/list',
	        templateUrl: context+'/view/character/html/list.html',
	        controller: 'CategoryController',
	      })
	   
	    .state("details", {
	        url:'/details/:id',
	        templateUrl: context+'/view/character/html/detail.html',
	        controller: 'CharacterDetailController',
	      });
	  }
	]);




myapp.controller('CategoryController', ['$scope','$http','$location', function($scope,$http,$location) {
	  var token = $("meta[name='_csrf']").attr("content");
	  var context=_contextPath;
	 
	   $scope.currentPage = 1;
	  
      $scope.getCharacterList = function (page,sortBy) {
    	   
    	    var url=context+"/character/list";
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
             
                $scope.itemsPerPage = $scope.viewby;
                $scope.maxSize = 5;

             
            	

            }).error(function (error) {
                 toaster.pop('error', error);
            });
        

    };
    
    $scope.getCharacterList();
    
    $scope.numberOfPages=function(){
        return Math.ceil( $scope.response.info.count/$scope.viewby);
    }
        
    $scope.setPage = function (pageNo) {
        $scope.currentPage = pageNo;
    };

    $scope.pageChanged = function() {
    	 $scope.getCharacterList( $scope.currentPage,null);
        console.log('Page changed to: ' + $scope.currentPage);
    };

    $scope.setItemsPerPage = function(num) {
        $scope.itemsPerPage = num;
        $scope.currentPage = 1; //reset to first page
    }
    
    
    $scope.filter=function() {
    	 $scope.getCharacterList(null, $scope.sortBy);
    }

    

}]).controller('CharacterDetailController', ['$scope','$http','$location','$stateParams', function($scope,$http,$location,$stateParams) {
	   $scope.edit=true;
	    var token = $("meta[name='_csrf']").attr("content");
	    var context=_contextPath;
       $scope.getCharacter = function () {
    	    var url=context+"/character/detail";
    	    if($stateParams.id) {
    	    	url+="?id="+$stateParams.id;
    	    }
    	  
    	   
    	    $http.get(url, {}).success(function (response) {
            	$scope.character=response;
            }).error(function (error) {
                 toaster.pop('error', error);
            });
    };
 
    $scope.getCharacter();
    
 

}]);
