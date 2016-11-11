var app = angular.module("myApp", []);

app.controller("manageUserCtrl", function($scope) {
    
    $scope.createUser = function ($http) {
        $http({
            url: '/user',
            method: 'POST',
        }).success(function (data) {
            $scope.user = data;
        });
    };
    
    $scope.result = "yeeeees";

    
    $scope.myTxt = "You have not yet clicked submit";
    $scope.myFunc = function () {
        $scope.myTxt = "You clicked submit!";
    }
    
    
    
    
    
});