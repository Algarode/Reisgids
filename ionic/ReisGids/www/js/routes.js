angular.module('app.routes', [])

.config(function($stateProvider, $urlRouterProvider) {

  // Ionic uses AngularUI Router which uses the concept of states
  // Learn more here: https://github.com/angular-ui/ui-router
  // Set up the various states which the app can be in.
  // Each state's controller can be found in controllers.js
  $stateProvider
    
      
        
    .state('bezienswaardigheden', {
      url: '/locations',
      templateUrl: 'templates/bezienswaardigheden.html',
      controller: 'bezienswaardighedenCtrl'
    })
        
      
    
      
        
    .state('login', {
      url: '/main',
      templateUrl: 'templates/login.html',
      controller: 'loginCtrl'
    })
        
      
    
      
        
    .state('bezienswaardigheid', {
      url: '/detail/:id',
      templateUrl: 'templates/bezienswaardigheid.html',
      controller: 'bezienswaardigheidCtrl'
    })
        
      
    
      
        
    .state('registreren', {
      url: '/register',
      templateUrl: 'templates/registreren.html',
      controller: 'registrerenCtrl'
    })
        
      
    
      
        
    .state('fotoDetails', {
      url: '/fotodetail',
      templateUrl: 'templates/fotoDetails.html',
      controller: 'fotoDetailsCtrl'
    })
        
      
    ;

  // if none of the above states are matched, use this as the fallback
  $urlRouterProvider.otherwise('/locations');

});