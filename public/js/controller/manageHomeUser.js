var app = angular.module("myApp", []);

//to control the ManageUser.html page
app.controller("manageHomeUserCtrl", function($scope,  $window, $http) {
    
    $scope.deconnection = function() {

        $http.post("/deconnection").then(function(response) {
            window.location.assign("/")
        }, function (response) {
            $scope.isntConnected = "Vous n'êtes pas déconnecté ";
        });
    };
    
    
    
});