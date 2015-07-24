'use strict';

angular
.module('LAP', ['ui.bootstrap', 'ui.router', 'pascalprecht.translate']);

angular
.module('LAP')
.config(function($translateProvider, $translatePartialLoaderProvider) {
    $translateProvider.useLoader('$translatePartialLoader', {
        urlTemplate: '/assets/translations/{lang}/{part}.json'
      });

    $translateProvider.preferredLanguage('en_us');
})
.config(function($stateProvider, $urlRouterProvider, $locationProvider) {

	// For unmatched routes
	$urlRouterProvider.otherwise('/');
	
	// Application routes
	$stateProvider
	    .state('overview', {
	        url: '/',
	        controller: 'OverviewCtrl',
	        templateUrl: '/assets/templates/overview.html'
	    })
	    .state('tenants', {
	        url: '/tenants',
	        templateUrl: '/assets/templates/tenants.html'
	    })
	    .state('jobs', {
	        url: '/jobs',
	        templateUrl: '/assets/templates/jobs.html'
	    })
	    .state('pipelines', {
	        url: '/pipelines',
	        templateUrl: '/assets/templates/pipelines.html',
		    resolve:{
	    		pipelines : function ($stateParams, PipelineDataService) {
	    			return PipelineDataService.getPipelines();
	    		}	
	     	},
	     	controller: 'PipelinesController'	    
	     })
	    .state('rules', {
	        url: '/rules',
	        templateUrl: '/assets/templates/rules.html'
	    });	    
	$locationProvider.html5Mode(true);
});