var app = angular.module('app', [])
app.controller('oauth', function($scope, $filter, $http, $window) {

	$scope.clickButton = function() {
		OAuth.initialize('T7jc-uQzB7aYr_-CqRkyQKsMwmM', {cache:true});
		authorizationResult = OAuth.create('facebook');

		OAuth.popup('facebook', {cache:true}, function(error, result) {
			console.log(result)
			if (!error) {
				authorizationResult = result;
				deferred.resolve(result);
			}
		})

		authorizationResult.get('/me?fields=id,name,email').done(function(data) {
			console.log(data)
		});
	}
	
}